package com.example.bikenavbackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PoiSummaryResponseDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("point")
    private CoordinateResponse point;

    @JsonProperty("explanation")
    private String explanation;

    public PoiSummaryResponseDTO() {}

    public PoiSummaryResponseDTO(Integer id, String name, String type, CoordinateResponse point, String explanation) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.point = point;
        this.explanation = explanation;
    }

    // Getter & Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CoordinateResponse getPoint() {
        return point;
    }

    public void setPoint(CoordinateResponse point) {
        this.point = point;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
