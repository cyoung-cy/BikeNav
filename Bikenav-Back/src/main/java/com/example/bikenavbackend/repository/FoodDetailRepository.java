package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.FoodDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodDetailRepository extends JpaRepository<FoodDetail, Integer> {
    List<FoodDetail> findByVillageId(Integer villageId);
}

