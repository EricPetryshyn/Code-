package com.ep.eric.golfscorecardbuddy;

/**
 * Created by T00229613 on 2/1/2017.
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

import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Scorecard_DB extends AppCompatActivity {

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

        //ImageButton plus = (ImageButton)findViewById(R.id.imageButton_add_scorecard);
        //Drawable d = ContextCompat.getDrawable(this, R.drawable.plus);
        //Drawable d = ContextCompat.getDrawable(this,R.drawable.plus);
        //d.setColorFilter(Color.parseColor("#FFBC00"), PorterDuff.Mode.MULTIPLY);

        ImageButton add = (ImageButton)findViewById(R.id.imageButton_add_scorecard);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Scorecard_Setup.class);
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
                Cursor cursor = myDB.getAllRows2();
                getNewId(cursor);
                Intent intent = new Intent(view.getContext(), Scorecard.class);
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
                    //if(event.getAction() == MotionEvent.ACTION_UP){
                        clickSource = v;
                        touchSource = null;
                   // }
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
                Cursor cursor = myDB.getAllRows2();
                getNewId(cursor);

                new AlertDialog.Builder(Scorecard_DB.this)
                        .setMessage("Delete Scorecard?\n\nWarning! May Affect Handicap.")
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
                    //listview.dispatchTouchEvent(event);
                    //if(event.getAction() == MotionEvent.ACTION_UP){
                        clickSource = v;
                        touchSource = null;
                   // }
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
        Cursor cursor = myDB.getAllRows2();
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

                    final SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(Scorecard_DB.this);
                    final long newId = sharedpreferences.getLong("id", 0);
                    myDB.deleteScorecardRow(newId);

                    Cursor cursor = myDB.getAllRows2();
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
                String name = cursor.getString(DBAdapter.COL_TEMPLATE);

                message += name + "\n";
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

                long id = cursor.getLong(DBAdapter.COL_ROWID2);

                if(count == selected){
                    final SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
                    sharedpreferences.edit().putLong("id",id).commit();
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
        Cursor cursor = myDB.getAllRows2();
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
