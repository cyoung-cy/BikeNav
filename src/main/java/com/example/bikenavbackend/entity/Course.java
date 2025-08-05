package com.example.bikenavbackend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_type")
    private String courseType;

    @Column(name = "dist_km")
    private BigDecimal distKm;

    @Column(name = "time")
    private Integer time;

    @Column(name = "diff")
    private String diff;

    @Column(name = "course_tag")
    private String courseTag;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(name = "is_recommended")
    private Boolean isRecommended;

    public Course() {
    }

    public Course(Integer courseId, String courseName, String courseType, BigDecimal distKm, Integer time, String diff, String courseTag, String thumbnailUrl, Boolean isRecommended) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseType = courseType;
        this.distKm = distKm;
        this.time = time;
        this.diff = diff;
        this.courseTag = courseTag;
        this.thumbnailUrl = thumbnailUrl;
        this.isRecommended = isRecommended;
    }

    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getCourseType() { return courseType; }
    public void setCourseType(String courseType) { this.courseType = courseType; }
    public BigDecimal getDistKm() { return distKm; }
    public void setDistKm(BigDecimal distKm) { this.distKm = distKm; }
    public Integer getTime() { return time; }
    public void setTime(Integer time) { this.time = time; }
    public String getDiff() { return diff; }
    public void setDiff(String diff) { this.diff = diff; }
    public String getCourseTag() { return courseTag; }
    public void setCourseTag(String courseTag) { this.courseTag = courseTag; }
    public String getThumbnailUrl() { return thumbnailUrl; }
    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }
    public Boolean getIsRecommended() { return isRecommended; }
    public void setIsRecommended(Boolean isRecommended) { this.isRecommended = isRecommended; }
}