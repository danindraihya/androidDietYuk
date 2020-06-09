package com.example.dietkuy.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class Olahraga {

    @SerializedName("id")
    private int id;

    @SerializedName("jenis")
    private String jenis;

    @SerializedName("waktu")
    private String waktu;

    public int getId() {
        return id;
    }

    public String getJenis() {
        return jenis;
    }

    public String getWaktu() {
        return waktu;
    }
}
