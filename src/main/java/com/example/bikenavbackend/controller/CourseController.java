package com.example.bikenavbackend.controller;

import com.example.bikenavbackend.dto.response.CourseListResponseDTO;
import com.example.bikenavbackend.entity.Course;
import com.example.bikenavbackend.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/list")
    public Map<String, Object> getCourseList(@RequestParam(value = "type", required = false) String type,
                                             @RequestParam(value = "diff", required = false) String diff,
                                             @RequestParam(value = "is_recommended", required = false) Boolean isRecommended) {
        Map<String, Object> response = new HashMap<>();
        List<CourseListResponseDTO> data = new ArrayList<>();

        if (type == null) {
            type = "walk";
        }

        // API 파라미터(ex: walk,bike) ↔ DB저장값(ex: walking,cycling) 매핑
        String dbType;
        if ("walk".equals(type)) {
            dbType = "walking";
        } else if ("bike".equals(type)) {
            dbType = "cycling";
        } else {
            dbType = type;
        }

        List<Course> courses = courseService.findCourses(dbType, diff, isRecommended);
        for (Course c : courses) {
            // 응답에는 다시 walk,bike 형태로 내려주도록
            String apiType = "walking".equals(c.getCourseType()) ? "walk" : "bike";

            CourseListResponseDTO dto = new CourseListResponseDTO(
                    c.getCourseId(),
                    c.getCourseName(),
                    c.getDistKm(),
                    c.getTime(),
                    c.getThumbnailUrl(),
                    Integer.parseInt(c.getDiff()),
                    c.getIsRecommended(),
                    apiType
            );
            data.add(dto);
        }
        response.put("success", true);
        response.put("data", data);
        return response;
    }
}
