package com.jaivy.BMS.Service.CityService;

import com.jaivy.BMS.Entity.City;

import java.util.List;

public interface CityService {
    City addCity(City city ) ;
    List<City> getAllCity () ;
    City getCityById  (Long cityId ) ;

}