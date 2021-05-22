package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        setTitle("메뉴");

        final ArrayList<String> midList = new ArrayList<String>();

        ListView list = (ListView) findViewById(R.id.listView1);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,midList);
        list.setAdapter(adapter);

        final EditText editItem =(EditText) findViewById(R.id.edtItem);
        Button menuAdd = (Button) findViewById(R.id.menuAdd);
        Button returnH = (Button)findViewById(R.id.returnH);

        final ArrayList<String> menuArray = new ArrayList<String>();
        menuAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                midList.add(editItem.getText().toString());
                adapter.notifyDataSetChanged();
                menuArray.add(editItem.getText().toString());
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                midList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        returnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuintent = new Intent(getApplicationContext(),MainActivity.class);
                menuintent.putExtra("menu",menuArray);
                startActivity(menuintent);
                finish();
            }
        });
    }
}
