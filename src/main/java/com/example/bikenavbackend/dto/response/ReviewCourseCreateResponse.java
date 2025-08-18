package com.example.bikenavbackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewCourseCreateResponse {

    private boolean success;
    private String message;
    private Data data;

    public ReviewCourseCreateResponse() {}

    public ReviewCourseCreateResponse(boolean success, String message, Data data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static class Data {
        @JsonProperty("review_id")
        private Long reviewId;

        @JsonProperty("user_id")
        private Long userId;

        @JsonProperty("course_id")
        private Long courseId;

        @JsonProperty("rating")
        private Integer rating;

        @JsonProperty("content")
        private String content;

        @JsonProperty("img_url")
        private String imgUrl;

        @JsonProperty("created_at")
        private String createdAt; // ISO 8601 string

        public Data() {}

        public Data(Long reviewId, Long userId, Long courseId, Integer rating, String content, String imgUrl, String createdAt) {
            this.reviewId = reviewId;
            this.userId = userId;
            this.courseId = courseId;
            this.rating = rating;
            this.content = content;
            this.imgUrl = imgUrl;
            this.createdAt = createdAt;
        }

        // getters & setters
        public Long getReviewId() { return reviewId; }
        public void setReviewId(Long reviewId) { this.reviewId = reviewId; }

        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }

        public Long getCourseId() { return courseId; }
        public void setCourseId(Long courseId) { this.courseId = courseId; }

        public Integer getRating() { return rating; }
        public void setRating(Integer rating) { this.rating = rating; }

        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }

        public String getImgUrl() { return imgUrl; }
        public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }

        public String getCreatedAt() { return createdAt; }
        public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    }

    // getters & setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Data getData() { return data; }
    public void setData(Data data) { this.data = data; }
}
