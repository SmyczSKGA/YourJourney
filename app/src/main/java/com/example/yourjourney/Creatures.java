package com.example.yourjourney;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.*;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Creatures extends AppCompatActivity {

    public static class Creature {
        public final String name, img;
        public final int hp, attack, defence, gold;

        public Creature(String name, int hp, int attack, int defence, int gold, String img) {
            this.name = name;
            this.hp = hp;
            this.attack = attack;
            this.defence = defence;
            this.gold = gold;
            this.img = img;
            CreatureList.add(this);
        }
        public static ArrayList<Creature> CreatureList = new ArrayList<Creature>();
        @Override
        public String toString(){
            return name+", "+hp+", "+attack+", "+defence+", "+gold+", "+img;
            }
    }

}
