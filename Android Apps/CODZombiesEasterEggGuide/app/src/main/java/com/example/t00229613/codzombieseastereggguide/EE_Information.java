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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.t00229613.codzombieseastereggguide.BackgroundService.MyBinder;

import static android.R.id.list;

public class EE_Information extends AppCompatActivity {

    BackgroundService mBoundService;
    boolean mServiceBound = false;
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ee_information);

        button = (ImageButton) findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mServiceBound) {
                    unbindService(mServiceConnection);
                    mServiceBound = false;
                }
                Intent music = new Intent(EE_Information.this, BackgroundService.class);
                stopService(music);

                finish();
            }
        });

        LinearLayout layout = (LinearLayout)findViewById(R.id.ee);

        Intent intent = getIntent();

        final SharedPreferences sharedpreferences = getSharedPreferences("Page", 0);

        if(!sharedpreferences.contains("activities")){
            sharedpreferences.edit().putInt("activities", 0 ).commit();
        }

        TextView text = (TextView) findViewById(R.id.textview);
        ListView listview = (ListView)findViewById(R.id.listview);
        Resources res = getResources();
        String menu[] = new String[0];
        String title = "";

        if(sharedpreferences.getInt("page1", 0) == 0) {
            menu = res.getStringArray(R.array.menu1);
            title = res.getString(R.string.title1);
            layout.setBackgroundDrawable(res.getDrawable(R.drawable.soe));
        }
        else if(sharedpreferences.getInt("page1", 0) == 1) {
            menu = res.getStringArray(R.array.menu2);
            title = res.getString(R.string.title2);
            layout.setBackgroundDrawable(res.getDrawable(R.drawable.g));
        }
        else if(sharedpreferences.getInt("page1", 0) == 2) {
            menu = res.getStringArray(R.array.menu3);
            title = res.getString(R.string.title3);
            layout.setBackgroundDrawable(res.getDrawable(R.drawable.de));
        }
        else if(sharedpreferences.getInt("page1", 0) == 3) {
            menu = res.getStringArray(R.array.menu4);
            title = res.getString(R.string.title4);
            layout.setBackgroundDrawable(res.getDrawable(R.drawable.zns));
        }
        else if(sharedpreferences.getInt("page1", 0) == 4) {
            menu = res.getStringArray(R.array.menu5);
            title = res.getString(R.string.title5);
            layout.setBackgroundDrawable(res.getDrawable(R.drawable.gk));
        }
        else{
            menu = res.getStringArray(R.array.menu6);
            title = res.getString(R.string.title6);
            layout.setBackgroundDrawable(res.getDrawable(R.drawable.r));
        }



        text.setText(title);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                textView.setTextColor(Color.LTGRAY);
                textView.setTypeface(null, Typeface.BOLD);

                return view;
            }
        };
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent intent = new Intent(view.getContext(), Information.class);
                    startActivity(intent);
                    sharedpreferences.edit().putInt("page2", 0).commit();
                }
                if(position == 1) {
                    Intent intent = new Intent(view.getContext(), Information.class);
                    startActivity(intent);
                    sharedpreferences.edit().putInt("page2", 1).commit();
                }
                if(position == 2) {
                    Intent intent = new Intent(view.getContext(), Information.class);
                    startActivity(intent);
                    sharedpreferences.edit().putInt("page2", 2).commit();
                }
                if(position == 3) {
                    Intent intent = new Intent(view.getContext(), Information.class);
                    startActivity(intent);
                    sharedpreferences.edit().putInt("page2", 3).commit();
                }
                if(position == 4) {
                    Intent intent = new Intent(view.getContext(), Information.class);
                    startActivity(intent);
                    sharedpreferences.edit().putInt("page2", 4).commit();
                }
                if(position == 5) {
                    Intent intent = new Intent(view.getContext(), Information.class);
                    startActivity(intent);
                    sharedpreferences.edit().putInt("page2", 5).commit();
                }
                if(position == 6) {
                    Intent intent = new Intent(view.getContext(), Information.class);
                    startActivity(intent);
                    sharedpreferences.edit().putInt("page2", 6).commit();
                }
                if(position == 7) {
                    Intent intent = new Intent(view.getContext(), Information.class);
                    startActivity(intent);
                    sharedpreferences.edit().putInt("page2", 7).commit();
                }
                if(position == 8) {
                    if(sharedpreferences.getInt("page1", 0) == 0) {
                        Intent intent = new Intent(view.getContext(), Symbols.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(view.getContext(),Information.class);
                        startActivity(intent);
                    }
                    sharedpreferences.edit().putInt("page2", 8).commit();
                }
                if(position == 9) {
                    Intent intent = new Intent(view.getContext(),Information.class);
                    startActivity(intent);
                    sharedpreferences.edit().putInt("page2", 9).commit();
                }
                if(position == 10) {
                    Intent intent = new Intent(view.getContext(),Information.class);
                    startActivity(intent);
                    sharedpreferences.edit().putInt("page2", 10).commit();
                }
                if(position == 11) {
                    Intent intent = new Intent(view.getContext(),Information.class);
                    startActivity(intent);
                    sharedpreferences.edit().putInt("page2", 11).commit();
                }
                int num =sharedpreferences.getInt("activities", 0 );
                num++;
                sharedpreferences.edit().putInt("activities", num ).commit();
            }
        });
    }

   /* @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(!hasFocus) {
            unbindService(mServiceConnection);
            mServiceBound = false;
            Intent music = new Intent(this, BackgroundService.class);
            stopService(music);
        }
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedpreferences = getSharedPreferences("Page", 0);
        Intent music = new Intent(this, BackgroundService.class);
        startService(music);
        bindService(music, mServiceConnection, Context.BIND_AUTO_CREATE);

        int num = 1;
        sharedpreferences.edit().putInt("activities", num ).commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            mServiceBound = false;
            Intent music = new Intent(this, BackgroundService.class);
            stopService(music);
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedpreferences = getSharedPreferences("Page", 0);
        unbindService(mServiceConnection);
        mServiceBound = false;
        if(sharedpreferences.getInt("activities", 0) == 1){
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
            MyBinder myBinder = (MyBinder) iBinder;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mServiceBound = false;
        }
    };
}