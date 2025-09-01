package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.CourseDescEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseDescRepository extends JpaRepository<CourseDescEntity, Integer> {
    Optional<CourseDescEntity> findByCourseId(Integer courseId);
}
