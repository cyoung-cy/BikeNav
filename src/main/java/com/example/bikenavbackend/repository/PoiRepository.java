package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.Poi;
import com.example.bikenavbackend.entity.PoiType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PoiRepository extends JpaRepository<Poi, Long> {

    // course_poi 조인 테이블과 조인하여 courseId에 해당하는 Poi 조회
    @Query("SELECT p FROM Poi p JOIN CoursePoi cp ON p.placeId = cp.poi.placeId WHERE cp.course.courseId = :courseId")
    List<Poi> findByCourseId(@Param("courseId") Long courseId);

    @Query("SELECT cp.poi FROM CoursePoi cp WHERE cp.course.courseId = :courseId AND cp.poi.type = :category")
    List<Poi> findByCourseIdAndCategory(@Param("courseId") Long courseId, @Param("category") PoiType category);
}
