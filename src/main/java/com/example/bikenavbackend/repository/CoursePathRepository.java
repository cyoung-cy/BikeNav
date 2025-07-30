package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.CoursePath;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursePathRepository extends JpaRepository<CoursePath, Long> {
    List<CoursePath> findByCourse_CourseIdOrderBySeqAsc(Long courseId);
}
