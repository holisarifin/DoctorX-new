package com.example.kholis.doctorx.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetJadwalDokter {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<JadwalDokter> listJadwalDokter;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<JadwalDokter> getListJadwalDokter() {
        return listJadwalDokter;
    }

    public void setListJadwalDokter(List<JadwalDokter> listJadwalDokter) {
        this.listJadwalDokter = listJadwalDokter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
