package com.example.kholis.doctorx;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kholis.doctorx.Adapter.PasienAdapter;
import com.example.kholis.doctorx.Model.GetPasien;
import com.example.kholis.doctorx.Model.Pasien;
import com.example.kholis.doctorx.Rest.ApiClient;
import com.example.kholis.doctorx.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewPasienActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static ViewPasienActivity vp;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pasien);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        vp = this;
        refresh();
    }

    public void refresh(){
        Call<GetPasien> pasienCall = mApiInterface.getPasien();
        pasienCall.enqueue(new Callback<GetPasien>() {
            @Override
            public void onResponse(Call<GetPasien> call, Response<GetPasien> response) {
                List<Pasien> pasienList = response.body().getListDataPasien();
                Log.d("Retrofit Get", "Jumlah data pasien : " + String.valueOf(pasienList.size()));
                mAdapter = new PasienAdapter(pasienList);
                mRecyclerView.setAdapter(mAdapter);
            }
            @Override
            public void onFailure(Call<GetPasien> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
    public void refreshId(){
        Call<GetPasien> pasienCall = mApiInterface.getPasien();
        pasienCall.enqueue(new Callback<GetPasien>() {
            @Override
            public void onResponse(Call<GetPasien> call, Response<GetPasien> response) {
                List<Pasien> pasienList = response.body().getListDataPasien();
                Log.d("Retrofit Get", "Jumlah data pasien : " + String.valueOf(pasienList.size()));
                mAdapter = new PasienAdapter(pasienList);
                mRecyclerView.setAdapter(mAdapter);
            }
            @Override
            public void onFailure(Call<GetPasien> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

}
