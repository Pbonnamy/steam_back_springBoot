package com.back_end_android.back_end.models;

import com.back_end_android.back_end.models.responseRetrofit.GameDetails;

public class GameDetailUp {

    GameDetails gameDetails;


    public GameDetails getGameDetails() {
        return gameDetails;
    }

    public void setGameDetails(GameDetails gameDetails) {
        this.gameDetails = gameDetails;
    }



    public GameDetailUp(GameDetails gameDetails) {
        this.gameDetails = gameDetails;
    }
}
