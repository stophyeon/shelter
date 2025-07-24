package com.example.shelter.shelter;

import com.example.shelter.shelter.dto.SummerShelterDto;
import com.example.shelter.shelter.dto.WinterShelterDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shelter")
@RequiredArgsConstructor
public class ShelterController {

    private final ShelterService service;

    @GetMapping("/summer/near")
    @Operation(summary = "무더위 쉼터 리스트 조회", description = "사용자 위치 근방 10KM이내 쉼터 리스트 조회",
            parameters = {
                    @Parameter(in = ParameterIn.HEADER, name = "userLat", description = "사용자 위치 위도", required = true, example = "37.359708"),
                    @Parameter(in = ParameterIn.HEADER, name = "userLot", description = "사용자 위치 경도", required = true, example = "127.1058342")
            })
    public List<SummerShelterDto> findNearSummerShelter(@RequestParam(value = "userLat",required = true) String userLat,
                                                  @RequestParam(value = "userLot",required = true)String userLot){
        return service.findNearSummerShelter(Double.valueOf(userLat),Double.valueOf(userLot));
    }

    @GetMapping("/winter/near")
    @Operation(summary = "한파 쉼터 리스트 조회", description = "사용자 위치 근방 10KM이내 쉼터 리스트 조회",
            parameters = {
                    @Parameter(in = ParameterIn.HEADER, name = "userLat", description = "사용자 위치 위도", required = true, example = "37.359708"),
                    @Parameter(in = ParameterIn.HEADER, name = "userLot", description = "사용자 위치 경도", required = true, example = "127.1058342")
            })
    public List<WinterShelterDto> findNearWinterShelter(@RequestParam(value = "userLat",required = true) String userLat,
                                                  @RequestParam(value = "userLot",required = true)String userLot){
        return service.findNearWinterShelter(Double.valueOf(userLat),Double.valueOf(userLot));
    }
}
