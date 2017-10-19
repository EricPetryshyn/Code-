package com.example.t00229613.tourguide;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener,Fragment2.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(int position) {
        Fragment2 frag = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        frag.updateFragment2View(position);
    }

}
