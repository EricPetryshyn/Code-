package com.ep.eric.golfscorecardbuddy;

/**
 * Created by T00229613 on 2/1/2017.
 */

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Build;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import static android.animation.ObjectAnimator.ofFloat;
import static android.media.MediaRecorder.AudioSource.VOICE_RECOGNITION;
import static com.ep.eric.golfscorecardbuddy.R.id.spinner;
import static com.ep.eric.golfscorecardbuddy.R.string.or;

public class Scorecard_Setup extends AppCompatActivity {

    DBAdapter myDB;
    Spinner template;
    ArrayList<String> arr1;
    ArrayAdapter<String> adapter;
    Spinner players;
    ArrayList<String> arr2;
    ArrayAdapter<String> adapter2;
    private TextToSpeech tts;
    private boolean ttsIsInit = false;

    public static int TTS_DATA_CHECK = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scorecard_setup);

        getIntent();

        final ImageButton info = (ImageButton) findViewById(R.id.imageButton_info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
                startActivityForResult(intent, TTS_DATA_CHECK);
                ttsIsInit = true;

                new AlertDialog.Builder(Scorecard_Setup.this)
                        .setMessage("Templates contain information about the course name, the par and yardage of each hole, the course rating, and slope rating. The 'Blank Template' does not contain any of this information. It should be used when information about the course is not known.\n\nClick on the drop down menu to select the template you want or click on the 'NEW TEMPLATE' button to create a new template.\n\nWhen creating a new template, course name is the only required field, but course rating and slope rating are necessary for calculating handicap.")
                        .setPositiveButton("OK", listener)
                        .setCancelable(false)
                        .create()
                        .show();
            }
        });

        final SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());

        final Button cont = (Button) findViewById(R.id.button_continue);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long newId = myDB.insertRow2(template.getSelectedItem().toString(),players.getSelectedItem().toString(),"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","");

                sharedpreferences.edit().putLong("id",newId).commit();

                Toast.makeText(getBaseContext(),"Scorecard Created",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), Scorecard.class);
                startActivity(intent);
            }
        });

        Button add = (Button) findViewById(R.id.button_template);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Scorecard_Location.class);
                startActivity(intent);
            }
        });

        Button close = (Button)findViewById(R.id.button_cancel);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        template = (Spinner)findViewById(spinner);
        /*Drawable spinnerDrawable = template.getBackground().getConstantState().newDrawable();
        spinnerDrawable.setColorFilter(getResources().getColor(R.color.sandYellow), PorterDuff.Mode.SRC_ATOP);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            template.setBackground(spinnerDrawable);
        }
        else{
            template.setBackgroundDrawable(spinnerDrawable);
        }*/

        arr1 = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arr1){
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                textView.setHeight(180);
                textView.setMinimumHeight(180);
                //textView.setTextColor(Color.parseColor("#bba35d"));
                //textView.setShadowLayer(5,5,5,Color.BLACK);
                textView.setTypeface(null, Typeface.BOLD);
                textView.setTextSize(20);

                return view;
            }
        };

        players = (Spinner)findViewById(R.id.spinner2);
        /*Drawable spinnerDrawable2 = players.getBackground().getConstantState().newDrawable();
        spinnerDrawable2.setColorFilter(getResources().getColor(R.color.sandYellow), PorterDuff.Mode.SRC_ATOP);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            players.setBackground(spinnerDrawable2);
        }
        else{
            players.setBackgroundDrawable(spinnerDrawable2);
        }*/
        arr2 = new ArrayList<String>();
        arr2.add("1");
        arr2.add("2");
        arr2.add("3");
        arr2.add("4");
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arr2){
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                textView.setHeight(180);
                textView.setMinimumHeight(180);
                //textView.setTextColor(Color.parseColor("#bba35d"));
                //textView.setShadowLayer(5,5,5,Color.BLACK);
                textView.setTypeface(null, Typeface.BOLD);
                textView.setTextSize(20);

                return view;
            }
        };
        players.setAdapter(adapter2);

        if(savedInstanceState != null) {
            template.setSelection(savedInstanceState.getInt("template"));
            players.setSelection(savedInstanceState.getInt("players"));
        }

        openDB();
        Cursor cursor = myDB.getAllRows();
        displayRecordSet(cursor);
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("template", template.getSelectedItemPosition());
        outState.putInt("players", players.getSelectedItemPosition());
    }

    private void displayRecordSet(Cursor cursor){
        String message = "";

        arr1.clear();
        arr1.add("Blank Template");

        if(cursor.moveToFirst()){
            do{
                message = "";
                String name = cursor.getString(DBAdapter.COL_NAME);

                message += name + "\n";
                arr1.add(message);
            }while(cursor.moveToNext());
        }
        template.setAdapter(adapter);
        cursor.close();
    }

    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {

        final int BUTTON_POSITIVE = -1;

        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {

                case BUTTON_POSITIVE:

                    tts.stop();
                    tts.shutdown();

                    dialog.dismiss();

                    break;
            }
        }
    };

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();

        // TODO Auto-generated method stub
        if (ttsIsInit) {
            tts.stop();
            tts.shutdown();
            ttsIsInit = false;
        }
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TTS_DATA_CHECK) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {

                tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {

                    @Override
                    public void onInit(int i) {
                        if (tts.isLanguageAvailable(Locale.US) >= 0) {
                            tts.setLanguage(Locale.US);
                            tts.setPitch(0.8f);
                            tts.setSpeechRate(1.1f);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                ttsGreater21("Templates contain information about the course name, the par and yardage of each hole, the course rating, and slope rating. The 'Blank Template' does not contain any of this information. It should be used when information about the course is not known.\n\nClick on the drop down menu to select the template you want or click on the 'NEW TEMPLATE' button to create a new template.\n\nWhen creating a new template, course name is the only required field, but course rating and slope rating are necessary for calculating handicap.");
                            } else {
                                ttsUnder20("Templates contain information about the course name, the par and yardage of each hole, the course rating, and slope rating. The 'Blank Template' does not contain any of this information. It should be used when information about the course is not known.\n\nClick on the drop down menu to select the template you want or click on the 'NEW TEMPLATE' button to create a new template.\n\nWhen creating a new template, course name is the only required field, but course rating and slope rating are necessary for calculating handicap.");
                            }
                        }
                    }
                });

            } else {
                Intent installVoice = new Intent(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installVoice);
            }
        }
    }

    @SuppressWarnings("deprecation")
    private void ttsUnder20(String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text) {
        String utteranceId=this.hashCode() + "";
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
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
        Cursor cursor = myDB.getAllRows();
        displayRecordSet(cursor);
    }
}
