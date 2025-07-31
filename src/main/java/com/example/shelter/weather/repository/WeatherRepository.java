package com.example.shelter.weather.repository;

import com.example.shelter.weather.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface WeatherRepository extends JpaRepository<Weather,Long> {
    //public List<WinterShelter> findByRegionCode(String regionCode);
    public Weather findByNxNy(Integer nx, Integer ny);

}
