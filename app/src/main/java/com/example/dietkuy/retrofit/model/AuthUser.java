package com.example.dietkuy.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class AuthUser {

    @SerializedName("status")
    private int status;

    @SerializedName("response")
    private String response;

    @SerializedName("id")
    private int id;

    public int getStatus() {
        return status;
    }

    public String getResponse() {
        return response;
    }

    public int getId() {
        return id;
    }
}
