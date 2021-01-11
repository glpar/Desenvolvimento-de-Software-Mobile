package com.example.helloworld;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import android.view.View.OnLongClickListener;
import android.widget.TextView;

import android.content.Intent;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    EditText edtInput;
    EditText edtLog;

    private ToggleButton toggleButton1, toggleButton2;
    private Button btnDisplay;

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView txtView = (TextView) findViewById(R.id.txtView);
        txtView.setOnLongClickListener(new OnLongClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(),
                        "You have pressed it long :)", 4000).show();
                return true;
            }
        });
        txtView.setOnClickListener(new OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "Not Long Enough :(",
                        1000).show();
            }
        });

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, button1);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                MainActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        });
        edtInput = findViewById(R.id.edtInput);
        edtLog = findViewById(R.id.edtLog);
        addListenerOnButton();


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


    public void onClickButton01( View view ){

       String textoEdtInput = edtInput.getText().toString();
       edtInput.setText("");

       String textoEdtLog = edtLog.getText().toString();
       textoEdtLog += "-" + textoEdtInput;

       edtLog.setText(textoEdtLog);

       Log.d("MainActivity", textoEdtInput);
    }
    public void addListenerOnButton() {

        toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer result = new StringBuffer();
                result.append("toggleButton1 : ").append(toggleButton1.getText());
                result.append("\ntoggleButton2 : ").append(toggleButton2.getText());

                Toast.makeText(MainActivity.this, result.toString(),
                        Toast.LENGTH_SHORT).show();

            }

        });


    }
}