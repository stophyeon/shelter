package com.example.shelter.shelter;

import com.example.shelter.shelter.dto.SummerShelterDto;
import com.example.shelter.shelter.dto.WinterShelterDto;
import com.example.shelter.shelter.entity.SummerShelter;
import com.example.shelter.shelter.entity.WinterShelter;
import com.example.shelter.shelter.repository.SummerShelterRepository;
import com.example.shelter.shelter.repository.WinterShelterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShelterService {

    private final SummerShelterRepository summerShelterRepository;
    private final WinterShelterRepository winterShelterRepository;
    private final SummerShelterMapper summerMapper;
    private final WinterShelterMapper winterMapper;
    public List<SummerShelterDto> findNearSummerShelter(Double lat, Double lot){
        List<Object[]> rawResults = summerShelterRepository.findNearbyShelters(lat,lot,10);
        List<SummerShelter> shelters = new ArrayList<>();
        for (Object[] row : rawResults) {
            SummerShelter shelter = (SummerShelter) row[0];
            Double distance = ((Number) row[1]).doubleValue();
            shelter.setDistance(distance);
            shelters.add(shelter);
        }
        return summerMapper.toDtoList(shelters);
    }

    public List<WinterShelterDto> findNearWinterShelter(Double lat, Double lot){
        List<Object[]> rawResults = winterShelterRepository.findNearbyShelters(lat,lot,10);
        List<WinterShelter> shelters = new ArrayList<>();
        for (Object[] row : rawResults) {
            WinterShelter shelter = (WinterShelter) row[0];
            Double distance = ((Number) row[1]).doubleValue();
            shelter.setDistance(distance);  // @Transient 필드에 직접 주입
            shelters.add(shelter);
        }
        return winterMapper.toDtoList(shelters);
    }
}
