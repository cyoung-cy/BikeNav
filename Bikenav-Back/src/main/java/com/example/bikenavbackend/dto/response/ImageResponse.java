package com.example.bikenavbackend.dto.response;

public class ImageResponse {
    private String url;
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

    public Boolean getIsMain() {
        return isMain;
    }
}


