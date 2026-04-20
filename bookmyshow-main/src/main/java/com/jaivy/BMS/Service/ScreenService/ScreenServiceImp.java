package com.jaivy.BMS.Service.ScreenService;

import com.jaivy.BMS.Dto.ScreenDto.ScreenResponseDTO;
import com.jaivy.BMS.Entity.Screen;
import com.jaivy.BMS.Repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenServiceImp implements ScreenService {

    private final ScreenRepository screenRepository;

    @Override
    public List<ScreenResponseDTO> getAllScreen() {

        return screenRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public ScreenResponseDTO getScreenById(Long screenId) {

        Screen screen = screenRepository.findById(screenId)
                .orElseThrow(() ->
                        new RuntimeException("Screen id not found " + screenId));

        return mapToDTO(screen);
    }

    @Override
    public List<ScreenResponseDTO> getScreenByTheater(Long theaterId) {

        return screenRepository.findByTheaterId(theaterId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private ScreenResponseDTO mapToDTO(Screen screen) {

        return ScreenResponseDTO.builder()
                .id(screen.getId())
                .name(screen.getName())
                // ✅ FIX: null check lagao
                .totalSeat(screen.getTotalSeat() != null ? screen.getTotalSeat() : 0)
                .theaterName(screen.getTheater() != null ? screen.getTheater().getName() : "N/A")
                .cityName(screen.getTheater() != null && screen.getTheater().getCity() != null
                        ? screen.getTheater().getCity().getName() : "N/A")
                .build();
    }
}