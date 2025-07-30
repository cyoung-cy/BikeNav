package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
