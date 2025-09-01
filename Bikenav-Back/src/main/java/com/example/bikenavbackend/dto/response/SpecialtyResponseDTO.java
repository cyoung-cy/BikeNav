package com.example.bikenavbackend.dto.response;

import java.util.List;

public class SpecialtyResponseDTO {
    private Integer id;
    private Integer villageId;
    private String villageName;
    private String type;
    private String name;
    private String imageUrl;
    private boolean recommended;
    private List<CoordinateDTO> path;

    public SpecialtyResponseDTO() {}

    public SpecialtyResponseDTO(Integer id, Integer villageId, String villageName,
                                String type, String name, String imageUrl,
                                boolean recommended, List<CoordinateDTO> path) {
        this.id = id;
        this.villageId = villageId;
        this.villageName = villageName;
        this.type = type;
        this.name = name;
        this.imageUrl = imageUrl;
        this.recommended = recommended;
        this.path = path;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getVillageId() { return villageId; }
    public void setVillageId(Integer villageId) { this.villageId = villageId; }

    public String getVillageName() { return villageName; }
    public void setVillageName(String villageName) { this.villageName = villageName; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public boolean isRecommended() { return recommended; }
    public void setRecommended(boolean recommended) { this.recommended = recommended; }

    public List<CoordinateDTO> getPath() { return path; }
    public void setPath(List<CoordinateDTO> path) { this.path = path; }
}

