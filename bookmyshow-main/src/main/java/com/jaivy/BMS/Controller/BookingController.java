package com.jaivy.BMS.Controller;

import com.jaivy.BMS.Dto.BookingDto.BookingRequestDto;
import com.jaivy.BMS.Dto.BookingDto.BookingResponseDTO;
import com.jaivy.BMS.Dto.SeatDto.CancelSeatRequest;
import com.jaivy.BMS.Service.BookingService.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDto request) {
        return ResponseEntity.ok(bookingService.createBooking(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingResponseDTO>> getBookingByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getBookingByUser(userId));
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<BookingResponseDTO> cancelBooking(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.cancelbooking(id));
    }

    @PutMapping("/{id}/cancel-seats")
    public ResponseEntity<BookingResponseDTO> cancelSeats(
            @PathVariable Long id,
            @RequestBody CancelSeatRequest request   // ✅ FIX
    ) {
        return ResponseEntity.ok(
                bookingService.cancelSeats(id, request.getSeatIds())
        );
    }
}