package com.example.bikenavbackend.controller;

import com.example.bikenavbackend.dto.response.PoiDetailResponseDTO;
import com.example.bikenavbackend.dto.response.PoiResponseDTO;
import com.example.bikenavbackend.dto.response.PoiSummaryResponseDTO;
import com.example.bikenavbackend.service.PoiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/course")
public class PoiController {

    private final PoiService poiService;

    public PoiController(PoiService poiService) {
        this.poiService = poiService;
    }

    @GetMapping("/{courseId}/pois")
    public Map<String, Object> getPoiList(@PathVariable Integer courseId,
                                          @RequestParam(value = "category", required = false) String category) {
        Map<String, Object> result = new HashMap<>();
        List<PoiSummaryResponseDTO> pois = poiService.getPoiSummaries(courseId, category);

        Map<String, Object> data = new HashMap<>();
        data.put("pois", pois);

        result.put("success", true);
        result.put("data", data);
        result.put("message", "코스 주변 POI 조회 성공");

        return result;
    }

    @GetMapping("/{courseId}/pois/{placeId}")
    public ResponseEntity<Map<String, Object>> getPoiDetail(@PathVariable Integer courseId,
                                                            @PathVariable("placeId") Integer placeId) {
        PoiDetailResponseDTO dto = poiService.getPoiDetail(courseId, placeId);

        Map<String, Object> result = new HashMap<>();
        if (dto == null) {
            result.put("success", false);
            result.put("message", "상권 상세 정보가 존재하지 않습니다.");
            return ResponseEntity.ok(result);
        }

        Map<String, Object> data = new HashMap<>();
        data.putAll(Map.of(
                "place_id", dto.getPlaceId(),
                "name", dto.getName(),
                "type", dto.getType(),
                "addr", dto.getAddr(),
                "hour", dto.getHour(),
                "rate", dto.getRate(),
                "tel", dto.getTel(),
                "tag", dto.getTag(),
                "images", dto.getImages()
        ));

        result.put("success", true);
        result.put("data", data);
        result.put("message", "상권 상세 정보 조회 성공");

        return ResponseEntity.ok(result);
    }

}
