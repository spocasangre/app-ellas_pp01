package com.example.restapi.models.dtos;

import javax.validation.constraints.NotNull;

public class EmailDTO {
    @NotNull
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
