package com.jaivy.BMS.Service.UserService;


import com.jaivy.BMS.Dto.LogInDto.LoginRequestDto;
import com.jaivy.BMS.Dto.UserDto.UserRequestDto;
import com.jaivy.BMS.Entity.User;

import java.util.List;

public interface  UserServices {
    User register(UserRequestDto userRequestDto  ) ;
    User Login(LoginRequestDto loginRequestDto ) ;
    List<User> getAllUser () ;
    User  getUserById (Long userId ) ;
}