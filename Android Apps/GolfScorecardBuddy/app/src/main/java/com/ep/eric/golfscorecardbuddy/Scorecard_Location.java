package com.ep.eric.golfscorecardbuddy;

/**
 * Created by T00229613 on 2/1/2017.
 */

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.R.attr.data;
import static android.media.MediaRecorder.AudioSource.VOICE_RECOGNITION;
import static com.ep.eric.golfscorecardbuddy.R.id.listview;
import static com.ep.eric.golfscorecardbuddy.R.string.save;

public class Scorecard_Location extends AppCompatActivity {

    DBAdapter myDB;
    EditText name,par1,par2,par3,par4,par5,par6,par7,par8,par9,par10,par11,par12,par13,par14,par15,par16,par17,par18,
            yard1,yard2,yard3,yard4,yard5,yard6,yard7,yard8,yard9,yard10,yard11,yard12,yard13,yard14,yard15,yard16,yard17,yard18,
            course_rating, slope_rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scorecard_location);

        getIntent();

        openDB();

        name = (EditText)findViewById(R.id.editText_name);
        par1 = (EditText)findViewById(R.id.editText_par_one);
        par2 = (EditText)findViewById(R.id.editText_par_two);
        par3 = (EditText)findViewById(R.id.editText_par_three);
        par4 = (EditText)findViewById(R.id.editText_par_four);
        par5 = (EditText)findViewById(R.id.editText_par_five);
        par6 = (EditText)findViewById(R.id.editText_par_six);
        par7 = (EditText)findViewById(R.id.editText_par_seven);
        par8 = (EditText)findViewById(R.id.editText_par_eight);
        par9 = (EditText)findViewById(R.id.editText_par_nine);
        par10 = (EditText)findViewById(R.id.editText_par_ten);
        par11 = (EditText)findViewById(R.id.editText_par_eleven);
        par12 = (EditText)findViewById(R.id.editText_par_twelve);
        par13 = (EditText)findViewById(R.id.editText_par_thirteen);
        par14 = (EditText)findViewById(R.id.editText_par_fourteen);
        par15 = (EditText)findViewById(R.id.editText_par_fifteen);
        par16 = (EditText)findViewById(R.id.editText_par_sixteen);
        par17 = (EditText)findViewById(R.id.editText_par_seventeen);
        par18 = (EditText)findViewById(R.id.editText_par_eighteen);
        yard1 = (EditText)findViewById(R.id.editText_yardage_one);
        yard2 = (EditText)findViewById(R.id.editText_yardage_two);
        yard3 = (EditText)findViewById(R.id.editText_yardage_three);
        yard4 = (EditText)findViewById(R.id.editText_yardage_four);
        yard5 = (EditText)findViewById(R.id.editText_yardage_five);
        yard6 = (EditText)findViewById(R.id.editText_yardage_six);
        yard7 = (EditText)findViewById(R.id.editText_yardage_seven);
        yard8 = (EditText)findViewById(R.id.editText_yardage_eight);
        yard9 = (EditText)findViewById(R.id.editText_yardage_nine);
        yard10 = (EditText)findViewById(R.id.editText_yardage_ten);
        yard11 = (EditText)findViewById(R.id.editText_yardage_eleven);
        yard12 = (EditText)findViewById(R.id.editText_yardage_twelve);
        yard13 = (EditText)findViewById(R.id.editText_yardage_thirteen);
        yard14 = (EditText)findViewById(R.id.editText_yardage_fourteen);
        yard15 = (EditText)findViewById(R.id.editText_yardage_fifteen);
        yard16 = (EditText)findViewById(R.id.editText_yardage_sixteen);
        yard17 = (EditText)findViewById(R.id.editText_yardage_seventeen);
        yard18 = (EditText)findViewById(R.id.editText_yardage_eighteen);
        course_rating = (EditText)findViewById(R.id.editText_course_rating);
        slope_rating = (EditText)findViewById(R.id.editText_slope_rating);

        if(savedInstanceState != null) {
            name.setText(savedInstanceState.getCharSequence("name"));
            par1.setText(savedInstanceState.getCharSequence("par1"));
            par2.setText(savedInstanceState.getCharSequence("par2"));
            par3.setText(savedInstanceState.getCharSequence("par3"));
            par4.setText(savedInstanceState.getCharSequence("par4"));
            par5.setText(savedInstanceState.getCharSequence("par5"));
            par6.setText(savedInstanceState.getCharSequence("par6"));
            par7.setText(savedInstanceState.getCharSequence("par7"));
            par8.setText(savedInstanceState.getCharSequence("par8"));
            par9.setText(savedInstanceState.getCharSequence("par9"));
            par10.setText(savedInstanceState.getCharSequence("par10"));
            par11.setText(savedInstanceState.getCharSequence("par11"));
            par12.setText(savedInstanceState.getCharSequence("par12"));
            par13.setText(savedInstanceState.getCharSequence("par13"));
            par14.setText(savedInstanceState.getCharSequence("par14"));
            par15.setText(savedInstanceState.getCharSequence("par15"));
            par16.setText(savedInstanceState.getCharSequence("par16"));
            par17.setText(savedInstanceState.getCharSequence("par17"));
            par18.setText(savedInstanceState.getCharSequence("par18"));
            yard1.setText(savedInstanceState.getCharSequence("yard1"));
            yard2.setText(savedInstanceState.getCharSequence("yard2"));
            yard3.setText(savedInstanceState.getCharSequence("yard3"));
            yard4.setText(savedInstanceState.getCharSequence("yard4"));
            yard5.setText(savedInstanceState.getCharSequence("yard5"));
            yard6.setText(savedInstanceState.getCharSequence("yard6"));
            yard7.setText(savedInstanceState.getCharSequence("yard7"));
            yard8.setText(savedInstanceState.getCharSequence("yard8"));
            yard9.setText(savedInstanceState.getCharSequence("yard9"));
            yard10.setText(savedInstanceState.getCharSequence("yard10"));
            yard11.setText(savedInstanceState.getCharSequence("yard11"));
            yard12.setText(savedInstanceState.getCharSequence("yard12"));
            yard13.setText(savedInstanceState.getCharSequence("yard13"));
            yard14.setText(savedInstanceState.getCharSequence("yard14"));
            yard15.setText(savedInstanceState.getCharSequence("yard15"));
            yard16.setText(savedInstanceState.getCharSequence("yard16"));
            yard17.setText(savedInstanceState.getCharSequence("yard17"));
            yard18.setText(savedInstanceState.getCharSequence("yard18"));
            course_rating.setText(savedInstanceState.getCharSequence("course_rating"));
            slope_rating.setText(savedInstanceState.getCharSequence("slope_rating"));
        }

        ImageButton mic = (ImageButton)findViewById(R.id.imageButton_mic);
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak normally into your phone");
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                try {
                    startActivityForResult(intent, VOICE_RECOGNITION);
                } catch (ActivityNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        Button save = (Button)findViewById(R.id.button_save_location);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long newId = -1;
                if(name.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(),"Please include a course name",Toast.LENGTH_SHORT).show();
                }
                else{
                    newId = myDB.insertRow(name.getText().toString(),par1.getText().toString(),par2.getText().toString(),par3.getText().toString(),par4.getText().toString(),par5.getText().toString(),par6.getText().toString(),par7.getText().toString(),par8.getText().toString(),par9.getText().toString(),par10.getText().toString(),par11.getText().toString(),par12.getText().toString(),par13.getText().toString(),par14.getText().toString(),par15.getText().toString(),par16.getText().toString(),par17.getText().toString(),par18.getText().toString(),yard1.getText().toString(),yard2.getText().toString(),yard3.getText().toString(),yard4.getText().toString(),yard5.getText().toString(),yard6.getText().toString(),yard7.getText().toString(),yard8.getText().toString(),yard9.getText().toString(),yard10.getText().toString(),yard11.getText().toString(),yard12.getText().toString(),yard13.getText().toString(),yard14.getText().toString(),yard15.getText().toString(),yard16.getText().toString(),yard17.getText().toString(),yard18.getText().toString(), course_rating.getText().toString(), slope_rating.getText().toString());
                }
                if (newId != -1){
                    Toast.makeText(getBaseContext(),"Template Saved",Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getBaseContext(),"ERROR - Failed To Save",Toast.LENGTH_SHORT).show();

                }
            }
        });

        Button cancel = (Button)findViewById(R.id.button_cancel_location);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            name.setText(result.get(0));
        }
    }

    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putCharSequence("name", name.getText());
        outState.putCharSequence("par1", par1.getText());
        outState.putCharSequence("par2", par2.getText());
        outState.putCharSequence("par3", par3.getText());
        outState.putCharSequence("par4", par4.getText());
        outState.putCharSequence("par5", par5.getText());
        outState.putCharSequence("par6", par6.getText());
        outState.putCharSequence("par7", par7.getText());
        outState.putCharSequence("par8", par8.getText());
        outState.putCharSequence("par9", par9.getText());
        outState.putCharSequence("par10", par10.getText());
        outState.putCharSequence("par11", par11.getText());
        outState.putCharSequence("par12", par12.getText());
        outState.putCharSequence("par13", par13.getText());
        outState.putCharSequence("par14", par14.getText());
        outState.putCharSequence("par15", par15.getText());
        outState.putCharSequence("par16", par16.getText());
        outState.putCharSequence("par17", par17.getText());
        outState.putCharSequence("par18", par18.getText());
        outState.putCharSequence("yard1", yard1.getText());
        outState.putCharSequence("yard2", yard2.getText());
        outState.putCharSequence("yard3", yard3.getText());
        outState.putCharSequence("yard4", yard4.getText());
        outState.putCharSequence("yard5", yard5.getText());
        outState.putCharSequence("yard6", yard6.getText());
        outState.putCharSequence("yard7", yard7.getText());
        outState.putCharSequence("yard8", yard8.getText());
        outState.putCharSequence("yard9", yard9.getText());
        outState.putCharSequence("yard10", yard10.getText());
        outState.putCharSequence("yard11", yard11.getText());
        outState.putCharSequence("yard12", yard12.getText());
        outState.putCharSequence("yard13", yard13.getText());
        outState.putCharSequence("yard14", yard14.getText());
        outState.putCharSequence("yard15", yard15.getText());
        outState.putCharSequence("yard16", yard16.getText());
        outState.putCharSequence("yard17", yard17.getText());
        outState.putCharSequence("yard18", yard18.getText());
        outState.putCharSequence("course_rating", course_rating.getText());
        outState.putCharSequence("slope_rating", slope_rating.getText());
    }

    private void openDB() {
        myDB = new DBAdapter(this);
        myDB.open();
    }

    private void closeDB(){
        myDB.close();
    }
}