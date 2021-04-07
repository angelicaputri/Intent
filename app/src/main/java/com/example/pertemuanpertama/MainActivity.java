package com.example.pertemuanpertama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button Tombol1,Tombol2,Tombol3,Tombol4,Tombol5;
    TextView TV1,TV2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tombol1 = findViewById(R.id.B1);
        Tombol2 = findViewById(R.id.B2);
        Tombol3 = findViewById(R.id.B3);
        Tombol4 = findViewById(R.id.B4);
        Tombol5 = findViewById(R.id.B5);
        TV1 = findViewById(R.id.nama);
        TV2 = findViewById(R.id.umur);

        //dial number
        Tombol1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dial = new Intent (Intent.ACTION_DIAL,Uri.parse("tel:0274486733"));
                //uri (Uniform Resource Identifier) untuk mengidentifikasi resource
                //uri.parse disini menjadikan uri menjadi suatu objek
                //tel: untuk buka calling app, geo: untuk buka maps, disebut data schemes
                startActivity(dial);
            }
        });

        //open browser
        Tombol2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browser = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com"));
                startActivity(browser);
            }
        });

        //open camera
        Tombol3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //MediaStore untuk akses fitur media seperti image,video,audio
                //Bisa dilihat di developer.android.com untuk fitur lainnya
                startActivity(cam);
            }
        });

        //pindah activity tanpa ngirim data
        Tombol4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent (MainActivity.this,TanpaData.class);
                //Intent variabel = new Intent(class asal.this,class tujuan.class);
                startActivity(pindah);
                //startActivity(variabel intent);
            }
        });

        //pindah activity dengan ngirim data
        Tombol5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent (MainActivity.this,DenganData.class);
//                data.putExtra("nama", "Putri Ayu");
//                data.putExtra("umur",21);
                data.putExtra("nama",TV1.getText().toString());
//                EditText masih berupa objek saat di getText, maka dari itu harus ditambah toString.
                data.putExtra("umur",Integer.parseInt(TV2.getText().toString()));
//                Integer.parseInt untuk mengkonversi String menjadi int.
                startActivity(data);
            }
        });
    }
//    public void Halo() {
//        System.out.println("Halo");
//    }
}