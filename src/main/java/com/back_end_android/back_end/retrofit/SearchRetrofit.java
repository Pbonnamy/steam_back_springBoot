package com.back_end_android.back_end.retrofit;

import org.json.JSONPropertyName;

import java.util.List;

public class SearchRetrofit {

    private int total;
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public static class Item{
        private String name;

        private int id;

        private String tiny_image;


        private Price price;

        public Price getPrice() {
            return price;
        }

        public void setPrice(Price price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTiny_image() {
            return tiny_image;
        }

        public void setTiny_image(String tiny_image) {
            this.tiny_image = tiny_image;
        }

        public static class Price{
            private int initial;

            public int getInitial() {
                return initial;
            }

            public void setInitial(int initial) {
                this.initial = initial;
            }
        }
    }
}
