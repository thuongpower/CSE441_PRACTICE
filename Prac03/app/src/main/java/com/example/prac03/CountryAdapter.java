package com.example.prac03;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private List<Country> countryList;
    private Context context;

    // Constructor cho adapter
    public CountryAdapter(List<Country> countryList, Context context) {
        this.countryList = countryList;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout cho mỗi item trong danh sách
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        // Bind dữ liệu vào ViewHolder
        Country country = countryList.get(position);
        holder.bind(country);
    }

    @Override
    public int getItemCount() {
        return countryList.size();  // Trả về số lượng quốc gia trong danh sách
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView countryName, countryCapital;
        ImageView countryFlag;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            // Liên kết các view trong layout item
            countryName = itemView.findViewById(R.id.country_name);
            countryCapital = itemView.findViewById(R.id.country_capital);
            countryFlag = itemView.findViewById(R.id.country_flag);

            // Xử lý sự kiện khi nhấn vào một item
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Country selectedCountry = countryList.get(position);

                    // Tạo Intent để chuyển đến CountryDetailActivity
                    Intent intent = new Intent(context, CountryDetailActivity.class);
                    intent.putExtra("country", selectedCountry);  // Truyền đối tượng Country qua Intent
                    context.startActivity(intent);  // Bắt đầu Activity mới
                }
            });
        }

        // Hàm để bind dữ liệu cho từng item
        public void bind(Country country) {
            countryName.setText(country.getName());        // Hiển thị tên quốc gia
            countryCapital.setText(country.getCapital());  // Hiển thị thủ đô quốc gia
            countryFlag.setImageResource(country.getFlag());  // Hiển thị cờ quốc gia
        }
    }
}


