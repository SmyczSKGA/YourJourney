package com.example.yourjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class City extends AppCompatActivity {

    public static int who;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        ListView lv_city = findViewById(R.id.lv_miastowe);

        List<String> list = new ArrayList<>();
        list.add("Zbrojmistrz");
        list.add("Alchemik");
        list.add("Płatnerz");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        lv_city.setAdapter(arrayAdapter);

        lv_city.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent menuSwitch = new Intent(getApplicationContext(), Shop.class);
                    who = 0;
                    startActivity(menuSwitch);
                }
                else if(position==1) {
                    Intent menuSwitch = new Intent(getApplicationContext(), Shop.class);
                    who = 1;
                    startActivity(menuSwitch);
                }
                else if(position==2) {
                    Intent menuSwitch = new Intent(getApplicationContext(), Shop.class);
                    who = 2;
                    startActivity(menuSwitch);
                }
                else {
                    Log.v("Error", "Błąd! Nie udało się wczytać widoku");
                }
            }
        });
    }

    public void back(View v) {
        Intent menuSwitch = new Intent(getApplicationContext(), activity_main4.class);
        startActivity(menuSwitch);
    }
}