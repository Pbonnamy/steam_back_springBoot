package com.back_end_android.back_end.models.responseRetrofit;

import java.util.List;

public class GameDetails {

    private String name;

    private String editor;

    private List<String> urlImage;

    private String cover;

    private String description;

    private String price;

    private  int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setUrlImage(List<String> urlImage) {
        this.urlImage = urlImage;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getEditor() {
        return editor;
    }

    public List<String> getUrlImage() {
        return urlImage;
    }

    public String getCover() {
        return cover;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "GameDetails{" +
                "name='" + name + '\'' +
                ", editor='" + editor + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", cover='" + cover + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
