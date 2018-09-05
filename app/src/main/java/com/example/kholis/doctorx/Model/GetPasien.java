package com.example.kholis.doctorx.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPasien {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Pasien> listDataPasien;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Pasien> getListDataPasien() {
        return listDataPasien;
    }

    public void setListDataPasien(List<Pasien> listDataPasien) {
        this.listDataPasien = listDataPasien;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
