package com.example.bikenavbackend.repository;

import com.example.bikenavbackend.entity.PoiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PoiRepository extends JpaRepository<PoiEntity, Integer> {

    List<PoiEntity> findByCourseId(Integer courseId);

    List<PoiEntity> findByCourseIdAndPoiType(Integer courseId, PoiEntity.PoiType poiType);
}
