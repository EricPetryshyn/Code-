package com.example.t00229613.calculator;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener,Fragment2.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Fragment1 frag1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.fragment);
        Fragment2 frag2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);

        frag2.setListener(new Fragment2.OnFragmentInteractionListener() {
            @Override
            public void onTextChange(CharSequence newText) {
                frag1.updateFragment1View(newText);
            }
        });
    }

    @Override
    public void onFragmentInteraction(int position) {

    }

    @Override
    public void onTextChange(CharSequence newText) {

    }
}
