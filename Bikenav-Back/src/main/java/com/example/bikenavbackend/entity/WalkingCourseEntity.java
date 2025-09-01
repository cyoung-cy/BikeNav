package com.example.bikenavbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "walking_course")
public class WalkingCourseEntity {

    @Id
    @Column(name = "walking_id")
    private Integer walkingId;

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

    public WalkingCourseEntity() {}

    public WalkingCourseEntity(Integer walkingId, Integer courseId, String startAddr, String endAddr,
                               String startPath, String middlePath, String endPath) {
        this.walkingId = walkingId;
        this.courseId = courseId;
        this.startAddr = startAddr;
        this.endAddr = endAddr;
        this.startPath = startPath;
        this.middlePath = middlePath;
        this.endPath = endPath;
    }

    public Integer getWalkingId() {
        return walkingId;
    }

    public void setWalkingId(Integer walkingId) {
        this.walkingId = walkingId;
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
