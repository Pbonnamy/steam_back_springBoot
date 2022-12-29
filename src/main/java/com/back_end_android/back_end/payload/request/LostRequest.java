package com.back_end_android.back_end.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LostRequest {

    @NotBlank
    private  String email;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
