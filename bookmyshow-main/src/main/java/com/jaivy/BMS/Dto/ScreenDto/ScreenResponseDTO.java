package com.jaivy.BMS.Dto.ScreenDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScreenResponseDTO {

    private Long id;
    private String name;
    private int totalSeat;
    private String theaterName;
    private String cityName;
}