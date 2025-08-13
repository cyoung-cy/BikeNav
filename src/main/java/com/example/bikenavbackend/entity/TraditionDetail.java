package com.example.bikenavbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tradition_detail")
public class TraditionDetail {

    @Id
    @Column(name = "tradition_id")
    private Integer traditionId;

    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "content", columnDefinition = "json")
    private String content;

    @Column(name = "is_recommended")
    private Boolean isRecommended;

    public TraditionDetail() {}

    public Integer getTraditionId() { return traditionId; }
    public void setTraditionId(Integer traditionId) { this.traditionId = traditionId; }

    public Integer getVillageId() { return villageId; }
    public void setVillageId(Integer villageId) { this.villageId = villageId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Boolean getIsRecommended() { return isRecommended; }
    public void setIsRecommended(Boolean isRecommended) { this.isRecommended = isRecommended; }
}
