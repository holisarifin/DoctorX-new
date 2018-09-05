package com.example.kholis.doctorx.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelPasien {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Pasien mPasien;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pasien getmPasien() {
        return mPasien;
    }

    public void setmPasien(Pasien mPasien) {
        this.mPasien = mPasien;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
