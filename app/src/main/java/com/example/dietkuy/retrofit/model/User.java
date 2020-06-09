package com.example.dietkuy.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private int id;

    @SerializedName("username")
    private String username;

    @SerializedName("height")
    private int height;

    @SerializedName("weight")
    private int weight;

    @SerializedName("ttl")
    private String ttl;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getTtl() {
        return ttl;
    }
}
