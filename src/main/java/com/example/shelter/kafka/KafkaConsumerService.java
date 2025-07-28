package com.example.shelter.kafka;

import com.example.shelter.shelter.entity.SummerShelter;
import com.example.shelter.shelter.entity.WinterShelter;
import com.example.shelter.shelter.repository.SummerShelterRepository;
import com.example.shelter.shelter.repository.WinterShelterRepository;
import com.example.shelter.weather.Weather;
import com.example.shelter.weather.repository.WeatherRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {
    private final SummerShelterRepository summerRepo;
    private final WinterShelterRepository winterRepo;
    private final WeatherRepository weatherRepo;

    @KafkaListener(topics = "summer-shelter-data", groupId = "shelter-group")
    public void consumeSummer(List<SummerShelter> data) {
        if (!data.isEmpty()) summerRepo.saveAll(data);
    }

    @KafkaListener(topics = "winter-shelter-data", groupId = "shelter-group")
    public void consumeWinter(List<WinterShelter> data) {
        if (!data.isEmpty()) winterRepo.saveAll(data);
    }

    @KafkaListener(topics = "weather-data", groupId = "weather-group")
    public void consumeWeather(List<Weather> data) {
        if (!data.isEmpty()) weatherRepo.saveAll(data);
    }
}
