package com.jaivy.BMS.Controller;

import com.jaivy.BMS.Dto.ShowDto.ShowResponseDTO;
import com.jaivy.BMS.Dto.TheaterDto.TheaterResponseDTO;
import com.jaivy.BMS.Entity.Show;
import com.jaivy.BMS.Service.ShowService.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/shows")
@RequiredArgsConstructor
public class ShowController {

    private  final ShowService showService  ;

    @GetMapping
    public ResponseEntity<List<ShowResponseDTO>> getAllShows()
    {
        return ResponseEntity.ok(showService.getAllShows() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowResponseDTO> getShowById(@PathVariable Long id)
    {
        return ResponseEntity.ok(showService.getShowByid(id));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<ShowResponseDTO>> getshowByMovie(@PathVariable Long movieId)
    {
        return ResponseEntity.ok(showService.getShowByMovie(movieId));
    }
    @GetMapping("/movie/{movieId}/date")
    public ResponseEntity<List<Show>>
    getShowByMovieAndDate(@PathVariable Long movieId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
    {
        return ResponseEntity.ok(showService.getShowByMovieAndDate(movieId,date));
    }
}