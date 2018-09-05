package com.example.kholis.doctorx.Model;

import com.google.gson.annotations.SerializedName;

public class JadwalDokter {
    @SerializedName("nama_dokter")
    private String nama_dokter;
    @SerializedName("hari")
    private String hari;
    @SerializedName("jam_mulai")
    private String jam_mulai;
    @SerializedName("jam_selesai")
    private String jam_selesai;
    @SerializedName("keahlian_dokter")
    private String keahlian_dokter;

    public JadwalDokter() {
    }

    public JadwalDokter(String nama_dokter, String hari, String jam_mulai, String jam_selesai, String keahlian_dokter) {
        this.nama_dokter = nama_dokter;
        this.hari = hari;
        this.jam_mulai = jam_mulai;
        this.jam_selesai = jam_selesai;
        this.keahlian_dokter = keahlian_dokter;
    }

    public String getNama_dokter() {
        return nama_dokter;
    }

    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJam_mulai() {
        return jam_mulai;
    }

    public void setJam_mulai(String jam_mulai) {
        this.jam_mulai = jam_mulai;
    }

    public String getJam_selesai() {
        return jam_selesai;
    }

    public void setJam_selesai(String jam_selesai) {
        this.jam_selesai = jam_selesai;
    }

    public String getKeahlian_dokter() {
        return keahlian_dokter;
    }

    public void setKeahlian_dokter(String keahlian_dokter) {
        this.keahlian_dokter = keahlian_dokter;
    }
}
