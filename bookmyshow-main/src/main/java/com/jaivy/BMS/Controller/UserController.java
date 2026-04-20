package com.jaivy.BMS.Controller;

import com.jaivy.BMS.Dto.LogInDto.LoginRequestDto;
import com.jaivy.BMS.Dto.UserDto.UserRequestDto;
import com.jaivy.BMS.Entity.User;
import com.jaivy.BMS.Service.UserService.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.RMIServerSocketFactory;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private  final UserServices  userServices  ;


    @PostMapping("/register")
    private ResponseEntity<User> register(@RequestBody UserRequestDto userRequestDto  ) {
       User user =  userServices.register(userRequestDto) ;
       return  ResponseEntity.ok(user) ;

    }

     @PostMapping("/login")
    private ResponseEntity<User> login(@RequestBody LoginRequestDto loginRequestDto ) {
         return ResponseEntity.ok(userServices.Login(loginRequestDto)) ;

     }

     @GetMapping("/getalluser")
    private ResponseEntity<List<User> > getAllUser  () {
         return  ResponseEntity.ok(userServices.getAllUser()) ;
     }

   @GetMapping ("/{Id}")
    private ResponseEntity<User> getAllUserById ( @PathVariable  Long id ) {
        return ResponseEntity.ok(userServices.getUserById(id))  ;
   }




}