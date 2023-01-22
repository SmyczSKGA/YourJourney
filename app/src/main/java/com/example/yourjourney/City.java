package com.example.yourjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class City extends AppCompatActivity {

    public static int who;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

    }

    public void armorer(View v) {
        Intent menuSwitch = new Intent(getApplicationContext(), Shop.class);
        who = 2;
        startActivity(menuSwitch);
    }
    public void weaponsmith(View v) {
        Intent menuSwitch = new Intent(getApplicationContext(), Shop.class);
        who = 0;
        startActivity(menuSwitch);
    }
    public void alchemist(View v) {
        Intent menuSwitch = new Intent(getApplicationContext(), Shop.class);
        who = 1;
        startActivity(menuSwitch);
    }
    public void back(View v) {
        Intent menuSwitch = new Intent(getApplicationContext(), activity_main4.class);
        startActivity(menuSwitch);
    }
}