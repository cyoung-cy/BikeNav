package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.TourismDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourismDetailRepository extends JpaRepository<TourismDetail, Integer> {
    List<TourismDetail> findByVillageId(Integer villageId);
}