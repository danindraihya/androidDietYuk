package com.example.dietkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LatihanActivity extends AppCompatActivity {
    Integer flag = 1;
    KenaikanFragment kf = new KenaikanFragment();
    Button btnSelesai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan);

        btnSelesai = findViewById(R.id.btnSelesai);

        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 1){
                    btnSelesai.setText("Selesai");
                    flag++;
                } else {
                    kf.addValues(0, 12);
                    flag = 1;
                }
            }
        });


    }
}