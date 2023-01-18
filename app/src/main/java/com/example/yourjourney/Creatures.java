package com.example.yourjourney;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.*;


public class Creatures extends AppCompatActivity {

    ArrayList<String> creatureList = new ArrayList<String>();

    public class Creature {
        public final String name, attack, defence, gold, img;

        public Creature(String name, String attack, String defence, String gold, String img) {
            this.name = name;
            this.attack = attack;
            this.defence = defence;
            this.gold = gold;
            this.img = img;
        }
    }

    Creature creature0 = new Creature("Wojownik", "3", "3", "0", "");
    Creature creature1 = new Creature("Mag", "5", "1", "0", "");
    Creature creature2 = new Creature("Łucznik", "1", "5", "0", "");
    Creature creature3 = new Creature("Dzik", "2", "3", "1", "");
    Creature creature4 = new Creature("Goblin", "4", "3", "2", "");
    Creature creature5 = new Creature("Ork", "5", "5", "4", "");

}
