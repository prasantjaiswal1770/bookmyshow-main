package com.jaivy.BMS.Service.ScreenService;

import com.jaivy.BMS.Dto.ScreenDto.ScreenResponseDTO;

import java.util.List;

public interface ScreenService {

    List<ScreenResponseDTO> getAllScreen();

    ScreenResponseDTO getScreenById(Long screenId);

    List<ScreenResponseDTO> getScreenByTheater(Long theaterId);
}