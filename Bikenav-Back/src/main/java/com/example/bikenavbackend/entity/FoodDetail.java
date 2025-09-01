package com.example.bikenavbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "food_detail")
public class FoodDetail {

    @Id
    @Column(name = "food_id")
    private Integer foodId;

    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "content", columnDefinition = "json")
    private String content;

    @Column(name = "is_recommended")
    private Boolean isRecommended;

    public FoodDetail() {}

    public Integer getFoodId() { return foodId; }
    public void setFoodId(Integer foodId) { this.foodId = foodId; }

    public Integer getVillageId() { return villageId; }
    public void setVillageId(Integer villageId) { this.villageId = villageId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Boolean getIsRecommended() { return isRecommended; }
    public void setIsRecommended(Boolean isRecommended) { this.isRecommended = isRecommended; }
}

