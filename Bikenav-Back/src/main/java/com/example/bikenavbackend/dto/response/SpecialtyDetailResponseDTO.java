package com.example.bikenavbackend.dto.response;

import java.util.List;

public class SpecialtyDetailResponseDTO {
    private Integer id;
    private Integer villageId;
    private String villageName;
    private String villageAddr;
    private String type;
    private String name;
    private String imageUrl;
    private List<String> tags;
    private boolean recommended;
    private SpecialtyContentDTO content;

    public SpecialtyDetailResponseDTO() {}

    public SpecialtyDetailResponseDTO(Integer id, Integer villageId, String villageName, String villageAddr,
                                      String type, String name, String imageUrl, List<String> tags,
                                      boolean recommended, SpecialtyContentDTO content) {
        this.id = id;
        this.villageId = villageId;
        this.villageName = villageName;
        this.villageAddr = villageAddr;
        this.type = type;
        this.name = name;
        this.imageUrl = imageUrl;
        this.tags = tags;
        this.recommended = recommended;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getVillageAddr() {
        return villageAddr;
    }

    public void setVillageAddr(String villageAddr) {
        this.villageAddr = villageAddr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public SpecialtyContentDTO getContent() {
        return content;
    }

    public void setContent(SpecialtyContentDTO content) {
        this.content = content;
    }
}
