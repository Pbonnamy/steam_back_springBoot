package com.back_end_android.back_end.models;

import com.back_end_android.back_end.models.responseRetrofit.GameDetails;

public class GameDetailUp {

    GameDetails gameDetails;
    Boolean isFavorite;

    Boolean isWishList;

    String idLike;

    String idWishList;


    public GameDetails getGameDetails() {
        return gameDetails;
    }

    public void setGameDetails(GameDetails gameDetails) {
        this.gameDetails = gameDetails;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }

    public Boolean getWishList() {
        return isWishList;
    }

    public void setWishList(Boolean wishList) {
        isWishList = wishList;
    }

    public String getIdLike() {
        return idLike;
    }

    public String getIdWishList() {
        return idWishList;
    }

    public GameDetailUp(GameDetails gameDetails, Boolean isFavorite, Boolean isWishList, String idLike, String idWishList) {
        this.gameDetails = gameDetails;
        this.isFavorite = isFavorite;
        this.isWishList = isWishList;
        this.idLike = idLike;
        this.idWishList = idWishList;
    }
}
