package com.jaivy.BMS.Dto.SeatDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SeatResponseDTO {

    private Long id;
    private String seatNumber;
    private String seatType;
    private  String seatRow  ;
     private  Integer seatCol  ;
    private String status;
}