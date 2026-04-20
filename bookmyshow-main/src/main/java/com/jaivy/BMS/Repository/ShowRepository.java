package com.jaivy.BMS.Repository;

import ch.qos.logback.classic.pattern.ClassOfCallerConverter;
import com.jaivy.BMS.Entity.Show;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByMovieId(Long movieId ) ;
    List<Show>findByScreenId(Long  screenId) ;
    List<Show>findByMovieIdAndShowDate(Long movieId , LocalDate showDate ) ;
    List<Show> findByScreenIdAndShowDate(Long  screenId , LocalDate showDate) ;
}