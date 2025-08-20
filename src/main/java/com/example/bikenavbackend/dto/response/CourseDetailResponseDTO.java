package com.example.bikenavbackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class CourseDetailResponseDTO {

    @JsonProperty("course_id")
    private Integer courseId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("dist_km")
    private Double distKm;

    @JsonProperty("time")
    private Integer time;

    @JsonProperty("path")
    private List<CoordinateResponse> path;

    @JsonProperty("diff")
    private Integer diff;

    @JsonProperty("type")
    private String type;    // walk | bike

    @JsonProperty("description")
    private String description;

    @JsonProperty("images")
    private List<ImageResponse> images;

    @JsonProperty("tags")
    private List<Map<String, String>> tags;

    @JsonProperty("tourist_spots")
    private List<String> touristSpots;

    @JsonProperty("nearby_businesses")
    private List<String> nearbyBusinesses;

    public CourseDetailResponseDTO(){}

    public CourseDetailResponseDTO(Integer courseId, String title, Double distKm, Integer time,
                                   List<CoordinateResponse> path, Integer diff, String type, String description,
                                   List<ImageResponse> images, List<Map<String, String>> tags, List<String> touristSpots,
                                   List<String> nearbyBusinesses) {
        this.courseId = courseId;
        this.title = title;
        this.distKm = distKm;
        this.time = time;
        this.path = path;
        this.diff = diff;
        this.type = type;
        this.description = description;
        this.images = images;
        this.tags = tags;
        this.touristSpots = touristSpots;
        this.nearbyBusinesses = nearbyBusinesses;
    }

    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Double getDistKm() { return distKm; }
    public void setDistKm(Double distKm) { this.distKm = distKm; }
    public Integer getTime() { return time; }
    public void setTime(Integer time) { this.time = time; }
    public List<CoordinateResponse> getPath() { return path; }
    public void setPath(List<CoordinateResponse> path) { this.path = path; }
    public Integer getDiff() { return diff; }
    public void setDiff(Integer diff) { this.diff = diff; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<ImageResponse> getImages() { return images; }
    public void setImages(List<ImageResponse> images) { this.images = images; }
    public List<Map<String, String>> getTags() { return tags; }
    public void setTags(List<Map<String, String>> tags) { this.tags = tags; }
    public List<String> getTouristSpots() { return touristSpots; }
    public void setTouristSpots(List<String> touristSpots) { this.touristSpots = touristSpots; }
    public List<String> getNearbyBusinesses() { return nearbyBusinesses; }
    public void setNearbyBusinesses(List<String> nearbyBusinesses) { this.nearbyBusinesses = nearbyBusinesses; }
}

