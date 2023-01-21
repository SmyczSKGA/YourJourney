package com.example.yourjourney;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import static com.example.yourjourney.Creatures.Creature.CreatureList;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CharCreate extends AppCompatActivity {

    public TextView login;
    String[] Heroes;
    ListView lv_postaci;
    TextView HP;
    TextView ATK;
    TextView DEF;
    Toast NoUser;
    Button b_zatwierdz;
    int Gold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv_postaci = findViewById(R.id.lv_postaci);
        b_zatwierdz = findViewById(R.id.b_zatwierdz);


        HP = findViewById(R.id.tv_hp);
        ATK = findViewById(R.id.tv_atak);
        DEF = findViewById(R.id.tv_obrona);
        Gold = 0;

        Heroes = getResources().getStringArray(R.array.characters);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_single_choice,
                Heroes);

        lv_postaci.setAdapter(adapter);
        lv_postaci.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv_postaci.setOnItemClickListener(CharPreviewDesc);

        login = findViewById(R.id.tv_login);
        NoUser = Toast.makeText(this, "",Toast.LENGTH_LONG);
        NoUser.setText("Wpisz nazwę postaci");

        b_zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.getText().toString().equals("")) {
                    NoUser.show();
                }
                else {
                    String filename = login.getText().toString();
                    String content = HP.getText().toString() +", "+ATK.getText().toString() +", "+DEF.getText().toString();

                    try {
                        saveTextAsFile(filename, content);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent loadSwitch = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(loadSwitch);
                }
            }
        });

    }

    public void saveTextAsFile(String filename, String content) throws IOException {
        String fileName = filename + ".txt";

        //create
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), fileName);

        //write to
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(content.getBytes());
            fos.close();
            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            Toast.makeText(this, "File not found!", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error occured!", Toast.LENGTH_SHORT).show();
        }
    }

    AdapterView.OnItemClickListener CharPreviewDesc = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Data", "dupa");
                if (lv_postaci.isItemChecked(0) == true) {
                    HP.setText("7");
                    ATK.setText("3");
                    DEF.setText("3");
                }
                if (lv_postaci.isItemChecked(1) == true) {
                    HP.setText("4");
                    ATK.setText("7");
                    DEF.setText("1");
                }
                if (lv_postaci.isItemChecked(2) == true) {
                    HP.setText("5");
                    ATK.setText("2");
                    DEF.setText("5");
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
}