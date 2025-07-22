package com.example.shelter.kafka;

import com.example.shelter.weather.Weather;
import com.example.shelter.weather.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherConsumer {
    private final WeatherRepository repository;

    @KafkaListener(topics = "weather-data", groupId = "weather-group")
    public void listen(List<Weather> weather) {
        log.info("Received shelter data: {}", weather);
        // DB 저장 또는 다른 로직 처리
        if (weather.isEmpty()) return;
        repository.saveAll(weather);

    }
}
