package com.example.dietkuy.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Latihan {

    @SerializedName("id")
    private int id;

    @SerializedName("hari")
    private String hari;

    @SerializedName("total_waktu")
    private String total_waktu;

    @SerializedName("olahraga")
    private List<Olahraga> olahraga;

    public int getId() {
        return id;
    }

    public String getHari() {
        return hari;
    }

    public String getTotal_waktu() {
        return total_waktu;
    }

    public List<Olahraga> getOlahraga() {
        return olahraga;
    }
}
