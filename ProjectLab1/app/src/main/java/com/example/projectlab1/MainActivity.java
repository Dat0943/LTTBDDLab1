package com.example.projectlab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtHoVaTen;
    EditText edtSDT;
    RadioButton rbNam;
    RadioButton rbNu;
    Button btnAdd;
    Spinner spQueQuan;
    ListView lvHocSinh;

    ArrayList<HocSinh> listHocSinh = new ArrayList<HocSinh>();
    ArrayAdapter<HocSinh> adapterHocSinh;

    List<String> listQueQuan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitWidget();

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listQueQuan);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spQueQuan.setAdapter(spinnerAdapter);

        adapterHocSinh = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listHocSinh);
        lvHocSinh.setAdapter(adapterHocSinh);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoTen = edtHoVaTen.getText().toString();
                String soDienThoai = edtSDT.getText().toString();
                String queQuan = spQueQuan.getSelectedItem().toString();
                String gioiTinh = "";

                if (hoTen.isEmpty() || soDienThoai.isEmpty() || queQuan.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (rbNam.isChecked()) {
                    gioiTinh = "Nam";
                } else if (rbNu.isChecked()) {
                    gioiTinh = "Nữ";
                } else {
                    Toast.makeText(MainActivity.this, "Hãy chọn giới tính của bạn!", Toast.LENGTH_SHORT).show();
                    return;
                }

                HocSinh hs = new HocSinh(hoTen, soDienThoai, gioiTinh, queQuan);
                listHocSinh.add(hs);
                adapterHocSinh.notifyDataSetChanged();

                Complete();
            }
        });
    }

    void InitWidget(){
        edtHoVaTen = (EditText) findViewById(R.id.edtHoVaTen);
        edtSDT = (EditText) findViewById(R.id.edtSDT);
        rbNam = (RadioButton) findViewById(R.id.rbNam);
        rbNu = (RadioButton) findViewById(R.id.rbNu);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        spQueQuan = (Spinner) findViewById(R.id.spQueQuan);
        lvHocSinh = (ListView) findViewById(R.id.lvHocSinh);

        listQueQuan.add("Thanh Hóa");
        listQueQuan.add("Hà Nội");
        listQueQuan.add("Ninh Bình");

        listHocSinh.add(new HocSinh("Trịnh Ngọc Đạt", "0943420119", "Thanh Hóa", "Nam"));
        listHocSinh.add(new HocSinh("Trịnh Ngọc Hà", "0123456789", "Thanh Hóa", "Nam"));
        listHocSinh.add(new HocSinh("Trịnh Ngọc Hường", "0113456789", "Hà Nội", "Nam"));
        listHocSinh.add(new HocSinh("Lê Thị Hoa", "0111456789", "Hà Nội", "Nữ"));
    }

    void Complete() {
        Toast.makeText(MainActivity.this,"Thêm học sinh thành công !!!",Toast.LENGTH_SHORT).show();

        edtHoVaTen.setText("");
        edtSDT.setText("");
        rbNam.setChecked(true);
        spQueQuan.setSelection(0);
    }
}