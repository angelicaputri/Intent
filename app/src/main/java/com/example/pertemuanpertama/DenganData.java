package com.example.pertemuanpertama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DenganData extends AppCompatActivity {
    TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dengan_data);

        tvHasil = findViewById(R.id.TVdata);

        String namaa = getIntent().getStringExtra("nama");
        int umurr = getIntent().getIntExtra("umur",0);

        String tekshasil = "Nama saya "+namaa+" dan saya berumur "+umurr;
        tvHasil.setText(tekshasil);

//        MainActivity mainActivity = new MainActivity();
//        mainActivity.Halo();
    }
}