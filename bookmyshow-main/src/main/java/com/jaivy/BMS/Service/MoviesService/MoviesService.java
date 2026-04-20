package com.jaivy.BMS.Service.MoviesService;

import com.jaivy.BMS.Entity.Movie;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface MoviesService {

     Movie addMovies(Movie movie ) ;

     List<Movie>getAllMovies() ;

     Movie getMoviesById(Long movieId ) ;
     List<Movie>searchByTitle(String title ) ;
      List<Movie> getByGenre(String genre ) ;
     List<Movie> getByLanguage(String language ) ;

     boolean  DeleteMovie (Movie movie  ) ;
     Movie UpdateMovie (Movie movie ) ;

}