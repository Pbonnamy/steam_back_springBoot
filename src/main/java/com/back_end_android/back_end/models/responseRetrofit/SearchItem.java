package com.back_end_android.back_end.models.responseRetrofit;

public class SearchItem {

    private String name;
    private Double price;

    private int id;

    private String image;

    private String nameEditor;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameEditor() {
        return nameEditor;
    }

    public void setNameEditor(String nameEditor) {
        this.nameEditor = nameEditor;
    }
}
