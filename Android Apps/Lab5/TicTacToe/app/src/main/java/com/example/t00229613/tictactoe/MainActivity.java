package com.example.t00229613.tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
        if (!sharedpreferences.contains("num")){
            sharedpreferences.edit().putInt("num", 0).commit();
            int num = sharedpreferences.getInt("num", 0);
            sharedpreferences.edit().putString("u"+num, "player").commit();
            sharedpreferences.edit().putInt("s"+num, 0).commit();
        }

        if (!sharedpreferences.contains("AI")){
            sharedpreferences.edit().putString("AI", "AI").commit();
            sharedpreferences.edit().putInt("AIscore", 0).commit();
        }

        if (!sharedpreferences.contains("gametype")){
            sharedpreferences.edit().putInt("gametype", 0).commit();
        }
        ListView listview = (ListView) findViewById(R.id.listView01);

        int num = sharedpreferences.getInt("num", 0);
        Toast.makeText(MainActivity.this, "Welcome " + sharedpreferences.getString("u"+num, ""), Toast.LENGTH_SHORT).show();

        Resources res = getResources();
        String menu[] = res.getStringArray(R.array.menu);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                textView.setTextColor(Color.BLACK);
                textView.setTypeface(null, Typeface.BOLD);

                return view;
            }
        };
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent intent = new Intent(view.getContext(), PlayGameActivity.class);
                    startActivity(intent);
                    sharedpreferences.edit().putInt("gametype", 0).commit();
                }
                if(position == 1) {
                    Intent intent = new Intent(view.getContext(), PlayGameActivity.class);
                    startActivity(intent);
                    sharedpreferences.edit().putInt("gametype", 1).commit();
                }
                if(position == 2) {
                    Intent intent = new Intent(view.getContext(), EnterNamesActivity.class);
                    startActivity(intent);
                }
                if(position == 3) {
                    Intent intent = new Intent(view.getContext(), ShowStandingsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
