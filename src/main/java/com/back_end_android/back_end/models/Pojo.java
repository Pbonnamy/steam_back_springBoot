package com.back_end_android.back_end.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pojo {
    @SerializedName("response")
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public static class Response {
        @SerializedName("rollup_date")
        private long rollupDate;

        @SerializedName("ranks")
        private List<Rank> ranks;

        public long getRollupDate() {
            return rollupDate;
        }

        public void setRollupDate(long rollupDate) {
            this.rollupDate = rollupDate;
        }

        public List<Rank> getRanks() {
            return ranks;
        }

        public void setRanks(List<Rank> ranks) {
            this.ranks = ranks;
        }
    }

    public static class Rank {
        @SerializedName("rank")
        private int rank;

        @SerializedName("appid")
        private int appId;

        @SerializedName("last_week_rank")
        private int lastWeekRank;

        @SerializedName("peak_in_game")
        private int peakInGame;

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getAppId() {
            return appId;
        }

        public void setAppId(int appId) {
            this.appId = appId;
        }

        public int getLastWeekRank() {
            return lastWeekRank;
        }

        public void setLastWeekRank(int lastWeekRank) {
            this.lastWeekRank = lastWeekRank;
        }

        public int getPeakInGame() {
            return peakInGame;
        }

        public void setPeakInGame(int peakInGame) {
            this.peakInGame = peakInGame;
        }
    }
}

