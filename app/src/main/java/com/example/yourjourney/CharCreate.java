package com.example.yourjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CharCreate extends AppCompatActivity {

    public TextView login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        login = findViewById(R.id.tv_login);


        public static ArrayList<CharCreate> lista = new ArrayList<>();

        public String toString()
        {return this.nazwa + " "+this.Imie+ "\nData urodzenia: "+this.dataUrodzenia+ "\nWydział: "+this.Wydzial+ "\nŚrednia: "+this.Srednia+ "\n\n\n"+ "\nŚrednia: "+this.Srednia;}
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