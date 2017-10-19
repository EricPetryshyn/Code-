package com.example.t00229613.codzombieseastereggguide;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import static android.R.id.list;

public class Symbols extends AppCompatActivity implements View.OnClickListener{

    BackgroundService mBoundService;
    boolean mServiceBound = false;
    boolean pressed1 = false;
    boolean pressed2 = false;
    boolean pressed3 = false;
    boolean pressed4 = false;
    boolean pressed5 = false;
    boolean pressed6 = false;
    boolean pressed7 = false;
    boolean pressed8 = false;
    boolean pressed9 = false;
    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton b4;
    ImageButton b5;
    ImageButton b6;
    ImageButton b7;
    ImageButton b8;
    ImageButton b9;
    int image1;
    int image2;
    int image3;
    int image4;
    int image5;
    int image6;
    int image7;
    int image8;
    int image9;
    int selected;
    String i1 = "i1";
    String i2 = "i2";
    String i3 = "i3";
    String i4 = "i4";
    String i5 = "i5";
    String i6 = "i6";
    String i7 = "i7";
    String i8 = "i8";
    String i9 = "i9";
    String p1 = "p1";
    String p2 = "p2";
    String p3 = "p3";
    String p4 = "p4";
    String p5 = "p5";
    String p6 = "p6";
    String p7 = "p7";
    String p8 = "p8";
    String p9 = "p9";
    String s = "s";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.symbols);

        Intent intent = getIntent();

        ImageButton button = (ImageButton) findViewById(R.id.imageButton11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences = getSharedPreferences("Page", 0);
                int num = 2;
                sharedpreferences.edit().putInt("activities", num ).commit();
                finish();
            }
        });

        b1 = (ImageButton) findViewById(R.id.imageButton1);
        b1.setOnClickListener(this);
        b2 = (ImageButton) findViewById(R.id.imageButton2);
        b2.setOnClickListener(this);
        b3 = (ImageButton) findViewById(R.id.imageButton3);
        b3.setOnClickListener(this);
        b4 = (ImageButton) findViewById(R.id.imageButton4);
        b4.setOnClickListener(this);
        b5 = (ImageButton) findViewById(R.id.imageButton5);
        b5.setOnClickListener(this);
        b6 = (ImageButton) findViewById(R.id.imageButton6);
        b6.setOnClickListener(this);
        b7 = (ImageButton) findViewById(R.id.imageButton7);
        b7.setOnClickListener(this);
        b8 = (ImageButton) findViewById(R.id.imageButton8);
        b8.setOnClickListener(this);
        b9 = (ImageButton) findViewById(R.id.imageButton9);
        b9.setOnClickListener(this);

        if(savedInstanceState == null){
            image1 = R.drawable.s1;
            image2 = R.drawable.s2;
            image3 = R.drawable.s3;
            image4 = R.drawable.s4;
            image5 = R.drawable.s5;
            image6 = R.drawable.s6;
            image7 = R.drawable.s7;
            image8 = R.drawable.s8;
            image9 = R.drawable.s9;
            selected = 0;
        }
        else{
            image1 = savedInstanceState.getInt(i1);
            b1.setBackgroundResource(image1);
            image2 = savedInstanceState.getInt(i2);
            b2.setBackgroundResource(image2);
            image3 = savedInstanceState.getInt(i3);
            b3.setBackgroundResource(image3);
            image4 = savedInstanceState.getInt(i4);
            b4.setBackgroundResource(image4);
            image5 = savedInstanceState.getInt(i5);
            b5.setBackgroundResource(image5);
            image6 = savedInstanceState.getInt(i6);
            b6.setBackgroundResource(image6);
            image7 = savedInstanceState.getInt(i7);
            b7.setBackgroundResource(image7);
            image8 = savedInstanceState.getInt(i8);
            b8.setBackgroundResource(image8);
            image9 = savedInstanceState.getInt(i9);
            b9.setBackgroundResource(image9);
            pressed1 = savedInstanceState.getBoolean(p1);
            pressed2 = savedInstanceState.getBoolean(p2);
            pressed3 = savedInstanceState.getBoolean(p3);
            pressed4 = savedInstanceState.getBoolean(p4);
            pressed5 = savedInstanceState.getBoolean(p5);
            pressed6 = savedInstanceState.getBoolean(p6);
            pressed7 = savedInstanceState.getBoolean(p7);
            pressed8 = savedInstanceState.getBoolean(p8);
            pressed9 = savedInstanceState.getBoolean(p9);
            selected = savedInstanceState.getInt(s);
        }
    }

    @Override
    public void onClick(View view) {

        b1 = (ImageButton) findViewById(R.id.imageButton1);
        b2 = (ImageButton) findViewById(R.id.imageButton2);
        b3 = (ImageButton) findViewById(R.id.imageButton3);
        b4 = (ImageButton) findViewById(R.id.imageButton4);
        b5 = (ImageButton) findViewById(R.id.imageButton5);
        b6 = (ImageButton) findViewById(R.id.imageButton6);
        b7 = (ImageButton) findViewById(R.id.imageButton7);
        b8 = (ImageButton) findViewById(R.id.imageButton8);
        b9 = (ImageButton) findViewById(R.id.imageButton9);

        switch (view.getId()){
            case R.id.imageButton1:
                if(pressed1){
                    b1.setBackgroundResource(R.drawable.s1);
                    image1 = R.drawable.s1;
                    selected--;
                    pressed1 = !pressed1;
                }
                else if(!pressed1 && selected < 3) {
                    b1.setBackgroundResource(R.drawable.s1_clicked);
                    image1 = R.drawable.s1_clicked;
                    selected++;
                    pressed1 = !pressed1;
                }
                break;

            case R.id.imageButton2:
                if(pressed2){
                    b2.setBackgroundResource(R.drawable.s2);
                    image2 = R.drawable.s2;
                    selected--;
                    pressed2 = !pressed2;
                }
                else if(!pressed2 && selected < 3){
                    b2.setBackgroundResource(R.drawable.s2_clicked);
                    image2 = R.drawable.s2_clicked;
                    selected++;
                    pressed2 = !pressed2;
                }
                break;

            case R.id.imageButton3:
                if(pressed3){
                    b3.setBackgroundResource(R.drawable.s3);
                    image3 = R.drawable.s3;
                    selected--;
                    pressed3 = !pressed3;
                }
                else if(!pressed3 && selected < 3){
                    b3.setBackgroundResource(R.drawable.s3_clicked);
                    image3 = R.drawable.s3_clicked;
                    selected++;
                    pressed3 = !pressed3;
                }
                break;

            case R.id.imageButton4:
                if(pressed4){
                    b4.setBackgroundResource(R.drawable.s4);
                    image4 = R.drawable.s4;
                    selected--;
                    pressed4 = !pressed4;
                }
                else if(!pressed4 && selected < 3){
                    b4.setBackgroundResource(R.drawable.s4_clicked);
                    image4 = R.drawable.s4_clicked;
                    selected++;
                    pressed4 = !pressed4;
                }
                break;

            case R.id.imageButton5:
                if(pressed5){
                    b5.setBackgroundResource(R.drawable.s5);
                    image5 = R.drawable.s5;
                    selected--;
                    pressed5 = !pressed5;
                }
                else if(!pressed5 && selected < 3){
                    b5.setBackgroundResource(R.drawable.s5_clicked);
                    image5 = R.drawable.s5_clicked;
                    selected++;
                    pressed5 = !pressed5;
                }
                break;

            case R.id.imageButton6:
                if(pressed6){
                    b6.setBackgroundResource(R.drawable.s6);
                    image6 = R.drawable.s6;
                    selected--;
                    pressed6 = !pressed6;
                }
                else if(!pressed6 && selected < 3){
                    b6.setBackgroundResource(R.drawable.s6_clicked);
                    image6 = R.drawable.s6_clicked;
                    selected++;
                    pressed6 = !pressed6;
                }
                break;

            case R.id.imageButton7:
                if(pressed7){
                    b7.setBackgroundResource(R.drawable.s7);
                    image7 = R.drawable.s7;
                    selected--;
                    pressed7 = !pressed7;
                }
                else if(!pressed7 && selected < 3){
                    b7.setBackgroundResource(R.drawable.s7_clicked);
                    image7 = R.drawable.s7_clicked;
                    selected++;
                    pressed7 = !pressed7;
                }
                break;

            case R.id.imageButton8:
                if(pressed8){
                    b8.setBackgroundResource(R.drawable.s8);
                    image8 = R.drawable.s8;
                    selected--;
                    pressed8 = !pressed8;
                }
                else if(!pressed8 && selected < 3){
                    b8.setBackgroundResource(R.drawable.s8_clicked);
                    image8 = R.drawable.s8_clicked;
                    selected++;
                    pressed8 = !pressed8;
                }
                break;

            case R.id.imageButton9:
                if(pressed9){
                    b9.setBackgroundResource(R.drawable.s9);
                    image9 = R.drawable.s9;
                    selected--;
                    pressed9 = !pressed9;
                }
                else if(!pressed9 && selected < 3){
                    b9.setBackgroundResource(R.drawable.s9_clicked);
                    image9 = R.drawable.s9_clicked;
                    selected++;
                    pressed9 = !pressed9;
                }
                break;
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(i1, image1);
        savedInstanceState.putInt(i2, image2);
        savedInstanceState.putInt(i3, image3);
        savedInstanceState.putInt(i4, image4);
        savedInstanceState.putInt(i5, image5);
        savedInstanceState.putInt(i6, image6);
        savedInstanceState.putInt(i7, image7);
        savedInstanceState.putInt(i8, image8);
        savedInstanceState.putInt(i9, image9);

        savedInstanceState.putBoolean(p1, pressed1);
        savedInstanceState.putBoolean(p2, pressed2);
        savedInstanceState.putBoolean(p3, pressed3);
        savedInstanceState.putBoolean(p4, pressed4);
        savedInstanceState.putBoolean(p5, pressed5);
        savedInstanceState.putBoolean(p6, pressed6);
        savedInstanceState.putBoolean(p7, pressed7);
        savedInstanceState.putBoolean(p8, pressed8);
        savedInstanceState.putBoolean(p9, pressed9);

        savedInstanceState.putInt(s, selected);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent music = new Intent(this, BackgroundService.class);
        startService(music);
        bindService(music, mServiceConnection, Context.BIND_AUTO_CREATE);
        SharedPreferences sharedpreferences = getSharedPreferences("Page", 0);
        int num = 1;
        sharedpreferences.edit().putInt("activities", num ).commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            mServiceBound = false;
            SharedPreferences sharedpreferences = getSharedPreferences("Page", 0);
            int num = 2;
            sharedpreferences.edit().putInt("activities", num ).commit();
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedpreferences = getSharedPreferences("Page", 0);
        if(sharedpreferences.getInt("activities", 0) == 1){
            unbindService(mServiceConnection);
            mServiceBound = false;
            Intent music = new Intent(this, BackgroundService.class);
            stopService(music);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(mServiceBound){
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BackgroundService.MyBinder myBinder = (BackgroundService.MyBinder) iBinder;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mServiceBound = false;
        }
    };
}
