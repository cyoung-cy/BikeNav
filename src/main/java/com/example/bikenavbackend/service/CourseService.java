package com.example.bikenavbackend.service;

import com.example.bikenavbackend.entity.Course;
import com.example.bikenavbackend.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findCourses(String type, String diff, Boolean isRecommended) {
        if (diff != null && isRecommended != null) {
            return courseRepository.findByCourseTypeAndDiffAndIsRecommended(type, diff, isRecommended);
        } else if (diff != null) {
            return courseRepository.findByCourseTypeAndDiff(type, diff);
        } else {
            return courseRepository.findByCourseType(type);
        }
    }
}