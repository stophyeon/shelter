package com.example.shelter.kafka;

import com.example.shelter.shelter.entity.SummerShelter;
import com.example.shelter.shelter.repository.SummerShelterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SummerShelterConsumer {
    private final SummerShelterRepository repository;

    //@KafkaListener(topics = "summer-shelter-data", groupId = "shelter-group")
    public void listen(List<SummerShelter> shelter) {
        log.info("Received shelter data: {}", shelter);
        // DB 저장 또는 다른 로직 처리
        if (shelter.isEmpty()) return;
        repository.saveAll(shelter);
    }
}
