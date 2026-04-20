package com.jaivy.BMS.Controller;

import com.jaivy.BMS.Dto.SeatDto.SeatResponseDTO;
import com.jaivy.BMS.Entity.Seat;
import com.jaivy.BMS.Entity.Show;
import com.jaivy.BMS.Service.SeatService.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seats")
public class SeatController {


    private final SeatService seatService;

    @GetMapping("/show/{showId}")
    public ResponseEntity<List<SeatResponseDTO>> getSeatsByShow(@PathVariable Long showId) {
        return ResponseEntity.ok(seatService.getSeatsByShow(showId));
    }


    @GetMapping("/{id}")
    public ResponseEntity<SeatResponseDTO> getSeatById(@PathVariable Long id)
    {
        return ResponseEntity.ok(seatService.getSeatById(id));
    }

}