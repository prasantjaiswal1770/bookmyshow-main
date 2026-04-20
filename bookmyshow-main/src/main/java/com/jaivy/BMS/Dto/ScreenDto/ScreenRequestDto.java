package com.jaivy.BMS.Dto.ScreenDto;


import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScreenRequestDto {
    private  Integer TotalSeat  ;
    private String name  ;
    private Long theaterId  ;
}