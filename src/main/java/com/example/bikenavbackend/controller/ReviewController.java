package com.example.bikenavbackend.controller;

import com.example.bikenavbackend.dto.request.ReviewCourseCreateRequest;
import com.example.bikenavbackend.dto.response.CourseReviewListResponseDTO;
import com.example.bikenavbackend.dto.response.ReviewCourseCreateResponse;
import com.example.bikenavbackend.dto.response.ReviewResponseDTO;
import com.example.bikenavbackend.entity.ReviewEntity;
import com.example.bikenavbackend.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;
    private static final DateTimeFormatter ISO = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 6.1 코스 후기 등록
    @PostMapping("/course")
    public ResponseEntity<ReviewCourseCreateResponse> createCourseReview(@RequestBody ReviewCourseCreateRequest request) {
        ReviewEntity saved = reviewService.createCourseReview(request);

        ReviewCourseCreateResponse.Data data = new ReviewCourseCreateResponse.Data(
                saved.getId(),
                saved.getUser().getId(),
                saved.getCourseId(),
                saved.getRating(),
                saved.getContent(),
                saved.getImgUrl(),
                saved.getCreatedAt() != null ? saved.getCreatedAt().format(ISO) : null
        );

        ReviewCourseCreateResponse body =
                new ReviewCourseCreateResponse(true, "코스 후기 등록 완료", data);

        return ResponseEntity.ok(body);
    }

    @GetMapping("/course/{courseId}")
    public CourseReviewListResponseDTO getCourseReviews(@PathVariable Long courseId) {
        List<ReviewResponseDTO> reviews = reviewService.getReviewsByCourseId(courseId);
        return new CourseReviewListResponseDTO(true, reviews, "코스 후기 조회 성공");
    }
}
