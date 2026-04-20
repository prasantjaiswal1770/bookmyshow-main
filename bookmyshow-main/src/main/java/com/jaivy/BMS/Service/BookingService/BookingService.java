package com.jaivy.BMS.Service.BookingService;

import com.jaivy.BMS.Dto.BookingDto.BookingRequestDto;
import com.jaivy.BMS.Dto.BookingDto.BookingResponseDTO;
import com.jaivy.BMS.Entity.Seat;

import java.util.List;

public interface BookingService {

    BookingResponseDTO createBooking(BookingRequestDto bookingRequestDto);

    List<BookingResponseDTO> getBookingByUser(Long userId);

    BookingResponseDTO cancelbooking(Long bookingId);

    BookingResponseDTO getBookingByUserId(Long bookingId);

    List<Seat> getAvailableSeats(Long showId);
    BookingResponseDTO cancelSeats(Long bookingId, List<Long> seatIds);
}