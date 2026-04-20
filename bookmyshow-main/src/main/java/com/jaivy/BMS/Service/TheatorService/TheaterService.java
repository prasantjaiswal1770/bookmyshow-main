package com.jaivy.BMS.Service.TheatorService;

import com.jaivy.BMS.Dto.TheaterDto.TheaterRequesDto;
import com.jaivy.BMS.Dto.TheaterDto.TheaterResponseDTO;
import com.jaivy.BMS.Entity.Theater;
import com.jaivy.BMS.Repository.TheaterRepository;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface TheaterService  {


    Theater addTheater (TheaterRequesDto  theaterRequesDto) ;

    Theater getThearterById(Long theaterId) ;

    List<Theater> getAllTheater();

List<TheaterResponseDTO> getTheaterByCityId(Long cityId);
}