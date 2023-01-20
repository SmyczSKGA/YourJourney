package com.example.yourjourney;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import static com.example.yourjourney.Creatures.Creature.CreatureList;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CharCreate extends AppCompatActivity {

    public TextView login;
    String[] Heroes;
    ListView lv_postaci;
    TextView HP;
    TextView ATK;
    TextView DEF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv_postaci = findViewById(R.id.lv_postaci);

        HP = findViewById(R.id.tv_hp);
        ATK = findViewById(R.id.tv_atak);
        DEF = findViewById(R.id.tv_obrona);

        Heroes = getResources().getStringArray(R.array.characters);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_single_choice,
                Heroes);

        lv_postaci.setAdapter(adapter);
        lv_postaci.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv_postaci.setOnItemClickListener(CharPreviewDesc);

        login = findViewById(R.id.tv_login);

    }

    AdapterView.OnItemClickListener CharPreviewDesc = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            for (int i = 0; i < lv_postaci.getCount(); i++) {
                Log.i("Data", "dupa");
                if (lv_postaci.isItemChecked(i) == lv_postaci.isItemChecked(0)) {
                    HP.setText("7");
                    ATK.setText("3");
                    DEF.setText("3");
                }
                if (lv_postaci.isItemChecked(i) == lv_postaci.isItemChecked(1)) {
                    HP.setText("4");
                    ATK.setText("7");
                    DEF.setText("1");
                }
                if (lv_postaci.isItemChecked(i) == lv_postaci.isItemChecked(2)) {
                    HP.setText("5");
                    ATK.setText("2");
                    DEF.setText("5");
                }
            }
        }
    };

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