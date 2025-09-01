package com.example.bikenavbackend.dto.response;

import java.util.List;

public class SpecialtyContentDTO {
    private String description;
    private String price;
    private List<String> menu;

    public SpecialtyContentDTO() {}

    public SpecialtyContentDTO(String description, String price, List<String> menu) {
        this.description = description;
        this.price = price;
        this.menu = menu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getMenu() {
        return menu;
    }

    public void setMenu(List<String> menu) {
        this.menu = menu;
    }
}
