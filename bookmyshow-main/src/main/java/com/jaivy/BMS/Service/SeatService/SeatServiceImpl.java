package com.jaivy.BMS.Service.SeatService;

import com.jaivy.BMS.Dto.SeatDto.SeatResponseDTO;
import com.jaivy.BMS.Entity.Seat;
import com.jaivy.BMS.Entity.Show;
import com.jaivy.BMS.Repository.BookingRepository;
import com.jaivy.BMS.Repository.SeatRepository;
import com.jaivy.BMS.Repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;
    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository; // ✅ ADD THIS

    // ✅ MAIN FIX METHOD
    @Override
    public List<SeatResponseDTO> getSeatsByShow(Long showId) {

        // 👉 1. Show निकालो
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        // 👉 2. Screen से seats निकालो
        List<Seat> seats = seatRepository.findByScreenId(show.getScreen().getId());

        // 👉 3. booked seats निकालो
        List<Long> bookedSeatIds = bookingRepository.findBookedSeatIdsByShowId(showId);

        // 👉 4. mapping with status
        return seats.stream().map(seat -> {

            String status = bookedSeatIds.contains(seat.getId())
                    ? "BOOKED"
                    : "AVAILABLE";

            return SeatResponseDTO.builder()
                    .id(seat.getId())
                    .seatNumber(seat.getSeatNumber())
                    .seatType(seat.getSeatType().name())
                    .seatRow(seat.getRow())
                    .seatCol(seat.getCol())
                    .status(status)
                    .build();

        }).toList();
    }

    @Override
    public Seat addSeat(Seat seat) {
        return seatRepository.save(seat); // ✅ FIXED
    }

    @Override
    public SeatResponseDTO getSeatById(Long id) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));

        return SeatResponseDTO.builder()
                .id(seat.getId())
                .seatNumber(seat.getSeatNumber())
                .seatType(seat.getSeatType().name())
                .seatRow(seat.getRow())
                .seatCol(seat.getCol())
                .status("AVAILABLE")
                .build();
    }
}