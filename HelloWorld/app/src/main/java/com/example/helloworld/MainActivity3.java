package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by For on 4/14/2017.
 */

public class MainActivity3 extends AppCompatActivity implements OnItemClickListener{
    TextView textView;
    ListView listView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listView = (ListView) findViewById(R.id.sportsList);
        listView.setOnItemClickListener(this);
        textView = (TextView) findViewById(R.id.text);
    }
/*
     * Parameters:
        adapter - The AdapterView where the click happened.
        view - The view within the AdapterView that was clicked
        position - The position of the view in the adapter.
        id - The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                Toast.LENGTH_SHORT).show();
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
}

