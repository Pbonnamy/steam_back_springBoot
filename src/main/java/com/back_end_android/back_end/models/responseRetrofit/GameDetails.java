package com.back_end_android.back_end.models.responseRetrofit;

public class GameDetails {

    private String name;

    private String editor;

    private String urlImage;

    private String cover;

    private String description;


    public void setName(String name) {
        this.name = name;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setUrlImage(String urlImage) {
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

    public String getUrlImage() {
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
