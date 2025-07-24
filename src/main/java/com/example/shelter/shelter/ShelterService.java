package com.example.shelter.shelter;

import com.example.shelter.shelter.dto.SummerShelterDto;
import com.example.shelter.shelter.dto.WinterShelterDto;
import com.example.shelter.shelter.repository.SummerShelterRepository;
import com.example.shelter.shelter.repository.WinterShelterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShelterService {

    private final SummerShelterRepository summerShelterRepository;
    private final WinterShelterRepository winterShelterRepository;
    private final SummerShelterMapper summerMapper;
    private final WinterShelterMapper winterMapper;
    public List<SummerShelterDto> findNearSummerShelter(Double lat, Double lot){
        return summerMapper.toDtoList(summerShelterRepository.findNearbyShelters(lat,lot,10));
    }

    public List<WinterShelterDto> findNearWinterShelter(Double lat, Double lot){
        return winterMapper.toDtoList(winterShelterRepository.findNearbyShelters(lat,lot,10));
    }
}
