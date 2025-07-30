package com.example.bikenavbackend.service;

import com.example.bikenavbackend.dto.response.CourseDetailResponseDTO;
import com.example.bikenavbackend.dto.response.CourseListResponseDTO;
import com.example.bikenavbackend.entity.Course;
import com.example.bikenavbackend.entity.CoursePath;
import com.example.bikenavbackend.entity.Poi;
import com.example.bikenavbackend.repository.CoursePathRepository;
import com.example.bikenavbackend.repository.CourseRepository;
import com.example.bikenavbackend.repository.PoiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CoursePathRepository coursePathRepository;
    private final PoiRepository poiRepository;

    public CourseService(CourseRepository courseRepository,
                         CoursePathRepository coursePathRepository,
                         PoiRepository poiRepository) {
        this.courseRepository = courseRepository;
        this.coursePathRepository = coursePathRepository;
        this.poiRepository = poiRepository;
    }

    public List<CourseListResponseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseListResponseDTO> responseDTOs = new ArrayList<>();

        for (Course course : courses) {
            CourseListResponseDTO dto = new CourseListResponseDTO();
            dto.setCourseId(course.getCourseId());
            dto.setTitle(course.getTitle());
            dto.setDistKm(course.getDistKm());
            dto.setTime(course.getTimeMin());
            dto.setImage(course.getImage());
            dto.setDiff(parseDiff(course.getDifficulty())); // "상" → 1
            dto.setRecommended(true); // isRecommended 필드가 DB에 없다면 기본 true
            responseDTOs.add(dto);
        }

        return responseDTOs;
    }

    @Transactional(readOnly = true)
    public CourseDetailResponseDTO getCourseDetail(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Course not found"));

        int diff = parseDiff(course.getDifficulty());

        List<CoursePath> coursePaths = coursePathRepository.findByCourse_CourseIdOrderBySeqAsc(courseId);
        List<CourseDetailResponseDTO.PathDTO> pathList = coursePaths.stream()
                .map(cp -> new CourseDetailResponseDTO.PathDTO(cp.getLat(), cp.getLng()))
                .collect(Collectors.toList());

        List<CourseDetailResponseDTO.ImageDTO> images = new ArrayList<>();
        if (course.getImage() != null && !course.getImage().isEmpty()) {
            images.add(new CourseDetailResponseDTO.ImageDTO(course.getImage(), true));
        }

        List<String> tags = new ArrayList<>(); // 태그 DB가 없으면 빈 리스트 유지

        List<Poi> pois = poiRepository.findByCourseId(courseId);
        List<String> touristSpots = new ArrayList<>();

        // 연관된 POI 중 타입이 Cafe, Restaurant, Hotel인 것들만 nearbyBusinesses로 추출
        List<String> nearbyBusinesses = pois.stream()
                .map(Poi::getName)
                .distinct()
                .collect(Collectors.toList());

        CourseDetailResponseDTO dto = new CourseDetailResponseDTO();
        dto.setCourseId(course.getCourseId());
        dto.setTitle(course.getTitle());
        dto.setDistKm(course.getDistKm());
        dto.setTime(course.getTimeMin());
        dto.setPath(pathList);
        dto.setDiff(diff);
        dto.setType(course.getType() != null ? course.getType().name().toLowerCase() : null);  // 변경된 부분
        dto.setDescription(course.getDescription());
        dto.setImages(images);
        dto.setTags(tags);
        dto.setTouristSpots(touristSpots);
        dto.setNearbyBusinesses(nearbyBusinesses);

        return dto;
    }


    private int parseDiff(String diff) {
        if (diff == null) return 2; // 기본 중간
        switch (diff) {
            case "상":
            case "hard":
                return 1;
            case "중":
            case "medium":
                return 2;
            case "하":
            case "easy":
                return 3;
            default:
                return 2;
        }
    }
}
