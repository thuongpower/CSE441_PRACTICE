package com.example.btth3_connectjson_crud;

import static com.example.btth3_connectjson_crud.R.id.spAddress;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddStudentActivity extends AppCompatActivity {

    private EditText etStudentId, etStudentName, etBirthDate, etEmail, etGpa, etYear;
    private Spinner spAddress, spMajor;
    private RadioGroup rgGender;
    private Button btnComplete;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        // Ánh xạ các view
        etStudentId = findViewById(R.id.etStudentId);
        etStudentName = findViewById(R.id.etStudentName);
        etBirthDate = findViewById(R.id.etBirthDate);
        spAddress = findViewById(R.id.spAddress);
        etEmail = findViewById(R.id.etEmail);
        spMajor = findViewById(R.id.spMajor);
        etGpa = findViewById(R.id.etGpa);
        etYear = findViewById(R.id.etYear);
        rgGender = findViewById(R.id.rgGender);
        btnComplete = findViewById(R.id.btnComplete);

        // Thiết lập spinner dữ liệu cho địa chỉ và chuyên ngành
        setupSpinner();

        // Thiết lập DatePicker cho ngày sinh
        setupDatePicker();

        // Xử lý sự kiện khi nhấn nút Hoàn tất
        btnComplete.setOnClickListener(v -> saveStudent());
    }

    // Hàm thiết lập spinner cho địa chỉ và chuyên ngành
    private void setupSpinner() {
        // Dữ liệu mẫu cho spinner địa chỉ
        ArrayAdapter<CharSequence> addressAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.address_list, // Bạn cần thêm các địa chỉ vào file strings.xml
                android.R.layout.simple_spinner_item
        );
        addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAddress.setAdapter(addressAdapter);

        // Dữ liệu mẫu cho spinner chuyên ngành
        ArrayAdapter<CharSequence> majorAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.major_list, // Bạn cần thêm các chuyên ngành vào file strings.xml
                android.R.layout.simple_spinner_item
        );
        majorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMajor.setAdapter(majorAdapter);
    }

    // Thiết lập DatePicker cho ngày sinh
    private void setupDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        etBirthDate.setOnClickListener(v -> {
            DatePickerDialog datePicker = new DatePickerDialog(AddStudentActivity.this, (view, selectedYear, selectedMonth, selectedDay) -> {
                etBirthDate.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
            }, year, month, day);
            datePicker.show();
        });
    }

    // Lưu thông tin sinh viên
    private void saveStudent() {
        // Lấy dữ liệu từ các trường nhập liệu
        String studentId = etStudentId.getText().toString();
        String studentName = etStudentName.getText().toString();
        String birthDate = etBirthDate.getText().toString();
        String email = etEmail.getText().toString();
        String gpa = etGpa.getText().toString();
        String year = etYear.getText().toString();

        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        String gender = (selectedGenderId == R.id.rbMale) ? "Nam" : "Nữ"; // Có thể thêm xử lý nếu có giới tính khác

        // Kiểm tra dữ liệu hợp lệ và hiển thị thông báo (có thể bổ sung thêm validate)
        if (studentId.isEmpty() || studentName.isEmpty() || birthDate.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        } else {
            // Xử lý lưu thông tin sinh viên vào database hoặc danh sách sinh viên (tùy thuộc vào yêu cầu của bạn)
            Toast.makeText(this, "Thêm sinh viên thành công!", Toast.LENGTH_SHORT).show();
            // Sau khi hoàn tất, có thể quay lại màn hình chính
            finish();
        }
    }
}

