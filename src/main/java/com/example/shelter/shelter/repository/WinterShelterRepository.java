package com.example.shelter.shelter.repository;



import com.example.shelter.shelter.dto.WinterShelterDto;
import com.example.shelter.shelter.entity.WinterShelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository

public interface WinterShelterRepository extends JpaRepository<WinterShelter,Long> {
    //public List<WinterShelter> findByRegionCode(String regionCode);
    public boolean existsByFacilityId(Long shelterId);
    @Query("SELECT w.facilityId FROM WinterShelter w")
    public Set<Long> findAllFacilityIds();

    @Query(value = """
        SELECT s.name,
                                                  s.sunday_open_time,
                                                  s.modified_at,
                                                  s.road_address,
                                                  s.holiday_close_time,
                                                  s.address_number,
                                                  s.capacity,
                                                  s.weekday_open_time,
                                                  s.saturday_close_time,
                                                  s.sunday_close_time,
                                                  s.facility_type,
                                                  s.facility_sub_type,
                                                  s.facility_id,
                                                  s.longitude,
                                                  s.latitude,
                                                  s.saturday_open_time,
                                                  s.remark,
                                                  s.holiday_open_time,
                                                  s.weekday_close_time,
               TRUNCATE((6371 * acos(cos(radians(:userLat)) * cos(radians(s.latitude)) *
                            cos(radians(s.longitude) - radians(:userLng)) +
                            sin(radians(:userLat)) * sin(radians(s.latitude)))
               ),4) AS distance
        FROM winter_shelters s
        HAVING distance <= :radiusKm
        ORDER BY distance ASC
        """, nativeQuery = true)
    List<WinterShelterDto> findNearbyShelters(
            @Param("userLat") double userLat,
            @Param("userLng") double userLng,
            @Param("radiusKm") double radiusKm
    );

}
