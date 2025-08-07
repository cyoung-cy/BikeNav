package com.example.bikenavbackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PoiResponseDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("address")
    private String address;

    @JsonProperty("hour")
    private String hour;

    @JsonProperty("rate")
    private Float rate;

    @JsonProperty("content")
    private String content;

    @JsonProperty("tel")
    private String tel;

    private CoordinateResponse point;
    private String explanation;

    public PoiResponseDTO() {}

    public PoiResponseDTO(Integer id, String name, String type, String address, String hour, Float rate, String content, String tel, CoordinateResponse point, String explanation) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.address = address;
        this.hour = hour;
        this.rate = rate;
        this.content = content;
        this.tel = tel;
        this.point = point;
        this.explanation = explanation;
    }

    public PoiResponseDTO(Integer id, String name, String type,
                          CoordinateResponse point, String explanation){
        this.id = id;
        this.name = name;
        this.type = type;
        this.point = point;
        this.explanation = explanation;
    }


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
