package com.jaivy.BMS.Service.UserService;

import com.jaivy.BMS.Dto.LogInDto.LoginRequestDto;
import com.jaivy.BMS.Dto.UserDto.UserRequestDto;
import com.jaivy.BMS.Entity.User;
import com.jaivy.BMS.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class  UserServiceImp implements UserServices {

    private final UserRepository  userRepository  ;

    @Override
    public User register(UserRequestDto userRequestDto) {
        if(userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new RuntimeException("Email already exist " +  userRequestDto.getEmail()) ;
        }
        User user = User.builder()
                .name(userRequestDto.getName())
                .phoneNumber(userRequestDto.getPhoneNumber() )
                .password(userRequestDto.getPassword())
                .email(userRequestDto.getEmail())
                .build() ;
        userRepository.save(user) ;
        return user  ;
    }

    @Override
    public User Login(LoginRequestDto loginRequestDto) {
        User user  =  userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow( ()-> new RuntimeException( "User Not found ")) ;

        if( loginRequestDto.getPassword() ==  user.getPassword()) {
            throw new RuntimeException("Invalid password ") ;
        }
        return  user ;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll() ;
    }


    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow( () -> new RuntimeException("User Not Found " + userId )) ;

    }




}