package com.example.bikenavbackend.controller;

import com.example.bikenavbackend.dto.response.CourseDetailResponseDTO;
import com.example.bikenavbackend.dto.response.CourseListResponseDTO;
import com.example.bikenavbackend.dto.response.PoiResponseDTO;
import com.example.bikenavbackend.entity.PoiType;
import com.example.bikenavbackend.service.CourseService;
import com.example.bikenavbackend.service.PoiService;

import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;
    private final PoiService poiService;

    public CourseController(CourseService courseService, PoiService poiService) {
        this.courseService = courseService;
        this.poiService = poiService;
    }

    @GetMapping("/list")
    public Map<String, Object> getAllCourses() {
        List<CourseListResponseDTO> courses = courseService.getAllCourses();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", courses);
        return response;
    }

    @GetMapping("/{courseId}")
    public Map<String, Object> getCourseDetail(@PathVariable Long courseId) {
        // 서비스에서 DTO 받아오기 (CourseDetailResponseDTO 같은 걸 가정)
        CourseDetailResponseDTO detail = courseService.getCourseDetail(courseId);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", detail);
        response.put("message", "코스 상세 정보 조회 성공");

        return response;
    }


    @GetMapping("/{courseId}/pois")
    public Map<String, Object> getPoisByCourse(
            @PathVariable Long courseId,
            @RequestParam(value = "type", required = false) PoiType category
    ) {
        System.out.println("courseId = " + courseId);
        System.out.println("category = " + category);

        List<PoiResponseDTO> pois = poiService.getPoisByCourseId(courseId, category);

        System.out.println("pois size = " + pois.size());

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        Map<String, Object> data = new HashMap<>();
        data.put("pois", pois);
        response.put("data", data);
        return response;
    }



}
