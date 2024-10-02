package com.example.prac03;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private List<Country> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Liên kết MainActivity với activity_main.xml

        // Tìm RecyclerView từ layout
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));  // Thiết lập layout cho RecyclerView

        // Khởi tạo danh sách các quốc gia
        countryList = new ArrayList<>();
        countryList.add(new Country("India", "New Delhi", R.drawable.india_flag, "1,428.6 million", "2,973,190 Km²", "481 people/Km²", "17.76%"));
        countryList.add(new Country("China", "Beijing", R.drawable.china_flag, "1,412.6 million", "9,596,961 Km²", "151 people/Km²", "18.47%"));
        countryList.add(new Country("United States", "Washington DC", R.drawable.usa_flag, "331 million", "9,833,517 Km²", "36 people/Km²", "4.25%"));
        countryList.add(new Country("Indonesia", "Jakarta", R.drawable.indonesia_flag, "273 million", "1,904,569 Km²", "144 people/Km²", "3.51%"));
        countryList.add(new Country("Pakistan", "Islamabad", R.drawable.pakistan_flag, "231 million", "881,913 Km²", "261 people/Km²", "2.83%"));
        countryList.add(new Country("Brazil", "Brasilia", R.drawable.brazil_flag, "215 million", "8,515,767 Km²", "25 people/Km²", "2.73%"));
        countryList.add(new Country("Nigeria", "Abuja", R.drawable.nigeria_flag, "213 million", "923,769 Km²", "231 people/Km²", "2.64%"));


        // Thiết lập Adapter
        adapter = new CountryAdapter(countryList, this);
        recyclerView.setAdapter(adapter);
    }
}
