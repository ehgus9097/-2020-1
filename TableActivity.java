package com.example.finalproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.graphics.Color.*;

public class TableActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        setTitle("테이블 배치");
        LinearLayout baseLayout = (LinearLayout) findViewById(R.id.baseLayout);

        final Button btn[] = new Button[24];
        Integer btnId[] = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btn10, R.id.btn11, R.id.btn12, R.id.btn13, R.id.btn14, R.id.btn15, R.id.btn16, R.id.btn17,
                R.id.btn18, R.id.btn19, R.id.btn20, R.id.btn21, R.id.btn22, R.id.btn23, R.id.btn24};
        RadioGroup radioG = (RadioGroup) findViewById(R.id.radioG);
        final RadioButton makeT = (RadioButton) findViewById(R.id.makeTable);
        final RadioButton removeT = (RadioButton) findViewById(R.id.removeTable);
        Button tReturn = (Button) findViewById(R.id.TReturn);
        for (int i = 0; i < 24; i++) {
            btn[i] = (Button) findViewById(btnId[i]);
        }
        final int[] table = new int[24];

        baseLayout.setBackgroundColor(rgb(245, 245, 220));

        for (int i = 0; i < 24; i++) {

            final int finalI = i;
            btn[i].setOnClickListener(new View.OnClickListener() {

                @SuppressLint("NewApi")
                @Override
                public void onClick(View view) {
                    if (removeT.isChecked()) {
                        view.setBackgroundColor(rgb(255, 255, 255));
                        table[finalI] = 0;
                    } else if (makeT.isChecked()) {
                        view.setBackgroundColor(rgb(230, 230, 230));
                        table[finalI] = 1;
                    }else{
                        table[finalI] = 0;
                    }
                }
            });
        }

        tReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("table",table);
                startActivity(intent);
                finish();
            }
        });
    }
}
