package com.back_end_android.back_end.payload.request;

import javax.validation.constraints.NotBlank;

public class DetailGame {

    @NotBlank
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
