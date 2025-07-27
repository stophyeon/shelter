package com.example.shelter.shelter.repository;


import com.example.shelter.shelter.dto.SummerShelterDto;
import com.example.shelter.shelter.entity.SummerShelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository

public interface SummerShelterRepository extends JpaRepository<SummerShelter,Long> {
    //public List<WinterShelter> findByRegionCode(String regionCode);
    public boolean existsByFacilityId(Long shelterId);
    @Query("SELECT s.facilityId FROM SummerShelter s")
    Set<Long> findAllFacilityIds();

    @Query(value = """
        SELECT s.facility_id, s.shelter_name, s.road_address, s.address_number,
                                  s.facility_type, s.facility_sub_type, s.usable_people,
                                  s.longitude, s.latitude,
                                  s.weekday_start_time, s.weekday_end_time,
                                  s.weekend_start_time, s.weekend_end_time,
                                  s.weekend_open_yn, s.night_open_yn, s.stay_possible_yn,
                                  s.cold_air_conditioner_count, s.electric_fan_count,
                                  s.area, s.year, s.area_code, s.manager_dept_code,
                                  s.modified_time, s.input_time, s.remark,
               TRUNCATE((6371 * acos(cos(radians(:userLat)) * cos(radians(s.latitude)) *
                            cos(radians(s.longitude) - radians(:userLng)) +
                            sin(radians(:userLat)) * sin(radians(s.latitude)))
               ),4) AS distance
        FROM summer_shelters s
        HAVING distance <= :radiusKm
        ORDER BY distance ASC
        """, nativeQuery = true)
    List<SummerShelterDto> findNearbyShelters(
            @Param("userLat") double userLat,
            @Param("userLng") double userLng,
            @Param("radiusKm") double radiusKm
    );
}
