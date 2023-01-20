package com.example.yourjourney;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.yourjourney.Creatures.Creature.CreatureList;

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
    String[] Heroes;
    ListView lv_postaci;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv_postaci = findViewById(R.id.lv_postaci);

        Heroes = getResources().getStringArray(R.array.characters);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_single_choice,
                Heroes);

        lv_postaci.setAdapter(adapter);
        lv_postaci.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

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