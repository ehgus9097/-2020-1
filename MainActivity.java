package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Console;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnStart,btnTable,btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ServingAssistant");

        btnStart = (Button) findViewById(R.id.btnStart);
        btnTable = (Button) findViewById(R.id.btnTable);
        btnMenu = (Button) findViewById(R.id.btnMenu);
        Intent getintent = getIntent();

        final int btnT[] = getintent.getIntArrayExtra("table");
        final ArrayList<String> menu = (ArrayList<String>) getintent.getStringArrayListExtra("menu");

        btnTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TableActivity.class);
                startActivity(intent);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),StartActivity.class);
                intent.putExtra("table",btnT);
                intent.putExtra("menu",menu);
                startActivity(intent);
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
