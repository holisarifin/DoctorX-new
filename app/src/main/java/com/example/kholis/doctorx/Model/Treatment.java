package com.example.kholis.doctorx.Model;

import com.google.gson.annotations.SerializedName;

public class Treatment {
    @SerializedName("nama_treatment")
    private String nama_treatment;

    public Treatment() {
    }

    public Treatment(String nama_treatment) {
        this.nama_treatment = nama_treatment;
    }

    public String getNama_treatment() {
        return nama_treatment;
    }

    public void setNama_treatment(String nama_treatment) {
        this.nama_treatment = nama_treatment;
    }
}
