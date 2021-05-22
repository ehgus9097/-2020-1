package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        setTitle("주문");

        Button btnOrder = (Button) findViewById(R.id.btnOrder);
        Button btnPay =(Button)findViewById(R.id.pay);

        final ArrayList<String> orderList = new ArrayList<String>();
        ListView listv = (ListView) findViewById(R.id.ListView2);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,orderList);
        listv.setAdapter(adapter);

        final Button btnMenu[] = new Button[14];
        Integer btnMenuId[] = {R.id.btnMenu1,R.id.btnMenu2,R.id.btnMenu3,R.id.btnMenu4,R.id.btnMenu5,R.id.btnMenu6,R.id.btnMenu7,R.id.btnMenu8,R.id.btnMenu9,R.id.btnMenu10,R.id.btnMenu11,R.id.btnMenu12,R.id.btnMenu13,R.id.btnMenu14};
        for (int i = 0; i < 14; i++) {
            btnMenu[i] = (Button) findViewById(btnMenuId[i]);
        }

        Intent mintent = getIntent();
        ArrayList<String> menu = (ArrayList<String>) mintent.getStringArrayListExtra("menu");
        final ArrayList<String> order = new ArrayList<String>();

        for (int i = 0; i< 12; i++){
            btnMenu[i].setText("메뉴없음");
        }

        for(int i=0; i<14;i++) {
            final int finalI = i;
            btnMenu[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    orderList.add(btnMenu[finalI].getText().toString());
                    adapter.notifyDataSetChanged();
                    order.add(btnMenu[finalI].getText().toString());
                }
            });
        }
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderintent = new Intent(getApplicationContext(),StartActivity.class);
                orderintent.putExtra("order",order);
                finish();
            }
        });

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent payintent = new Intent(getApplicationContext(),StartActivity.class);
                payintent.putExtra("pay",0);
                finish();
            }
        });
    }
}
