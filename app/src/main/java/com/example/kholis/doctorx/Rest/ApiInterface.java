package com.example.kholis.doctorx.Rest;

import com.example.kholis.doctorx.Model.GetDokter;
import com.example.kholis.doctorx.Model.GetHistory;
import com.example.kholis.doctorx.Model.GetJadwalDokter;
import com.example.kholis.doctorx.Model.GetPasien;
import com.example.kholis.doctorx.Model.PostPutDelPasien;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("pasien_android")
    Call<GetPasien> getPasien();
    @GET("pasien_android")
    Call<GetPasien> getPasienById(@Query("id") int id);
    @GET("pasien_android")
    Call<GetPasien> getPasienByName(@Query("namapanggilan") String namapanggilan);
    @GET("history")
    Call<GetHistory> getHistory();
    @GET("history")
    Call<GetHistory> getHistoryById(@Query("id") int id);
    @GET("history")
    Call<GetHistory> getHistoryByName(@Query("namapanggilan") String namapanggilan);
    @GET("jadwaldokter")
    Call<GetJadwalDokter> getJadwalDokter();
    @GET("dokter")
    Call<GetDokter> getDokter();
    @FormUrlEncoded
    @POST("pasien")
    Call<PostPutDelPasien> postPasien(@Field("namalengkap") String namalengkap,
                                      @Field("namapanggilan") String namapanggilan,
                                      @Field("jeniskelamin") String jeniskelamin,
                                      @Field("tanggallahir") String tanggallahir,
                                      @Field("statuspernikahan") String statuspernikahan,
                                      @Field("tempatlahir") String tempatlahir,
                                      @Field("alamat") String alamat,
                                      @Field("provinsi") String provinsi,
                                      @Field("kabupatenkota") String kabupatenkota,
                                      @Field("kodepos") String kodepos);
    @FormUrlEncoded
    @PUT("pasien")
    Call<PostPutDelPasien> putPasien( @Field("id") String id,
                                      @Field("namalengkap") String namalengkap,
                                      @Field("namapanggilan") String namapanggilan,
                                      @Field("jeniskelamin") String jeniskelamin,
                                      @Field("tanggallahir") String tanggallahir,
                                      @Field("statuspernikahan") String statuspernikahan,
                                      @Field("tempatlahir") String tempatlahir,
                                      @Field("alamat") String alamat,
                                      @Field("provinsi") String provinsi,
                                      @Field("kabupatenkota") String kabupatenkota,
                                      @Field("kodepos") String kodepos);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "pasien", hasBody = true)
    Call<PostPutDelPasien> deletePasien(@Field("id")String id);
}
