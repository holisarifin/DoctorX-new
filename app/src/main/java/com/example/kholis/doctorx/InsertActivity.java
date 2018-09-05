package com.example.kholis.doctorx;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kholis.doctorx.Model.PostPutDelPasien;
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

public class InsertActivity extends AppCompatActivity {

    EditText edtNamaLengkap, edtNamaPanggilan,edtTempatLahir, edtAlamat, edtKodepos;
    Button btnInserting, btnBackGo;
    ApiInterface mApiInterface;
    Spinner spinnerjenisKelamin, spinnerStatusPernikahan, spinnerProvinsi, spinnerKabKota;
    String spinnerValue, spinnerValueStatusPernikahan, spinnerValueProvinsi, spinnerValueKabKota;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat simpleDateFormat;
    TextView edtTanggalLahir;
    ImageButton inputTanggalLahir;
    Context context = this;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarInsert);
        setSupportActionBar(toolbar);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationViewInsert);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_register:
                        /*Intent intent1 = new Intent(InsertActivity.this, InsertActivity.class);
                        Log.e("Insert Activity", "masuk insert");
                        startActivity(intent1);*/
                        return true;
                    case R.id.navigation_home:
                        Intent intent2 = new Intent(InsertActivity.this, MainActivity.class);
                        Log.e("Main Activity", "masuk main");
                        startActivity(intent2);
                        return true;
                    case R.id.navigation_history :
                        Intent intent3 = new Intent(InsertActivity.this, MedicalRecordActivity.class);
                        Log.e("Medical Record Activity", "masuk history");
                        startActivity(intent3);
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.navigation_register);
        edtNamaLengkap          = (EditText) findViewById(R.id.edtNamaLengkap);
        edtNamaPanggilan        = (EditText) findViewById(R.id.edtNamaPanggilan);
        spinnerjenisKelamin     = (Spinner) findViewById(R.id.spinnerJenisKelamin);
        spinnerStatusPernikahan = (Spinner) findViewById(R.id.spinnerStatusPernikahan);
        edtTempatLahir          = (EditText) findViewById(R.id.edtTempatLahir);
        edtAlamat               = (EditText) findViewById(R.id.edtAlamat);
        spinnerProvinsi         = (Spinner) findViewById(R.id.spinnerProvinsi);
        spinnerKabKota          = (Spinner) findViewById(R.id.spinnerKabupatenKota);
        edtKodepos              = (EditText) findViewById(R.id.edtKodepos);

        String[] jeniskelamin = new String[]{
                "",
                "Laki-Laki",
                "Perempuan"
        };
        String[] statuspernikahan = new String[]{
                "",
                "Sudah Menikah",
                "Belum Menikah"
        };
        String[] provinsi = new String[]{
                "",
                "Jawa Barat",
                "Jawa Tengah",
                "Jawa Timur"
        };
        String[] kabupatenkota = new String[]{
                "",
                "Kabupaten Bandung",
                "Kota Bandung"
        };

        List<String> jeniskelaminList = new ArrayList<>(Arrays.asList(jeniskelamin));
        List<String> statuspernikahanList = new ArrayList<>(Arrays.asList(statuspernikahan));
        List<String> provinsiList = new ArrayList<>(Arrays.asList(provinsi));
        List<String> kabupatenkotaList = new ArrayList<>(Arrays.asList(kabupatenkota));

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, jeniskelaminList){
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = null;
                if(position==0) {
                    TextView tv = new TextView(getContext());
                    // Set the disable item text color
                    tv.setHeight(0);
                    tv.setVisibility(View.GONE);
                    view = tv;
                }
                else {
                    view = super.getDropDownView(position, null, parent);
                }
                parent.setVerticalScrollBarEnabled(false);
                return view;
            }
        };

        stringArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinnerjenisKelamin.setAdapter(stringArrayAdapter);

        spinnerjenisKelamin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerValue = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> stringArrayAdapterStatusPenikahan = new ArrayAdapter<String>(this, R.layout.spinner_item, statuspernikahanList){
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = null;
                if(position==0) {
                    TextView tv = new TextView(getContext());
                    tv.setHeight(0);
                    tv.setVisibility(View.GONE);
                    view = tv;
                }
                else {
                    view = super.getDropDownView(position, null, parent);
                }
                parent.setVerticalScrollBarEnabled(false);
                return view;
            }
        };

        stringArrayAdapterStatusPenikahan.setDropDownViewResource(R.layout.spinner_item);
        spinnerStatusPernikahan.setAdapter(stringArrayAdapterStatusPenikahan);

        spinnerStatusPernikahan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerValueStatusPernikahan = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> stringArrayAdapterProvinsi = new ArrayAdapter<String>(this, R.layout.spinner_item, provinsiList){
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = null;
                if(position==0) {
                    TextView tv = new TextView(getContext());
                    tv.setHeight(0);
                    tv.setVisibility(View.GONE);
                    view = tv;
                }
                else {
                    view = super.getDropDownView(position, null, parent);
                }
                parent.setVerticalScrollBarEnabled(false);
                return view;
            }
        };

        stringArrayAdapterProvinsi.setDropDownViewResource(R.layout.spinner_item);
        spinnerProvinsi.setAdapter(stringArrayAdapterProvinsi);
        spinnerProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerValueProvinsi = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> stringArrayAdapterKabupatenKota = new ArrayAdapter<String>(this, R.layout.spinner_item, kabupatenkotaList){
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = null;
                if(position==0) {
                    TextView tv = new TextView(getContext());
                    tv.setHeight(0);
                    tv.setVisibility(View.GONE);
                    view = tv;
                }
                else {
                    view = super.getDropDownView(position, null, parent);
                }
                parent.setVerticalScrollBarEnabled(false);
                return view;
            }
        };

        stringArrayAdapterKabupatenKota.setDropDownViewResource(R.layout.spinner_item);
        spinnerKabKota.setAdapter(stringArrayAdapterKabupatenKota);
        spinnerKabKota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerValueKabKota = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        edtTanggalLahir = (TextView) findViewById(R.id.edtTanggalLahir);
        inputTanggalLahir = (ImageButton) findViewById(R.id.inputTanggalLahir);
        inputTanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnInserting = (Button) findViewById(R.id.btnInserting);
        btnInserting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("Konfirmasi Data Pasien");
                alertDialogBuilder.setMessage("Anda yakin dengan data yang diinputkan telah sesuai ?")
                        .setCancelable(false)
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(InsertActivity.this, ViewPasienActivity.class));
                                Call<PostPutDelPasien> postPasienCall = mApiInterface.postPasien(edtNamaLengkap.getText().toString(), edtNamaPanggilan.getText().toString(),
                                        spinnerValue, edtTanggalLahir.getText().toString(), spinnerValueStatusPernikahan, edtTempatLahir.getText().toString(),
                                        edtAlamat.getText().toString(), spinnerValueProvinsi, spinnerValueKabKota, edtKodepos.getText().toString());
                                postPasienCall.enqueue(new Callback<PostPutDelPasien>() {
                                    @Override
                                    public void onResponse(Call<PostPutDelPasien> call, Response<PostPutDelPasien> response) {
                                        final Dialog dialog = new Dialog(context);
                                        dialog.setContentView(R.layout.success);

                                        TextView textView = (TextView) dialog.findViewById(R.id.text);
                                        textView.setText("Pasien berhasil didaftarkan");
                                        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                                        dialogButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                dialog.dismiss();
                                            }
                                        });
                                        dialog.show();
                                        ViewPasienActivity.vp.refresh();
                                        finish();
                                    }

                                    @Override
                                    public void onFailure(Call<PostPutDelPasien> call, Throwable t) {
                                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });
        btnBackGo = (Button) findViewById(R.id.btnBackGo);
        btnBackGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPasienActivity.vp.refresh();
                finish();
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
                edtTanggalLahir.setText(simpleDateFormat.format(newDate.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

}
