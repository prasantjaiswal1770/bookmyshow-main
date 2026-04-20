package com.jaivy.BMS.Service.ShowService;

import com.jaivy.BMS.Dto.ShowDto.ShowResponseDTO;
import com.jaivy.BMS.Dto.ShowDto.ShowreqestDto;
import com.jaivy.BMS.Entity.Movie;
import com.jaivy.BMS.Entity.Screen;
import com.jaivy.BMS.Entity.Show;
import com.jaivy.BMS.Repository.ScreenRepository;
import com.jaivy.BMS.Repository.ShowRepository;
import com.jaivy.BMS.Service.MoviesService.MoviesService;
import com.jaivy.BMS.Service.TheatorService.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowServiceImp implements ShowService {

    private final ShowRepository showRepository;
    private final MoviesService moviesService;
    private final TheaterService theaterService;
    private final ScreenRepository screenRepository;

    // ===== ADD SHOW =====
    @Override
    public Show AddShow(ShowreqestDto showreqestDto) {
        Movie dbMovie = moviesService.getMoviesById(Long.valueOf(showreqestDto.getMoviesId()));
        Screen screen = screenRepository.getScreenById(showreqestDto.getScreenId());
        Show show = Show.builder()
                .movie(dbMovie)
                .screen(screen)
                .startTime(showreqestDto.getStartTime())
                .endTime(showreqestDto.getEndTime())
                .showDate(showreqestDto.getShowDate())
                .ticketPrice(showreqestDto.getTicketPrice())
                .build();
        return showRepository.save(show);
    }

    // ===== GET ALL SHOWS =====
    @Override
    public List<ShowResponseDTO> getAllShows() {
        return showRepository.findAll()
                .stream()
                .map(show -> ShowResponseDTO.builder()
                        .id(show.getId())
                        .screenId(show.getScreen().getId())
                        .movieTitle(show.getMovie().getTitle())
                        .screenName(show.getScreen().getName())
                        .theaterName(show.getScreen().getTheater().getName())
                        .cityName(show.getScreen().getTheater().getCity().getName())
                        .showDate(show.getShowDate())
                        .startTime(show.getStartTime())
                        .endTime(show.getEndTime())
                        .ticketPrice(show.getTicketPrice())
                        .build())
                .toList();
    }

    // ===== GET SHOW BY ID =====
    @Override
    public ShowResponseDTO getShowByid(Long showId) {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found: " + showId));
        return ShowResponseDTO.builder()
                .id(show.getId())
                .screenId(show.getScreen().getId())
                .movieTitle(show.getMovie().getTitle())
                .screenName(show.getScreen().getName())
                .theaterName(show.getScreen().getTheater().getName())
                .cityName(show.getScreen().getTheater().getCity().getName())
                .showDate(show.getShowDate())
                .startTime(show.getStartTime())
                .endTime(show.getEndTime())
                .ticketPrice(show.getTicketPrice())
                .build();
    }

    // ===== GET SHOW BY MOVIE =====
    @Override
    public List<ShowResponseDTO> getShowByMovie(Long movieId) {
        return showRepository.findByMovieId(movieId)
                .stream()
                .map(show -> ShowResponseDTO.builder()
                        .id(show.getId())
                        .screenId(show.getScreen().getId())
                        .movieTitle(show.getMovie().getTitle())
                        .screenName(show.getScreen().getName())
                        .theaterName(show.getScreen().getTheater().getName())
                        .cityName(show.getScreen().getTheater().getCity().getName())
                        .showDate(show.getShowDate())
                        .startTime(show.getStartTime())
                        .endTime(show.getEndTime())
                        .ticketPrice(show.getTicketPrice())
                        .build())
                .toList();
    }

    // ===== GET SHOW BY MOVIE AND DATE =====
    @Override
    public List<Show> getShowByMovieAndDate(Long movieId, LocalDate date) {
        return showRepository.findByMovieIdAndShowDate(movieId, date);
    }
}