package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findByCourseId(Long courseId);
}
