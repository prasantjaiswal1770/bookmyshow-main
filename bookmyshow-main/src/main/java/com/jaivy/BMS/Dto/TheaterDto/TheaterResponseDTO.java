package com.jaivy.BMS.Dto.TheaterDto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class TheaterResponseDTO {

    private Long id;
    private String name;
    private String address;
    private String cityName;
}