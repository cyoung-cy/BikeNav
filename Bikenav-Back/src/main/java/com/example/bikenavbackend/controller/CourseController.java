package com.example.bikenavbackend.controller;

import com.example.bikenavbackend.dto.response.CourseDetailResponseDTO;
import com.example.bikenavbackend.entity.Course;
import com.example.bikenavbackend.service.CourseService;
import com.example.bikenavbackend.service.PoiService;
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
        List<Map<String, Object>> data = new ArrayList<>();

        // API → DB 타입 매핑
        String dbType = null;
        if (type != null) {
            if ("walk".equals(type)) {
                dbType = "walking";
            } else if ("bike".equals(type)) {
                dbType = "cycling";
            }
        }

        List<Course> courses = courseService.findCourses(dbType, diff, isRecommended);

        for (Course c : courses) {
            // DB에는 walking / cycling → API응답은 walk / bike
            String apiType = "walking".equals(c.getCourseType()) ? "walk"
                    : "cycling".equals(c.getCourseType()) ? "bike"
                    : null;

            Map<String, Object> dto = new HashMap<>();
            dto.put("course_id", c.getCourseId());
            dto.put("title", c.getCourseName());
            dto.put("dist_km", c.getDistKm());
            dto.put("time", c.getTime());
            dto.put("image", c.getThumbnailUrl());
            dto.put("diff", Integer.parseInt(c.getDiff()));
            dto.put("is_recommended", c.getIsRecommended());
            dto.put("type", apiType);

            data.add(dto);
        }

        response.put("success", true);
        response.put("data", data);
        return response;
    }

    @GetMapping("/{courseId}")
    public Map<String,Object> getCourseDetail(@PathVariable Integer courseId) throws Exception{
        CourseDetailResponseDTO detail = courseService.getDetail(courseId);
        Map<String,Object> result = new HashMap<>();
        result.put("success", true);
        result.put("data", detail);
        result.put("message","코스 상세 정보 조회 성공");
        return result;
    }

}
