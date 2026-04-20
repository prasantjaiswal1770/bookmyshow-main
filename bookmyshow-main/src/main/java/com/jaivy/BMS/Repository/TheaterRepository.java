package com.jaivy.BMS.Repository;

import com.jaivy.BMS.Dto.TheaterDto.TheaterResponseDTO;
import com.jaivy.BMS.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

    List<Theater> findByCityId(Long cityId);

}