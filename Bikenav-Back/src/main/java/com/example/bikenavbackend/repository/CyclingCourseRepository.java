package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.CyclingCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CyclingCourseRepository extends JpaRepository<CyclingCourseEntity, Integer> {
    Optional<CyclingCourseEntity> findByCourseId(Integer courseId);
}

