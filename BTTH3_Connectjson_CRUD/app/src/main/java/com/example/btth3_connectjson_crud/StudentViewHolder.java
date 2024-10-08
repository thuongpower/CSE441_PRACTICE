package com.example.btth3_connectjson_crud;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    TextView fullName, gpa, major;
    ImageView imageViewStudent; // Thêm ImageView

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        fullName = itemView.findViewById(R.id.tvStudentName);
        gpa = itemView.findViewById(R.id.tvGpa);
        major = itemView.findViewById(R.id.tvTitle);
        imageViewStudent = itemView.findViewById(R.id.imageViewGender); // Liên kết ImageView
    }
}
