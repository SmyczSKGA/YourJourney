package com.example.yourjourney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class CharCreate extends AppCompatActivity {

    public TextView login;
    String[] Heroes;
    ListView lv_postaci;
    TextView HP;
    TextView ATK;
    TextView DEF;
    Toast NoUser;
    Toast NoClass;
    Button b_zatwierdz;
    ImageView iv_sakwa;
    int Gold;
    String currentTime;
    static boolean created = false;
    static String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv_postaci = findViewById(R.id.lv_postaci);
        b_zatwierdz = findViewById(R.id.b_atak);


        HP = findViewById(R.id.tv_hp);
        ATK = findViewById(R.id.tv_atak_w);
        DEF = findViewById(R.id.tv_obrona_w);
        Gold = 0;
        iv_sakwa = findViewById(R.id.iv_sakwa);

        Heroes = getResources().getStringArray(R.array.characters);
        // ADAPTER
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_single_choice,
                Heroes);

        lv_postaci.setAdapter(adapter);
        lv_postaci.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv_postaci.setOnItemClickListener(CharPreviewDesc);

        login = findViewById(R.id.tv_login);
        NoUser = Toast.makeText(this, "Wpisz nazwę postaci",Toast.LENGTH_SHORT);
        NoClass = Toast.makeText(this, "Wybierz swoją klasę", Toast.LENGTH_SHORT);

        // ZAPIS WYBORU
        b_zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentTime = new SimpleDateFormat("HH_mm_ss", Locale.getDefault()).format(new Date());
                created = true;
                if (login.getText().toString().equals("")) {
                    NoUser.show();
                }
                else if(lv_postaci.isItemChecked(0) == true) {
                    filename = login.getText().toString() + "_"+ currentTime;
                    String content = login.getText().toString() +", "+ HP.getText().toString() +", "+ATK.getText().toString() +", "+DEF.getText().toString()
                            +", "+Gold+", R.drawable.woj_ikona, ";

                    new Creatures.Creature(login.getText().toString(), 7, 3, 3, 0, "R.drawable.woj_ikona");
                    saveTextAsFile(filename, content);

                    Intent loadSwitch = new Intent(getApplicationContext(), activity_main4.class);
                    startActivity(loadSwitch);
                }
                else if(lv_postaci.isItemChecked(1) == true){
                    String filename = login.getText().toString();
                    String content = login.getText().toString() +", "+ HP.getText().toString() +", "+ATK.getText().toString() +", "+DEF.getText().toString()
                            +", "+Gold+", R.drawable.mag_ikona, ";

                    new Creatures.Creature(login.getText().toString(), 4,1, 7, 0, "R.drawable.mag_ikona");
                    saveTextAsFile(filename, content);

                    Intent loadSwitch = new Intent(getApplicationContext(), activity_main4.class);
                    startActivity(loadSwitch);
                }
                else if(lv_postaci.isItemChecked(2) == true){
                    String filename = login.getText().toString();
                    String content = login.getText().toString() +", "+ HP.getText().toString() +", "+ATK.getText().toString() +", "+DEF.getText().toString()
                            +", "+Gold+", R.drawable.lucznik_ikona, ";

                    new Creatures.Creature(login.getText().toString(), 5, 5, 2, 0, "R.drawable.lucznik_ikona");
                    saveTextAsFile(filename, content);

                    Intent loadSwitch = new Intent(getApplicationContext(), activity_main4.class);
                    startActivity(loadSwitch);
                }
                else {
                    NoClass.show();
                }
            }
        });
    }

    // TWORZENIE PLIKU DO ZAPISU
    public void saveTextAsFile(String filename, String content) {
        String fileName = filename + ".txt";

        //create
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Documents/MyJourney", fileName);

        //write to
        try {
            String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Documents/MyJourney";
            File root = new File(rootPath);
            if (!root.exists()) {
                root.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(content.getBytes());
            fos.close();
            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e){
            e.printStackTrace();
            Toast.makeText(this, "File not found!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error occured!", Toast.LENGTH_SHORT).show();
        }
    }

    // POLA ADAPTERA
    AdapterView.OnItemClickListener CharPreviewDesc = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Data", "dupa");
                if (lv_postaci.isItemChecked(0) == true) {
                    HP.setText("7");
                    ATK.setText("3");
                    DEF.setText("3");
                    iv_sakwa.setImageResource(R.drawable.woj_ikona);
                }
                if (lv_postaci.isItemChecked(1) == true) {
                    HP.setText("4");
                    ATK.setText("7");
                    DEF.setText("1");
                    iv_sakwa.setImageResource(R.drawable.mag_ikona);
                }
                if (lv_postaci.isItemChecked(2) == true) {
                    HP.setText("5");
                    ATK.setText("2");
                    DEF.setText("5");
                    iv_sakwa.setImageResource(R.drawable.lucznik_ikona);
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