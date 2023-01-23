package com.example.yourjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Fight extends AppCompatActivity {

    String M_name;
    int M_hp;
    int M_hpmax;
    int M_atk;
    int M_def;
    int M_gold;
    String M_img;
    TextView tv_hp;
    TextView tv_atak;
    TextView tv_obrona;
    TextView tv_gold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        tv_hp = findViewById(R.id.tv_hp);
        tv_atak = findViewById(R.id.tv_atak);
        tv_obrona = findViewById(R.id.tv_obrona);
        tv_gold = findViewById(R.id.tv_gold1);
        tv_hp = ;
    }


    public void turn(){

    }
}