package com.jaivy.BMS.Service.CityService;

import com.jaivy.BMS.Entity.City;
import com.jaivy.BMS.Repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImp implements  CityService {

    private  final CityRepository cityRepository  ;

    @Override
    public City addCity(City city) {
        return cityRepository.save(city) ;

    }

    @Override
    public List<City> getAllCity() {
        return  cityRepository.findAll();

    }

    @Override
    public City getCityById(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(()-> new RuntimeException("City not found "+ cityId ));
    }


}