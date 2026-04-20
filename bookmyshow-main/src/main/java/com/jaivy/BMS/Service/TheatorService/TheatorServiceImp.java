package com.jaivy.BMS.Service.TheatorService;

import com.jaivy.BMS.Dto.TheaterDto.TheaterRequesDto;
import com.jaivy.BMS.Dto.TheaterDto.TheaterResponseDTO;
import com.jaivy.BMS.Entity.City;
import com.jaivy.BMS.Entity.Theater;
import com.jaivy.BMS.Repository.TheaterRepository;
import com.jaivy.BMS.Service.CityService.CityServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheatorServiceImp implements  TheaterService {

    private final CityServiceImp cityServiceImp  ;
    private final  TheaterRepository theaterRepository  ;

    // ADD THEATER SERVIVE IMPLEMENTATION
    @Override
    public Theater addTheater(TheaterRequesDto theaterRequesDto ) {
            City city = cityServiceImp.getCityById(theaterRequesDto.getCityId()) ;
            Theater theater  = Theater.builder()
                    .name(theaterRequesDto.getName())
                    .addresh(theaterRequesDto.getAddresh())
                    .city(city)
                    .build() ;
            return theaterRepository.save(theater) ;

    }

    @Override
    public Theater getThearterById(Long theaterId) {
        return theaterRepository.findById(theaterId)
                .orElseThrow( () -> new RuntimeException("Theater is not present  "+ theaterId  )) ;
    }

    @Override
    public List<Theater> getAllTheater() {
         return theaterRepository.findAll() ;
    }

    @Override
    public List<TheaterResponseDTO> getTheaterByCityId(Long cityId) {

        List<Theater> theaters = theaterRepository.findByCityId(cityId);

        return theaters.stream()
                .map(theater -> TheaterResponseDTO.builder()
                        .id(theater.getId())
                        .name(theater.getName())
                        .address(theater.getAddresh())
                        .cityName(theater.getCity().getName())
                        .build())
                .toList();
    }



}