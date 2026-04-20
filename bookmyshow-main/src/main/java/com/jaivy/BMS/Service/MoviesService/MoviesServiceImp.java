package com.jaivy.BMS.Service.MoviesService;

import com.jaivy.BMS.Entity.Movie;
import com.jaivy.BMS.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesServiceImp implements MoviesService {

    private final MovieRepository movieRepository ;


    @Override
    public Movie addMovies(Movie movie) {
      return movieRepository.save(movie) ;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll() ;
    }

    @Override
    public Movie getMoviesById(Long movieId) {
         return  movieRepository.findById(movieId)
                 .orElseThrow( ()-> new RuntimeException("Movie not Found "));
    }

    @Override
    public List<Movie> searchByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title) ;
    }

    @Override
    public List<Movie> getByGenre(String genre) {
        return movieRepository.findByGenre(genre) ;
    }

    @Override

    public  List<Movie>  getByLanguage(String language) {
        return movieRepository.findByLanguage(language) ;
    }

    @Override
    public boolean DeleteMovie(Movie movie) {
        if(movieRepository.existsById(movie.getId())) {
            movieRepository.delete(movie) ;
            return true  ;
        } else{
            return false   ;
        }
    }

    @Override
    public Movie UpdateMovie(Movie movie) {
        Movie DbMovies =  movieRepository.findById(movie.getId() )
                .orElseThrow( () ->new RuntimeException(  " First add this Movies ")) ;
        if(DbMovies != null ) {
           DbMovies.setDescription(movie.getDescription()) ;
           DbMovies.setDurationInMinutes(movie.getDurationInMinutes());
           DbMovies.setGenre(movie.getGenre());
           DbMovies.setId(movie.getId());
           DbMovies.setLanguage(movie.getLanguage());
           DbMovies.setPosterUrl(movie.getPosterUrl());
           DbMovies.setRating(movie.getRating());
           DbMovies.setRealeseDate(movie.getRealeseDate());
           DbMovies.setTitle(movie.getTitle() );

           movieRepository.save(DbMovies) ;
        }
        return DbMovies ;
    }


}