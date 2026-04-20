package com.jaivy.BMS.Dto.SeatDto;

import com.jaivy.BMS.Entity.Screen;
import com.jaivy.BMS.Entity.Seat;
import com.jaivy.BMS.Enum.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequestDto {
    private  String seatNumber  ;
    private  String row  ;
    private Integer col  ;
    private SeatType seatType  ;

    private Screen screen ;
}