package com.example.bikenavbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course_desc")
public class CourseDescEntity {

    @Id
    @Column(name = "desc_id")
    private Integer descId;

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "location")
    private String location;

    @Column(name = "content")
    private String content;

    @Column(name = "tourist_spots")
    private String touristSpots; // 콤마 또는 JSON 문자열로 저장됨. DB는 varchar, 입력은 JSON 배열 형태

    @Column(name = "nearby_businesses")
    private String nearbyBusinesses; // 마찬가지 JSON 문자열 형태

    public CourseDescEntity() {}

    public CourseDescEntity(Integer descId, Integer courseId, String location, String content,
                            String touristSpots, String nearbyBusinesses) {
        this.descId = descId;
        this.courseId = courseId;
        this.location = location;
        this.content = content;
        this.touristSpots = touristSpots;
        this.nearbyBusinesses = nearbyBusinesses;
    }

    public Integer getDescId() {
        return descId;
    }

    public void setDescId(Integer descId) {
        this.descId = descId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTouristSpots() {
        return touristSpots;
    }

    public void setTouristSpots(String touristSpots) {
        this.touristSpots = touristSpots;
    }

    public String getNearbyBusinesses() {
        return nearbyBusinesses;
    }

    public void setNearbyBusinesses(String nearbyBusinesses) {
        this.nearbyBusinesses = nearbyBusinesses;
    }
}