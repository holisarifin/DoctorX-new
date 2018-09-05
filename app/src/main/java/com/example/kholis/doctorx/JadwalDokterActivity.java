package com.example.kholis.doctorx;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.kholis.doctorx.Adapter.JadwalDokterAdapter;
import com.example.kholis.doctorx.Adapter.RecordAdapter;
import com.example.kholis.doctorx.Model.GetJadwalDokter;
import com.example.kholis.doctorx.Model.JadwalDokter;
import com.example.kholis.doctorx.Rest.ApiClient;
import com.example.kholis.doctorx.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalDokterActivity extends AppCompatActivity {

    TextView nama, hari, jammulai, jamselesai, keahlian;
    TableLayout table;
    ApiInterface mApiInterface;
    public static JadwalDokterActivity jd;
    public List<JadwalDokter> jadwalDokterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_dokter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarSchedule);
        setSupportActionBar(toolbar);

        nama = (TextView) findViewById(R.id.nama);
        hari = (TextView) findViewById(R.id.hari);
        jammulai = (TextView) findViewById(R.id.jammulai);
        jamselesai = (TextView) findViewById(R.id.jamselesai);
        keahlian = (TextView) findViewById(R.id.keahlian);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        jd = this;
        refresh();
    }

    public void refresh(){
        Call<GetJadwalDokter> jadwalDokterCall = mApiInterface.getJadwalDokter();
        jadwalDokterCall.enqueue(new Callback<GetJadwalDokter>() {
            @Override
            public void onResponse(Call<GetJadwalDokter> call, Response<GetJadwalDokter> response) {
                jadwalDokterList = response.body().getListJadwalDokter();
                Log.d("Retrofit Get", "Jumlah data dokter : " + String.valueOf(jadwalDokterList.size()));

                ListView recordsView = (ListView) findViewById(R.id.records_view);
                RecordAdapter recordAdapter = new RecordAdapter(jd, jadwalDokterList);
                recordsView.setAdapter(recordAdapter);
                recordAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<GetJadwalDokter> call, Throwable t) {

            }
        });
    }
}
