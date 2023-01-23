package com.example.yourjourney;

import static com.example.yourjourney.Creatures.Creature.CreatureList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class Fight extends AppCompatActivity {

    String M_name;
    int M_hp;
    int M_hpmax;
    int M_atk;
    int M_def;
    int M_gold;
    String M_img;
    TextView tv_hp;
    TextView tv_atk;
    TextView tv_def;
    TextView tv_gold;
    TextView result;
    Random rand = new Random();
    int chance_H;
    int roll_H;
    int chance_M;
    int roll_M;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        String splitter = CreatureList.get(Forest.i).toString();
        String[] separate = splitter.split(", ");

        tv_hp = findViewById(R.id.tv_hp);
        tv_atk = findViewById(R.id.tv_atak_w);
        tv_def = findViewById(R.id.tv_obrona_w);
        tv_gold = findViewById(R.id.tv_gold1);

        tv_hp.setText(String.valueOf(activity_main4.H_hp)+"/"+String.valueOf(activity_main4.H_hpmax));
        tv_atk.setText(String.valueOf(activity_main4.H_atk));
        tv_def.setText(String.valueOf(activity_main4.H_def));
        tv_gold.setText(String.valueOf(activity_main4.H_gold));

        M_name = separate[0];
        M_hp = Integer.valueOf(separate[1]);
        M_hpmax = Integer.valueOf(separate[1]);
        M_atk = Integer.valueOf(separate[2]);
        M_def = Integer.valueOf(separate[3]);
        M_gold = Integer.valueOf(separate[4]);
        M_img = separate[5];
    }


    public void attack(){
        roll_H = rand.nextInt((100 - 0) + 1) + 0;
        chance_H = 20 + (10*(activity_main4.H_atk - M_def));

        roll_M = rand.nextInt((100 - 0) + 1) + 0;
        chance_M = 20 + (10*(M_atk - activity_main4.H_def));

        if(chance_H>roll_H) {
            result.setText("Trafienie! Zadajesz przeciwnikowi 1 obrażen!");
            M_hp--;
        }
        else if(chance_H<=roll_H) {
            result.setText("Nie trafiasz!");
        }
        if(chance_M>roll_M) {
            result.setText("Przeciwnik trafia cię! Dostajesz 1 obrażen!");
            activity_main4.H_hp--;
        }
        else if(chance_M<=roll_M) {
            result.setText("Przeciwnik nie trafia!");
        }
    }

    public void defence(){
        roll_M = rand.nextInt((100 - 0) + 1) + 0;
        chance_M = 20 + (5*(M_atk - (activity_main4.H_def+activity_main4.H_def)));

        if(chance_M>roll_M) {
            result.setText("Przeciwnik trafia cię! Dostajesz 1 obrażen!");
            activity_main4.H_hp--;
        }
        else if(chance_M<=roll_M) {
            if(chance_M+chance_M<=roll_M) {

            }
            result.setText("Przeciwnik nie trafia!");
        }
    }

    public void surrender(){
        Intent menuSwitch = new Intent(getApplicationContext(), gameover.class);
        startActivity(menuSwitch);
    }
}