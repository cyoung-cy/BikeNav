package com.example.bikenavbackend.service;

import com.example.bikenavbackend.dto.response.SpecialtyContentDTO;
import com.example.bikenavbackend.dto.response.SpecialtyDetailResponseDTO;
import com.example.bikenavbackend.entity.*;
import com.example.bikenavbackend.repository.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SpecialtyDetailService {

    private final VillageRepository villageRepository;
    private final FoodDetailRepository foodDetailRepository;
    private final TourismDetailRepository tourismDetailRepository;
    private final TraditionDetailRepository traditionDetailRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public SpecialtyDetailService(VillageRepository villageRepository,
                                  FoodDetailRepository foodDetailRepository,
                                  TourismDetailRepository tourismDetailRepository,
                                  TraditionDetailRepository traditionDetailRepository) {
        this.villageRepository = villageRepository;
        this.foodDetailRepository = foodDetailRepository;
        this.tourismDetailRepository = tourismDetailRepository;
        this.traditionDetailRepository = traditionDetailRepository;
    }

    public SpecialtyDetailResponseDTO getSpecialtyDetail(Integer villageId, String type, Integer id) throws Exception {
        Village village = villageRepository.findById(villageId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 마을입니다."));

        switch (type.toLowerCase()) {
            case "food":
                FoodDetail food = foodDetailRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 음식 특화상품입니다."));
                return mapToDTO(village, "food", food.getFoodId(), food.getContent(), food.getIsRecommended());
            case "tourism":
                TourismDetail tourism = tourismDetailRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 관광 특화상품입니다."));
                return mapToDTO(village, "tourism", tourism.getTourismId(), tourism.getContent(), tourism.getIsRecommended());
            case "tradition":
                TraditionDetail tradition = traditionDetailRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 전통 특화상품입니다."));
                return mapToDTO(village, "tradition", tradition.getTraditionId(), tradition.getContent(), tradition.getIsRecommended());
            default:
                throw new IllegalArgumentException("유효하지 않은 type입니다.");
        }
    }

    private SpecialtyDetailResponseDTO mapToDTO(Village village, String type, Integer id, String contentJson, Boolean recommended) throws Exception {
        // contentJson 파싱
        JsonNode contentNode = objectMapper.readTree(contentJson);

        String name = "";
        if (contentNode.has("name")) {
            name = contentNode.get("name").asText();
        } else if (contentNode.has("title")) {
            name = contentNode.get("title").asText();
        }

        String description = contentNode.has("description") ? contentNode.get("description").asText() : "";
        String price = contentNode.has("price") ? contentNode.get("price").asText() : "";
        List<String> menu = new ArrayList<>();
        if (contentNode.has("menu") && contentNode.get("menu").isArray()) {
            for (JsonNode menuNode : contentNode.get("menu")) {
                menu.add(menuNode.asText());
            }
        }

        List<String> tags = new ArrayList<>();
        if (village.getVillageTag() != null && !village.getVillageTag().isEmpty()) {
            JsonNode tagsNode = objectMapper.readTree(village.getVillageTag());
            if (tagsNode.isArray()) {
                for (JsonNode tagNode : tagsNode) {
                    tags.add(tagNode.asText());
                }
            }
        }

        SpecialtyContentDTO contentDTO = new SpecialtyContentDTO(description, price, menu);

        return new SpecialtyDetailResponseDTO(
                id,
                village.getVillageId(),
                village.getVillageName(),
                village.getVillageAddr(),
                type,
                name,
                village.getImageUrl(),
                tags,
                recommended != null && recommended,
                contentDTO
        );
    }
}
