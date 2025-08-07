package com.example.bikenavbackend.controller;

import com.example.bikenavbackend.dto.response.PoiResponseDTO;
import com.example.bikenavbackend.service.PoiService;
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
        List<PoiResponseDTO> pois = poiService.getPois(courseId, category);

        Map<String, Object> data = new HashMap<>();
        data.put("pois", pois);

        result.put("success", true);
        result.put("data", data);
        result.put("message", "코스 주변 POI 조회 성공");

        return result;
    }
}
