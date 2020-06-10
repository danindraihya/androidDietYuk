package com.example.dietkuy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Day2 extends AppCompatActivity {

    Integer flag = 1;
    TextView hari, waktu, jenis1, waktu1, jenis2, waktu2;
    KenaikanFragment kf = new KenaikanFragment();
    Button btnSelesai;

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
        btnSelesai = findViewById(R.id.btnSelesai);

        hari.setText("Hari 2");
        waktu.setText("3 - 5 menit/hari");
        jenis1.setText("Plank");
        waktu1.setText("00:30");
        jenis2.setText("Plank");
        waktu2.setText("00:30");

        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 1){
                    btnSelesai.setText("Selesai");
                    flag++;
                } else {
                    kf.addValues(1, 33);
                    flag = 1;
                }
            }
        });



    }
}
