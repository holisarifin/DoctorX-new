package com.example.kholis.doctorx.Model;

import com.google.gson.annotations.SerializedName;

public class History {
    @SerializedName("id")
    private String id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("dokter")
    private String dokter;
    @SerializedName("treatment")
    private String treatment;
    @SerializedName("hari")
    private String hari;

    public History() {
    }

    public History(String id, String nama, String dokter, String treatment, String hari) {
        this.id = id;
        this.nama = nama;
        this.dokter = dokter;
        this.treatment = treatment;
        this.hari = hari;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDokter() {
        return dokter;
    }

    public void setDokter(String dokter) {
        this.dokter = dokter;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }
}
