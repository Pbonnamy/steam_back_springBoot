package com.back_end_android.back_end.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("wishlist")
public class WhishList {
    @Id
    private String id;

    private String tenant;

    private String name;

    private int steamID;

    private String editor;

    private List<String> urlImage;

    private String cover;

    private String description;

    private String price;

    private String type;
    

    public WhishList( String tenant, String name, int steamID, String editor, List<String> urlImage, String cover, String description, String price, String type) {
        this.tenant = tenant;
        this.name = name;
        this.steamID = steamID;
        this.editor = editor;
        this.urlImage = urlImage;
        this.cover = cover;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSteamID() {
        return steamID;
    }

    public void setSteamID(int steamID) {
        this.steamID = steamID;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public List<String> getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(List<String> urlImage) {
        this.urlImage = urlImage;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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
}
