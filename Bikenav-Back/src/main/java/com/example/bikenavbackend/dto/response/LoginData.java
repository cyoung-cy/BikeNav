package com.example.bikenavbackend.dto.response;

public class LoginData {
    private String token;
    private Long user_id;
    private String name;

    public LoginData() { }

    public LoginData(String token, Long user_id, String name) {
        this.token = token;
        this.user_id = user_id;
        this.name = name;
    }

    // Getters / Setters
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public Long getUser_id() { return user_id; }
    public void setUser_id(Long user_id) { this.user_id = user_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
