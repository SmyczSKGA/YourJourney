package com.example.yourjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class activity_main4 extends AppCompatActivity {

    boolean firsttime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        if(CharCreate.created==true) {
            CharCreate.created=false;
        }
        else if(firsttime==true) {
            firsttime=false;
        }
        else {

        }
    }


    public void back(View v) {
        Intent menuSwitch = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(menuSwitch);
    }
}