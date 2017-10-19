package com.example.t00229613.tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by T00229613 on 11/10/2016.
 */
public class ShowStandingsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_standings_activity);

        Button back = (Button) findViewById(R.id.buttonback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());

        int num = sharedpreferences.getInt("num", 0);

        String username[] = new String[num+2];

        for(int i=0; i <= num; i++) {

            username[i] = "Username: " + sharedpreferences.getString("u"+i, "") + "     Score: " + sharedpreferences.getInt("s"+i, 0) + "\nLast Played: " + sharedpreferences.getString("t"+i, "") + "\n\n";
        }
        username[num+1] = "Username: " + sharedpreferences.getString("AI", "") + "     Score: " + sharedpreferences.getInt("AIscore", 0) + "\n";



        ListView listview = (ListView) findViewById(R.id.listview);


        Resources res = getResources();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, username){
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
    }
}
