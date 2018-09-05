package com.example.kholis.doctorx.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTreatment {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Treatment> listTreatment;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Treatment> getListTreatment() {
        return listTreatment;
    }

    public void setListTreatment(List<Treatment> listTreatment) {
        this.listTreatment = listTreatment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
