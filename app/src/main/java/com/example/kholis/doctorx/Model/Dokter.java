package com.example.kholis.doctorx.Model;

import com.google.gson.annotations.SerializedName;

public class Dokter {
    @SerializedName("nama_dokter")
    private String nama_dokter;

    public Dokter() {
    }

    public Dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    public String getNama_dokter() {
        return nama_dokter;
    }

    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }
}
