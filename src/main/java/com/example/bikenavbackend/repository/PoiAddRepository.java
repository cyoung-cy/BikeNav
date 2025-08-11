package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.PoiAddEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoiAddRepository extends JpaRepository<PoiAddEntity, Integer> {

    PoiAddEntity findByPoiId(Integer poiId);

}
