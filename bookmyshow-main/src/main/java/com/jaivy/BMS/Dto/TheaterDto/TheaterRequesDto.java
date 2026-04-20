package com.jaivy.BMS.Dto.TheaterDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterRequesDto {
    private String name  ;
    private  String addresh  ;
    private Long  cityId  ;
}