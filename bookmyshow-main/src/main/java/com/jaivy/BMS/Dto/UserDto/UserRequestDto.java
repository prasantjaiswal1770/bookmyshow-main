package com.jaivy.BMS.Dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.print.attribute.standard.RequestingUserName;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String name  ;
    private String email  ;
    private  String password  ;
    private String phoneNumber  ;
}