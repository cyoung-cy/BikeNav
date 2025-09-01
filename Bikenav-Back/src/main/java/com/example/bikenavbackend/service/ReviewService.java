package com.example.bikenavbackend.service;

import com.example.bikenavbackend.dto.request.ReviewCourseCreateRequest;
import com.example.bikenavbackend.dto.response.ReviewResponseDTO;
import com.example.bikenavbackend.entity.ReviewEntity;
import com.example.bikenavbackend.entity.UserEntity;
import com.example.bikenavbackend.repository.ReviewRepository;
import com.example.bikenavbackend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public ReviewEntity createCourseReview(ReviewCourseCreateRequest req) {
        // 기본 검증
        if (req.getUserId() == null) throw new IllegalArgumentException("user_id is required");
        if (req.getCourseId() == null) throw new IllegalArgumentException("course_id is required");
        if (req.getTrackingId() == null) throw new IllegalArgumentException("tracking_id is required");
        if (req.getRating() == null) throw new IllegalArgumentException("rating is required");
        if (req.getRating() < 1 || req.getRating() > 5) {
            throw new IllegalArgumentException("rating must be between 1 and 5");
        }

        UserEntity user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + req.getUserId()));

        ReviewEntity review = new ReviewEntity();
        review.setUser(user);
        review.setCourseId(req.getCourseId());
        review.setTrackingId(req.getTrackingId());
        review.setRating(req.getRating());
        review.setContent(req.getContent());
        review.setImgUrl(req.getImgUrl());
        review.setThumbnailUrl(req.getThumbnailUrl());

        return reviewRepository.save(review);
    }

    public List<ReviewResponseDTO> getReviewsByCourseId(Long courseId) {
        List<ReviewEntity> entities = reviewRepository.findByCourseId(courseId);

        return entities.stream()
                .map(r -> new ReviewResponseDTO(
                        r.getId(),
                        r.getUser().getId(),
                        r.getUser().getName(),
                        r.getRating(),
                        r.getContent(),
                        r.getCreatedAt().format(formatter)
                ))
                .collect(Collectors.toList());
    }
}
