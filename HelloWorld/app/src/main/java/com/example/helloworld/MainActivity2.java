package com.example.helloworld;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


/**
 * Created by For on 4/14/2017.
 */

public class MainActivity2 extends AppCompatActivity {
    MediaPlayer mySound;

    @Override
    protected void onPause() {
        super.onPause();
        mySound.release();
    }

    TextView textView;
    Spinner spnr;

    String[] celebrities = {
            "Monkey D. Luffy",
            "Roronoa Zoro",
            "Nami",
            "Nico Robin",
            "Sanji",
            "Portgas D. Ace",
            "Usopp",
            "Chopper",
            "Brook",
            "Jinbe",
            "Gol D. Roger",
            "Chopper",
            "Edward Newgate"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mySound = MediaPlayer.create(this, R.raw.weare);
        textView = (TextView) findViewById(R.id.text);

        spnr = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, celebrities);

        spnr.setAdapter(adapter);
        spnr.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {

                        int position = spnr.getSelectedItemPosition();
                        Toast.makeText(getApplicationContext(),"You have selected "+celebrities[+position],Toast.LENGTH_LONG).show();
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub

                    }

                }
        );
        String str[]={"Arun","Mathev","Vishnu","Vishal","Arjun",
                "Arul","Balaji","Babu","Boopathy","Godwin","Nagaraj"};

        AutoCompleteTextView t1 = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,str);

        t1.setThreshold(1);
        t1.setAdapter(adp);
    }

    public void Troca(View View){
        String button_text;
        button_text =((Button)View).getText().toString();
        if(button_text.equals("First Activity"))
        {
            Intent act1 = new Intent(this,MainActivity.class);
            startActivity(act1);
        }
        else if (button_text.equals("Second Activity"))
        {
            Intent act2 = new Intent(this,MainActivity2.class);
            startActivity(act2);

        }

        else if (button_text.equals("Third Activity"))
        {
            Intent act3 = new Intent(this,MainActivity3.class);
            startActivity(act3);

        }}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void playMusic(View view) {
        mySound.start();
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_marines:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}