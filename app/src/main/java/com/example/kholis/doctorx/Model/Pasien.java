package com.example.kholis.doctorx.Model;

import com.google.gson.annotations.SerializedName;

public class Pasien {
    @SerializedName("id")
    private String id;
    @SerializedName("namalengkap")
    private String namalengkap;
    @SerializedName("namapanggilan")
    private String namapanggilan;
    @SerializedName("jeniskelamin")
    private String jeniskelamin;
    @SerializedName("tanggallahir")
    private String tanggallahir;
    @SerializedName("statuspernikahan")
    private String statuspernikahan;
    @SerializedName("tempatlahir")
    private String tempatlahir;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("provinsi")
    private String provinsi;
    @SerializedName("kabupatenkota")
    private String kabupatenkota;
    @SerializedName("kodepos")
    private String kodepos;

    public Pasien() {
    }

    public Pasien(String id, String namalengkap, String namapanggilan, String jeniskelamin, String tanggallahir, String statuspernikahan, String tempatlahir, String alamat, String provinsi, String kabupatenkota, String kodepos) {
        this.id = id;
        this.namalengkap = namalengkap;
        this.namapanggilan = namapanggilan;
        this.jeniskelamin = jeniskelamin;
        this.tanggallahir = tanggallahir;
        this.statuspernikahan = statuspernikahan;
        this.tempatlahir = tempatlahir;
        this.alamat = alamat;
        this.provinsi = provinsi;
        this.kabupatenkota = kabupatenkota;
        this.kodepos = kodepos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getNamapanggilan() {
        return namapanggilan;
    }

    public void setNamapanggilan(String namapanggilan) {
        this.namapanggilan = namapanggilan;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getTanggallahir() {
        return tanggallahir;
    }

    public void setTanggallahir(String tanggallahir) {
        this.tanggallahir = tanggallahir;
    }

    public String getStatuspernikahan() {
        return statuspernikahan;
    }

    public void setStatuspernikahan(String statuspernikahan) {
        this.statuspernikahan = statuspernikahan;
    }

    public String getTempatlahir() {
        return tempatlahir;
    }

    public void setTempatlahir(String tempatlahir) {
        this.tempatlahir = tempatlahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKabupatenkota() {
        return kabupatenkota;
    }

    public void setKabupatenkota(String kabupatenkota) {
        this.kabupatenkota = kabupatenkota;
    }

    public String getKodepos() {
        return kodepos;
    }

    public void setKodepos(String kodepos) {
        this.kodepos = kodepos;
    }
}
