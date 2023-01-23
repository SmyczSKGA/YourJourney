package com.example.yourjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends AppCompatActivity {
    Toast fail;
    Toast success;
    TextView tv_hp;
    TextView tv_atk;
    TextView tv_def;
    TextView tv_gold;
    TextView oferta;
    Button choice1;
    Button choice2;
    int H_hptemp;
    int H_hpmaxtemp;
    int H_atktemp;
    int H_deftemp;
    int H_goldtemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        H_hptemp = activity_main4.H_hp;
        H_hpmaxtemp = activity_main4.H_hpmax;
        H_atktemp = activity_main4.H_atk;
        H_deftemp = activity_main4.H_def;
        H_goldtemp = activity_main4.H_gold;

        tv_hp = findViewById(R.id.tv_hp);
        tv_atk = findViewById(R.id.tv_atak);
        tv_def = findViewById(R.id.tv_obrona);
        tv_gold = findViewById(R.id.tv_gold1);

        tv_hp.setText(String.valueOf(H_hptemp)+"/"+String.valueOf(H_hpmaxtemp));
        tv_atk.setText(String.valueOf(H_atktemp));
        tv_def.setText(String.valueOf(H_deftemp));
        tv_gold.setText(String.valueOf(H_goldtemp));

        oferta = findViewById(R.id.tv_komunikat);
        choice1 = findViewById(R.id.b_opcja1);
        choice2 = findViewById(R.id.b_opcja2);

        fail.makeText(this, "Za mało złota", Toast.LENGTH_SHORT);
        success.makeText(this, "Pomyślnie zakupiono", Toast.LENGTH_SHORT);

        if (City.who==0) {
            oferta.setText("Zaglądasz do Zbrojmistrza. Możesz u niego ulepszyć swój atak, by łatwiej trafić przecwnika. \n(1gold=1atk)");

            choice1.setText("Ulepsz swój atak.");

            choice1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                        fail.show();
                }
            });
        }
        else if (City.who==1) {
            oferta.setText("Zaglądasz do Alchemika. Możesz u niego kupić mikstury wzmacniające twoją wytrzymałość, lub lecznicze, by zagoić rany. \n(1gold=1MaxHp, 1gold=2hp)");
        }
        else {
            oferta.setText("Zaglądasz do Płatnerza. Możesz u niego ulepszyć swoją obronę, by lepiej bronić się przed atakami przeciwnika. \n(1gold=1def)");
        }
    }

    public void back(View v) {
        Intent menuSwitch = new Intent(getApplicationContext(), City.class);
        startActivity(menuSwitch);
    }

    public void confirm(View v) {
        activity_main4.H_hp = H_hptemp;
        activity_main4.H_hpmax = H_hpmaxtemp;
        activity_main4.H_atk = H_atktemp;
        activity_main4.H_def = H_deftemp;
        activity_main4.H_gold = H_goldtemp;
        Toast.makeText(this, "Zapisano!", Toast.LENGTH_SHORT).show();
    }

    public void reset(View v) {
        H_hptemp = activity_main4.H_hp;
        H_hpmaxtemp = activity_main4.H_hpmax;
        H_atktemp = activity_main4.H_atk;
        H_deftemp = activity_main4.H_def;
        H_goldtemp = activity_main4.H_gold;
        Toast.makeText(this, "Zresetowano!", Toast.LENGTH_SHORT).show();
    }
}