package com.jaivy.BMS.Service.SeatService;

import com.jaivy.BMS.Dto.SeatDto.SeatResponseDTO;
import com.jaivy.BMS.Entity.Seat;

import java.util.List;

public interface SeatService {

    Seat addSeat(Seat seat);

    SeatResponseDTO getSeatById(Long seatId);


    List<SeatResponseDTO> getSeatsByShow(Long showId);
}