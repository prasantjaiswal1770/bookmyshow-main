package com.jaivy.BMS.Dto.ShowDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowreqestDto {

    private Integer moviesId  ;
    private Integer showId  ;
    private LocalDate  showDate  ;
    private LocalTime startTime  ;
    private LocalTime endTime ;
    private double ticketPrice ;
    private Long ScreenId  ;

}