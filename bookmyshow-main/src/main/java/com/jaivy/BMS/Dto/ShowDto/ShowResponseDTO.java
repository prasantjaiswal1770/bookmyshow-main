package com.jaivy.BMS.Dto.ShowDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowResponseDTO {
    private Long id;
    private Long screenId;
    private String screenName;
    private String theaterName;
    private String cityName;
    private String movieTitle;
    private LocalDate showDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Double ticketPrice;
}