package com.back_end_android.back_end.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SteamApp {
    private boolean success;
    private Data data;

    public boolean isSuccess() {
        return success;
    }

    public Data getData() {
        return data;
    }

    public static class Data {

        private List<Screenshots>  screenshots;

        @SerializedName("price_overview")
        @Expose
        private PriceOverview priceOverview;

        public PriceOverview getPriceOverview() {
            return priceOverview;
        }

        public void setPriceOverview(PriceOverview priceOverview) {
            this.priceOverview = priceOverview;
        }

        public class PriceOverview {

            @SerializedName("currency")
            @Expose
            private String currency;
            @SerializedName("initial")
            @Expose
            private Integer initial;
            @SerializedName("final")
            @Expose
            private Integer _final;
            @SerializedName("discount_percent")
            @Expose
            private Integer discountPercent;
            @SerializedName("initial_formatted")
            @Expose
            private String initialFormatted;
            @SerializedName("final_formatted")
            @Expose
            private String finalFormatted;

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public Integer getInitial() {
                return initial;
            }

            public void setInitial(Integer initial) {
                this.initial = initial;
            }

            public Integer getFinal() {
                return _final;
            }

            public void setFinal(Integer _final) {
                this._final = _final;
            }

            public Integer getDiscountPercent() {
                return discountPercent;
            }

            public void setDiscountPercent(Integer discountPercent) {
                this.discountPercent = discountPercent;
            }

            public String getInitialFormatted() {
                return initialFormatted;
            }

            public void setInitialFormatted(String initialFormatted) {
                this.initialFormatted = initialFormatted;
            }

            public String getFinalFormatted() {
                return finalFormatted;
            }

            public void setFinalFormatted(String finalFormatted) {
                this.finalFormatted = finalFormatted;
            }

        }



        public List<Screenshots> getScreenshots() {
            return screenshots;
        }



        public void setScreenshots(List<Screenshots> screenshots) {
            this.screenshots = screenshots;
        }

        public static class Screenshots{
            private int id;
            private String path_thumbnail;

            private String path_full;

            public int getId() {
                return id;
            }

            public String getPath_thumbnail() {
                return path_thumbnail;
            }

            public String getPath_full() {
                return path_full;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setPath_thumbnail(String path_thumbnail) {
                this.path_thumbnail = path_thumbnail;
            }

            public void setPath_full(String path_full) {
                this.path_full = path_full;
            }
        }

        private List<String> publishers;

        public List<String> getPublishers() {
            return publishers;
        }

        public void setPublishers(List<String> publishers) {
            this.publishers = publishers;
        }



        private String header_image;

        public void setHeader_image(String header) {
            this.header_image = header;
        }

        public String getHeader() {
            return header_image;
        }

        private String type;
        private String name;
        private int steam_appid;
        private String required_age;
        private boolean is_free;
        private String controller_support;

        private String detailed_description;


        private String short_description;

        public void setShort_description(String short_description) {
            this.short_description = short_description;
        }

        public String getShort_description() {
            return short_description;
        }

        public void setDetailed_description(String detailed_description) {
            this.detailed_description = detailed_description;
        }

        public String getDetailed_description() {
            return detailed_description;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public int getSteamAppid() {
            return steam_appid;
        }

        public String getRequiredAge() {
            return required_age;
        }

        public boolean isFree() {
            return is_free;
        }

        public String getControllerSupport() {
            return controller_support;
        }
    }
}
