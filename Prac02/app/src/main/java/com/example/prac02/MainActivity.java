package com.example.prac02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private StaffViewModel staffViewModel;
    private EditText etStaffId, etFullName, etBirthDate, etSalary;
    private TextView tvResult;
    private Button btnAddStaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo ViewModel
        staffViewModel = new ViewModelProvider(this).get(StaffViewModel.class);

        // Liên kết các view
        etStaffId = findViewById(R.id.etStaffId);
        etFullName = findViewById(R.id.etFullName);
        etBirthDate = findViewById(R.id.etBirthDate);
        etSalary = findViewById(R.id.etSalary);
        tvResult = findViewById(R.id.tvResult);
        btnAddStaff = findViewById(R.id.btnAddStaff);

        // Quan sát dữ liệu từ ViewModel
        staffViewModel.getStaffData().observe(this, staffInfo -> {
            if (staffInfo != null) {
                tvResult.setText(staffInfo);
            } else {
                tvResult.setText("No Result!");
            }
        });

        // Thiết lập hành động cho nút "Add New Staff"
        btnAddStaff.setOnClickListener(v -> {
            String staffId = etStaffId.getText().toString();
            String fullName = etFullName.getText().toString();
            String birthDate = etBirthDate.getText().toString();
            String salary = etSalary.getText().toString();

            // Gọi phương thức thêm nhân viên
            staffViewModel.addStaff(staffId, fullName, birthDate, salary);
        });
    }
}
