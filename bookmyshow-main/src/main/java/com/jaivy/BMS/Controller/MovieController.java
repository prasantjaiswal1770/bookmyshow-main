package com.jaivy.BMS.Controller;

import com.jaivy.BMS.Entity.Movie;
import com.jaivy.BMS.Service.MoviesService.MoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {


    private final MoviesService movieService  ;


    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies()
    {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id)
    {
        return ResponseEntity.ok(movieService.getMoviesById(id));
    }


    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String title)
    {
        return ResponseEntity.ok(movieService.searchByTitle(title));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getByGenre(@PathVariable String genre)
    {
        return ResponseEntity.ok(movieService.getByGenre(genre));
    }

    @GetMapping("/genre/{language}")
    public ResponseEntity<List<Movie>> getByLanguage(@PathVariable String language)
    {
        return ResponseEntity.ok(movieService.getByLanguage(language));
    }
}