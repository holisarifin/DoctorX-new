package com.example.kholis.doctorx.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDokter {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Dokter> listDokter;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Dokter> getListDokter() {
        return listDokter;
    }

    public void setListDokter(List<Dokter> listDokter) {
        this.listDokter = listDokter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
