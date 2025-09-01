package com.example.bikenavbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "poi_add")
public class PoiAddEntity {

    @Id
    @Column(name = "poi_id")
    private Integer poiId;

    @Column(name = "hour", columnDefinition = "text")
    private String hour;

    @Column(name = "poi_tel", columnDefinition = "text")
    private String poiTel;

    @Column(name = "poi_tag", columnDefinition = "json")
    private String poiTag;

    public PoiAddEntity() {}

    // getters and setters

    public Integer getPoiId() {
        return poiId;
    }

    public void setPoiId(Integer poiId) {
        this.poiId = poiId;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
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
}
