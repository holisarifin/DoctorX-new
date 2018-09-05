package com.example.kholis.doctorx;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kholis.doctorx.Adapter.DokterAdapter;
import com.example.kholis.doctorx.Adapter.PasienAdapter;
import com.example.kholis.doctorx.Adapter.SearchingAdapter;
import com.example.kholis.doctorx.Model.Dokter;
import com.example.kholis.doctorx.Model.GetDokter;
import com.example.kholis.doctorx.Model.GetPasien;
import com.example.kholis.doctorx.Model.Pasien;
import com.example.kholis.doctorx.Rest.ApiClient;
import com.example.kholis.doctorx.Rest.ApiInterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsultationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Spinner spinnerKonsultasi, spinnerCari;
    EditText editTextKonsultasi;
    ApiInterface mApiInterface;
    String spinnerValue, katakunci;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    DatePickerDialog datePickerDialog;
    SimpleDateFormat simpleDateFormat;
    ImageButton inputTanggalKonsultasi, imageSearching;
    TextView edtTanggalKonsultasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarConsultation);
        setSupportActionBar(toolbar);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<GetDokter> getDokterCall = mApiInterface.getDokter();
        getDokterCall.enqueue(new Callback<GetDokter>() {
            @Override
            public void onResponse(Call<GetDokter> call, Response<GetDokter> response) {
                List<Dokter> dokterList = response.body().getListDokter();
                Log.d("Retrofit Get", "Jumlah data dokter : " + String.valueOf(dokterList.size()));
                spinnerKonsultasi = (Spinner) findViewById(R.id.spinnerdokterKonsultasi);
                DokterAdapter adapter = new DokterAdapter(ConsultationActivity.this, R.layout.spinner_item, dokterList);

                spinnerKonsultasi.setAdapter(adapter);
                spinnerKonsultasi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String item = ((TextView) view.findViewById(R.id.spinnerTxt)).getText().toString();
                        //pilihanDokter.setText(item);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onFailure(Call<GetDokter> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationViewConsultation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_register:
                        Intent intent1 = new Intent(ConsultationActivity.this, InsertActivity.class);
                        Log.e("Insert Activity", "masuk insert");
                        startActivity(intent1);
                        return true;
                    case R.id.navigation_home:
                        Intent intent2 = new Intent(ConsultationActivity.this, MainActivity.class);
                        Log.e("Main Activity", "masuk main");
                        startActivity(intent2);
                        return true;
                    case R.id.navigation_history :
                        Intent intent3 = new Intent(ConsultationActivity.this, MedicalRecordActivity.class);
                        Log.e("Medical Record Activity", "masuk history");
                        startActivity(intent3);
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(0);
        editTextKonsultasi = (EditText) findViewById(R.id.editTextKonsultasi);
        imageSearching = (ImageButton) findViewById(R.id.imageButtonKonsultasi);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewConsultation);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        spinnerCari = (Spinner) findViewById(R.id.spinnercariKonsultasi);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.search_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCari.setAdapter(adapter);
        spinnerCari.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerValue = (String) parent.getItemAtPosition(position);

                if(spinnerValue.equalsIgnoreCase("ID")){
                    imageSearching.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            katakunci = editTextKonsultasi.getText().toString();
                            Log.e("Text ID","05. Kata kunci nya adalah = " + katakunci );
                            Call<GetPasien> getPasienCall = mApiInterface.getPasienById(Integer.parseInt(katakunci));
                            getPasienCall.enqueue(new Callback<GetPasien>() {
                                @Override
                                public void onResponse(Call<GetPasien> call, Response<GetPasien> response) {
                                    List<Pasien> pasienIDList = response.body().getListDataPasien();
                                    Log.d("Retrofit Get", "Jumlah data dokter : " + String.valueOf(pasienIDList.size()));
                                    mAdapter = new SearchingAdapter(pasienIDList);
                                    mRecyclerView.setAdapter(mAdapter);
                                }

                                @Override
                                public void onFailure(Call<GetPasien> call, Throwable t) {
                                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    });
                }
                else if (spinnerValue.equalsIgnoreCase("Nama")){
                    imageSearching.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            katakunci = editTextKonsultasi.getText().toString();
                            Log.e("Text Nama","06. Kata kuncinya adalah = " + katakunci );
                            Call<GetPasien> getPasienCall = mApiInterface.getPasienByName(katakunci);
                            getPasienCall.enqueue(new Callback<GetPasien>() {
                                @Override
                                public void onResponse(Call<GetPasien> call, Response<GetPasien> response) {
                                    List<Pasien> pasienNamaList = response.body().getListDataPasien();
                                    Log.d("Retrofit Get", "Jumlah data dokter : " + String.valueOf(pasienNamaList.size()));
                                    mAdapter = new SearchingAdapter(pasienNamaList);
                                    mRecyclerView.setAdapter(mAdapter);
                                }

                                @Override
                                public void onFailure(Call<GetPasien> call, Throwable t) {
                                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    });

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        edtTanggalKonsultasi = (TextView) findViewById(R.id.edtTanggalKonsultasi);
        inputTanggalKonsultasi = (ImageButton) findViewById(R.id.inputTanggalKonsultasi);
        inputTanggalKonsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
    }

    private void showDateDialog(){
        Calendar calendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfMonth);
                edtTanggalKonsultasi.setText(simpleDateFormat.format(newDate.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}
