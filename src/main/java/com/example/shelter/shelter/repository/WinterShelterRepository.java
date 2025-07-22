package com.example.shelter.shelter.repository;


import com.example.shelter.shelter.entity.WinterShelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository

public interface WinterShelterRepository extends JpaRepository<WinterShelter,Long> {
    //public List<WinterShelter> findByRegionCode(String regionCode);
    public boolean existsByFacilityId(Long shelterId);
    @Query("SELECT w.facilityId FROM WinterShelter w")
    public Set<Long> findAllFacilityIds();

}
