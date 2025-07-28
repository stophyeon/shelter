package com.example.shelter.weather;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeatherMapper {

    @Mapping(target="id", ignore=true)
    Weather toEntity(WeatherDto dto);

    WeatherDto toDto(Weather entity);

    List<WeatherDto> toDtoList(List<Weather> entityList);
    @Mapping(target="id", ignore=true)
    List<Weather> toEntityList(List<WeatherDto> dtoList);
}
