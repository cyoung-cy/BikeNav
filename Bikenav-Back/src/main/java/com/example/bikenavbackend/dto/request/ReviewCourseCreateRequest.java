package com.example.bikenavbackend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewCourseCreateRequest {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("course_id")
    private Long courseId;

    @JsonProperty("tracking_id")
    private Long trackingId;

    @JsonProperty("rating")
    private Integer rating;

    @JsonProperty("content")
    private String content;

    @JsonProperty("img_url")
    private String imgUrl;

    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;

    public ReviewCourseCreateRequest() {}

    // getters & setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public Long getTrackingId() { return trackingId; }
    public void setTrackingId(Long trackingId) { this.trackingId = trackingId; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getImgUrl() { return imgUrl; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }

    public String getThumbnailUrl() { return thumbnailUrl; }
    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }
}
