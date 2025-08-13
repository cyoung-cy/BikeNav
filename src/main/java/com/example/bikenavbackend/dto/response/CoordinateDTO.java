package com.example.bikenavbackend.dto.response;

public class CoordinateDTO {
    private double lat;
    private double lng;

    public CoordinateDTO() {}

    public CoordinateDTO(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() { return lat; }
    public void setLat(double lat) { this.lat = lat; }

    public double getLng() { return lng; }
    public void setLng(double lng) { this.lng = lng; }
}
