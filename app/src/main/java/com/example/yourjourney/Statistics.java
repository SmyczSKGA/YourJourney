package com.example.yourjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {

    TextView tv_name;
    TextView tv_hp;
    TextView tv_atk;
    TextView tv_def;
    TextView tv_gold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv_name = findViewById(R.id.tv_login_s);
        tv_hp = findViewById(R.id.tv_hp);
        tv_atk = findViewById(R.id.tv_atak);
        tv_def = findViewById(R.id.tv_obrona);
        tv_gold = findViewById(R.id.tv_gold);

        tv_name.setText(activity_main4.H_name);
        tv_hp.setText(String.valueOf(activity_main4.H_hp)+"/"+String.valueOf(activity_main4.H_hpmax));
        tv_atk.setText(String.valueOf(activity_main4.H_atk));
        tv_def.setText(String.valueOf(activity_main4.H_def));
        tv_gold.setText(String.valueOf(activity_main4.H_gold));
    }

    public void back(View v) {
        Intent menuSwitch = new Intent(getApplicationContext(), activity_main4.class);
        startActivity(menuSwitch);
    }

    @Override
    protected void onResume() {
        super.onResume();

        tv_name = findViewById(R.id.tv_login_s);
        tv_hp = findViewById(R.id.tv_hp);
        tv_atk = findViewById(R.id.tv_atak);
        tv_def = findViewById(R.id.tv_obrona);
        tv_gold = findViewById(R.id.tv_gold);

        tv_name.setText(activity_main4.H_name);
        tv_hp.setText(String.valueOf(activity_main4.H_hp)+"/"+String.valueOf(activity_main4.H_hpmax));
        tv_atk.setText(String.valueOf(activity_main4.H_atk));
        tv_def.setText(String.valueOf(activity_main4.H_def));
        tv_gold.setText(String.valueOf(activity_main4.H_gold));
    }
}