package com.jaivy.BMS.Controller;

import com.jaivy.BMS.Dto.TheaterDto.TheaterResponseDTO;
import com.jaivy.BMS.Entity.Theater;
import com.jaivy.BMS.Service.TheatorService.TheaterService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/theaters")
@RequiredArgsConstructor
public class TheaterController {

    private  final TheaterService theaterService  ;

    @GetMapping("/getAllTheater")
    public ResponseEntity<List<Theater> > getAllTheater () {
          return ResponseEntity.ok(theaterService.getAllTheater () )  ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theater> getAllTheaterById (@PathVariable Long id  ) {
        return ResponseEntity.ok(theaterService.getThearterById(id ))  ;
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<TheaterResponseDTO> > getTheaterByCity  (@PathVariable Long cityId ) {
        return ResponseEntity.ok(theaterService.getTheaterByCityId ( cityId  ))  ;
    }











}