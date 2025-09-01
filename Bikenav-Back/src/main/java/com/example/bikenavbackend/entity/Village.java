package com.example.bikenavbackend.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "village")
public class Village {

    @Id
    @Column(name = "village_id")
    private Integer villageId;

    @Column(name = "village_name")
    private String villageName;

    @Column(name = "village_intro")
    private String villageIntro;

    @Column(name = "village_addr")
    private String villageAddr;

    @Column(name = "village_path", columnDefinition = "json")
    private String villagePath; // JSON 문자열로 저장

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "village_tag", columnDefinition = "json")
    private String villageTag;

    public Village() {}

    public Integer getVillageId() { return villageId; }
    public void setVillageId(Integer villageId) { this.villageId = villageId; }

    public String getVillageName() { return villageName; }
    public void setVillageName(String villageName) { this.villageName = villageName; }

    public String getVillageIntro() { return villageIntro; }
    public void setVillageIntro(String villageIntro) { this.villageIntro = villageIntro; }

    public String getVillageAddr() { return villageAddr; }
    public void setVillageAddr(String villageAddr) { this.villageAddr = villageAddr; }

    public String getVillagePath() { return villagePath; }
    public void setVillagePath(String villagePath) { this.villagePath = villagePath; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getVillageTag() { return villageTag; }
    public void setVillageTag(String villageTag) { this.villageTag = villageTag; }
}

