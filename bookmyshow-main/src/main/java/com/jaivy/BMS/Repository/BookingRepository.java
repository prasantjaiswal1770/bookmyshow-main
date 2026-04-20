package com.jaivy.BMS.Repository;

import com.jaivy.BMS.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserId(Long userId);

    List<Booking> findByShowId(Long showId);

//    @Query("""
//           SELECT s.id
//           FROM Booking b
//           JOIN b.seats s
//           WHERE b.show.id = :showId
//           """)
//    List<Long> findBookedSeatIdByShowId(Long showId);

    @Query("""
SELECT s.id FROM Booking b 
JOIN b.seats s 
WHERE b.show.id = :showId 
AND b.bookingStatus = 'CONFIRMED'
""")
    List<Long> findBookedSeatIdsByShowId(Long showId);

}