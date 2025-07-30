package com.example.bikenavbackend.dto.response;

public class CoursePathDTO {
    private int seq;
    private double lat;
    private double lng;

    public CoursePathDTO() {
    }

    public CoursePathDTO(int seq, double lat, double lng) {
        this.seq = seq;
        this.lat = lat;
        this.lng = lng;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}