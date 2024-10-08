package com.example.btth3_connectjson_crud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.fullName.setText(student.getFullName().getLast() + " " +
                student.getFullName().getMiddle() + " " + student.getFullName().getFirst());
        holder.gpa.setText(String.valueOf(student.getGpa()));
        holder.major.setText(student.getMajor());

        // Hiển thị ảnh theo giới tính
        if (student.getGender().equalsIgnoreCase("Nam")) {
            holder.imageViewStudent.setImageResource(R.drawable.male); // Sử dụng male.png cho Nam
        } else if (student.getGender().equalsIgnoreCase("Nữ")) {
            holder.imageViewStudent.setImageResource(R.drawable.female); // Sử dụng female.png cho Nữ
        }
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewStudent;
        TextView fullName, gpa, major;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.tvStudentName);
            gpa = itemView.findViewById(R.id.tvGpa);
            major = itemView.findViewById(R.id.tvTitle);
        }
    }
}

