package com.example.yourjourney;

import static com.example.yourjourney.Creatures.Creature.CreatureList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class activity_main4 extends AppCompatActivity {

    boolean firsttime = true;
    final String filename = CharCreate.filename;
    public static String H_name;
    public static int H_hp; public int H_hp_temp;
    public static int H_hpmax; public int H_hpmax_temp;
    public static int H_atk; public int H_atk_temp;
    public static int H_def; public int H_def_temp;
    public static int H_gold; public int H_gold_temp;
    String H_img;
    String splitter = CreatureList.get(CreatureList.size() - 1).toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        if(firsttime==true) {
            String[] separate = splitter.split(", ");
            H_name = separate[0];
            H_hp = Integer.valueOf(separate[1]); H_hp_temp= H_hp;
            H_hpmax = Integer.valueOf(separate[1]); H_hpmax_temp = H_hpmax;
            H_atk = Integer.valueOf(separate[2]); H_atk_temp = H_atk;
            H_def = Integer.valueOf(separate[3]); H_def_temp = H_def;
            H_gold = Integer.valueOf(separate[4]); H_gold_temp = H_gold;
            H_img = separate[5];
            //H_name = CreatureList.get(CreatureList.size() - 1).toString();
            Log.i("Test","NAME: "+H_name);
            Log.i("Test","HP: "+H_hp);
            Log.i("Test","HPMAX: "+H_hpmax);
            Log.i("Test","ATK: "+H_atk);
            Log.i("Test","DEF: "+H_def);
            Log.i("Test","GOLD: "+H_gold);
            Log.i("Test","IMG: "+H_img);
            firsttime=false;
        }
        else {}
    }

    private boolean isExternalStorageReadable() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
            || Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())) {
            Log.i("State", "Readable");
            return true;
        }
        else {
            return false;
        }
    }


    public void back(View v) {
        firsttime=true;
        Intent menuSwitch = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(menuSwitch);
    }

    public void statistics(View v) {
        Intent menuSwitch = new Intent(getApplicationContext(), Statistics.class);
        startActivity(menuSwitch);
    }
    public void city(View v) {
        Intent menuSwitch = new Intent(getApplicationContext(), City.class);
        startActivity(menuSwitch);
    }
}