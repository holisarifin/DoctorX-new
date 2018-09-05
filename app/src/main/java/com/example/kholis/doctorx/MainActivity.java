package com.example.kholis.doctorx;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.kholis.doctorx.Model.GetPasien;
import com.example.kholis.doctorx.Model.Pasien;
import com.example.kholis.doctorx.Rest.ApiInterface;
import com.example.kholis.doctorx.Slider.FragmentSlider;
import com.example.kholis.doctorx.Slider.SliderIndicator;
import com.example.kholis.doctorx.Slider.SliderPagerAdapter;
import com.example.kholis.doctorx.Slider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    Button btnIns;
    ImageView imgDaftarPasien, imgRiwayatPasien, imgJadwalDokter, imgDaftarKonsultasi, imgDaftarTreatment, imgHelper;

    private SliderPagerAdapter mSliderAdapter;
    private SliderIndicator mIndicator;
    private SliderView sliderView;
    private LinearLayout mLinearLayout;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_register:
                        Intent intent1 = new Intent(MainActivity.this, InsertActivity.class);
                        Log.e("Insert Activity", "masuk insert");
                        startActivity(intent1);
                        return true;
                    case R.id.navigation_home:
                        /*Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
                        Log.e("Main Activity", "masuk main");
                        startActivity(intent2);*/
                        return true;
                    case R.id.navigation_history :
                        Intent intent3 = new Intent(MainActivity.this, MedicalRecordActivity.class);
                        Log.e("Medical Record Activity", "masuk history");
                        startActivity(intent3);
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        sliderView = (SliderView) findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) findViewById(R.id.pagesContainer);
        setupSlider();
        imgDaftarPasien = (ImageView) findViewById(R.id.imageDaftarPasien);
        imgDaftarPasien.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });
        imgRiwayatPasien = (ImageView) findViewById(R.id.imageRiwayatPasien);
        imgRiwayatPasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MedicalRecordActivity.class));
            }
        });
        imgJadwalDokter = (ImageView) findViewById(R.id.imageJadwalDokter);
        imgJadwalDokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, JadwalDokterActivity.class));
            }
        });
        imgDaftarKonsultasi = (ImageView) findViewById(R.id.imageDaftarKonsultasi);
        imgDaftarKonsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ConsultationActivity.class));
            }
        });
        imgDaftarTreatment = (ImageView) findViewById(R.id.imageDaftarTreatment);
        imgDaftarTreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TreatmentActivity.class));
            }
        });
        imgHelper = (ImageView) findViewById(R.id.imageHelper);
        imgHelper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HelperActivity.class));
            }
        });
    }

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("https://webicdn.com/sdirmember/15/14740/slider/74q8f.jpg"));
        fragments.add(FragmentSlider.newInstance("https://webicdn.com/sdirmember/15/14740/slider/v8tpx.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/biN2sqExViEh8IYSJrXlNKjpjxx.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg"));

        mSliderAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
        sliderView.setAdapter(mSliderAdapter);
        mIndicator = new SliderIndicator(this, mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }

}