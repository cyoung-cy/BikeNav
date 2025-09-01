package com.example.bikenavbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course_poi")
public class CoursePoiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_poi_id")
    private Integer coursePoiId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poi_id")
    private PoiEntity poi;

    @Column(name = "dist_km")
    private Double distKm;

    public CoursePoiEntity() {}

    // Getters & Setters
    public Integer getCoursePoiId() {
        return coursePoiId;
    }

    public void setCoursePoiId(Integer coursePoiId) {
        this.coursePoiId = coursePoiId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public PoiEntity getPoi() {
        return poi;
    }

    public void setPoi(PoiEntity poi) {
        this.poi = poi;
    }

    public Double getDistKm() {
        return distKm;
    }

    public void setDistKm(Double distKm) {
        this.distKm = distKm;
    }
}
