package com.back_end_android.back_end.payload.response;

public class GameDetailUser {

    Boolean isWishList;

    Boolean isLike;

    String idLike;

    String idWishList;

    public Boolean getWishList() {
        return isWishList;
    }

    public Boolean getLike() {
        return isLike;
    }

    public String getIdLike() {
        return idLike;
    }

    public String getIdWishList() {
        return idWishList;
    }

    public GameDetailUser(Boolean isWishList, Boolean isLike, String idLike, String idWishList) {
        this.isWishList = isWishList;
        this.isLike = isLike;
        this.idLike = idLike;
        this.idWishList = idWishList;
    }
}
