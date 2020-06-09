package com.example.dietkuy;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Day2 extends AppCompatActivity {

    TextView hari, waktu, jenis1, waktu1, jenis2, waktu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan);

        hari = findViewById(R.id.judulLatihan);
        waktu = findViewById(R.id.waktuLatihan);
        jenis1 = findViewById(R.id.tv1);
        waktu1 = findViewById(R.id.tv2_2);
        jenis2 = findViewById(R.id.tv2);
        waktu2 = findViewById(R.id.tv2_2);

        hari.setText("Hari 2");
        waktu.setText("3 - 5 menit/hari");
        jenis1.setText("Plank");
        waktu1.setText("00:30");
        jenis2.setText("Plank");
        waktu2.setText("00:30");


    }
}
