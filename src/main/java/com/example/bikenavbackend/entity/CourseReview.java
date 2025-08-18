package com.example.bikenavbackend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "course_review")
public class CourseReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private Long userId;
    private Long courseId;
    private Long trackingId;
    private int rating;
    private String content;
    private String imgUrl;
    private String thumbnailUrl;

    @CreationTimestamp
    private LocalDateTime createdAt;
}

