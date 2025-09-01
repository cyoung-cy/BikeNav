package com.example.bikenavbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tourism_detail")
public class TourismDetail {

    @Id
    @Column(name = "tourism_id")
    private Integer tourismId;

    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "content", columnDefinition = "json")
    private String content;

    @Column(name = "is_recommended")
    private Boolean isRecommended;

    public TourismDetail() {}

    public Integer getTourismId() { return tourismId; }
    public void setTourismId(Integer tourismId) { this.tourismId = tourismId; }

    public Integer getVillageId() { return villageId; }
    public void setVillageId(Integer villageId) { this.villageId = villageId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Boolean getIsRecommended() { return isRecommended; }
    public void setIsRecommended(Boolean isRecommended) { this.isRecommended = isRecommended; }
}

