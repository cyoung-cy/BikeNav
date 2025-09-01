package com.example.bikenavbackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PoiDetailResponseDTO {

    @JsonProperty("place_id")
    private Integer placeId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("addr")
    private String addr;

    @JsonProperty("hour")
    private String hour;

    @JsonProperty("rate")
    private Float rate;

    @JsonProperty("tel")
    private String tel;

    @JsonProperty("tag")
    private String tag; // poi_tag는 JSON이지만 일단 String으로 처리 (필요시 DTO로 분리 가능)

    @JsonProperty("images")
    private List<ImageResponse> images;

    public PoiDetailResponseDTO() {}

    public PoiDetailResponseDTO(Integer placeId, String name, String type, String addr, String hour, Float rate, String tel, String tag, List<ImageResponse> images) {
        this.placeId = placeId;
        this.name = name;
        this.type = type;
        this.addr = addr;
        this.hour = hour;
        this.rate = rate;
        this.tel = tel;
        this.tag = tag;
        this.images = images;
    }

    // getters, setters

    public static class ImageResponse {
        @JsonProperty("url")
        private String url;

        @JsonProperty("is_main")
        private Boolean isMain;

        public ImageResponse() {}

        public ImageResponse(String url, Boolean isMain) {
            this.url = url;
            this.isMain = isMain;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Boolean getMain() {
            return isMain;
        }

        public void setMain(Boolean main) {
            isMain = main;
        }


    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<ImageResponse> getImages() {
        return images;
    }

    public void setImages(List<ImageResponse> images) {
        this.images = images;
    }

    // Getters & setters omitted for brevity
}
