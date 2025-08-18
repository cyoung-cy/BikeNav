package com.example.bikenavbackend.dto.response;

import java.util.List;

public class CourseReviewListResponseDTO {

    private boolean success;
    private Data data;
    private String message;

    public static class Data {
        private List<ReviewResponseDTO> reviews;

        public Data() {}

        public Data(List<ReviewResponseDTO> reviews) {
            this.reviews = reviews;
        }

        public List<ReviewResponseDTO> getReviews() {
            return reviews;
        }

        public void setReviews(List<ReviewResponseDTO> reviews) {
            this.reviews = reviews;
        }
    }

    public CourseReviewListResponseDTO() {}

    public CourseReviewListResponseDTO(boolean success, List<ReviewResponseDTO> reviews, String message) {
        this.success = success;
        this.data = new Data(reviews);
        this.message = message;
    }

    // Getter & Setter
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
