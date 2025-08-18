package com.example.bikenavbackend.dto.response;

public class ReviewResponseDTO {

    private Long review_id;
    private Long user_id;
    private String user_name;
    private int rating;
    private String content;
    private String created_at;

    public ReviewResponseDTO() {}

    public ReviewResponseDTO(Long review_id, Long user_id, String user_name,
                             int rating, String content, String created_at) {
        this.review_id = review_id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.rating = rating;
        this.content = content;
        this.created_at = created_at;
    }

    // Getter & Setter
    public Long getReview_id() { return review_id; }
    public void setReview_id(Long review_id) { this.review_id = review_id; }

    public Long getUser_id() { return user_id; }
    public void setUser_id(Long user_id) { this.user_id = user_id; }

    public String getUser_name() { return user_name; }
    public void setUser_name(String user_name) { this.user_name = user_name; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getCreated_at() { return created_at; }
    public void setCreated_at(String created_at) { this.created_at = created_at; }
}
