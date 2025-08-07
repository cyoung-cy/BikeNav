package com.example.bikenavbackend.service;

import com.example.bikenavbackend.dto.response.CoordinateResponse;
import com.example.bikenavbackend.dto.response.PoiResponseDTO;
import com.example.bikenavbackend.entity.PoiEntity;
import com.example.bikenavbackend.repository.PoiRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PoiService {

    private final PoiRepository poiRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PoiService(PoiRepository poiRepository) {
        this.poiRepository = poiRepository;
    }

    public List<PoiResponseDTO> getPois(Integer courseId, String category) {
        List<PoiEntity> entities;

        if (category == null || category.isEmpty()) {
            entities = poiRepository.findByCourseId(courseId);
        } else {
            try {
                PoiEntity.PoiType poiType = PoiEntity.PoiType.valueOf(category); // 문자열 → enum
                entities = poiRepository.findByCourseIdAndPoiType(courseId, poiType);
            } catch (IllegalArgumentException e) {
                // category 문자열이 enum에 없는 값인 경우 예외 처리
                return new ArrayList<>();
            }
        }

        List<PoiResponseDTO> result = new ArrayList<>();
        for (PoiEntity entity : entities) {
            // poi_path 안에 들어있는 JSON → lat/lng 파싱
            CoordinateResponse point = null;
            try {
                if (entity.getPoiPath() != null) {
                    JsonNode node = objectMapper.readTree(entity.getPoiPath());
                    Double lat = node.get("lat").asDouble();
                    Double lng = node.get("lng").asDouble();
                    point = new CoordinateResponse(lat, lng);
                }
            } catch (Exception e) {
                point = null;
            }

            PoiResponseDTO dto = new PoiResponseDTO(
                    entity.getPoiId(),
                    entity.getPoiName(),
                    entity.getPoiType().name(),    // enum → string
                    point,
                    entity.getPoiContant()
            );
            result.add(dto);
        }
        return result;
    }
}
