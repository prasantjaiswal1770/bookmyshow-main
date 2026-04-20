package com.jaivy.BMS.Service.ShowService;

import com.jaivy.BMS.Dto.ShowDto.ShowResponseDTO;
import com.jaivy.BMS.Dto.ShowDto.ShowreqestDto;
import com.jaivy.BMS.Entity.Show;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;
import java.util.List;

public interface ShowService {
    Show AddShow(ShowreqestDto showreqestDto  ) ;

    List<ShowResponseDTO> getShowByMovie(Long movieId ) ;
    List<Show>getShowByMovieAndDate(Long movieId , LocalDate date ) ;

    ShowResponseDTO getShowByid(Long showId);

    List<ShowResponseDTO>getAllShows () ;
}