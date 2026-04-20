package com.jaivy.BMS.Service.BookingService;

import com.jaivy.BMS.Dto.BookingDto.BookingRequestDto;
import com.jaivy.BMS.Dto.BookingDto.BookingResponseDTO;
import com.jaivy.BMS.Dto.SeatDto.SeatDTO;
import com.jaivy.BMS.Entity.*;
import com.jaivy.BMS.Enum.BookingStatus;
import com.jaivy.BMS.Repository.BookingRepository;
import com.jaivy.BMS.Repository.SeatRepository;
import com.jaivy.BMS.Repository.ShowRepository;
import com.jaivy.BMS.Service.UserService.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImp implements BookingService {

    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;
    private final UserServices userServices;
    private final ShowRepository showRepository;

    // CREATE BOOKING
    @Override
    public BookingResponseDTO createBooking(BookingRequestDto bookingRequestDto) {

        User user = userServices.getUserById(bookingRequestDto.getUserId());

        Show show = showRepository.findById(bookingRequestDto.getShowId())
                .orElseThrow(() -> new RuntimeException("Show not found"));

        // Check already booked seats
        List<Long> alreadyBookedSeat =
                bookingRepository.findBookedSeatIdsByShowId(bookingRequestDto.getShowId());

        for (Long seatId : bookingRequestDto.getSeatIds()) {
            if (alreadyBookedSeat.contains(seatId)) {
                throw new RuntimeException("Seat " + seatId + " already booked");
            }
        }

        // Fetch seats
        List<Seat> seats = seatRepository.findAllById(bookingRequestDto.getSeatIds());

        if (seats.size() != bookingRequestDto.getSeatIds().size()) {
            throw new RuntimeException("Some seats are invalid");
        }

        double totalPrice = seats.size() * show.getTicketPrice();

        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .seats(seats)
                .totalPrice(totalPrice)
                .bookingStatus(BookingStatus.CONFIRMED)
                .build();

        Booking savedBooking = bookingRepository.save(booking);

        return mapToDTO(savedBooking);
    }

    // GET BOOKINGS BY USER
    @Override
    public List<BookingResponseDTO> getBookingByUser(Long userId) {

        return bookingRepository.findByUserId(userId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // AVAILABLE SEATS
    @Override
    public List<Seat> getAvailableSeats(Long showId) {

        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found " + showId));

        List<Long> bookedSeatIds = bookingRepository.findBookedSeatIdsByShowId(showId);

        List<Seat> allSeats = seatRepository.findByScreenId(show.getScreen().getId());

        return allSeats.stream()
                .filter(seat -> !bookedSeatIds.contains(seat.getId()))
                .toList();
    }

    // CANCEL BOOKING
    @Override
    public BookingResponseDTO cancelbooking(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with id " + bookingId));

        booking.setBookingStatus(BookingStatus.CANCELLED);

        Booking updatedBooking = bookingRepository.save(booking);

        return mapToDTO(updatedBooking);
    }

    @Override
    public BookingResponseDTO cancelSeats(Long bookingId, List<Long> seatIds) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        // ✅ FIX: new ArrayList banao, unmodifiable list modify nahi hoti
        List<Seat> remainingSeats = new ArrayList<>(
                booking.getSeats()
                        .stream()
                        .filter(seat -> !seatIds.contains(seat.getId()))
                        .toList()
        );

        booking.setSeats(remainingSeats);

        if (remainingSeats.isEmpty()) {
            booking.setBookingStatus(BookingStatus.CANCELLED);
        }

        double newPrice = remainingSeats.size() * booking.getShow().getTicketPrice();
        booking.setTotalPrice(newPrice);

        return mapToDTO(bookingRepository.save(booking));
    }
    // GET BOOKING BY ID
    @Override
    public BookingResponseDTO getBookingByUserId(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with id " + bookingId));

        return mapToDTO(booking);
    }

    private BookingResponseDTO mapToDTO(Booking booking) {

        List<SeatDTO> seats = booking.getSeats()
                .stream()
                .map(seat -> new SeatDTO(
                        seat.getId(),
                        seat.getSeatNumber()
                ))
                .toList();

        return BookingResponseDTO.builder()
                .bookingId(booking.getId())
                .userName(booking.getUser().getName())
                .movieTitle(booking.getShow().getMovie().getTitle())
                .theaterName(booking.getShow().getScreen().getTheater().getName())
                .screenName(booking.getShow().getScreen().getName())
                .seats(seats)   // ✅ FIXED
                .totalPrice(booking.getTotalPrice())
                .bookingStatus(booking.getBookingStatus())
                .bookedAt(booking.getBookedAt())
                .build();
    }
}