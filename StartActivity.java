package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static android.graphics.Color.rgb;

public class StartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        setTitle("sales");

        Button returns = (Button) findViewById(R.id.returns);
        final Button btn[] = new Button[24];

        Integer btnId[] = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btn10, R.id.btn11, R.id.btn12, R.id.btn13, R.id.btn14, R.id.btn15, R.id.btn16, R.id.btn17,
                R.id.btn18, R.id.btn19, R.id.btn20, R.id.btn21, R.id.btn22, R.id.btn23, R.id.btn24};

        returns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        for (int i = 0; i < 24; i++) {
            btn[i] = (Button) findViewById(btnId[i]);
        }

        final Intent gintent = getIntent();
        final ArrayList<String> menu = (ArrayList<String>) gintent.getStringArrayListExtra("menu");
        final ArrayList<String> order = (ArrayList<String>) gintent.getStringArrayListExtra("order");
        final int btnTable[] = gintent.getIntArrayExtra("table");
        for(int i =0;i < btnTable.length;i++) {
            if(btnTable[i] == 1){
                btn[i].setBackgroundColor(rgb(230, 230, 230));

            }else{
                btn[i].setText("/");
            }
        }

        for (int i = 0; i<24; i++){
            final int finalI = i;
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(btnTable[finalI] == 1) {
                        Intent orderintent = new Intent(getApplicationContext(), OrderActivity.class);
                        orderintent.putExtra("menu", menu);
                        startActivity(orderintent);
                    }
                }
            });
            //btn[finalI].setText(order.get(i));
        }
        for(int i =0; i< 24; i++){
            int pay = gintent.getIntExtra("pay",1);
            if(pay == 0){
                btn[i].clearComposingText();
            }
        }
    }
}
