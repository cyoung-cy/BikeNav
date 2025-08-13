package com.example.bikenavbackend.service;

import com.example.bikenavbackend.dto.response.CoordinateDTO;
import com.example.bikenavbackend.dto.response.SpecialtyListResponseDTO;
import com.example.bikenavbackend.dto.response.SpecialtyResponseDTO;
import com.example.bikenavbackend.entity.*;
import com.example.bikenavbackend.repository.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialtyService {

    private final VillageRepository villageRepository;
    private final FoodDetailRepository foodDetailRepository;
    private final TourismDetailRepository tourismDetailRepository;
    private final TraditionDetailRepository traditionDetailRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public SpecialtyService(VillageRepository villageRepository,
                            FoodDetailRepository foodDetailRepository,
                            TourismDetailRepository tourismDetailRepository,
                            TraditionDetailRepository traditionDetailRepository) {
        this.villageRepository = villageRepository;
        this.foodDetailRepository = foodDetailRepository;
        this.tourismDetailRepository = tourismDetailRepository;
        this.traditionDetailRepository = traditionDetailRepository;
    }

    public SpecialtyListResponseDTO getAllSpecialties() {
        List<SpecialtyResponseDTO> specialties = new ArrayList<>();

        List<Village> villages = villageRepository.findAll();
        for (Village village : villages) {
            List<CoordinateDTO> path = parsePath(village.getVillagePath());

            // Food
            List<FoodDetail> foods = foodDetailRepository.findByVillageId(village.getVillageId());
            for (FoodDetail food : foods) {
                specialties.add(
                        new SpecialtyResponseDTO(
                                food.getFoodId(),
                                village.getVillageId(),
                                village.getVillageName(),
                                "food",
                                extractNameFromContent(food.getContent()),
                                village.getImageUrl(),
                                food.getIsRecommended() != null && food.getIsRecommended(),
                                path
                        )
                );
            }

            // Tourism
            List<TourismDetail> tourisms = tourismDetailRepository.findByVillageId(village.getVillageId());
            for (TourismDetail tourism : tourisms) {
                specialties.add(
                        new SpecialtyResponseDTO(
                                tourism.getTourismId(),
                                village.getVillageId(),
                                village.getVillageName(),
                                "tourism",
                                extractNameFromContent(tourism.getContent()),
                                village.getImageUrl(),
                                tourism.getIsRecommended() != null && tourism.getIsRecommended(),
                                path
                        )
                );
            }

            // Tradition
            List<TraditionDetail> traditions = traditionDetailRepository.findByVillageId(village.getVillageId());
            for (TraditionDetail tradition : traditions) {
                specialties.add(
                        new SpecialtyResponseDTO(
                                tradition.getTraditionId(),
                                village.getVillageId(),
                                village.getVillageName(),
                                "tradition",
                                extractNameFromContent(tradition.getContent()),
                                village.getImageUrl(),
                                tradition.getIsRecommended() != null && tradition.getIsRecommended(),
                                path
                        )
                );
            }
        }

        return new SpecialtyListResponseDTO(specialties);
    }

    private List<CoordinateDTO> parsePath(String villagePathJson) {
        List<CoordinateDTO> pathList = new ArrayList<>();
        if (villagePathJson == null || villagePathJson.isEmpty()) {
            return pathList;
        }

        try {
            JsonNode root = objectMapper.readTree(villagePathJson);
            if (root.isArray()) {
                // JSON 배열일 경우
                for (JsonNode node : root) {
                    double lat = node.has("lat") ? node.get("lat").asDouble() : 0.0;
                    double lng = node.has("lng") ? node.get("lng").asDouble() : 0.0;
                    pathList.add(new CoordinateDTO(lat, lng));
                }
            } else if (root.isObject()) {
                // 단일 객체일 경우
                double lat = root.has("lat") ? root.get("lat").asDouble() : 0.0;
                double lng = root.has("lng") ? root.get("lng").asDouble() : 0.0;
                pathList.add(new CoordinateDTO(lat, lng));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathList;
    }

    private String extractNameFromContent(String contentJson) {
        if (contentJson == null || contentJson.isEmpty()) {
            return "";
        }

        try {
            JsonNode root = objectMapper.readTree(contentJson);
            if (root.has("name")) {
                return root.get("name").asText();
            } else if (root.has("title")) {
                return root.get("title").asText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
