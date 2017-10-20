package com.ep.eric.golfscorecardbuddy;

/**
 * Created by Eric on 2/21/2017.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class Teetime_DB extends AppCompatActivity {

    DBAdapter myDB;
    ArrayList<String> arr;
    ArrayAdapter<String> adapter;
    ListView listview;
    ArrayList<String> arr2;
    ArrayAdapter<String> adapter2;
    ListView listview_delete;
    int selected;
    View touchSource;
    View clickSource;
    int offset = 0;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scorecard_db);

        getIntent();

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6098990941180338/8173850401");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();//.addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("EFD7155B8B2BFAD02ECD1BF0BEDEF1C0").build();
        mAdView.loadAd(adRequest);

        TextView title = (TextView)findViewById(R.id.textView_scorecard_title);
        title.setText("Tee Times:");

        ImageButton add = (ImageButton)findViewById(R.id.imageButton_add_scorecard);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Teetime.class);
                startActivity(intent);
            }
        });

        listview = (ListView)findViewById(R.id.listview);
        arr = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr){
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                textView.setHeight(180);
                textView.setMinimumHeight(180);
                textView.setTextColor(Color.parseColor("#bba35d"));
                textView.setShadowLayer(5,5,5,Color.BLACK);
                textView.setTypeface(null, Typeface.BOLD);
                textView.setTextSize(24);

                return view;
            }
        };

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selected = position;
                Cursor cursor = myDB.getAllRows3();
                getNewId(cursor);
                Intent intent = new Intent(view.getContext(), Teetime_Update.class);
                startActivity(intent);
            }
        });

        listview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(touchSource == null){
                    touchSource = v;
                }

                if(v == touchSource){
                    //listview_delete.dispatchTouchEvent(event);
                   // if(event.getAction() == MotionEvent.ACTION_UP){
                        clickSource = v;
                        touchSource = null;
                    //}
                }
                return false;
            }
        });

        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(view == clickSource && listview_delete.getCount() > 1){
                    listview_delete.setSelectionFromTop(firstVisibleItem, view.getChildAt(0).getTop() + offset);
                }
            }
        });

        listview_delete = (ListView)findViewById(R.id.sc_delete_listview);
        arr2 = new ArrayList<String>();
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr2){
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                textView.setHeight(180);
                textView.setMinimumHeight(180);
                textView.setTextColor(Color.parseColor("#bba35d"));
                textView.setShadowLayer(5,5,5,Color.BLACK);
                textView.setTypeface(null, Typeface.BOLD);
                textView.setTextSize(24);

                return view;
            }
        };

        listview_delete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selected = position;
                Cursor cursor = myDB.getAllRows3();
                getNewId(cursor);

                new AlertDialog.Builder(Teetime_DB.this)
                        .setMessage("Delete Tee Time?")
                        .setPositiveButton("OK", listener)
                        .setNegativeButton("Cancel", listener)
                        .create()
                        .show();

            }
        });

        listview_delete.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(touchSource == null){
                    touchSource = v;
                }

                if(v == touchSource){
                   // listview.dispatchTouchEvent(event);
                    //if(event.getAction() == MotionEvent.ACTION_UP){
                        clickSource = v;
                        touchSource = null;
                    //}
                }
                return false;
            }
        });

        listview_delete.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(view == clickSource && listview.getCount() > 1){
                    listview.setSelectionFromTop(firstVisibleItem, view.getChildAt(0).getTop() + offset);
                }
            }
        });

        openDB();
        Cursor cursor = myDB.getAllRows3();
        displayRecordSet(cursor);
    }

    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {

        final int BUTTON_NEGATIVE = -2;
        final int BUTTON_POSITIVE = -1;

        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case BUTTON_NEGATIVE:

                    dialog.dismiss();
                    break;

                case BUTTON_POSITIVE:

                    final SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(Teetime_DB.this);
                    final long newId = sharedpreferences.getLong("teetime_id", 0);
                    myDB.deleteTeeTime(newId);

                    Cursor cursor = myDB.getAllRows3();
                    displayRecordSet(cursor);

                    dialog.dismiss();

                    break;
            }
        }
    };

    private void displayRecordSet(Cursor cursor){
        String message = "";

        arr.clear();
        arr2.clear();

        if(cursor.moveToFirst()){
            do{
                message = "";
                String name = cursor.getString(DBAdapter.COL_COURSE_NAME);
                //String year = cursor.getString(DBAdapter.COL_YEAR);
                int month = Integer.parseInt(cursor.getString(DBAdapter.COL_MONTH));
                String month_name = "";
                switch(month){
                    case 0:
                        month_name = "Jan";
                        break;
                    case 1:
                        month_name = "Feb";
                        break;
                    case 2:
                        month_name = "Mar";
                        break;
                    case 3:
                        month_name = "Apr";
                        break;
                    case 4:
                        month_name = "May";
                        break;
                    case 5:
                        month_name = "June";
                        break;
                    case 6:
                        month_name = "July";
                        break;
                    case 7:
                        month_name = "Aug";
                        break;
                    case 8:
                        month_name = "Sept";
                        break;
                    case 9:
                        month_name = "Oct";
                        break;
                    case 10:
                        month_name = "Nov";
                        break;
                    case 11:
                        month_name = "Dec";
                        break;
                }
                String day = cursor.getString(DBAdapter.COL_DATE);
                int hour = Integer.parseInt(cursor.getString(DBAdapter.COL_HOUR))%12;
                String ampm;
                if(Integer.parseInt(cursor.getString(DBAdapter.COL_HOUR)) > 12) {
                    ampm = "PM";
                }
                else{
                    ampm = "AM";
                }
                String minute = cursor.getString(DBAdapter.COL_MINUTE);
                switch(minute){
                    case "0":
                        minute = "00";
                        break;
                    case "1":
                        minute = "01";
                        break;
                    case "2":
                        minute = "02";
                        break;
                    case "3":
                        minute = "03";
                        break;
                    case "4":
                        minute = "04";
                        break;
                    case "5":
                        minute = "05";
                        break;
                    case "6":
                        minute = "06";
                        break;
                    case "7":
                        minute = "07";
                        break;
                    case "8":
                        minute = "08";
                        break;
                    case "9":
                        minute = "09";
                        break;
                }

                message += name + " " + month_name + " " + day + ", " + hour + ":" + minute + " " + ampm + "\n";
                arr.add(message);
                arr2.add("Delete");
            }while(cursor.moveToNext());
        }
        listview.setAdapter(adapter);
        listview_delete.setAdapter(adapter2);
        cursor.close();
    }

    private void getNewId(Cursor cursor){

        int count = 0;

        if(cursor.moveToFirst()){
            do{

                long id = cursor.getLong(DBAdapter.COL_ROWID3);

                if(count == selected){
                    final SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
                    sharedpreferences.edit().putLong("teetime_id",id).commit();
                    break;
                }

                count++;

            }while(cursor.moveToNext());
        }
        cursor.close();
    }

    private void openDB() {
        myDB = new DBAdapter(this);
        myDB.open();
    }

    private void closeDB(){
        myDB.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Cursor cursor = myDB.getAllRows3();
        displayRecordSet(cursor);
        mAdView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdView.destroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAdView.pause();
    }
}
