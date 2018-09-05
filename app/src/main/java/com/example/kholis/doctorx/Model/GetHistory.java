package com.example.kholis.doctorx.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetHistory {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<History> listHistory;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<History> getListHistory() {
        return listHistory;
    }

    public void setListHistory(List<History> listHistory) {
        this.listHistory = listHistory;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
