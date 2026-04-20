package com.jaivy.BMS.Dto.SeatDto;

import lombok.Data;

import java.util.List;

@Data
public class CancelSeatRequest {
    private List<Long> seatIds;
}