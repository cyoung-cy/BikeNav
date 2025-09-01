package com.example.bikenavbackend.service;

import com.example.bikenavbackend.dto.response.CourseDetailResponseDTO;
import com.example.bikenavbackend.entity.Course;
import com.example.bikenavbackend.entity.CourseDescEntity;
import com.example.bikenavbackend.repository.CourseDescRepository;
import com.example.bikenavbackend.repository.CourseRepository;
import com.example.bikenavbackend.repository.CyclingCourseRepository;
import com.example.bikenavbackend.repository.WalkingCourseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.example.bikenavbackend.dto.response.*;
import com.example.bikenavbackend.entity.*;
import com.example.bikenavbackend.repository.*;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseDescRepository descRepository;
    private final WalkingCourseRepository walkingRepository;
    private final CyclingCourseRepository cyclingRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CourseService(CourseRepository courseRepository,
                         CourseDescRepository descRepository,
                         WalkingCourseRepository walkingRepository,
                         CyclingCourseRepository cyclingRepository){
        this.courseRepository = courseRepository;
        this.descRepository = descRepository;
        this.walkingRepository = walkingRepository;
        this.cyclingRepository = cyclingRepository;
    }
    public List<Course> findCourses(String type, String diff, Boolean isRecommended) {
        System.out.printf("findCourses called with type=%s, diff=%s, isRecommended=%s%n", type, diff, isRecommended);
        if (type == null && diff == null && isRecommended == null) {
            return courseRepository.findAll();
        }
        return courseRepository.findCourses(type, diff, isRecommended);
    }

    public CourseDetailResponseDTO getDetail(Integer courseId) throws Exception{
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("course not found"));

        CourseDescEntity desc = descRepository.findByCourseId(courseId)
                .orElse(null);

        // 1) tags
        List<Map<String, String>> tags = Collections.emptyList();
        if (course.getCourseTag() != null) {
            tags = objectMapper.readValue(
                    course.getCourseTag(),
                    new TypeReference<List<Map<String, String>>>() {}
            );
        }

        // 2) tourist_spots / nearby_businesses (varchar에 JSON 배열 문자열 들어오므로 파싱)
        List<String> ts = new ArrayList<>();
        List<String> nb = new ArrayList<>();
        if(desc != null){
            if(desc.getTouristSpots()!=null){
                ts = Arrays.asList(desc.getTouristSpots()
                        .replace("[","")
                        .replace("]","")
                        .replace("\"","")
                        .split(","));
            }
            if(desc.getNearbyBusinesses()!=null){
                nb = Arrays.asList(desc.getNearbyBusinesses()
                        .replace("[","")
                        .replace("]","")
                        .replace("\"","")
                        .split(","));
            }
        }

        // 3) path
        List<CoordinateResponse> path = new ArrayList<>();

        if("walking".equals(course.getCourseType())) {
            WalkingCourseEntity w = walkingRepository.findByCourseId(courseId).orElse(null);
            if(w!=null){
                path.addAll(parsePathJson(w.getStartPath()));
                path.addAll(parsePathJson(w.getMiddlePath()));
                path.addAll(parsePathJson(w.getEndPath()));
            }
        }else{
            CyclingCourseEntity c = cyclingRepository.findByCourseId(courseId).orElse(null);
            if(c!=null){
                path.addAll(parsePathJson(c.getStartPath()));
                path.addAll(parsePathJson(c.getMiddlePath()));
                path.addAll(parsePathJson(c.getEndPath()));
            }
        }

        // 4) type
        String apiType = "walking".equals(course.getCourseType()) ? "walk" : "bike";

        // 5) images (명세 필수이므로 빈 배열)
        List<ImageResponse> images = new ArrayList<>();

        // 6) 설명
        String description = (desc != null) ? desc.getContent() : "";

        return new CourseDetailResponseDTO(
                course.getCourseId(),
                course.getCourseName(),
                course.getDistKm().doubleValue(),
                course.getTime(),
                path != null ? path : new ArrayList<>(),
                Integer.parseInt(course.getDiff()),
                apiType,
                description,
                images,
                tags != null ? tags : new ArrayList<>(),
                ts != null ? ts : new ArrayList<>(),
                nb != null ? nb : new ArrayList<>()
        );
    }


    private List<CoordinateResponse> parsePathJson(String json) throws Exception{
        if (json == null) return new ArrayList<>();

        String trimmed = json.trim();
        if (!trimmed.startsWith("[")) {
            trimmed = "[" + trimmed + "]";
        }

        return objectMapper.readValue(
                trimmed,
                new TypeReference<List<CoordinateResponse>>() {}
        );
    }


}


