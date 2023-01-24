package com.example.yourjourney;

import static com.example.yourjourney.Creatures.Creature.CreatureList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Forest extends AppCompatActivity {

    ImageView event;
    TextView title;
    TextView brief;
    TextView tv_decision1;
    TextView tv_decision2;
    TextView tv_decision3;
    TextView tv_hp;
    TextView tv_gold;
    TextView tv_atk;
    TextView tv_def;
    Button b_decision1;
    Button b_decision2;
    Button b_decision3;
    public int place;
    public static int i;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        title = findViewById(R.id.tv_miastowe);
        brief = findViewById(R.id.tv_oferta);
        event = findViewById(R.id.iv_miastowy);

        tv_atk = findViewById(R.id.tv_atak_w);
        tv_def = findViewById(R.id.tv_obrona_w);
        tv_hp = findViewById(R.id.tv_hp);
        tv_gold = findViewById(R.id.tv_gold1);
        tv_decision1 = findViewById(R.id.tv_decyzja_1);
        tv_decision2 = findViewById(R.id.tv_decyzja2);
        tv_decision3 = findViewById(R.id.tv_decyzja3);
        b_decision1 = findViewById(R.id.b_decyzja1);
        b_decision2 = findViewById(R.id.b_decyzja2);
        b_decision3 = findViewById(R.id.b_decyzja3);

        tv_hp.setText(String.valueOf(activity_main4.H_hp)+"/"+String.valueOf(activity_main4.H_hpmax));
        tv_gold.setText(String.valueOf(activity_main4.H_gold));

        if(place==0) {event1();}
        else if(place==1) {event2();}
        else if(place==2) {event3();}
        else if(place==3) {event4();}
        else if(place==4) {event5();}
        else if(place==5) {event6();}
    }

    //POCZĄTEK
    public void  event1() {
        place=0;
        title.setText("Stajesz na rozdrożu");
        event.setImageResource(R.drawable.land2_pola);
        brief.setText("Postanowiłeś wyruszyć w nieznane, jednak stając na rozdrożu, postanowiłeś upewnić się w swej decyzji.");
        tv_decision1.setText("idź na pole");
        tv_decision2.setText("Idź do lasu");
        tv_decision3.setText("Wróć do punktu zbornego");

        b_decision1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                event2();
            }
        });
        b_decision2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                event4();
            }
        });
        b_decision3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent menuSwitch = new Intent(getApplicationContext(), activity_main4.class);
                startActivity(menuSwitch);
            }
        });
    }

    public void  event2() {
        place=1;
        title.setText("Wchodzisz na pole");
        event.setImageResource(R.drawable.kwiotki_i_pola);
        brief.setText("Wchodząc na pole, zauważasz przechodnia, który kieruje się ku miastu. Widzisz, że ma coś w koszyku.");
        tv_decision1.setText("Zaatakuj go");
        tv_decision2.setText("Podejdź do niego");
        tv_decision3.setText("Zignoruj go");

        b_decision1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent menuSwitch = new Intent(getApplicationContext(), gameover.class);
                startActivity(menuSwitch);
            }
        });
        b_decision2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                event3();
            }
        });
        b_decision3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                event4();
            }
        });
    }

    public void  event3() {
        place=2;
        title.setText("Nieznajomy");
        event.setImageResource(R.drawable.przechodzien);
        brief.setText("Gdy podchodzisz do przechodnia, zauważasz, że coś czyha w zaroślach, gdy tylko was zauważa rzuca się na was. Zaczyna się walka.");
        tv_decision1.setText("Crap baskets");
        tv_decision2.setText("O nie! Jestesmy zgubieni!");
        tv_decision3.setText("I tak to wygram, bo to wersja demonstracyjna");

        b_decision1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                place=4;
                i = rand.nextInt((5 - 2 +1) +2);
                Intent menuSwitch = new Intent(getApplicationContext(), Fight.class);
                startActivity(menuSwitch);
            }
        });
        b_decision2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                place=4;
                i = rand.nextInt((5 - 2 +1) +2);
                Intent menuSwitch = new Intent(getApplicationContext(), Fight.class);
                startActivity(menuSwitch);
            }
        });
        b_decision3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                place=4;
                i = rand.nextInt((5 - 2 +1) +2);
                Intent menuSwitch = new Intent(getApplicationContext(), Fight.class);
                startActivity(menuSwitch);
            }
        });
    }

    public void  event4() {
        place=3;
        title.setText("Wchodzisz do lasu");
        event.setImageResource(R.drawable.land2_pola);
        brief.setText("Wchodząc do mrocznego lasu, zauważasz, że nie jesteś tu sam.");
        tv_decision1.setText("O Bogowie! Walka!");
        tv_decision2.setText("");
        tv_decision3.setText("Wróć do punktu zbornego.");

        b_decision1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                place=5;
                i = rand.nextInt((5 - 2 +1) +2);
                Intent menuSwitch = new Intent(getApplicationContext(), Fight.class);
                startActivity(menuSwitch);
            }
        });
        b_decision2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                place=5;
                i = rand.nextInt((5 - 2 +1) +2);
                Intent menuSwitch = new Intent(getApplicationContext(), Fight.class);
                startActivity(menuSwitch);
            }
        });
        b_decision3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                place=5;
                i = rand.nextInt((5 - 2 +1) +2);
                Intent menuSwitch = new Intent(getApplicationContext(), Fight.class);
                startActivity(menuSwitch);
            }
        });
    }

    public void  event5() {
        place=4;
        title.setText("Zostań na chwilę i posłuchaj");
        event.setImageResource(R.drawable.przechodzien);
        brief.setText("Po pokonaniu stwora, przechodzień oferuje ci zapłatę w wysokości 5 sztuk złota za ocalenie mu życia.");
        tv_decision1.setText("Przyjmę twój podarek. Odprowadzę cię do miasta, jest tutaj zbyt niebezpiecznie");
        tv_decision2.setText("Nie musisz mi dziękować. Odprowadzę cię do miasta, jest tutaj zbyt niebezpiecznie");
        tv_decision3.setText("Podwójne racje? Świetnie!");

        b_decision1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent menuSwitch = new Intent(getApplicationContext(), activity_main4.class);
                startActivity(menuSwitch);
            }
        });
        b_decision2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i = rand.nextInt((5 - 2 +1) +2);
                Intent menuSwitch = new Intent(getApplicationContext(), activity_main4.class);
                startActivity(menuSwitch);
            }
        });
        b_decision3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i = rand.nextInt((5 - 2 +1) +2);
                Intent menuSwitch = new Intent(getApplicationContext(), activity_main4.class);
                startActivity(menuSwitch);
            }
        });
    }

    public void  event6() {
        place=5;
        title.setText("Zbyt groźnie");
        event.setImageResource(R.drawable.przechodzien);
        brief.setText("Ten las jest zbyt groźny byś mógł go eksplorować.");
        tv_decision1.setText("Uciekajcie!");
        tv_decision2.setText("Zbyt Straszne!");
        tv_decision3.setText("Szok!");

        b_decision1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent menuSwitch = new Intent(getApplicationContext(), activity_main4.class);
                startActivity(menuSwitch);
            }
        });
        b_decision2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i = rand.nextInt((5 - 2 +1) +2);
                Intent menuSwitch = new Intent(getApplicationContext(), activity_main4.class);
                startActivity(menuSwitch);
            }
        });
        b_decision3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i = rand.nextInt((5 - 2 +1) +2);
                Intent menuSwitch = new Intent(getApplicationContext(), activity_main4.class);
                startActivity(menuSwitch);
            }
        });
    }


}