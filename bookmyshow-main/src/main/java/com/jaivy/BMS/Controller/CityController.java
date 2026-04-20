package com.jaivy.BMS.Controller;

import com.jaivy.BMS.Entity.City;
import com.jaivy.BMS.Service.CityService.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping ("/cities")
@RestController
@RequiredArgsConstructor
public class CityController {


    private final CityService cityService;


    @GetMapping
    public ResponseEntity<List<City>> getAllCities()
    {

        return ResponseEntity.ok(cityService.getAllCity() );
    }

    @GetMapping("{id}")
    public ResponseEntity<City> getAllCities(@PathVariable Long id)
    {
        return ResponseEntity.ok(cityService.getCityById(id));
    }


}