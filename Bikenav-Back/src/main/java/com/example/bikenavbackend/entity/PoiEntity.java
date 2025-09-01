package com.example.bikenavbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "poi")
public class PoiEntity {

    @Id
    @Column(name = "poi_id")
    private Integer poiId;

    @Column(name = "poi_name", length = 100)
    private String poiName;

    @Enumerated(EnumType.STRING)
    @Column(name = "poi_type", columnDefinition = "enum('biz','util','tourist')")
    private PoiType poiType;

    @Column(name = "poi_addr", length = 200)
    private String poiAddr;

    @Column(name = "poi_path", columnDefinition = "json")
    private String poiPath;

    @Column(name = "hour", length = 50)
    private String hour;

    @Column(name = "rate")
    private Float rate;

    @Column(name = "poi_contant", length = 255)
    private String poiContant;

    @Column(name = "poi_tel", length = 30)
    private String poiTel;

    @Column(name = "poi_tag", columnDefinition = "json")
    private String poiTag;

    @Column(name = "course_id")
    private Integer courseId;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public PoiEntity() {}

    // Getters & Setters

    public Integer getPoiId() {
        return poiId;
    }

    public void setPoiId(Integer poiId) {
        this.poiId = poiId;
    }

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }

    public PoiType getPoiType() {
        return poiType;
    }

    public void setPoiType(PoiType poiType) {
        this.poiType = poiType;
    }

    public String getPoiAddr() {
        return poiAddr;
    }

    public void setPoiAddr(String poiAddr) {
        this.poiAddr = poiAddr;
    }

    public String getPoiPath() {
        return poiPath;
    }

    public void setPoiPath(String poiPath) {
        this.poiPath = poiPath;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getPoiContant() {
        return poiContant;
    }

    public void setPoiContant(String poiContant) {
        this.poiContant = poiContant;
    }

    public String getPoiTel() {
        return poiTel;
    }

    public void setPoiTel(String poiTel) {
        this.poiTel = poiTel;
    }

    public String getPoiTag() {
        return poiTag;
    }

    public void setPoiTag(String poiTag) {
        this.poiTag = poiTag;
    }

    public enum PoiType {
        biz, util, tourist
    }
}
