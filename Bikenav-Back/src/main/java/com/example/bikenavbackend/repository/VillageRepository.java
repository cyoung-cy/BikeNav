package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepository extends JpaRepository<Village, Integer> {
}