package com.example.t00229613.tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by T00229613 on 11/10/2016.
 */
public class EnterNamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_names_activity);

        Intent intent = getIntent();
        final SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
        final EditText text = (EditText) findViewById(R.id.editText01);
        Button button = (Button) findViewById(R.id.button01);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = sharedpreferences.getInt("num", 0) + 1;
                sharedpreferences.edit().putInt("num", num).commit();

                sharedpreferences.edit().putString("u"+num, text.getText().toString()).commit();
                sharedpreferences.edit().putInt("s"+num, 0).commit();
                sharedpreferences.edit().putString("t"+num, "").commit();

                finish();
            }
        });
    }
}
