package com.example.bikenavbackend.service;

import com.example.bikenavbackend.dto.response.PoiResponseDTO;
import com.example.bikenavbackend.entity.Poi;
import com.example.bikenavbackend.entity.PoiType;
import com.example.bikenavbackend.repository.PoiRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PoiService {

    private final PoiRepository poiRepository;

    public PoiService(PoiRepository poiRepository) {
        this.poiRepository = poiRepository;
    }

    public List<PoiResponseDTO> getPoisByCourseId(Long courseId, PoiType category) {
        List<Poi> pois;

        if (category != null) {
            pois = poiRepository.findByCourseIdAndCategory(courseId, category);
        } else {
            pois = poiRepository.findByCourseId(courseId);
        }

        return pois.stream()
                .map(poi -> new PoiResponseDTO(
                        poi.getPlaceId(),
                        poi.getName(),
                        poi.getType(),
                        poi.getLat(),
                        poi.getLng()
                ))
                .collect(Collectors.toList());
    }

}
