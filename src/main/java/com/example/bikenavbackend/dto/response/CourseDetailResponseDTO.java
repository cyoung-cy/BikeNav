package com.example.bikenavbackend.dto.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CourseDetailResponseDTO {

    @JsonProperty("course_id")
    private Long courseId;
    private String title;

    @JsonProperty("dist_km")
    private Double distKm;
    private Integer time;
    private List<PathDTO> path;
    private Integer diff;       // 난이도 (1: 상, 2: 중, 3: 하)
    private String type;        // "walk" 또는 "bike"
    private String description;
    private List<ImageDTO> images;
    private List<String> tags;

    @JsonProperty("tourist_spots")
    private List<String> touristSpots;
    @JsonProperty("nearby_businesses")
    private List<String> nearbyBusinesses;

    // Getter/Setter 생략 가능시 lombok 사용 권장(@Getter @Setter)

    public static class PathDTO {
        private Double lat;
        private Double lng;

        public PathDTO() {}
        public PathDTO(Double lat, Double lng) {
            this.lat = lat;
            this.lng = lng;
        }
        public Double getLat() { return lat; }
        public void setLat(Double lat) { this.lat = lat; }
        public Double getLng() { return lng; }
        public void setLng(Double lng) { this.lng = lng; }
    }

    public static class ImageDTO {
        private String url;

        @JsonProperty("is_main")
        private Boolean isMain;

        public ImageDTO() {}
        public ImageDTO(String url, Boolean isMain) {
            this.url = url;
            this.isMain = isMain;
        }
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
        public Boolean getIsMain() { return isMain; }
        public void setIsMain(Boolean isMain) { this.isMain = isMain; }
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getDistKm() {
        return distKm;
    }

    public void setDistKm(Double distKm) {
        this.distKm = distKm;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public List<PathDTO> getPath() {
        return path;
    }

    public void setPath(List<PathDTO> path) {
        this.path = path;
    }

    public Integer getDiff() {
        return diff;
    }

    public void setDiff(Integer diff) {
        this.diff = diff;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ImageDTO> images) {
        this.images = images;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTouristSpots() {
        return touristSpots;
    }

    public void setTouristSpots(List<String> touristSpots) {
        this.touristSpots = touristSpots;
    }

    public List<String> getNearbyBusinesses() {
        return nearbyBusinesses;
    }

    public void setNearbyBusinesses(List<String> nearbyBusinesses) {
        this.nearbyBusinesses = nearbyBusinesses;
    }
}
