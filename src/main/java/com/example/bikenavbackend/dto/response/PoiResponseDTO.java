package com.example.bikenavbackend.dto.response;

import com.example.bikenavbackend.entity.Poi;
import com.example.bikenavbackend.entity.PoiType;

public class PoiResponseDTO {
    private Long id;
    private String name;
    private String category;
    private Double lat;
    private Double lng;

    public PoiResponseDTO() {}

    public PoiResponseDTO(Long id, String name, String category, Double lat, Double lng) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.lat = lat;
        this.lng = lng;
    }

    // PoiType을 String으로 변환하는 생성자
    public PoiResponseDTO(Long placeId, String name, PoiType type, Double lat, Double lng) {
        this.id = placeId;
        this.name = name;
        this.category = type.name(); // enum → String
        this.lat = lat;
        this.lng = lng;
    }

    public PoiResponseDTO(Poi poi) {
        this.id = poi.getPlaceId(); // 잘못된 placeId() → getPlaceId()
        this.name = poi.getName();
        this.category = poi.getType().name(); // enum → String
        this.lat = poi.getLat();
        this.lng = poi.getLng();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
