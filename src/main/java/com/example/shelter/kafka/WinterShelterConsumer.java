package com.example.shelter.kafka;

import com.example.shelter.shelter.entity.WinterShelter;
import com.example.shelter.shelter.repository.WinterShelterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WinterShelterConsumer {
    private final WinterShelterRepository repository;

    @KafkaListener(topics = "winter-shelter-data", groupId = "shelter-group")
    public void listen(List<WinterShelter> shelter) {
        log.info("Received shelter data: {}", shelter);
        // DB 저장 또는 다른 로직 처리
        if (shelter.isEmpty()) return;
        repository.saveAll(shelter);
    }
}
