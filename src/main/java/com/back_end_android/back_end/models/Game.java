package com.back_end_android.back_end.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Game{
    @SerializedName("success")
    private boolean success;

    @SerializedName("data")
    private Data data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        @SerializedName("type")
        private String type;

        @SerializedName("name")
        private String name;

        @SerializedName("steam_appid")
        private int steamAppId;

        @SerializedName("required_age")
        private String requiredAge;

        @SerializedName("is_free")
        private boolean isFree;

        @SerializedName("controller_support")
        private String controllerSupport;

        @SerializedName("dlc")
        private List<Integer> dlc;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSteamAppId() {
            return steamAppId;
        }

        public void setSteamAppId(int steamAppId) {
            this.steamAppId = steamAppId;
        }

        public String getRequiredAge() {
            return requiredAge;
        }

        public void setRequiredAge(String requiredAge) {
            this.requiredAge = requiredAge;
        }

        public boolean isFree() {
            return isFree;
        }

        public void setFree(boolean free) {
            isFree = free;
        }

        public String getControllerSupport() {
            return controllerSupport;
        }

        public void setControllerSupport(String controllerSupport) {
            this.controllerSupport = controllerSupport;
        }

        public List<Integer> getDlc() {
            return dlc;
        }

        public void setDlc(List<Integer> dlc) {
            this.dlc = dlc;
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }
}



