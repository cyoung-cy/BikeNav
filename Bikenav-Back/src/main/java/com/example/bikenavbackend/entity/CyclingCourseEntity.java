package com.example.bikenavbackend.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "cycling_course")
public class CyclingCourseEntity {

    @Id
    @Column(name = "cycling_id")
    private Integer cyclingId;

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "start_addr")
    private String startAddr;

    @Column(name = "end_addr")
    private String endAddr;

    @Column(name = "start_path", columnDefinition = "json")
    private String startPath;

    @Column(name = "middle_path", columnDefinition = "json")
    private String middlePath;

    @Column(name = "end_path", columnDefinition = "json")
    private String endPath;

    public CyclingCourseEntity() {}

    public CyclingCourseEntity(Integer cyclingId, Integer courseId, String startAddr, String endAddr,
                               String startPath, String middlePath, String endPath) {
        this.cyclingId = cyclingId;
        this.courseId = courseId;
        this.startAddr = startAddr;
        this.endAddr = endAddr;
        this.startPath = startPath;
        this.middlePath = middlePath;
        this.endPath = endPath;
    }

    public Integer getCyclingId() {
        return cyclingId;
    }

    public void setCyclingId(Integer cyclingId) {
        this.cyclingId = cyclingId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getStartAddr() {
        return startAddr;
    }

    public void setStartAddr(String startAddr) {
        this.startAddr = startAddr;
    }

    public String getEndAddr() {
        return endAddr;
    }

    public void setEndAddr(String endAddr) {
        this.endAddr = endAddr;
    }

    public String getStartPath() {
        return startPath;
    }

    public void setStartPath(String startPath) {
        this.startPath = startPath;
    }

    public String getMiddlePath() {
        return middlePath;
    }

    public void setMiddlePath(String middlePath) {
        this.middlePath = middlePath;
    }

    public String getEndPath() {
        return endPath;
    }

    public void setEndPath(String endPath) {
        this.endPath = endPath;
    }
}

