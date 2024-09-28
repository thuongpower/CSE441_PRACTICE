package com.example.prac01;

// SubActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    private EditText etName, etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_main);  // Tái sử dụng layout activity_input

        etName = findViewById(R.id.etName);
        etGPA = findViewById(R.id.etGPA);

        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ EditText
                String name = etName.getText().toString();
                String gpa = etGPA.getText().toString();

                // Tạo Intent để gửi dữ liệu về MainActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", name);
                resultIntent.putExtra("gpa", gpa);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}

