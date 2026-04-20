package com.jaivy.BMS.Repository;

import com.jaivy.BMS.Entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
    List<Screen> findByTheaterId(Long TheaterId ) ;

    Screen getScreenById(Long screenId);
}