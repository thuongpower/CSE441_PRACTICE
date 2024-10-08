package com.example.btth3_connectjson_crud;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String jsonFileString = loadJSONFromAsset();
        Gson gson = new Gson();
        Type listStudentType = new TypeToken<List<Student>>() {}.getType();
        List<Student> students = gson.fromJson(jsonFileString, listStudentType);

        studentAdapter = new StudentAdapter(students);
        recyclerView.setAdapter(studentAdapter);
    }

    // Đọc file JSON từ thư mục assets
    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("students.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }
}
