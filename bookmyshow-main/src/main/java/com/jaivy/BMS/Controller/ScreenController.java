package com.jaivy.BMS.Controller;

import com.jaivy.BMS.Dto.ScreenDto.ScreenResponseDTO;
import com.jaivy.BMS.Service.ScreenService.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    @GetMapping
    public ResponseEntity<List<ScreenResponseDTO>> getAllScreens() {
        return ResponseEntity.ok(screenService.getAllScreen());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScreenResponseDTO> getScreenById(@PathVariable Long id) {
        return ResponseEntity.ok(screenService.getScreenById(id));
    }

    @GetMapping("/theater/{theaterId}")
    public ResponseEntity<List<ScreenResponseDTO>> getScreenByTheaterId(
            @PathVariable Long theaterId) {

        return ResponseEntity.ok(screenService.getScreenByTheater(theaterId));
    }
}