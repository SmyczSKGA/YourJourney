package com.example.yourjourney;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Creatures extends AppCompatActivity {



    public class Creature {
        public final String name, String attack, String defence, String damage, String armor, String img;

        public Creature(String name, String attack, String defence, String damage, String armor, String img) {
            this.name = name;
            this.attack = attack;
            this.defence = defence;
            this.damage = damage;
            this.armor = armor;
            this.img = img;
        }
    }

    public static ArrayList<Creature> studenci=new ArrayList<Creature>();
}
