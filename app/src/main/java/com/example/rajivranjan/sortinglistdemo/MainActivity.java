package com.example.rajivranjan.sortinglistdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;
    Button btnasc;
    Button revbtn;
    String[] months = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        btnasc = (Button) findViewById(R.id.btnasc);
        revbtn = (Button) findViewById(R.id.reversebtn);
        lv.setFastScrollEnabled(true);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, months);
        lv.setAdapter(adapter);


        btnasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list = new ArrayList<String>(Arrays.asList(months));
                Collections.sort(list);
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                    adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list);
                    lv.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }
            }
        });

        revbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list = new ArrayList<String>(Arrays.asList(months));
                Collections.sort(list, Collections.reverseOrder());
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                    adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, list);
                    lv.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }
            }
        });


    }
}
