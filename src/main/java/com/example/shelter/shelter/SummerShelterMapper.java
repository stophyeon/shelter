package com.example.shelter.shelter;


import com.example.shelter.shelter.dto.SummerShelterDto;
import com.example.shelter.shelter.entity.SummerShelter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SummerShelterMapper {
    @Mapping(target="id", ignore=true)
    SummerShelter toEntity(SummerShelterDto dto);

    SummerShelterDto toDto(SummerShelter entity);

    List<SummerShelterDto> toDtoList(List<SummerShelter> entityList);
    @Mapping(target="id", ignore=true)
    List<SummerShelter> toEntityList(List<SummerShelterDto> dtoList);
}
