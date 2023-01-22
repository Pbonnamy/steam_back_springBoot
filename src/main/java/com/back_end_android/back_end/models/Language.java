package com.back_end_android.back_end.models;

public enum Language {
    FR("french", "0.00€"), EN("english", "$0.00USD");

    private final String language;

    private final String price;

    Language(String language, String price) {
        this.language = language;
        this.price = price;
    }

    public String getLanguage() {
        return language;
    }

    public String getPrice() {
        return price;
    }
}
