package com.example.yourjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends AppCompatActivity {
    TextView tv_hp;
    TextView tv_atk;
    TextView tv_def;
    TextView tv_gold;
    TextView oferta;
    TextView choice1;
    TextView choice2;
    Button button1;
    Button button2;
    ImageView shop;
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
        shop = findViewById(R.id.iv_miastowy);

        tv_hp.setText(String.valueOf(H_hptemp)+"/"+String.valueOf(H_hpmaxtemp));
        tv_atk.setText(String.valueOf(H_atktemp));
        tv_def.setText(String.valueOf(H_deftemp));
        tv_gold.setText(String.valueOf(H_goldtemp));

        oferta = findViewById(R.id.tv_komunikat);
        choice1 = findViewById(R.id.tv_opcja1);
        choice2 = findViewById(R.id.tv_opcja2);
        button1 = findViewById(R.id.b_opcja1);
        button2 = findViewById(R.id.b_opcja2);

        if (City.who==0) {
            oferta.setText("Zaglądasz do Zbrojmistrza. Możesz u niego ulepszyć swój atak, by łatwiej trafić przecwnika.");

            choice1.setText("Ulepsz swój atak. (1G)");
            choice2.setText("");
            button1.setText("Kup");
            button2.setText("");
            H_goldtemp = 3;
            shop.setImageResource(R.drawable.zbroj);

            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(H_goldtemp>0){
                        H_goldtemp--;
                        H_atktemp++;
                        tv_atk.setText(String.valueOf(H_atktemp));
                        tv_gold.setText(String.valueOf(H_goldtemp));
                    }
                    else{
                        Log.v("ZAKUP", "Heh KUP");
                    }
                }
            });

        }
        else if (City.who==1) {
            oferta.setText("Zaglądasz do Alchemika. Możesz u niego kupić mikstury wzmacniające twoją wytrzymałość, lub lecznicze, by zagoić rany.");

            choice1.setText("Kup miksturę leczniczą (1G)");
            choice2.setText("Zwiększ swoją wytrzymałość (2G)");
            button1.setText("Kup");
            button2.setText("Kup");
            shop.setImageResource(R.drawable.alchem);

            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(H_goldtemp>0){
                        if(H_hptemp+2>H_hpmaxtemp+1) {
                            tv_hp.setText(String.valueOf(H_hptemp) + "/" + String.valueOf(H_hpmaxtemp));
                            tv_gold.setText(String.valueOf(H_goldtemp));
                        }
                        else if(H_hptemp+2>H_hpmaxtemp) {
                            H_goldtemp--;
                            H_hptemp++;
                            tv_hp.setText(String.valueOf(H_hptemp) + "/" + String.valueOf(H_hpmaxtemp));
                            tv_gold.setText(String.valueOf(H_goldtemp));
                        }
                        else {
                            H_goldtemp--;
                            H_hptemp=H_hptemp+2;
                            tv_hp.setText(String.valueOf(H_hptemp) + "/" + String.valueOf(H_hpmaxtemp));
                            tv_gold.setText(String.valueOf(H_goldtemp));
                        }
                    }
                    else{
                        Log.v("ZAKUP", "Heh KUP");
                    }
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(H_goldtemp>1){
                        H_goldtemp=H_goldtemp-2;
                        H_hpmaxtemp++;
                        tv_hp.setText(String.valueOf(H_hptemp) + "/" + String.valueOf(H_hpmaxtemp));
                        tv_gold.setText(String.valueOf(H_goldtemp));
                    }
                    else{
                        Log.v("ZAKUP", "Heh KUP");
                    }
                }
            });
        }
        else {
            oferta.setText("Zaglądasz do Płatnerza. Możesz u niego ulepszyć swoją obronę, by lepiej bronić się przed atakami przeciwnika.");
            choice1.setText("Ulepsz swoją obronę.");
            choice2.setText("");
            button1.setText("Kup");
            button2.setText("");
            shop.setImageResource(R.drawable.plat);

            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(H_goldtemp>0){
                        H_goldtemp--;
                        H_deftemp++;

                        button1.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                if(H_goldtemp>0){
                                    H_goldtemp--;
                                    H_deftemp++;
                                    tv_def.setText(String.valueOf(H_deftemp));
                                    tv_gold.setText(String.valueOf(H_goldtemp));
                                }
                                else{
                                    Log.v("ZAKUP", "Heh KUP");
                                }
                            }
                        });
                    }
                    else if (H_goldtemp<=0){
                        Log.v("ZAKUP", "Heh KUP");
                    }
                }
            });
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