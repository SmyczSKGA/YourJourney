package com.example.yourjourney;

import static com.example.yourjourney.Creatures.Creature.CreatureList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public TextView title;
    public Button start_btn;
    public Button load_btn;
    public Button exit_btn;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Creatures.Creature.CreatureList.isEmpty()) {
            new Creatures.Creature("Wojownik", 7,3, 3, 0, "");
            new Creatures.Creature("Mag", 4, 7, 1, 0, "");
            new Creatures.Creature("Łucznik", 5, 2, 5, 0, "");
            new Creatures.Creature("Dzik", 4, 3, 1, 0, "");
            new Creatures.Creature("Goblin", 5, 2, 4, 0, "");
            new Creatures.Creature("Ork", 6, 5, 3, 0, "");
        }

        Log.i("Data",CreatureList.get(index).toString());

    }

    public void start(View v) {
        Intent startSwitch = new Intent(getApplicationContext(), CharCreate.class);
        startActivity(startSwitch);
    }

    public void load(View v) {
        Intent loadSwitch = new Intent(getApplicationContext(), CharCreate.class);
        startActivity(loadSwitch);
    }

    public void exit(View v) {
        System.exit(0);
    }
}