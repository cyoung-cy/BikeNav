package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByCourseTypeAndDiffAndIsRecommended(String courseType, String diff, Boolean isRecommended);
    List<Course> findByCourseTypeAndDiff(String courseType, String diff);
    List<Course> findByCourseType(String courseType);
}