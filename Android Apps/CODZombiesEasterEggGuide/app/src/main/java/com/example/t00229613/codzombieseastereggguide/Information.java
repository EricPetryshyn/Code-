package com.example.t00229613.codzombieseastereggguide;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

public class Information extends AppCompatActivity {

    BackgroundService mBoundService;
    boolean mServiceBound = false;
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        button = (ImageButton) findViewById(R.id.imageButton10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences = getSharedPreferences("Page", 0);
                int num = 2;
                sharedpreferences.edit().putInt("activities", num ).commit();
                finish();
            }
        });

        LinearLayout layout = (LinearLayout)findViewById(R.id.i);

        Intent intent = getIntent();

        final SharedPreferences sharedpreferences = getSharedPreferences("Page", 0);
        TextView text = (TextView) findViewById(R.id.textviewtitle);
        TextView text2 = (TextView) findViewById(R.id.textviewdes);
        Resources res = getResources();
        String title = "";
        String des = "";

        if(sharedpreferences.getInt("page1", 0) == 0) {
            if (sharedpreferences.getInt("page2", 0) == 0) {
                title = res.getString(R.string.title11);
                des = res.getString(R.string.des1);
            } else if (sharedpreferences.getInt("page2", 0) == 1) {
                title = res.getString(R.string.title12);
                des = res.getString(R.string.des2);
            } else if (sharedpreferences.getInt("page2", 0) == 2) {
                title = res.getString(R.string.title13);
                des = res.getString(R.string.des3);
            } else if (sharedpreferences.getInt("page2", 0) == 3) {
                title = res.getString(R.string.title14);
                des = res.getString(R.string.des4);
            } else if (sharedpreferences.getInt("page2", 0) == 4) {
                title = res.getString(R.string.title15);
                des = res.getString(R.string.des5);
            } else if (sharedpreferences.getInt("page2", 0) == 5) {
                title = res.getString(R.string.title16);
                des = res.getString(R.string.des6);
            } else if (sharedpreferences.getInt("page2", 0) == 6) {
                title = res.getString(R.string.title17);
                des = res.getString(R.string.des7);
            } else {
                title = res.getString(R.string.title18);
                des = res.getString(R.string.des8);
            }
            layout.setBackgroundDrawable(res.getDrawable(R.drawable.soe));
        }
        else if(sharedpreferences.getInt("page1", 0) == 1) {
            if (sharedpreferences.getInt("page2", 0) == 0) {
                title = res.getString(R.string.title12);
                des = res.getString(R.string.des9);
            } else if (sharedpreferences.getInt("page2", 1) == 1) {
                title = res.getString(R.string.title19);
                des = res.getString(R.string.des10);
            } else {
                title = res.getString(R.string.title20);
                des = res.getString(R.string.des11);
            }
            layout.setBackgroundDrawable(res.getDrawable(R.drawable.g));
        }
        else if(sharedpreferences.getInt("page1", 0) == 2) {
            if (sharedpreferences.getInt("page2", 0) == 0) {
                title = res.getString(R.string.title21);
                des = res.getString(R.string.des12);
            } else if (sharedpreferences.getInt("page2", 0) == 1) {
                title = res.getString(R.string.title22);
                des = res.getString(R.string.des13);
            } else if (sharedpreferences.getInt("page2", 0) == 2) {
                title = res.getString(R.string.title23);
                des = res.getString(R.string.des14);
            } else if (sharedpreferences.getInt("page2", 0) == 3) {
                title = res.getString(R.string.title24);
                des = res.getString(R.string.des15);
            } else if (sharedpreferences.getInt("page2", 0) == 4) {
                title = res.getString(R.string.title25);
                des = res.getString(R.string.des16);
            } else if (sharedpreferences.getInt("page2", 0) == 5) {
                title = res.getString(R.string.title26);
                des = res.getString(R.string.des17);
            } else if (sharedpreferences.getInt("page2", 0) == 6) {
                title = res.getString(R.string.title27);
                des = res.getString(R.string.des18);
            } else if (sharedpreferences.getInt("page2", 0) == 7) {
                title = res.getString(R.string.title28);
                des = res.getString(R.string.des19);
            }else if (sharedpreferences.getInt("page2", 0) == 8) {
                title = res.getString(R.string.title29);
                des = res.getString(R.string.des20);
            }else if (sharedpreferences.getInt("page2", 0) == 9) {
                title = res.getString(R.string.title30);
                des = res.getString(R.string.des21);
            }else if (sharedpreferences.getInt("page2", 0) == 10) {
                title = res.getString(R.string.title31);
                des = res.getString(R.string.des22);
            }else {
                title = res.getString(R.string.title32);
                des = res.getString(R.string.des23);
            }
            layout.setBackgroundDrawable(res.getDrawable(R.drawable.de));
        }
        else if(sharedpreferences.getInt("page1", 0) == 3) {
            if (sharedpreferences.getInt("page2", 0) == 0) {
                title = res.getString(R.string.title33);
                des = res.getString(R.string.des24);
            } else if (sharedpreferences.getInt("page2", 0) == 1) {
                title = res.getString(R.string.title34);
                des = res.getString(R.string.des25);
            } else if (sharedpreferences.getInt("page2", 0) == 2) {
                title = res.getString(R.string.title36);
                des = res.getString(R.string.des26);
            } else if (sharedpreferences.getInt("page2", 0) == 3) {
                title = res.getString(R.string.title36);
                des = res.getString(R.string.des27);
            } else if (sharedpreferences.getInt("page2", 0) == 4) {
                title = res.getString(R.string.title37);
                des = res.getString(R.string.des28);
            } else if (sharedpreferences.getInt("page2", 0) == 5) {
                title = res.getString(R.string.title38);
                des = res.getString(R.string.des29);
            } else if (sharedpreferences.getInt("page2", 0) == 6) {
                title = res.getString(R.string.title39);
                des = res.getString(R.string.des30);
            } else if (sharedpreferences.getInt("page2", 0) == 7) {
                title = res.getString(R.string.title40);
                des = res.getString(R.string.des31);
            } else {
                title = res.getString(R.string.title41);
                des = res.getString(R.string.des32);
            }
            layout.setBackgroundDrawable(res.getDrawable(R.drawable.zns));
        }
        else if (sharedpreferences.getInt("page1", 0) == 4) {
            if (sharedpreferences.getInt("page2", 0) == 0) {
                title = res.getString(R.string.title43);
                des = res.getString(R.string.des33);
            } else if (sharedpreferences.getInt("page2", 0) == 1) {
                title = res.getString(R.string.title44);
                des = res.getString(R.string.des34);
            } else if (sharedpreferences.getInt("page2", 0) == 2) {
                title = res.getString(R.string.title45);
                des = res.getString(R.string.des35);
            } else if (sharedpreferences.getInt("page2", 0) == 3) {
                title = res.getString(R.string.title46);
                des = res.getString(R.string.des36);
            } else if (sharedpreferences.getInt("page2", 0) == 4) {
                title = res.getString(R.string.title47);
                des = res.getString(R.string.des37);
            } else if (sharedpreferences.getInt("page2", 0) == 5) {
                   title = res.getString(R.string.title48);
                des = res.getString(R.string.des38);
            } else if (sharedpreferences.getInt("page2", 0) == 6) {
                title = res.getString(R.string.title49);
                des = res.getString(R.string.des39);
            } else if (sharedpreferences.getInt("page2", 0) == 7) {
                title = res.getString(R.string.title50);
                des = res.getString(R.string.des40);
            } else if (sharedpreferences.getInt("page2", 0) == 8) {
                title = res.getString(R.string.title51);
                des = res.getString(R.string.des41);
            } else {
                title = res.getString(R.string.title52);
                des = res.getString(R.string.des42);
            }
            layout.setBackgroundDrawable(res.getDrawable(R.drawable.gk));
        } else {
            if (sharedpreferences.getInt("page2", 0) == 0) {
                title = res.getString(R.string.title53);
                des = res.getString(R.string.des43);
            } else if (sharedpreferences.getInt("page2", 0) == 1) {
                title = res.getString(R.string.title54);
                des = res.getString(R.string.des44);
            } else if (sharedpreferences.getInt("page2", 0) == 2) {
                title = res.getString(R.string.title55);
                des = res.getString(R.string.des45);
            } else if (sharedpreferences.getInt("page2", 0) == 3) {
                title = res.getString(R.string.title56);
                des = res.getString(R.string.des46);
            } else if (sharedpreferences.getInt("page2", 0) == 4) {
                title = res.getString(R.string.title57);
                des = res.getString(R.string.des47);
            } else if (sharedpreferences.getInt("page2", 0) == 5) {
                title = res.getString(R.string.title58);
                des = res.getString(R.string.des48);
            } else if (sharedpreferences.getInt("page2", 0) == 6) {
                title = res.getString(R.string.title59);
                des = res.getString(R.string.des49);
            } else if (sharedpreferences.getInt("page2", 0) == 7) {
                title = res.getString(R.string.title60);
                des = res.getString(R.string.des50);
            } else if (sharedpreferences.getInt("page2", 0) == 8) {
                title = res.getString(R.string.title61);
                des = res.getString(R.string.des51);
            } else {
                title = res.getString(R.string.title62);
                des = res.getString(R.string.des52);
            }
            layout.setBackgroundDrawable(res.getDrawable(R.drawable.r));
        }

        text.setText(title);
        text2.setText(des);
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

        /*

        public void startNewService(View view)[
            Intent music = new Intent(this, BackgroundService.class);
            startService(music);
        }

        public void stoptNewService(View view)[
            Intent music = new Intent(this, BackgroundService.class);
            stopService(music);
        }

        */
    };
}
