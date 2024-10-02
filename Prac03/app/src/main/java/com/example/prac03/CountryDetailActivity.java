package com.example.prac03;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CountryDetailActivity extends AppCompatActivity {
    private ImageView countryFlag;
    private TextView countryName, countryCapital, countryPopulation, countryArea, countryDensity, worldShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail); // Kết nối với layout

        // Liên kết các View từ layout
        countryFlag = findViewById(R.id.country_flag_detail);
        countryName = findViewById(R.id.country_name_detail);
        countryCapital = findViewById(R.id.country_capital_detail);
        countryPopulation = findViewById(R.id.country_population);
        countryArea = findViewById(R.id.country_area);
        countryDensity = findViewById(R.id.country_density);
        worldShare = findViewById(R.id.country_world_share);

        // Nhận dữ liệu từ Intent
        Country country = (Country) getIntent().getSerializableExtra("country");

        // Nếu country không null, hiển thị thông tin chi tiết
        if (country != null) {
            countryFlag.setImageResource(country.getFlag());
            countryName.setText(country.getName());
            countryCapital.setText("Capital: " + country.getCapital());
            countryPopulation.setText("Population: " + country.getPopulation());
            countryArea.setText("Area: " + country.getArea());
            countryDensity.setText("Density: " + country.getDensity());
            worldShare.setText("World Share: " + country.getWorldShare());
        }
    }
}


