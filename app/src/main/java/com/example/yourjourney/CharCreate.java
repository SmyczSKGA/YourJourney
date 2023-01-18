package com.example.yourjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CharCreate extends AppCompatActivity {

    public TextView login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayAdapter<Creatures> adapter = new ArrayAdapter<Creatures>(this, android.R.layout.simple_list_item_1);
        ListView listView = (ListView) findViewById(R.id.lv_postaci);
        listView.setAdapter(adapter);

        login = findViewById(R.id.tv_login);

    }

    public void back(View v) {
        Intent menuSwitch = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(menuSwitch);
    }

    public void reset(View v) {
        login.setText("");
    }

    public void confirm(View v) {
        Intent loadSwitch = new Intent(getApplicationContext(), CharCreate.class);
        startActivity(loadSwitch);
    }




}