package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.PoiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PoiRepository extends JpaRepository<PoiEntity, Integer> {

    @Query(value = "SELECT p.* FROM poi p "
            + "JOIN course_poi cp ON p.poi_id = cp.poi_id "
            + "WHERE cp.course_id = :courseId", nativeQuery = true)
    List<PoiEntity> findPoisByCourseId(@Param("courseId") Integer courseId);

    @Query(value = "SELECT p.* FROM poi p "
            + "JOIN course_poi cp ON p.poi_id = cp.poi_id "
            + "WHERE cp.course_id = :courseId AND p.poi_type = :poiType", nativeQuery = true)
    List<PoiEntity> findPoisByCourseIdAndPoiType(@Param("courseId") Integer courseId,
                                                 @Param("poiType") String poiType);

    @Query(value = "SELECT p.* FROM poi p "
            + "JOIN course_poi cp ON p.poi_id = cp.poi_id "
            + "WHERE cp.course_id = :courseId AND p.poi_id = :poiId", nativeQuery = true)
    Optional<PoiEntity> findByCourseIdAndPoiId(@Param("courseId") Integer courseId,
                                               @Param("poiId") Integer poiId);
}
