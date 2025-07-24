package com.example.shelter.shelter.repository;


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
        SELECT s.*,
               (6371 * acos(cos(radians(:userLat)) * cos(radians(s.latitude)) * 
                            cos(radians(s.longitude) - radians(:userLng)) + 
                            sin(radians(:userLat)) * sin(radians(s.latitude)))
               ) AS distance 
        FROM summer_shelters s
        HAVING distance <= :radiusKm
        ORDER BY distance ASC
        """, nativeQuery = true)
    List<SummerShelter> findNearbyShelters(
            @Param("userLat") double userLat,
            @Param("userLng") double userLng,
            @Param("radiusKm") double radiusKm
    );
}
