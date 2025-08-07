package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.WalkingCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalkingCourseRepository extends JpaRepository<WalkingCourseEntity, Integer> {
    Optional<WalkingCourseEntity> findByCourseId(Integer courseId);
}

