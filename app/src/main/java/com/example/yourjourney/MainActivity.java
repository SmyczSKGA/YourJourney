package com.example.yourjourney;

import static com.example.yourjourney.Creatures.Creature.CreatureList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
            new Creatures.Creature("Wojownik", "3", "3", "0", "");
            new Creatures.Creature("Mag", "5", "1", "0", "");
            new Creatures.Creature("Łucznik", "1", "5", "0", "");
            new Creatures.Creature("Dzik", "2", "3", "1", "");
            new Creatures.Creature("Goblin", "4", "3", "1", "");
            new Creatures.Creature("Ork", "5", "5", "1", "");
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