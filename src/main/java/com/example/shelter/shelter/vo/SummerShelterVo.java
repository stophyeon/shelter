package com.example.shelter.shelter.vo;

import com.example.shelter.shelter.dto.SummerShelterDto;
import com.example.shelter.shelter.dto.WinterShelterDto;
import lombok.Data;

import java.util.List;

@Data
public class SummerShelterVo {
    private String resultMsg;
    private String resultCode;
    private List<SummerShelterDto> shelters;
}
