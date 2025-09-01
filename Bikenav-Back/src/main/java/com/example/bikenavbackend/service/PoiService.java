package com.example.bikenavbackend.service;

import com.example.bikenavbackend.dto.response.CoordinateResponse;
import com.example.bikenavbackend.dto.response.PoiDetailResponseDTO;
import com.example.bikenavbackend.dto.response.PoiResponseDTO;
import com.example.bikenavbackend.dto.response.PoiSummaryResponseDTO;
import com.example.bikenavbackend.entity.PoiAddEntity;
import com.example.bikenavbackend.entity.PoiEntity;
import com.example.bikenavbackend.repository.PoiAddRepository;
import com.example.bikenavbackend.repository.PoiRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PoiService {

    private final PoiRepository poiRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final PoiAddRepository poiAddRepository;

    public PoiService(PoiRepository poiRepository, PoiAddRepository poiAddRepository) {
        this.poiRepository = poiRepository;
        this.poiAddRepository = poiAddRepository;
    }

    public List<PoiSummaryResponseDTO> getPoiSummaries(Integer courseId, String category) {
        List<PoiEntity> entities;

        if (category == null || category.isEmpty()) {
            entities = poiRepository.findPoisByCourseId(courseId);
        } else {
            try {
                // category 문자열과 enum 매칭 (필요에 따라 매핑 로직 조정)
                entities = poiRepository.findPoisByCourseIdAndPoiType(courseId, category.toLowerCase());
            } catch (IllegalArgumentException e) {
                return new ArrayList<>();
            }
        }

        List<PoiSummaryResponseDTO> result = new ArrayList<>();

        for (PoiEntity entity : entities) {
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

            PoiSummaryResponseDTO dto = new PoiSummaryResponseDTO(
                    entity.getPoiId(),
                    entity.getPoiName(),
                    mapPoiTypeToApiType(entity.getPoiType() != null ? entity.getPoiType().name() : null),
                    point,
                    entity.getPoiContant() == null ? "" : entity.getPoiContant()
            );

            result.add(dto);
        }
        return result;
    }

    private String mapPoiTypeToApiType(String poiTypeName) {
        if (poiTypeName == null) return "Unknown";

        switch (poiTypeName.toLowerCase()) {
            case "biz":
                return "biz";
            case "util":
                return "util";
            case "tourist":
                return "tourist";
            default:
                return "Unknown";
        }
    }

    public PoiDetailResponseDTO getPoiDetail(Integer courseId, Integer poiId) {
        Optional<PoiEntity> optionalPoi = poiRepository.findByCourseIdAndPoiId(courseId, poiId);

        if (optionalPoi.isEmpty()) {
            return null;
        }

        PoiEntity entity = optionalPoi.get();

        PoiAddEntity poiAdd = poiAddRepository.findByPoiId(poiId);

        String hour = poiAdd != null ? poiAdd.getHour() : null;
        String tel = poiAdd != null ? poiAdd.getPoiTel() : null;
        String tag = poiAdd != null ? poiAdd.getPoiTag() : null;

        return new PoiDetailResponseDTO(
                entity.getPoiId(),
                entity.getPoiName(),
                mapPoiTypeToApiType(entity.getPoiType() != null ? entity.getPoiType().name() : null),
                entity.getPoiAddr(),
                hour,
                entity.getRate(),
                tel,
                tag,
                Collections.emptyList()
        );
    }
}

