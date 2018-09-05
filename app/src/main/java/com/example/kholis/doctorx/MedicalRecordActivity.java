package com.example.kholis.doctorx;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.kholis.doctorx.Adapter.HistoryAdapter;
import com.example.kholis.doctorx.Adapter.PasienAdapter;
import com.example.kholis.doctorx.Model.GetHistory;
import com.example.kholis.doctorx.Model.GetPasien;
import com.example.kholis.doctorx.Model.History;
import com.example.kholis.doctorx.Model.Pasien;
import com.example.kholis.doctorx.Rest.ApiClient;
import com.example.kholis.doctorx.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MedicalRecordActivity extends AppCompatActivity {

    EditText editTextNama, editTextID;
    private ImageButton imageButton, tombolHistory;

    ApiInterface mApiInterface;

    String cariId = "", cariNama = "";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medical_record);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarHistory);
        setSupportActionBar(toolbar);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationViewHistory);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_register:
                        Intent intent1 = new Intent(MedicalRecordActivity.this, InsertActivity.class);
                        Log.e("Insert Activity", "masuk insert");
                        startActivity(intent1);
                        return true;
                    case R.id.navigation_home:
                        Intent intent2 = new Intent(MedicalRecordActivity.this, MainActivity.class);
                        Log.e("Main Activity", "masuk main");
                        startActivity(intent2);
                        return true;
                    case R.id.navigation_history :
                        /*Intent intent3 = new Intent(MedicalRecordActivity.this, MedicalRecordActivity.class);
                        Log.e("Medical Record Activity", "masuk history");
                        startActivity(intent3);*/
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.navigation_history);
        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextID = (EditText) findViewById(R.id.editTextID);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        tombolHistory = (ImageButton) findViewById(R.id.tombolHistory);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewRecord);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cariId = editTextID.getText().toString();
                cariNama = editTextNama.getText().toString();

                if (!cariId.equalsIgnoreCase("") && cariNama.equalsIgnoreCase("")) {
                    Log.e("Text ID","1. ID nya adalah = " + cariId );
                    Log.e("Text Nama","1. namanya adalah = " + cariNama );
                    Call<GetPasien> getPasienCall = mApiInterface.getPasienById(Integer.parseInt(cariId));
                    getPasienCall.enqueue(new Callback<GetPasien>() {
                        @Override
                        public void onResponse(Call<GetPasien> call, Response<GetPasien> response) {
                            List<Pasien> pasienIDList = response.body().getListDataPasien();
                            Log.d("Retrofit Get", "Jumlah data pasien : " + String.valueOf(pasienIDList.size()));
                            mAdapter = new PasienAdapter(pasienIDList);
                            mRecyclerView.setAdapter(mAdapter);
                        }

                        @Override
                        public void onFailure(Call<GetPasien> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else if (!cariNama.equalsIgnoreCase("") && cariId.equalsIgnoreCase("")){
                    Log.e("Text ID","2. ID nya adalah = " + cariId );
                    Log.e("Text Nama","2. namanya adalah = " + cariNama );
                    Call<GetPasien> getPasienCall = mApiInterface.getPasienByName(cariNama);
                    getPasienCall.enqueue(new Callback<GetPasien>() {
                        @Override
                        public void onResponse(Call<GetPasien> call, Response<GetPasien> response) {
                            List<Pasien> pasienNamaList = response.body().getListDataPasien();
                            Log.d("Retrofit Get", "Jumlah data pasien : " + String.valueOf(pasienNamaList.size()));
                            mAdapter = new PasienAdapter(pasienNamaList);
                            mRecyclerView.setAdapter(mAdapter);
                        }

                        @Override
                        public void onFailure(Call<GetPasien> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

        tombolHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cariId.equalsIgnoreCase("") && cariNama.equalsIgnoreCase("")) {
                    Log.e("Text ID","3. ID nya adalah = " + cariId );
                    Log.e("Text Nama","3. namanya adalah = " + cariNama );
                    Call<GetHistory> getHistoryCall = mApiInterface.getHistoryById(Integer.parseInt(cariId));
                    getHistoryCall.enqueue(new Callback<GetHistory>() {
                        @Override
                        public void onResponse(Call<GetHistory> call, Response<GetHistory> response) {
                            List<History> historyIDList = response.body().getListHistory();
                            Log.d("Retrofit Get", "Jumlah data pasien : " + String.valueOf(historyIDList.size()));
                            mAdapter = new HistoryAdapter(historyIDList);
                            mRecyclerView.setAdapter(mAdapter);
                        }

                        @Override
                        public void onFailure(Call<GetHistory> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else if (!cariNama.equalsIgnoreCase("") && cariId.equalsIgnoreCase("")){
                    Log.e("Text ID","4. ID nya adalah = " + cariId );
                    Log.e("Text Nama","4. namanya adalah = " + cariNama );
                    Call<GetHistory> getHistoryCall = mApiInterface.getHistoryByName(cariNama);
                    getHistoryCall.enqueue(new Callback<GetHistory>() {
                        @Override
                        public void onResponse(Call<GetHistory> call, Response<GetHistory> response) {
                            List<History> historyNamaList = response.body().getListHistory();
                            Log.d("Retrofit Get", "Jumlah data pasien : " + String.valueOf(historyNamaList.size()));
                            mAdapter = new HistoryAdapter(historyNamaList);
                            mRecyclerView.setAdapter(mAdapter);
                        }

                        @Override
                        public void onFailure(Call<GetHistory> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

    }

}
