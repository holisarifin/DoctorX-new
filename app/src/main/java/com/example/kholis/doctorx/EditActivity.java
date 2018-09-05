package com.example.kholis.doctorx;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kholis.doctorx.Model.PostPutDelPasien;
import com.example.kholis.doctorx.Rest.ApiClient;
import com.example.kholis.doctorx.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {
    EditText edtId, edtNamaLengkap, edtNamaPanggilan, edtJenisKelamin, edtTanggalLahir, edtStatusPernikahan,
            edtTempatLahir, edtAlamat, edtProvinsi, edtKabupatenKota, edtKodepos;
    Button btnUpdate, btnDelete, btnBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edtId               = (EditText) findViewById(R.id.edtId);
        edtNamaLengkap      = (EditText) findViewById(R.id.edtNamaLengkap);
        edtNamaPanggilan    = (EditText) findViewById(R.id.edtNamaPanggilan);
        edtJenisKelamin     = (EditText) findViewById(R.id.edtJenisKelamin);
        edtTanggalLahir     = (EditText) findViewById(R.id.edtTanggalLahir);
        edtStatusPernikahan = (EditText) findViewById(R.id.edtStatusPernikahan);
        edtTempatLahir      = (EditText) findViewById(R.id.edtTempatLahir);
        edtAlamat           = (EditText) findViewById(R.id.edtAlamat);
        edtProvinsi         = (EditText) findViewById(R.id.edtProvinsi);
        edtKabupatenKota    = (EditText) findViewById(R.id.edtKabupatenKota);
        edtKodepos          = (EditText) findViewById(R.id.edtKodepos);

        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtNamaLengkap.setText(mIntent.getStringExtra("NamaLengkap"));
        edtNamaPanggilan.setText(mIntent.getStringExtra("NamaPanggilan"));
        edtJenisKelamin.setText(mIntent.getStringExtra("JenisKelamin"));
        edtTanggalLahir.setText(mIntent.getStringExtra("TanggalLahir"));
        edtStatusPernikahan.setText(mIntent.getStringExtra("StatusPernikahan"));
        edtTempatLahir.setText(mIntent.getStringExtra("TempatLahir"));
        edtAlamat.setText(mIntent.getStringExtra("Alamat"));
        edtProvinsi.setText(mIntent.getStringExtra("Provinsi"));
        edtKabupatenKota.setText(mIntent.getStringExtra("KabupatenKota"));
        edtKodepos.setText(mIntent.getStringExtra("Kodepos"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnUpdate = (Button) findViewById(R.id.btnUpdate2);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelPasien> updatePasienCall = mApiInterface.putPasien(
                        edtId.getText().toString(),
                        edtNamaLengkap.getText().toString(),
                        edtNamaPanggilan.getText().toString(),
                        edtJenisKelamin.getText().toString(),
                        edtTanggalLahir.getText().toString(),
                        edtStatusPernikahan.getText().toString(),
                        edtTempatLahir.getText().toString(),
                        edtAlamat.getText().toString(),
                        edtProvinsi.getText().toString(),
                        edtKabupatenKota.getText().toString(),
                        edtKodepos.getText().toString());
                updatePasienCall.enqueue(new Callback<PostPutDelPasien>() {
                    @Override
                    public void onResponse(Call<PostPutDelPasien> call, Response<PostPutDelPasien> response) {
                        ViewPasienActivity.vp.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelPasien> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btnDelete = (Button) findViewById(R.id.btnDelete2);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.getText().toString().trim().isEmpty()== false){
                    Call<PostPutDelPasien> deletePasien = mApiInterface.deletePasien(edtId.getText().toString());
                    deletePasien.enqueue(new Callback<PostPutDelPasien>() {
                        @Override
                        public void onResponse(Call<PostPutDelPasien> call, Response<PostPutDelPasien> response) {
                            ViewPasienActivity.vp.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelPasien> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });

                    btnBack = (Button) findViewById(R.id.btnBackGo);
                    btnBack.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ViewPasienActivity.vp.refresh();
                            finish();
                        }
                    });
                }
            }
        });
    }
}

