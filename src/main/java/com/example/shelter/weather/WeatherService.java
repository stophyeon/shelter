package com.example.shelter.weather;

import com.example.shelter.weather.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherRepository repository;
    private final TranNxNyService translator;
    private final WeatherMapper mapper;


    public WeatherDto findTodayWeather(String userLat, String userLot){
        Grid loc = translator.latLonToGrid(Double.parseDouble(userLat),Double.parseDouble(userLot));
        Weather entity =repository.findByNxNy(loc.getNx(), loc.getNy());
        return mapper.toDto(entity);
    }
}
