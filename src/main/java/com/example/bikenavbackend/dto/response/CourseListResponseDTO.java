package com.example.bikenavbackend.dto.response;

public class CourseListResponseDTO {
    private Long courseId;
    private String title;
    private double distKm;
    private int time;
    private String image;
    private int diff;
    private boolean isRecommended;

    public CourseListResponseDTO() {}

    public CourseListResponseDTO(Long courseId, String title, double distKm, int time, String image, int diff, boolean isRecommended) {
        this.courseId = courseId;
        this.title = title;
        this.distKm = distKm;
        this.time = time;
        this.image = image;
        this.diff = diff;
        this.isRecommended = isRecommended;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDistKm() {
        return distKm;
    }

    public void setDistKm(double distKm) {
        this.distKm = distKm;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public boolean isRecommended() {
        return isRecommended;
    }

    public void setRecommended(boolean recommended) {
        isRecommended = recommended;
    }
}
