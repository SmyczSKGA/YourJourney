package com.example.yourjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;


public class Creatures extends AppCompatActivity {


    ListView bohaterowie;
    ArrayAdapter <Creatures> bohaternik;
    ImageView postac;
    RadioButton wojownik;
    RadioButton lucznik;
    RadioButton mag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bohaterowie = findViewById(R.id.lv_postaci);
        postac = findViewById(R.id.iv_bohater);

        wojownik = findViewById(R.id.b_woj);
        lucznik = findViewById(R.id.b_lucznik);
        mag = findViewById(R.id.b_mag);

        bohaternik = new ArrayAdapter<Creatures>
                (this, android.R.layout.simple_list_item_checked, CharCreate.lista);


        bohaterowie.setAdapter(bohaternik);   // dziennik to element na którym ustawiamy adapter listy (w klasie MainActivity - dzienniczek)
        bohaterowie.setChoiceMode(ListView.CHOICE_MODE_SINGLE);  //opcja wybrania wielu rekordów listy

        if (CharCreate.lista.isEmpty())
        {
            new Student("Stanisław", "Antczak", "Mechaniczny", "1998-01-11", 4.13, R.drawable.facet1);
            new Student("Janusz", "Antkiewicz", "Mechaniczny", "1998-08-11", 4.19, R.drawable.facet2);
            new Student("Paweł", "Bartnik", "Nawigacyjny", "1998-01-11", 4.13, R.drawable.facet3);
            new Student("Adam", "Bartkowiak", "Elektryczny", "1996-07-11", 3.13, R.drawable.facet4);
            new Student("Paweł", "Zagórski", "Elektryczny", "1995-01-11", 3.99, R.drawable.facet5);
            new Student("Piotr", "Zawadzki", "PiT", "1997-03-21", 4.01, R.drawable.facet6);
            new Student("Bartosz", "Kowalski", "Nawigacyjny", "1995-11-11", 3.99, R.drawable.facet7);
            new Student("Bartosz", "Janowski", "Elektryczny", "1995-07-11", 3.29, R.drawable.facet8);
            new Student("Mikołaj", "Żurawski", "PiT", "1997-12-21", 4.89, R.drawable.facet9);
            new Student("Paweł", "Filipiak", "PiT", "2001-04-29", 3.99, R.drawable.facet10);
            new Student("Zdzisław", "Gutkowski", "Nawigacyjny", "2001-05-29", 4.05, R.drawable.facet11);
        }

        bohaterowie.setOnItemClickListener(iCL);
        //  dzienniczek.notifyDataSetChanged();
    }

}
}