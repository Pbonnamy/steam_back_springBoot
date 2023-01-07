package com.back_end_android.back_end.models.responseRetrofit;

public class ReviewEntityReponse {

    private String id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int like;

    private String description;

    public String getId() {
        return id;
    }

    public int getLike() {
        return like;
    }

    public String getDescription() {
        return description;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
