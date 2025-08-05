package com.example.bikenavbackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class CourseListResponseDTO {
    @JsonProperty("course_id")
    private Integer courseId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("dist_km")
    private BigDecimal distKm;

    @JsonProperty("time")
    private Integer time;

    @JsonProperty("image")
    private String image;

    @JsonProperty("diff")
    private Integer diff;

    @JsonProperty("recommended")
    private Boolean isRecommended;

    @JsonProperty("type")
    private String type;

    // 기본 생성자
    public CourseListResponseDTO() {}

    // 전체 필드 생성자
    public CourseListResponseDTO(Integer courseId, String title, BigDecimal distKm, Integer time,
                                 String image, Integer diff, Boolean isRecommended, String type) {
        this.courseId = courseId;
        this.title = title;
        this.distKm = distKm;
        this.time = time;
        this.image = image;
        this.diff = diff;
        this.isRecommended = isRecommended;
        this.type = type;
    }

    // getter, setter

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getDistKm() {
        return distKm;
    }

    public void setDistKm(BigDecimal distKm) {
        this.distKm = distKm;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getDiff() {
        return diff;
    }

    public void setDiff(Integer diff) {
        this.diff = diff;
    }

    public Boolean getIsRecommended() {
        return isRecommended;
    }

    public void setIsRecommended(Boolean isRecommended) {
        this.isRecommended = isRecommended;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
