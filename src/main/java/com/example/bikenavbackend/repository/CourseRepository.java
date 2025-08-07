package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("SELECT c FROM Course c " +
            "WHERE (:type IS NULL OR c.courseType = :type) " +
            "AND   (:diff IS NULL OR c.diff = :diff) " +
            "AND   (:isRecommended IS NULL OR c.isRecommended = :isRecommended)")
    List<Course> findCourses(
            @Param("type") String type,
            @Param("diff") String diff,
            @Param("isRecommended") Boolean isRecommended);

}
