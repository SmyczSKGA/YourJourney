package com.example.yourjourney;

import static com.example.yourjourney.Creatures.Creature.CreatureList;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public TextView title;
    public Button start_btn;
    public Button load_btn;
    public Button exit_btn;
    int index = 0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
        }

        if (Creatures.Creature.CreatureList.isEmpty()) {
            new Creatures.Creature("Wojownik", 7,3, 3, 0, "R.drawable.woj_ikona");
            new Creatures.Creature("Mag", 4, 7, 1, 0, "R.drawable.mag_ikona");
            new Creatures.Creature("Łucznik", 5, 2, 5, 0, "R.drawable.lucznik_ikona");
            new Creatures.Creature("Dzik", 4, 3, 1, 0, "");
            new Creatures.Creature("Goblin", 5, 2, 4, 0, "");
            new Creatures.Creature("Ork", 6, 5, 3, 0, "");
        }

        Log.i("Data",CreatureList.get(index).toString());

    }

    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1000:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Możesz teraz zapisywać!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "UWAGA! Nie możesz zapisywać!", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
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