package com.back_end_android.back_end.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewResponse {
    int success;
    QuerySummary querySummary;
    List<Review> reviews;

    public static class QuerySummary {
        int numReviews;
        int reviewScore;
        String reviewScoreDesc;
        int totalPositive;
        int totalNegative;
        int totalReviews;
    }

    public static class Review {
        String recommendationid;
        Author author;
        String language;
        String review;
        int timestampCreated;
        int timestampUpdated;
        boolean votedUp;
        int votesUp;
        int votesFunny;

        @SerializedName("weighted_vote_score")
        String weightedVoteScore;
        int commentCount;
        boolean steamPurchase;
        boolean receivedForFree;
        boolean writtenDuringEarlyAccess;
        boolean hiddenInSteamChina;
        String steamChinaLocation;

        public void setRecommendationid(String recommendationid) {
            this.recommendationid = recommendationid;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public void setTimestampCreated(int timestampCreated) {
            this.timestampCreated = timestampCreated;
        }

        public void setTimestampUpdated(int timestampUpdated) {
            this.timestampUpdated = timestampUpdated;
        }

        public void setVotedUp(boolean votedUp) {
            this.votedUp = votedUp;
        }

        public void setVotesUp(int votesUp) {
            this.votesUp = votesUp;
        }

        public void setVotesFunny(int votesFunny) {
            this.votesFunny = votesFunny;
        }

        public void setWeightedVoteScore(String weightedVoteScore) {
            this.weightedVoteScore = weightedVoteScore;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public void setSteamPurchase(boolean steamPurchase) {
            this.steamPurchase = steamPurchase;
        }

        public void setReceivedForFree(boolean receivedForFree) {
            this.receivedForFree = receivedForFree;
        }

        public void setWrittenDuringEarlyAccess(boolean writtenDuringEarlyAccess) {
            this.writtenDuringEarlyAccess = writtenDuringEarlyAccess;
        }

        public void setHiddenInSteamChina(boolean hiddenInSteamChina) {
            this.hiddenInSteamChina = hiddenInSteamChina;
        }

        public void setSteamChinaLocation(String steamChinaLocation) {
            this.steamChinaLocation = steamChinaLocation;
        }

        public String getRecommendationid() {
            return recommendationid;
        }

        public Author getAuthor() {
            return author;
        }

        public String getLanguage() {
            return language;
        }

        public String getReview() {
            return review;
        }

        public int getTimestampCreated() {
            return timestampCreated;
        }

        public int getTimestampUpdated() {
            return timestampUpdated;
        }

        public boolean isVotedUp() {
            return votedUp;
        }

        public int getVotesUp() {
            return votesUp;
        }

        public int getVotesFunny() {
            return votesFunny;
        }

        public String getWeightedVoteScore() {
            return weightedVoteScore;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public boolean isSteamPurchase() {
            return steamPurchase;
        }

        public boolean isReceivedForFree() {
            return receivedForFree;
        }

        public boolean isWrittenDuringEarlyAccess() {
            return writtenDuringEarlyAccess;
        }

        public boolean isHiddenInSteamChina() {
            return hiddenInSteamChina;
        }

        public String getSteamChinaLocation() {
            return steamChinaLocation;
        }

        public static class Author {

            String steamid;
            int numGamesOwned;
            int numReviews;
            int playtimeForever;
            int playtimeLastTwoWeeks;
            int playtimeAtReview;
            int lastPlayed;

            public String getSteamid() {
                return steamid;
            }

            public void setSteamid(String steamid) {
                this.steamid = steamid;
            }

            public int getNumGamesOwned() {
                return numGamesOwned;
            }

            public void setNumGamesOwned(int numGamesOwned) {
                this.numGamesOwned = numGamesOwned;
            }

            public int getNumReviews() {
                return numReviews;
            }

            public void setNumReviews(int numReviews) {
                this.numReviews = numReviews;
            }

            public int getPlaytimeForever() {
                return playtimeForever;
            }

            public void setPlaytimeForever(int playtimeForever) {
                this.playtimeForever = playtimeForever;
            }

            public int getPlaytimeLastTwoWeeks() {
                return playtimeLastTwoWeeks;
            }

            public void setPlaytimeLastTwoWeeks(int playtimeLastTwoWeeks) {
                this.playtimeLastTwoWeeks = playtimeLastTwoWeeks;
            }

            public int getPlaytimeAtReview() {
                return playtimeAtReview;
            }

            public void setPlaytimeAtReview(int playtimeAtReview) {
                this.playtimeAtReview = playtimeAtReview;
            }

            public int getLastPlayed() {
                return lastPlayed;
            }

            public void setLastPlayed(int lastPlayed) {
                this.lastPlayed = lastPlayed;
            }
        }
    }
}
