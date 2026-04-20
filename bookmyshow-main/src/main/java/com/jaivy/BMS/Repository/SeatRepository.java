package com.jaivy.BMS.Repository;

import com.jaivy.BMS.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat>findByScreenId(Long ScreenId ) ;

}