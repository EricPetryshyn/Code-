package com.ep.eric.golfscorecardbuddy;

/**
 * Created by Eric on 2/10/2017.
 */

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class Scorecard extends AppCompatActivity{

    DBAdapter myDB;
    String template,players,n1_sc1,n1_sc2,n1_sc3,n1_sc4,n1_sc5,n1_sc6,n1_sc7,n1_sc8,n1_sc9,n1_sc10,n1_sc11,n1_sc12,n1_sc13,n1_sc14,n1_sc15,n1_sc16,n1_sc17,n1_sc18,
            n2_sc1,n2_sc2,n2_sc3,n2_sc4,n2_sc5,n2_sc6,n2_sc7,n2_sc8,n2_sc9,n2_sc10,n2_sc11,n2_sc12,n2_sc13,n2_sc14,n2_sc15,n2_sc16,n2_sc17,n2_sc18,
            n3_sc1,n3_sc2,n3_sc3,n3_sc4,n3_sc5,n3_sc6,n3_sc7,n3_sc8,n3_sc9,n3_sc10,n3_sc11,n3_sc12,n3_sc13,n3_sc14,n3_sc15,n3_sc16,n3_sc17,n3_sc18,
            n4_sc1,n4_sc2,n4_sc3,n4_sc4,n4_sc5,n4_sc6,n4_sc7,n4_sc8,n4_sc9,n4_sc10,n4_sc11,n4_sc12,n4_sc13,n4_sc14,n4_sc15,n4_sc16,n4_sc17,n4_sc18,
            n1,n2,n3,n4,y1,y2,y3,y4,y5,y6,y7,y8,y9,y10,y11,y12,y13,y14,y15,y16,y17,y18,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18;

    EditText name2, name3, name4, n1_score1, n1_score2, n1_score3, n1_score4, n1_score5, n1_score6, n1_score7, n1_score8, n1_score9, n1_score10, n1_score11, n1_score12, n1_score13,
    n1_score14, n1_score15, n1_score16, n1_score17, n1_score18, n2_score1, n2_score2, n2_score3, n2_score4, n2_score5, n2_score6, n2_score7, n2_score8, n2_score9, n2_score10, n2_score11,
    n2_score12, n2_score13, n2_score14, n2_score15, n2_score16, n2_score17, n2_score18, n3_score1, n3_score2, n3_score3, n3_score4, n3_score5, n3_score6, n3_score7, n3_score8, n3_score9,
    n3_score10, n3_score11, n3_score12, n3_score13, n3_score14, n3_score15, n3_score16, n3_score17, n3_score18, n4_score1, n4_score2, n4_score3, n4_score4, n4_score5, n4_score6, n4_score7,
    n4_score8, n4_score9, n4_score10, n4_score11, n4_score12, n4_score13, n4_score14, n4_score15, n4_score16, n4_score17, n4_score18;

    TextView name1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scorecard);

        getIntent();

        openDB();

        LinearLayout layout_main = (LinearLayout) findViewById(R.id.layout_main);
        final LinearLayout layout_name = (LinearLayout) findViewById(R.id.layout_name);
        final LinearLayout layout_n2 = (LinearLayout) findViewById(R.id.layout_name2);
        final LinearLayout layout_n3 = (LinearLayout) findViewById(R.id.layout_name3);
        final LinearLayout layout_n4 = (LinearLayout) findViewById(R.id.layout_name4);
        final LinearLayout layout_par = (LinearLayout) findViewById(R.id.layout_par);
        final LinearLayout layout_yardage = (LinearLayout) findViewById(R.id.layout_yardage);
        final TextView name = (TextView)findViewById(R.id.textView_sc_name);
        final TextView yard1 = (TextView)findViewById(R.id.textView_sc_yardage_one);
        final TextView yard2 = (TextView)findViewById(R.id.textView_sc_yardage_two);
        final TextView yard3 = (TextView)findViewById(R.id.textView_sc_yardage_three);
        final TextView yard4 = (TextView)findViewById(R.id.textView_sc_yardage_four);
        final TextView yard5 = (TextView)findViewById(R.id.textView_sc_yardage_five);
        final TextView yard6 = (TextView)findViewById(R.id.textView_sc_yardage_six);
        final TextView yard7 = (TextView)findViewById(R.id.textView_sc_yardage_seven);
        final TextView yard8 = (TextView)findViewById(R.id.textView_sc_yardage_eight);
        final TextView yard9 = (TextView)findViewById(R.id.textView_sc_yardage_nine);
        final TextView yard_front_total = (TextView)findViewById(R.id.textView_yardage_front_total);
        final TextView yard10 = (TextView)findViewById(R.id.textView_sc_yardage_ten);
        final TextView yard11 = (TextView)findViewById(R.id.textView_sc_yardage_eleven);
        final TextView yard12 = (TextView)findViewById(R.id.textView_sc_yardage_twelve);
        final TextView yard13 = (TextView)findViewById(R.id.textView_sc_yardage_thirteen);
        final TextView yard14 = (TextView)findViewById(R.id.textView_sc_yardage_fourteen);
        final TextView yard15 = (TextView)findViewById(R.id.textView_sc_yardage_fifteen);
        final TextView yard16 = (TextView)findViewById(R.id.textView_sc_yardage_sixteen);
        final TextView yard17 = (TextView)findViewById(R.id.textView_sc_yardage_seventeen);
        final TextView yard18 = (TextView)findViewById(R.id.textView_sc_yardage_eighteen);
        final TextView yard_back_total = (TextView)findViewById(R.id.textView_yardage_back_total);
        final TextView yard_total = (TextView)findViewById(R.id.textView_yardage_total);
        final TextView par1 = (TextView)findViewById(R.id.textView_sc_par_one);
        final TextView par2 = (TextView)findViewById(R.id.textView_sc_par_two);
        final TextView par3 = (TextView)findViewById(R.id.textView_sc_par_three);
        final TextView par4 = (TextView)findViewById(R.id.textView_sc_par_four);
        final TextView par5 = (TextView)findViewById(R.id.textView_sc_par_five);
        final TextView par6 = (TextView)findViewById(R.id.textView_sc_par_six);
        final TextView par7 = (TextView)findViewById(R.id.textView_sc_par_seven);
        final TextView par8 = (TextView)findViewById(R.id.textView_sc_par_eight);
        final TextView par9 = (TextView)findViewById(R.id.textView_sc_par_nine);
        final TextView par_front_total = (TextView)findViewById(R.id.textView_par_front_total);
        final TextView par10 = (TextView)findViewById(R.id.textView_sc_par_ten);
        final TextView par11 = (TextView)findViewById(R.id.textView_sc_par_eleven);
        final TextView par12 = (TextView)findViewById(R.id.textView_sc_par_twelve);
        final TextView par13 = (TextView)findViewById(R.id.textView_sc_par_thirteen);
        final TextView par14 = (TextView)findViewById(R.id.textView_sc_par_fourteen);
        final TextView par15 = (TextView)findViewById(R.id.textView_sc_par_fifteen);
        final TextView par16 = (TextView)findViewById(R.id.textView_sc_par_sixteen);
        final TextView par17 = (TextView)findViewById(R.id.textView_sc_par_seventeen);
        final TextView par18 = (TextView)findViewById(R.id.textView_sc_par_eighteen);
        final TextView par_back_total = (TextView)findViewById(R.id.textView_par_back_total);
        final TextView par_total = (TextView)findViewById(R.id.textView_par_total);
        n1_score1 = (EditText) findViewById(R.id.editText_sc_n1_score1);
        n1_score1.addTextChangedListener(new GeneralTextWatcher(n1_score1));
        n1_score2 = (EditText)findViewById(R.id.editText_sc_n1_score2);
        n1_score2.addTextChangedListener(new GeneralTextWatcher(n1_score2));
        n1_score3 = (EditText)findViewById(R.id.editText_sc_n1_score3);
        n1_score3.addTextChangedListener(new GeneralTextWatcher(n1_score3));
        n1_score4 = (EditText)findViewById(R.id.editText_sc_n1_score4);
        n1_score4.addTextChangedListener(new GeneralTextWatcher(n1_score4));
        n1_score5 = (EditText)findViewById(R.id.editText_sc_n1_score5);
        n1_score5.addTextChangedListener(new GeneralTextWatcher(n1_score5));
        n1_score6 = (EditText)findViewById(R.id.editText_sc_n1_score6);
        n1_score6.addTextChangedListener(new GeneralTextWatcher(n1_score6));
        n1_score7 = (EditText)findViewById(R.id.editText_sc_n1_score7);
        n1_score7.addTextChangedListener(new GeneralTextWatcher(n1_score7));
        n1_score8 = (EditText)findViewById(R.id.editText_sc_n1_score8);
        n1_score8.addTextChangedListener(new GeneralTextWatcher(n1_score8));
        n1_score9 = (EditText)findViewById(R.id.editText_sc_n1_score9);
        n1_score9.addTextChangedListener(new GeneralTextWatcher(n1_score9));
        n1_score10 = (EditText)findViewById(R.id.editText_sc_n1_score10);
        n1_score10.addTextChangedListener(new GeneralTextWatcher(n1_score10));
        n1_score11 = (EditText)findViewById(R.id.editText_sc_n1_score11);
        n1_score11.addTextChangedListener(new GeneralTextWatcher(n1_score11));
        n1_score12 = (EditText)findViewById(R.id.editText_sc_n1_score12);
        n1_score12.addTextChangedListener(new GeneralTextWatcher(n1_score12));
        n1_score13 = (EditText)findViewById(R.id.editText_sc_n1_score13);
        n1_score13.addTextChangedListener(new GeneralTextWatcher(n1_score13));
        n1_score14 = (EditText)findViewById(R.id.editText_sc_n1_score14);
        n1_score14.addTextChangedListener(new GeneralTextWatcher(n1_score14));
        n1_score15 = (EditText)findViewById(R.id.editText_sc_n1_score15);
        n1_score15.addTextChangedListener(new GeneralTextWatcher(n1_score15));
        n1_score16 = (EditText)findViewById(R.id.editText_sc_n1_score16);
        n1_score16.addTextChangedListener(new GeneralTextWatcher(n1_score16));
        n1_score17 = (EditText)findViewById(R.id.editText_sc_n1_score17);
        n1_score17.addTextChangedListener(new GeneralTextWatcher(n1_score17));
        n1_score18 = (EditText)findViewById(R.id.editText_sc_n1_score18);
        n1_score18.addTextChangedListener(new GeneralTextWatcher(n1_score18));
        n2_score1 = (EditText)findViewById(R.id.editText_sc_n2_score1);
        n2_score1.addTextChangedListener(new GeneralTextWatcher(n2_score1));
        n2_score2 = (EditText)findViewById(R.id.editText_sc_n2_score2);
        n2_score2.addTextChangedListener(new GeneralTextWatcher(n2_score2));
        n2_score3 = (EditText)findViewById(R.id.editText_sc_n2_score3);
        n2_score3.addTextChangedListener(new GeneralTextWatcher(n2_score3));
        n2_score4 = (EditText)findViewById(R.id.editText_sc_n2_score4);
        n2_score4.addTextChangedListener(new GeneralTextWatcher(n2_score4));
        n2_score5 = (EditText)findViewById(R.id.editText_sc_n2_score5);
        n2_score5.addTextChangedListener(new GeneralTextWatcher(n2_score5));
        n2_score6 = (EditText)findViewById(R.id.editText_sc_n2_score6);
        n2_score6.addTextChangedListener(new GeneralTextWatcher(n2_score6));
        n2_score7 = (EditText)findViewById(R.id.editText_sc_n2_score7);
        n2_score7.addTextChangedListener(new GeneralTextWatcher(n2_score7));
        n2_score8 = (EditText)findViewById(R.id.editText_sc_n2_score8);
        n2_score8.addTextChangedListener(new GeneralTextWatcher(n2_score8));
        n2_score9 = (EditText)findViewById(R.id.editText_sc_n2_score9);
        n2_score9.addTextChangedListener(new GeneralTextWatcher(n2_score9));
        n2_score10 = (EditText)findViewById(R.id.editText_sc_n2_score10);
        n2_score10.addTextChangedListener(new GeneralTextWatcher(n2_score10));
        n2_score11 = (EditText)findViewById(R.id.editText_sc_n2_score11);
        n2_score11.addTextChangedListener(new GeneralTextWatcher(n2_score11));
        n2_score12 = (EditText)findViewById(R.id.editText_sc_n2_score12);
        n2_score12.addTextChangedListener(new GeneralTextWatcher(n2_score12));
        n2_score13 = (EditText)findViewById(R.id.editText_sc_n2_score13);
        n2_score13.addTextChangedListener(new GeneralTextWatcher(n2_score13));
        n2_score14 = (EditText)findViewById(R.id.editText_sc_n2_score14);
        n2_score14.addTextChangedListener(new GeneralTextWatcher(n2_score14));
        n2_score15 = (EditText)findViewById(R.id.editText_sc_n2_score15);
        n2_score15.addTextChangedListener(new GeneralTextWatcher(n2_score15));
        n2_score16 = (EditText)findViewById(R.id.editText_sc_n2_score16);
        n2_score16.addTextChangedListener(new GeneralTextWatcher(n2_score16));
        n2_score17 = (EditText)findViewById(R.id.editText_sc_n2_score17);
        n2_score17.addTextChangedListener(new GeneralTextWatcher(n2_score17));
        n2_score18 = (EditText)findViewById(R.id.editText_sc_n2_score18);
        n2_score18.addTextChangedListener(new GeneralTextWatcher(n2_score18));
        n3_score1 = (EditText)findViewById(R.id.editText_sc_n3_score1);
        n3_score1.addTextChangedListener(new GeneralTextWatcher(n3_score1));
        n3_score2 = (EditText)findViewById(R.id.editText_sc_n3_score2);
        n3_score2.addTextChangedListener(new GeneralTextWatcher(n3_score2));
        n3_score3 = (EditText)findViewById(R.id.editText_sc_n3_score3);
        n3_score3.addTextChangedListener(new GeneralTextWatcher(n3_score3));
        n3_score4 = (EditText)findViewById(R.id.editText_sc_n3_score4);
        n3_score4.addTextChangedListener(new GeneralTextWatcher(n3_score4));
        n3_score5 = (EditText)findViewById(R.id.editText_sc_n3_score5);
        n3_score5.addTextChangedListener(new GeneralTextWatcher(n3_score5));
        n3_score6 = (EditText)findViewById(R.id.editText_sc_n3_score6);
        n3_score6.addTextChangedListener(new GeneralTextWatcher(n3_score6));
        n3_score7 = (EditText)findViewById(R.id.editText_sc_n3_score7);
        n3_score7.addTextChangedListener(new GeneralTextWatcher(n3_score7));
        n3_score8 = (EditText)findViewById(R.id.editText_sc_n3_score8);
        n3_score8.addTextChangedListener(new GeneralTextWatcher(n3_score8));
        n3_score9 = (EditText)findViewById(R.id.editText_sc_n3_score9);
        n3_score9.addTextChangedListener(new GeneralTextWatcher(n3_score9));
        n3_score10 = (EditText)findViewById(R.id.editText_sc_n3_score10);
        n3_score10.addTextChangedListener(new GeneralTextWatcher(n3_score10));
        n3_score11 = (EditText)findViewById(R.id.editText_sc_n3_score11);
        n3_score11.addTextChangedListener(new GeneralTextWatcher(n3_score11));
        n3_score12 = (EditText)findViewById(R.id.editText_sc_n3_score12);
        n3_score12.addTextChangedListener(new GeneralTextWatcher(n3_score12));
        n3_score13 = (EditText)findViewById(R.id.editText_sc_n3_score13);
        n3_score13.addTextChangedListener(new GeneralTextWatcher(n3_score13));
        n3_score14 = (EditText)findViewById(R.id.editText_sc_n3_score14);
        n3_score14.addTextChangedListener(new GeneralTextWatcher(n3_score14));
        n3_score15 = (EditText)findViewById(R.id.editText_sc_n3_score15);
        n3_score15.addTextChangedListener(new GeneralTextWatcher(n3_score15));
        n3_score16 = (EditText)findViewById(R.id.editText_sc_n3_score16);
        n3_score16.addTextChangedListener(new GeneralTextWatcher(n3_score16));
        n3_score17 = (EditText)findViewById(R.id.editText_sc_n3_score17);
        n3_score17.addTextChangedListener(new GeneralTextWatcher(n3_score17));
        n3_score18 = (EditText)findViewById(R.id.editText_sc_n3_score18);
        n3_score18.addTextChangedListener(new GeneralTextWatcher(n3_score18));
        n4_score1 = (EditText)findViewById(R.id.editText_sc_n4_score1);
        n4_score1.addTextChangedListener(new GeneralTextWatcher(n4_score1));
        n4_score2 = (EditText)findViewById(R.id.editText_sc_n4_score2);
        n4_score2.addTextChangedListener(new GeneralTextWatcher(n4_score2));
        n4_score3 = (EditText)findViewById(R.id.editText_sc_n4_score3);
        n4_score3.addTextChangedListener(new GeneralTextWatcher(n4_score3));
        n4_score4 = (EditText)findViewById(R.id.editText_sc_n4_score4);
        n4_score4.addTextChangedListener(new GeneralTextWatcher(n4_score4));
        n4_score5 = (EditText)findViewById(R.id.editText_sc_n4_score5);
        n4_score5.addTextChangedListener(new GeneralTextWatcher(n4_score5));
        n4_score6 = (EditText)findViewById(R.id.editText_sc_n4_score6);
        n4_score6.addTextChangedListener(new GeneralTextWatcher(n4_score6));
        n4_score7 = (EditText)findViewById(R.id.editText_sc_n4_score7);
        n4_score7.addTextChangedListener(new GeneralTextWatcher(n4_score7));
        n4_score8 = (EditText)findViewById(R.id.editText_sc_n4_score8);
        n4_score8.addTextChangedListener(new GeneralTextWatcher(n4_score8));
        n4_score9 = (EditText)findViewById(R.id.editText_sc_n4_score9);
        n4_score9.addTextChangedListener(new GeneralTextWatcher(n4_score9));
        n4_score10 = (EditText)findViewById(R.id.editText_sc_n4_score10);
        n4_score10.addTextChangedListener(new GeneralTextWatcher(n4_score10));
        n4_score11 = (EditText)findViewById(R.id.editText_sc_n4_score11);
        n4_score11.addTextChangedListener(new GeneralTextWatcher(n4_score11));
        n4_score12 = (EditText)findViewById(R.id.editText_sc_n4_score12);
        n4_score12.addTextChangedListener(new GeneralTextWatcher(n4_score12));
        n4_score13 = (EditText)findViewById(R.id.editText_sc_n4_score13);
        n4_score13.addTextChangedListener(new GeneralTextWatcher(n4_score13));
        n4_score14 = (EditText)findViewById(R.id.editText_sc_n4_score14);
        n4_score14.addTextChangedListener(new GeneralTextWatcher(n4_score14));
        n4_score15 = (EditText)findViewById(R.id.editText_sc_n4_score15);
        n4_score15.addTextChangedListener(new GeneralTextWatcher(n4_score15));
        n4_score16 = (EditText)findViewById(R.id.editText_sc_n4_score16);
        n4_score16.addTextChangedListener(new GeneralTextWatcher(n4_score16));
        n4_score17 = (EditText)findViewById(R.id.editText_sc_n4_score17);
        n4_score17.addTextChangedListener(new GeneralTextWatcher(n4_score17));
        n4_score18 = (EditText)findViewById(R.id.editText_sc_n4_score18);
        n4_score18.addTextChangedListener(new GeneralTextWatcher(n4_score18));

        final SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this);

        name1 = (TextView)findViewById(R.id.textView_sc_name1);
        name1.setText(sharedpreferences.getString("user_name", ""));
        name2 = (EditText)findViewById(R.id.editText_sc_name2);
        name3 = (EditText)findViewById(R.id.editText_sc_name3);
        name4 = (EditText)findViewById(R.id.editText_sc_name4);

        if(savedInstanceState != null){
            name2.setText(savedInstanceState.getCharSequence("name2"));
            name3.setText(savedInstanceState.getCharSequence("name3"));
            name4.setText(savedInstanceState.getCharSequence("name4"));
            n1_score1.setText(savedInstanceState.getCharSequence("n1_score1"));
            n1_score2.setText(savedInstanceState.getCharSequence("n1_score2"));
            n1_score3.setText(savedInstanceState.getCharSequence("n1_score3"));
            n1_score4.setText(savedInstanceState.getCharSequence("n1_score4"));
            n1_score5.setText(savedInstanceState.getCharSequence("n1_score5"));
            n1_score6.setText(savedInstanceState.getCharSequence("n1_score6"));
            n1_score7.setText(savedInstanceState.getCharSequence("n1_score7"));
            n1_score8.setText(savedInstanceState.getCharSequence("n1_score8"));
            n1_score9.setText(savedInstanceState.getCharSequence("n1_score9"));
            n1_score10.setText(savedInstanceState.getCharSequence("n1_score10"));
            n1_score11.setText(savedInstanceState.getCharSequence("n1_score11"));
            n1_score12.setText(savedInstanceState.getCharSequence("n1_score12"));
            n1_score13.setText(savedInstanceState.getCharSequence("n1_score13"));
            n1_score14.setText(savedInstanceState.getCharSequence("n1_score14"));
            n1_score15.setText(savedInstanceState.getCharSequence("n1_score15"));
            n1_score16.setText(savedInstanceState.getCharSequence("n1_score16"));
            n1_score17.setText(savedInstanceState.getCharSequence("n1_score17"));
            n1_score18.setText(savedInstanceState.getCharSequence("n1_score18"));
            n2_score1.setText(savedInstanceState.getCharSequence("n2_score1"));
            n2_score2.setText(savedInstanceState.getCharSequence("n2_score2"));
            n2_score3.setText(savedInstanceState.getCharSequence("n2_score3"));
            n2_score4.setText(savedInstanceState.getCharSequence("n2_score4"));
            n2_score5.setText(savedInstanceState.getCharSequence("n2_score5"));
            n2_score6.setText(savedInstanceState.getCharSequence("n2_score6"));
            n2_score7.setText(savedInstanceState.getCharSequence("n2_score7"));
            n2_score8.setText(savedInstanceState.getCharSequence("n2_score8"));
            n2_score9.setText(savedInstanceState.getCharSequence("n2_score9"));
            n2_score10.setText(savedInstanceState.getCharSequence("n2_score10"));
            n2_score11.setText(savedInstanceState.getCharSequence("n2_score11"));
            n2_score12.setText(savedInstanceState.getCharSequence("n2_score12"));
            n2_score13.setText(savedInstanceState.getCharSequence("n2_score13"));
            n2_score14.setText(savedInstanceState.getCharSequence("n2_score14"));
            n2_score15.setText(savedInstanceState.getCharSequence("n2_score15"));
            n2_score16.setText(savedInstanceState.getCharSequence("n2_score16"));
            n2_score17.setText(savedInstanceState.getCharSequence("n2_score17"));
            n2_score18.setText(savedInstanceState.getCharSequence("n2_score18"));
            n3_score1.setText(savedInstanceState.getCharSequence("n3_score1"));
            n3_score2.setText(savedInstanceState.getCharSequence("n3_score2"));
            n3_score3.setText(savedInstanceState.getCharSequence("n3_score3"));
            n3_score4.setText(savedInstanceState.getCharSequence("n3_score4"));
            n3_score5.setText(savedInstanceState.getCharSequence("n3_score5"));
            n3_score6.setText(savedInstanceState.getCharSequence("n3_score6"));
            n3_score7.setText(savedInstanceState.getCharSequence("n3_score7"));
            n3_score8.setText(savedInstanceState.getCharSequence("n3_score8"));
            n3_score9.setText(savedInstanceState.getCharSequence("n3_score9"));
            n3_score10.setText(savedInstanceState.getCharSequence("n3_score10"));
            n3_score11.setText(savedInstanceState.getCharSequence("n3_score11"));
            n3_score12.setText(savedInstanceState.getCharSequence("n3_score12"));
            n3_score13.setText(savedInstanceState.getCharSequence("n3_score13"));
            n3_score14.setText(savedInstanceState.getCharSequence("n3_score14"));
            n3_score15.setText(savedInstanceState.getCharSequence("n3_score15"));
            n3_score16.setText(savedInstanceState.getCharSequence("n3_score16"));
            n3_score17.setText(savedInstanceState.getCharSequence("n3_score17"));
            n3_score18.setText(savedInstanceState.getCharSequence("n3_score18"));
            n4_score1.setText(savedInstanceState.getCharSequence("n4_score1"));
            n4_score2.setText(savedInstanceState.getCharSequence("n4_score2"));
            n4_score3.setText(savedInstanceState.getCharSequence("n4_score3"));
            n4_score4.setText(savedInstanceState.getCharSequence("n4_score4"));
            n4_score5.setText(savedInstanceState.getCharSequence("n4_score5"));
            n4_score6.setText(savedInstanceState.getCharSequence("n4_score6"));
            n4_score7.setText(savedInstanceState.getCharSequence("n4_score7"));
            n4_score8.setText(savedInstanceState.getCharSequence("n4_score8"));
            n4_score9.setText(savedInstanceState.getCharSequence("n4_score9"));
            n4_score10.setText(savedInstanceState.getCharSequence("n4_score10"));
            n4_score11.setText(savedInstanceState.getCharSequence("n4_score11"));
            n4_score12.setText(savedInstanceState.getCharSequence("n4_score12"));
            n4_score13.setText(savedInstanceState.getCharSequence("n4_score13"));
            n4_score14.setText(savedInstanceState.getCharSequence("n4_score14"));
            n4_score15.setText(savedInstanceState.getCharSequence("n4_score15"));
            n4_score16.setText(savedInstanceState.getCharSequence("n4_score16"));
            n4_score17.setText(savedInstanceState.getCharSequence("n4_score17"));
            n4_score18.setText(savedInstanceState.getCharSequence("n4_score18"));
        }

        final long newId = sharedpreferences.getLong("id", 0);
        Cursor cursor = myDB.getScorecardInfo(newId);

        if(cursor.moveToFirst()){
            do{
                template = cursor.getString(DBAdapter.COL_TEMPLATE);
                players = cursor.getString(DBAdapter.COL_PLAYERS);
                n1_sc1 = cursor.getString(DBAdapter.COL_N1_SC1);
                n1_sc2 = cursor.getString(DBAdapter.COL_N1_SC2);
                n1_sc3 = cursor.getString(DBAdapter.COL_N1_SC3);
                n1_sc4 = cursor.getString(DBAdapter.COL_N1_SC4);
                n1_sc5 = cursor.getString(DBAdapter.COL_N1_SC5);
                n1_sc6 = cursor.getString(DBAdapter.COL_N1_SC6);
                n1_sc7 = cursor.getString(DBAdapter.COL_N1_SC7);
                n1_sc8 = cursor.getString(DBAdapter.COL_N1_SC8);
                n1_sc9 = cursor.getString(DBAdapter.COL_N1_SC9);
                n1_sc10 = cursor.getString(DBAdapter.COL_N1_SC10);
                n1_sc11 = cursor.getString(DBAdapter.COL_N1_SC11);
                n1_sc12 = cursor.getString(DBAdapter.COL_N1_SC12);
                n1_sc13 = cursor.getString(DBAdapter.COL_N1_SC13);
                n1_sc14 = cursor.getString(DBAdapter.COL_N1_SC14);
                n1_sc15 = cursor.getString(DBAdapter.COL_N1_SC15);
                n1_sc16 = cursor.getString(DBAdapter.COL_N1_SC16);
                n1_sc17 = cursor.getString(DBAdapter.COL_N1_SC17);
                n1_sc18 = cursor.getString(DBAdapter.COL_N1_SC18);
                n2 = cursor.getString(DBAdapter.COL_N2);
                n2_sc1 = cursor.getString(DBAdapter.COL_N2_SC1);
                n2_sc2 = cursor.getString(DBAdapter.COL_N2_SC2);
                n2_sc3 = cursor.getString(DBAdapter.COL_N2_SC3);
                n2_sc4 = cursor.getString(DBAdapter.COL_N2_SC4);
                n2_sc5 = cursor.getString(DBAdapter.COL_N2_SC5);
                n2_sc6 = cursor.getString(DBAdapter.COL_N2_SC6);
                n2_sc7 = cursor.getString(DBAdapter.COL_N2_SC7);
                n2_sc8 = cursor.getString(DBAdapter.COL_N2_SC8);
                n2_sc9 = cursor.getString(DBAdapter.COL_N2_SC9);
                n2_sc10 = cursor.getString(DBAdapter.COL_N2_SC10);
                n2_sc11 = cursor.getString(DBAdapter.COL_N2_SC11);
                n2_sc12 = cursor.getString(DBAdapter.COL_N2_SC12);
                n2_sc13 = cursor.getString(DBAdapter.COL_N2_SC13);
                n2_sc14 = cursor.getString(DBAdapter.COL_N2_SC14);
                n2_sc15 = cursor.getString(DBAdapter.COL_N2_SC15);
                n2_sc16 = cursor.getString(DBAdapter.COL_N2_SC16);
                n2_sc17 = cursor.getString(DBAdapter.COL_N2_SC17);
                n2_sc18 = cursor.getString(DBAdapter.COL_N2_SC18);
                n3 = cursor.getString(DBAdapter.COL_N3);
                n3_sc1 = cursor.getString(DBAdapter.COL_N3_SC1);
                n3_sc2 = cursor.getString(DBAdapter.COL_N3_SC2);
                n3_sc3 = cursor.getString(DBAdapter.COL_N3_SC3);
                n3_sc4 = cursor.getString(DBAdapter.COL_N3_SC4);
                n3_sc5 = cursor.getString(DBAdapter.COL_N3_SC5);
                n3_sc6 = cursor.getString(DBAdapter.COL_N3_SC6);
                n3_sc7 = cursor.getString(DBAdapter.COL_N3_SC7);
                n3_sc8 = cursor.getString(DBAdapter.COL_N3_SC8);
                n3_sc9 = cursor.getString(DBAdapter.COL_N3_SC9);
                n3_sc10 = cursor.getString(DBAdapter.COL_N3_SC10);
                n3_sc11 = cursor.getString(DBAdapter.COL_N3_SC11);
                n3_sc12 = cursor.getString(DBAdapter.COL_N3_SC12);
                n3_sc13 = cursor.getString(DBAdapter.COL_N3_SC13);
                n3_sc14 = cursor.getString(DBAdapter.COL_N3_SC14);
                n3_sc15 = cursor.getString(DBAdapter.COL_N3_SC15);
                n3_sc16 = cursor.getString(DBAdapter.COL_N3_SC16);
                n3_sc17 = cursor.getString(DBAdapter.COL_N3_SC17);
                n3_sc18 = cursor.getString(DBAdapter.COL_N3_SC18);
                n4 = cursor.getString(DBAdapter.COL_N4);
                n4_sc1 = cursor.getString(DBAdapter.COL_N4_SC1);
                n4_sc2 = cursor.getString(DBAdapter.COL_N4_SC2);
                n4_sc3 = cursor.getString(DBAdapter.COL_N4_SC3);
                n4_sc4 = cursor.getString(DBAdapter.COL_N4_SC4);
                n4_sc5 = cursor.getString(DBAdapter.COL_N4_SC5);
                n4_sc6 = cursor.getString(DBAdapter.COL_N4_SC6);
                n4_sc7 = cursor.getString(DBAdapter.COL_N4_SC7);
                n4_sc8 = cursor.getString(DBAdapter.COL_N4_SC8);
                n4_sc9 = cursor.getString(DBAdapter.COL_N4_SC9);
                n4_sc10 = cursor.getString(DBAdapter.COL_N4_SC10);
                n4_sc11 = cursor.getString(DBAdapter.COL_N4_SC11);
                n4_sc12 = cursor.getString(DBAdapter.COL_N4_SC12);
                n4_sc13 = cursor.getString(DBAdapter.COL_N4_SC13);
                n4_sc14 = cursor.getString(DBAdapter.COL_N4_SC14);
                n4_sc15 = cursor.getString(DBAdapter.COL_N4_SC15);
                n4_sc16 = cursor.getString(DBAdapter.COL_N4_SC16);
                n4_sc17 = cursor.getString(DBAdapter.COL_N4_SC17);
                n4_sc18 = cursor.getString(DBAdapter.COL_N4_SC18);




            }while(cursor.moveToNext());
        }

        if (!(template.equals("Blank Template"))){
            name.setText(template);

            Cursor cursor2 = myDB.getParYardageInfo(template.substring(0,template.length()-1));

            if(cursor2.moveToFirst()){
                do{
                    y1 = cursor2.getString(DBAdapter.COL_YARD1);
                    y2 = cursor2.getString(DBAdapter.COL_YARD2);
                    y3 = cursor2.getString(DBAdapter.COL_YARD3);
                    y4 = cursor2.getString(DBAdapter.COL_YARD4);
                    y5 = cursor2.getString(DBAdapter.COL_YARD5);
                    y6 = cursor2.getString(DBAdapter.COL_YARD6);
                    y7 = cursor2.getString(DBAdapter.COL_YARD7);
                    y8 = cursor2.getString(DBAdapter.COL_YARD8);
                    y9 = cursor2.getString(DBAdapter.COL_YARD9);
                    y10 = cursor2.getString(DBAdapter.COL_YARD10);
                    y11 = cursor2.getString(DBAdapter.COL_YARD11);
                    y12 = cursor2.getString(DBAdapter.COL_YARD12);
                    y13 = cursor2.getString(DBAdapter.COL_YARD13);
                    y14 = cursor2.getString(DBAdapter.COL_YARD14);
                    y15 = cursor2.getString(DBAdapter.COL_YARD15);
                    y16 = cursor2.getString(DBAdapter.COL_YARD16);
                    y17 = cursor2.getString(DBAdapter.COL_YARD17);
                    y18 = cursor2.getString(DBAdapter.COL_YARD18);
                    p1 = cursor2.getString(DBAdapter.COL_PAR1);
                    p2 = cursor2.getString(DBAdapter.COL_PAR2);
                    p3 = cursor2.getString(DBAdapter.COL_PAR3);
                    p4 = cursor2.getString(DBAdapter.COL_PAR4);
                    p5 = cursor2.getString(DBAdapter.COL_PAR5);
                    p6 = cursor2.getString(DBAdapter.COL_PAR6);
                    p7 = cursor2.getString(DBAdapter.COL_PAR7);
                    p8 = cursor2.getString(DBAdapter.COL_PAR8);
                    p9 = cursor2.getString(DBAdapter.COL_PAR9);
                    p10 = cursor2.getString(DBAdapter.COL_PAR10);
                    p11 = cursor2.getString(DBAdapter.COL_PAR11);
                    p12 = cursor2.getString(DBAdapter.COL_PAR12);
                    p13 = cursor2.getString(DBAdapter.COL_PAR13);
                    p14 = cursor2.getString(DBAdapter.COL_PAR14);
                    p15 = cursor2.getString(DBAdapter.COL_PAR15);
                    p16 = cursor2.getString(DBAdapter.COL_PAR16);
                    p17 = cursor2.getString(DBAdapter.COL_PAR17);
                    p18 = cursor2.getString(DBAdapter.COL_PAR18);

                }while(cursor2.moveToNext());
            }
        }
        else{
            layout_main.removeView(layout_name);
        }
        if (players.equals("1")){
            ((ViewManager)layout_n2.getParent()).removeView(layout_n2);
            ((ViewManager)layout_n3.getParent()).removeView(layout_n3);
            ((ViewManager)layout_n4.getParent()).removeView(layout_n4);
        }
        else if(players.equals("2")){
            ((ViewManager)layout_n3.getParent()).removeView(layout_n3);
            ((ViewManager)layout_n4.getParent()).removeView(layout_n4);
        }
        else if(players.equals("3")){
            ((ViewManager)layout_n4.getParent()).removeView(layout_n4);
        }

        par1.setText(p1);
        par2.setText(p2);
        par3.setText(p3);
        par4.setText(p4);
        par5.setText(p5);
        par6.setText(p6);
        par7.setText(p7);
        par8.setText(p8);
        par9.setText(p9);
        par10.setText(p10);
        par11.setText(p11);
        par12.setText(p12);
        par13.setText(p13);
        par14.setText(p14);
        par15.setText(p15);
        par16.setText(p16);
        par17.setText(p17);
        par18.setText(p18);
        yard1.setText(y1);
        yard2.setText(y2);
        yard3.setText(y3);
        yard4.setText(y4);
        yard5.setText(y5);
        yard6.setText(y6);
        yard7.setText(y7);
        yard8.setText(y8);
        yard9.setText(y9);
        yard10.setText(y10);
        yard11.setText(y11);
        yard12.setText(y12);
        yard13.setText(y13);
        yard14.setText(y14);
        yard15.setText(y15);
        yard16.setText(y16);
        yard17.setText(y17);
        yard18.setText(y18);
        n1_score1.setText(n1_sc1);
        n1_score2.setText(n1_sc2);
        n1_score3.setText(n1_sc3);
        n1_score4.setText(n1_sc4);
        n1_score5.setText(n1_sc5);
        n1_score6.setText(n1_sc6);
        n1_score7.setText(n1_sc7);
        n1_score8.setText(n1_sc8);
        n1_score9.setText(n1_sc9);
        n1_score10.setText(n1_sc10);
        n1_score11.setText(n1_sc11);
        n1_score12.setText(n1_sc12);
        n1_score13.setText(n1_sc13);
        n1_score14.setText(n1_sc14);
        n1_score15.setText(n1_sc15);
        n1_score16.setText(n1_sc16);
        n1_score17.setText(n1_sc17);
        n1_score18.setText(n1_sc18);
        name2.setText(n2);
        n2_score1.setText(n2_sc1);
        n2_score2.setText(n2_sc2);
        n2_score3.setText(n2_sc3);
        n2_score4.setText(n2_sc4);
        n2_score5.setText(n2_sc5);
        n2_score6.setText(n2_sc6);
        n2_score7.setText(n2_sc7);
        n2_score8.setText(n2_sc8);
        n2_score9.setText(n2_sc9);
        n2_score10.setText(n2_sc10);
        n2_score11.setText(n2_sc11);
        n2_score12.setText(n2_sc12);
        n2_score13.setText(n2_sc13);
        n2_score14.setText(n2_sc14);
        n2_score15.setText(n2_sc15);
        n2_score16.setText(n2_sc16);
        n2_score17.setText(n2_sc17);
        n2_score18.setText(n2_sc18);
        name3.setText(n3);
        n3_score1.setText(n3_sc1);
        n3_score2.setText(n3_sc2);
        n3_score3.setText(n3_sc3);
        n3_score4.setText(n3_sc4);
        n3_score5.setText(n3_sc5);
        n3_score6.setText(n3_sc6);
        n3_score7.setText(n3_sc7);
        n3_score8.setText(n3_sc8);
        n3_score9.setText(n3_sc9);
        n3_score10.setText(n3_sc10);
        n3_score11.setText(n3_sc11);
        n3_score12.setText(n3_sc12);
        n3_score13.setText(n3_sc13);
        n3_score14.setText(n3_sc14);
        n3_score15.setText(n3_sc15);
        n3_score16.setText(n3_sc16);
        n3_score17.setText(n3_sc17);
        n3_score18.setText(n3_sc18);
        name4.setText(n4);
        n4_score1.setText(n4_sc1);
        n4_score2.setText(n4_sc2);
        n4_score3.setText(n4_sc3);
        n4_score4.setText(n4_sc4);
        n4_score5.setText(n4_sc5);
        n4_score6.setText(n4_sc6);
        n4_score7.setText(n4_sc7);
        n4_score8.setText(n4_sc8);
        n4_score9.setText(n4_sc9);
        n4_score10.setText(n4_sc10);
        n4_score11.setText(n4_sc11);
        n4_score12.setText(n4_sc12);
        n4_score13.setText(n4_sc13);
        n4_score14.setText(n4_sc14);
        n4_score15.setText(n4_sc15);
        n4_score16.setText(n4_sc16);
        n4_score17.setText(n4_sc17);
        n4_score18.setText(n4_sc18);

        int par_front_calc = 0;
        int par_back_calc = 0;
        int yard_front_calc = 0;
        int yard_back_calc = 0;

        if(par1.length() > 0 && par2.length() > 0 && par3.length() > 0 && par4.length() > 0 && par5.length() > 0 && par6.length() > 0 && par7.length() > 0 && par8.length() > 0 && par9.length() > 0){
            par_front_calc = Integer.parseInt(par1.getText().toString()) + Integer.parseInt(par2.getText().toString()) + Integer.parseInt(par3.getText().toString()) + Integer.parseInt(par4.getText().toString()) + Integer.parseInt(par5.getText().toString()) + Integer.parseInt(par6.getText().toString()) + Integer.parseInt(par7.getText().toString()) + Integer.parseInt(par8.getText().toString()) + Integer.parseInt(par9.getText().toString());

            par_front_total.setText(String.valueOf(par_front_calc));
        }
        if(par10.length() > 0 && par11.length() > 0 && par12.length() > 0 && par13.length() > 0 && par14.length() > 0 && par15.length() > 0 && par16.length() > 0 && par17.length() > 0 && par18.length() > 0){
            par_back_calc = Integer.parseInt(par10.getText().toString()) + Integer.parseInt(par11.getText().toString()) + Integer.parseInt(par12.getText().toString()) + Integer.parseInt(par13.getText().toString()) + Integer.parseInt(par14.getText().toString()) + Integer.parseInt(par15.getText().toString()) + Integer.parseInt(par16.getText().toString()) + Integer.parseInt(par17.getText().toString()) + Integer.parseInt(par18.getText().toString());

            par_back_total.setText(String.valueOf(par_back_calc));
        }
        if(par_front_calc != 0 && par_back_calc != 0){
            par_total.setText(String.valueOf(par_front_calc + par_back_calc));
        }

        if(yard1.length() > 0 && yard2.length() > 0 && yard3.length() > 0 && yard4.length() > 0 && yard5.length() > 0 && yard6.length() > 0 && yard7.length() > 0 && yard8.length() > 0 && yard9.length() > 0){
            yard_front_calc = Integer.parseInt(yard1.getText().toString()) + Integer.parseInt(yard2.getText().toString()) + Integer.parseInt(yard3.getText().toString()) + Integer.parseInt(yard4.getText().toString()) + Integer.parseInt(yard5.getText().toString()) + Integer.parseInt(yard6.getText().toString()) + Integer.parseInt(yard7.getText().toString()) + Integer.parseInt(yard8.getText().toString()) + Integer.parseInt(yard9.getText().toString());

            yard_front_total.setText(String.valueOf(yard_front_calc));
        }
        if(yard10.length() > 0 && yard11.length() > 0 && yard12.length() > 0 && yard13.length() > 0 && yard14.length() > 0 && yard15.length() > 0 && yard16.length() > 0 && yard17.length() > 0 && yard18.length() > 0){
            yard_back_calc = Integer.parseInt(yard10.getText().toString()) + Integer.parseInt(yard11.getText().toString()) + Integer.parseInt(yard12.getText().toString()) + Integer.parseInt(yard13.getText().toString()) + Integer.parseInt(yard14.getText().toString()) + Integer.parseInt(yard15.getText().toString()) + Integer.parseInt(yard16.getText().toString()) + Integer.parseInt(yard17.getText().toString()) + Integer.parseInt(yard18.getText().toString());

            yard_back_total.setText(String.valueOf(yard_back_calc));
        }
        if(yard_front_calc != 0 && yard_back_calc != 0){
            yard_total.setText(String.valueOf(yard_front_calc + yard_back_calc));
        }

        if(p1 == null && p2 == null && p3 == null && p4 == null && p5 == null && p6 == null && p7 == null && p8 == null && p9 == null && p10 == null && p11 == null && p12 == null && p13 == null && p14 == null && p15 == null && p16 == null && p17 == null && p18 == null){
            ((ViewManager)layout_par.getParent()).removeView(layout_par);
        }
        else if(p1.equals("") && p2.equals("") && p3.equals("") && p4.equals("") && p5.equals("") && p6.equals("") && p7.equals("") && p8.equals("") && p9.equals("") && p10.equals("") && p11.equals("") && p12.equals("") && p13.equals("") && p14.equals("") && p15.equals("") && p16.equals("") && p17.equals("") && p18.equals("")){
            ((ViewManager)layout_par.getParent()).removeView(layout_par);

        }
        if(y1 == null && y2 == null && y3 == null && y4 == null && y5 == null && y6 == null && y7 == null && y8 == null && y9 == null && y10 == null && y11 == null && y12 == null && y13 == null && y14 == null && y15 == null && y16 == null && y17 == null && y18 == null){
            ((ViewManager)layout_yardage.getParent()).removeView(layout_yardage);
        }
        else if(y1.equals("") && y2.equals("") && y3.equals("") && y4.equals("") && y5.equals("") && y6.equals("") && y7.equals("") && y8.equals("") && y9.equals("") && y10.equals("") && y11.equals("") && y12.equals("") && y13.equals("") && y14.equals("") && y15.equals("") && y16.equals("") && y17.equals("") && y18.equals("")){
            ((ViewManager)layout_yardage.getParent()).removeView(layout_yardage);
        }



        Button cancel = (Button)findViewById(R.id.button_cancel_scorecard);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button save = (Button)findViewById(R.id.button_save_scorecard);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1_sc1 = n1_score1.getText().toString();
                n1_sc2 = n1_score2.getText().toString();
                n1_sc3 = n1_score3.getText().toString();
                n1_sc4 = n1_score4.getText().toString();
                n1_sc5 = n1_score5.getText().toString();
                n1_sc6 = n1_score6.getText().toString();
                n1_sc7 = n1_score7.getText().toString();
                n1_sc8 = n1_score8.getText().toString();
                n1_sc9 = n1_score9.getText().toString();
                n1_sc10 = n1_score10.getText().toString();
                n1_sc11 = n1_score11.getText().toString();
                n1_sc12 = n1_score12.getText().toString();
                n1_sc13 = n1_score13.getText().toString();
                n1_sc14 = n1_score14.getText().toString();
                n1_sc15 = n1_score15.getText().toString();
                n1_sc16 = n1_score16.getText().toString();
                n1_sc17 = n1_score17.getText().toString();
                n1_sc18 = n1_score18.getText().toString();
                n2 = name2.getText().toString();
                n2_sc1 = n2_score1.getText().toString();
                n2_sc2 = n2_score2.getText().toString();
                n2_sc3 = n2_score3.getText().toString();
                n2_sc4 = n2_score4.getText().toString();
                n2_sc5 = n2_score5.getText().toString();
                n2_sc6 = n2_score6.getText().toString();
                n2_sc7 = n2_score7.getText().toString();
                n2_sc8 = n2_score8.getText().toString();
                n2_sc9 = n2_score9.getText().toString();
                n2_sc10 = n2_score10.getText().toString();
                n2_sc11 = n2_score11.getText().toString();
                n2_sc12 = n2_score12.getText().toString();
                n2_sc13 = n2_score13.getText().toString();
                n2_sc14 = n2_score14.getText().toString();
                n2_sc15 = n2_score15.getText().toString();
                n2_sc16 = n2_score16.getText().toString();
                n2_sc17 = n2_score17.getText().toString();
                n2_sc18 = n2_score18.getText().toString();
                n3 = name3.getText().toString();
                n3_sc1 = n3_score1.getText().toString();
                n3_sc2 = n3_score2.getText().toString();
                n3_sc3 = n3_score3.getText().toString();
                n3_sc4 = n3_score4.getText().toString();
                n3_sc5 = n3_score5.getText().toString();
                n3_sc6 = n3_score6.getText().toString();
                n3_sc7 = n3_score7.getText().toString();
                n3_sc8 = n3_score8.getText().toString();
                n3_sc9 = n3_score9.getText().toString();
                n3_sc10 = n3_score10.getText().toString();
                n3_sc11 = n3_score11.getText().toString();
                n3_sc12 = n3_score12.getText().toString();
                n3_sc13 = n3_score13.getText().toString();
                n3_sc14 = n3_score14.getText().toString();
                n3_sc15 = n3_score15.getText().toString();
                n3_sc16 = n3_score16.getText().toString();
                n3_sc17 = n3_score17.getText().toString();
                n3_sc18 = n3_score18.getText().toString();
                n4 = name4.getText().toString();
                n4_sc1 = n4_score1.getText().toString();
                n4_sc2 = n4_score2.getText().toString();
                n4_sc3 = n4_score3.getText().toString();
                n4_sc4 = n4_score4.getText().toString();
                n4_sc5 = n4_score5.getText().toString();
                n4_sc6 = n4_score6.getText().toString();
                n4_sc7 = n4_score7.getText().toString();
                n4_sc8 = n4_score8.getText().toString();
                n4_sc9 = n4_score9.getText().toString();
                n4_sc10 = n4_score10.getText().toString();
                n4_sc11 = n4_score11.getText().toString();
                n4_sc12 = n4_score12.getText().toString();
                n4_sc13 = n4_score13.getText().toString();
                n4_sc14 = n4_score14.getText().toString();
                n4_sc15 = n4_score15.getText().toString();
                n4_sc16 = n4_score16.getText().toString();
                n4_sc17 = n4_score17.getText().toString();
                n4_sc18 = n4_score18.getText().toString();

                myDB.updateRow2(newId,template,players,n1_sc1,n1_sc2,n1_sc3,n1_sc4,n1_sc5,n1_sc6,n1_sc7,n1_sc8,n1_sc9,n1_sc10,n1_sc11,n1_sc12,n1_sc13,n1_sc14,n1_sc15,n1_sc16,n1_sc17,n1_sc18,
                        n2_sc1,n2_sc2,n2_sc3,n2_sc4,n2_sc5,n2_sc6,n2_sc7,n2_sc8,n2_sc9,n2_sc10,n2_sc11,n2_sc12,n2_sc13,n2_sc14,n2_sc15,n2_sc16,n2_sc17,n2_sc18,
                        n3_sc1,n3_sc2,n3_sc3,n3_sc4,n3_sc5,n3_sc6,n3_sc7,n3_sc8,n3_sc9,n3_sc10,n3_sc11,n3_sc12,n3_sc13,n3_sc14,n3_sc15,n3_sc16,n3_sc17,n3_sc18,
                        n4_sc1,n4_sc2,n4_sc3,n4_sc4,n4_sc5,n4_sc6,n4_sc7,n4_sc8,n4_sc9,n4_sc10,n4_sc11,n4_sc12,n4_sc13,n4_sc14,n4_sc15,n4_sc16,n4_sc17,n4_sc18,
                        n2, n3, n4);
                finish();
            }
        });

        cursor.close();


    }

    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putCharSequence("name2", name2.getText());
        outState.putCharSequence("name3", name3.getText());
        outState.putCharSequence("name4", name4.getText());
        outState.putCharSequence("n1_score1", n1_score1.getText());
        outState.putCharSequence("n1_score2", n1_score2.getText());
        outState.putCharSequence("n1_score3", n1_score3.getText());
        outState.putCharSequence("n1_score4", n1_score4.getText());
        outState.putCharSequence("n1_score5", n1_score5.getText());
        outState.putCharSequence("n1_score6", n1_score6.getText());
        outState.putCharSequence("n1_score7", n1_score7.getText());
        outState.putCharSequence("n1_score8", n1_score8.getText());
        outState.putCharSequence("n1_score9", n1_score9.getText());
        outState.putCharSequence("n1_score10", n1_score10.getText());
        outState.putCharSequence("n1_score11", n1_score11.getText());
        outState.putCharSequence("n1_score12", n1_score12.getText());
        outState.putCharSequence("n1_score13", n1_score13.getText());
        outState.putCharSequence("n1_score14", n1_score14.getText());
        outState.putCharSequence("n1_score15", n1_score15.getText());
        outState.putCharSequence("n1_score16", n1_score16.getText());
        outState.putCharSequence("n1_score17", n1_score17.getText());
        outState.putCharSequence("n1_score18", n1_score18.getText());
        outState.putCharSequence("n2_score1", n2_score1.getText());
        outState.putCharSequence("n2_score2", n2_score2.getText());
        outState.putCharSequence("n2_score3", n2_score3.getText());
        outState.putCharSequence("n2_score4", n2_score4.getText());
        outState.putCharSequence("n2_score5", n2_score5.getText());
        outState.putCharSequence("n2_score6", n2_score6.getText());
        outState.putCharSequence("n2_score7", n2_score7.getText());
        outState.putCharSequence("n2_score8", n2_score8.getText());
        outState.putCharSequence("n2_score9", n2_score9.getText());
        outState.putCharSequence("n2_score10", n2_score10.getText());
        outState.putCharSequence("n2_score11", n2_score11.getText());
        outState.putCharSequence("n2_score12", n2_score12.getText());
        outState.putCharSequence("n2_score13", n2_score13.getText());
        outState.putCharSequence("n2_score14", n2_score14.getText());
        outState.putCharSequence("n2_score15", n2_score15.getText());
        outState.putCharSequence("n2_score16", n2_score16.getText());
        outState.putCharSequence("n2_score17", n2_score17.getText());
        outState.putCharSequence("n2_score18", n2_score18.getText());
        outState.putCharSequence("n3_score1", n3_score1.getText());
        outState.putCharSequence("n3_score2", n3_score2.getText());
        outState.putCharSequence("n3_score3", n3_score3.getText());
        outState.putCharSequence("n3_score4", n3_score4.getText());
        outState.putCharSequence("n3_score5", n3_score5.getText());
        outState.putCharSequence("n3_score6", n3_score6.getText());
        outState.putCharSequence("n3_score7", n3_score7.getText());
        outState.putCharSequence("n3_score8", n3_score8.getText());
        outState.putCharSequence("n3_score9", n3_score9.getText());
        outState.putCharSequence("n3_score10", n3_score10.getText());
        outState.putCharSequence("n3_score11", n3_score11.getText());
        outState.putCharSequence("n3_score12", n3_score12.getText());
        outState.putCharSequence("n3_score13", n3_score13.getText());
        outState.putCharSequence("n3_score14", n3_score14.getText());
        outState.putCharSequence("n3_score15", n3_score15.getText());
        outState.putCharSequence("n3_score16", n3_score16.getText());
        outState.putCharSequence("n3_score17", n3_score17.getText());
        outState.putCharSequence("n3_score18", n3_score18.getText());
        outState.putCharSequence("n4_score1", n4_score1.getText());
        outState.putCharSequence("n4_score2", n4_score2.getText());
        outState.putCharSequence("n4_score3", n4_score3.getText());
        outState.putCharSequence("n4_score4", n4_score4.getText());
        outState.putCharSequence("n4_score5", n4_score5.getText());
        outState.putCharSequence("n4_score6", n4_score6.getText());
        outState.putCharSequence("n4_score7", n4_score7.getText());
        outState.putCharSequence("n4_score8", n4_score8.getText());
        outState.putCharSequence("n4_score9", n4_score9.getText());
        outState.putCharSequence("n4_score10", n4_score10.getText());
        outState.putCharSequence("n4_score11", n4_score11.getText());
        outState.putCharSequence("n4_score12", n4_score12.getText());
        outState.putCharSequence("n4_score13", n4_score13.getText());
        outState.putCharSequence("n4_score14", n4_score14.getText());
        outState.putCharSequence("n4_score15", n4_score15.getText());
        outState.putCharSequence("n4_score16", n4_score16.getText());
        outState.putCharSequence("n4_score17", n4_score17.getText());
        outState.putCharSequence("n4_score18", n4_score18.getText());
    }

    private void openDB() {
        myDB = new DBAdapter(this);
        myDB.open();
    }

    private void closeDB(){
        myDB.close();
    }

    public class Scorecard_Totals extends AsyncTask<Integer, String, Integer>{

        Handler handler = new Handler();

        public Scorecard_Totals() {
            super();
        }

        @Override
        protected Integer doInBackground(Integer... params) {

            handler.post(runnable);

            return null;
        }

        private Runnable runnable = new Runnable() {
            @Override
            public void run() {

                final EditText n1_score1 = (EditText) findViewById(R.id.editText_sc_n1_score1);
                final EditText n1_score2 = (EditText)findViewById(R.id.editText_sc_n1_score2);
                final EditText n1_score3 = (EditText)findViewById(R.id.editText_sc_n1_score3);
                final EditText n1_score4 = (EditText)findViewById(R.id.editText_sc_n1_score4);
                final EditText n1_score5 = (EditText)findViewById(R.id.editText_sc_n1_score5);
                final EditText n1_score6 = (EditText)findViewById(R.id.editText_sc_n1_score6);
                final EditText n1_score7 = (EditText)findViewById(R.id.editText_sc_n1_score7);
                final EditText n1_score8 = (EditText)findViewById(R.id.editText_sc_n1_score8);
                final EditText n1_score9 = (EditText)findViewById(R.id.editText_sc_n1_score9);
                final EditText n1_score10 = (EditText)findViewById(R.id.editText_sc_n1_score10);
                final EditText n1_score11 = (EditText)findViewById(R.id.editText_sc_n1_score11);
                final EditText n1_score12 = (EditText)findViewById(R.id.editText_sc_n1_score12);
                final EditText n1_score13 = (EditText)findViewById(R.id.editText_sc_n1_score13);
                final EditText n1_score14 = (EditText)findViewById(R.id.editText_sc_n1_score14);
                final EditText n1_score15 = (EditText)findViewById(R.id.editText_sc_n1_score15);
                final EditText n1_score16 = (EditText)findViewById(R.id.editText_sc_n1_score16);
                final EditText n1_score17 = (EditText)findViewById(R.id.editText_sc_n1_score17);
                final EditText n1_score18 = (EditText)findViewById(R.id.editText_sc_n1_score18);
                final TextView name1_front_total = (TextView) findViewById(R.id.textView_sc_n1_front_total);
                final TextView name1_back_total = (TextView) findViewById(R.id.textView_sc_n1_back_total);
                final TextView name1_total = (TextView) findViewById(R.id.textView_sc_n1_total);
                final EditText n2_score1 = (EditText) findViewById(R.id.editText_sc_n2_score1);
                final EditText n2_score2 = (EditText)findViewById(R.id.editText_sc_n2_score2);
                final EditText n2_score3 = (EditText)findViewById(R.id.editText_sc_n2_score3);
                final EditText n2_score4 = (EditText)findViewById(R.id.editText_sc_n2_score4);
                final EditText n2_score5 = (EditText)findViewById(R.id.editText_sc_n2_score5);
                final EditText n2_score6 = (EditText)findViewById(R.id.editText_sc_n2_score6);
                final EditText n2_score7 = (EditText)findViewById(R.id.editText_sc_n2_score7);
                final EditText n2_score8 = (EditText)findViewById(R.id.editText_sc_n2_score8);
                final EditText n2_score9 = (EditText)findViewById(R.id.editText_sc_n2_score9);
                final EditText n2_score10 = (EditText)findViewById(R.id.editText_sc_n2_score10);
                final EditText n2_score11 = (EditText)findViewById(R.id.editText_sc_n2_score11);
                final EditText n2_score12 = (EditText)findViewById(R.id.editText_sc_n2_score12);
                final EditText n2_score13 = (EditText)findViewById(R.id.editText_sc_n2_score13);
                final EditText n2_score14 = (EditText)findViewById(R.id.editText_sc_n2_score14);
                final EditText n2_score15 = (EditText)findViewById(R.id.editText_sc_n2_score15);
                final EditText n2_score16 = (EditText)findViewById(R.id.editText_sc_n2_score16);
                final EditText n2_score17 = (EditText)findViewById(R.id.editText_sc_n2_score17);
                final EditText n2_score18 = (EditText)findViewById(R.id.editText_sc_n2_score18);
                final TextView name2_front_total = (TextView) findViewById(R.id.textView_sc_n2_front_total);
                final TextView name2_back_total = (TextView) findViewById(R.id.textView_sc_n2_back_total);
                final TextView name2_total = (TextView) findViewById(R.id.textView_sc_n2_total);
                final EditText n3_score1 = (EditText) findViewById(R.id.editText_sc_n3_score1);
                final EditText n3_score2 = (EditText)findViewById(R.id.editText_sc_n3_score2);
                final EditText n3_score3 = (EditText)findViewById(R.id.editText_sc_n3_score3);
                final EditText n3_score4 = (EditText)findViewById(R.id.editText_sc_n3_score4);
                final EditText n3_score5 = (EditText)findViewById(R.id.editText_sc_n3_score5);
                final EditText n3_score6 = (EditText)findViewById(R.id.editText_sc_n3_score6);
                final EditText n3_score7 = (EditText)findViewById(R.id.editText_sc_n3_score7);
                final EditText n3_score8 = (EditText)findViewById(R.id.editText_sc_n3_score8);
                final EditText n3_score9 = (EditText)findViewById(R.id.editText_sc_n3_score9);
                final EditText n3_score10 = (EditText)findViewById(R.id.editText_sc_n3_score10);
                final EditText n3_score11 = (EditText)findViewById(R.id.editText_sc_n3_score11);
                final EditText n3_score12 = (EditText)findViewById(R.id.editText_sc_n3_score12);
                final EditText n3_score13 = (EditText)findViewById(R.id.editText_sc_n3_score13);
                final EditText n3_score14 = (EditText)findViewById(R.id.editText_sc_n3_score14);
                final EditText n3_score15 = (EditText)findViewById(R.id.editText_sc_n3_score15);
                final EditText n3_score16 = (EditText)findViewById(R.id.editText_sc_n3_score16);
                final EditText n3_score17 = (EditText)findViewById(R.id.editText_sc_n3_score17);
                final EditText n3_score18 = (EditText)findViewById(R.id.editText_sc_n3_score18);
                final TextView name3_front_total = (TextView) findViewById(R.id.textView_sc_n3_front_total);
                final TextView name3_back_total = (TextView) findViewById(R.id.textView_sc_n3_back_total);
                final TextView name3_total = (TextView) findViewById(R.id.textView_sc_n3_total);
                final EditText n4_score1 = (EditText) findViewById(R.id.editText_sc_n4_score1);
                final EditText n4_score2 = (EditText)findViewById(R.id.editText_sc_n4_score2);
                final EditText n4_score3 = (EditText)findViewById(R.id.editText_sc_n4_score3);
                final EditText n4_score4 = (EditText)findViewById(R.id.editText_sc_n4_score4);
                final EditText n4_score5 = (EditText)findViewById(R.id.editText_sc_n4_score5);
                final EditText n4_score6 = (EditText)findViewById(R.id.editText_sc_n4_score6);
                final EditText n4_score7 = (EditText)findViewById(R.id.editText_sc_n4_score7);
                final EditText n4_score8 = (EditText)findViewById(R.id.editText_sc_n4_score8);
                final EditText n4_score9 = (EditText)findViewById(R.id.editText_sc_n4_score9);
                final EditText n4_score10 = (EditText)findViewById(R.id.editText_sc_n4_score10);
                final EditText n4_score11 = (EditText)findViewById(R.id.editText_sc_n4_score11);
                final EditText n4_score12 = (EditText)findViewById(R.id.editText_sc_n4_score12);
                final EditText n4_score13 = (EditText)findViewById(R.id.editText_sc_n4_score13);
                final EditText n4_score14 = (EditText)findViewById(R.id.editText_sc_n4_score14);
                final EditText n4_score15 = (EditText)findViewById(R.id.editText_sc_n4_score15);
                final EditText n4_score16 = (EditText)findViewById(R.id.editText_sc_n4_score16);
                final EditText n4_score17 = (EditText)findViewById(R.id.editText_sc_n4_score17);
                final EditText n4_score18 = (EditText)findViewById(R.id.editText_sc_n4_score18);
                final TextView name4_front_total = (TextView) findViewById(R.id.textView_sc_n4_front_total);
                final TextView name4_back_total = (TextView) findViewById(R.id.textView_sc_n4_back_total);
                final TextView name4_total = (TextView) findViewById(R.id.textView_sc_n4_total);


                int front_calc = 0;
                int back_calc = 0;
                int front_calc2 = 0;
                int back_calc2 = 0;
                int front_calc3 = 0;
                int back_calc3 = 0;
                int front_calc4 = 0;
                int back_calc4 = 0;

                if(n1_score1.length() > 0 && n1_score2.length() > 0 && n1_score3.length() > 0 && n1_score4.length() > 0 && n1_score5.length() > 0 && n1_score6.length() > 0 && n1_score7.length() > 0 && n1_score8.length() > 0 && n1_score9.length() > 0){
                    front_calc = Integer.parseInt(n1_score1.getText().toString()) + Integer.parseInt(n1_score2.getText().toString()) + Integer.parseInt(n1_score3.getText().toString()) + Integer.parseInt(n1_score4.getText().toString()) + Integer.parseInt(n1_score5.getText().toString()) + Integer.parseInt(n1_score6.getText().toString()) + Integer.parseInt(n1_score7.getText().toString()) + Integer.parseInt(n1_score8.getText().toString()) + Integer.parseInt(n1_score9.getText().toString());

                    name1_front_total.setText(String.valueOf(front_calc));
                }
                if(n1_score10.length() > 0 && n1_score11.length() > 0 && n1_score12.length() > 0 && n1_score13.length() > 0 && n1_score14.length() > 0 && n1_score15.length() > 0 && n1_score16.length() > 0 && n1_score17.length() > 0 && n1_score18.length() > 0){
                    back_calc = Integer.parseInt(n1_score10.getText().toString()) + Integer.parseInt(n1_score11.getText().toString()) + Integer.parseInt(n1_score12.getText().toString()) + Integer.parseInt(n1_score13.getText().toString()) + Integer.parseInt(n1_score14.getText().toString()) + Integer.parseInt(n1_score15.getText().toString()) + Integer.parseInt(n1_score16.getText().toString()) + Integer.parseInt(n1_score17.getText().toString()) + Integer.parseInt(n1_score18.getText().toString());

                    name1_back_total.setText(String.valueOf(back_calc));
                }
                if(front_calc != 0 && back_calc != 0){
                    name1_total.setText(String.valueOf(front_calc + back_calc));
                }

                if (Integer.valueOf(players) >= 2) {
                    if (n2_score1.length() > 0 && n2_score2.length() > 0 && n2_score3.length() > 0 && n2_score4.length() > 0 && n2_score5.length() > 0 && n2_score6.length() > 0 && n2_score7.length() > 0 && n2_score8.length() > 0 && n2_score9.length() > 0) {
                        front_calc2 = Integer.parseInt(n2_score1.getText().toString()) + Integer.parseInt(n2_score2.getText().toString()) + Integer.parseInt(n2_score3.getText().toString()) + Integer.parseInt(n2_score4.getText().toString()) + Integer.parseInt(n2_score5.getText().toString()) + Integer.parseInt(n2_score6.getText().toString()) + Integer.parseInt(n2_score7.getText().toString()) + Integer.parseInt(n2_score8.getText().toString()) + Integer.parseInt(n2_score9.getText().toString());

                        name2_front_total.setText(String.valueOf(front_calc2));
                    }
                    if (n2_score10.length() > 0 && n2_score11.length() > 0 && n2_score12.length() > 0 && n2_score13.length() > 0 && n2_score14.length() > 0 && n2_score15.length() > 0 && n2_score16.length() > 0 && n2_score17.length() > 0 && n2_score18.length() > 0) {
                        back_calc2 = Integer.parseInt(n2_score10.getText().toString()) + Integer.parseInt(n2_score11.getText().toString()) + Integer.parseInt(n2_score12.getText().toString()) + Integer.parseInt(n2_score13.getText().toString()) + Integer.parseInt(n2_score14.getText().toString()) + Integer.parseInt(n2_score15.getText().toString()) + Integer.parseInt(n2_score16.getText().toString()) + Integer.parseInt(n2_score17.getText().toString()) + Integer.parseInt(n2_score18.getText().toString());

                        name2_back_total.setText(String.valueOf(back_calc2));
                    }
                    if (front_calc2 != 0 && back_calc2 != 0) {
                        name2_total.setText(String.valueOf(front_calc2 + back_calc2));
                    }
                }

                if (Integer.valueOf(players) >= 3) {
                    if (n3_score1.length() > 0 && n3_score2.length() > 0 && n3_score3.length() > 0 && n3_score4.length() > 0 && n3_score5.length() > 0 && n3_score6.length() > 0 && n3_score7.length() > 0 && n3_score8.length() > 0 && n3_score9.length() > 0) {
                        front_calc3 = Integer.parseInt(n3_score1.getText().toString()) + Integer.parseInt(n3_score2.getText().toString()) + Integer.parseInt(n3_score3.getText().toString()) + Integer.parseInt(n3_score4.getText().toString()) + Integer.parseInt(n3_score5.getText().toString()) + Integer.parseInt(n3_score6.getText().toString()) + Integer.parseInt(n3_score7.getText().toString()) + Integer.parseInt(n3_score8.getText().toString()) + Integer.parseInt(n3_score9.getText().toString());

                        name3_front_total.setText(String.valueOf(front_calc3));
                    }
                    if (n3_score10.length() > 0 && n3_score11.length() > 0 && n3_score12.length() > 0 && n3_score13.length() > 0 && n3_score14.length() > 0 && n3_score15.length() > 0 && n3_score16.length() > 0 && n3_score17.length() > 0 && n3_score18.length() > 0) {
                        back_calc3 = Integer.parseInt(n3_score10.getText().toString()) + Integer.parseInt(n3_score11.getText().toString()) + Integer.parseInt(n3_score12.getText().toString()) + Integer.parseInt(n3_score13.getText().toString()) + Integer.parseInt(n3_score14.getText().toString()) + Integer.parseInt(n3_score15.getText().toString()) + Integer.parseInt(n3_score16.getText().toString()) + Integer.parseInt(n3_score17.getText().toString()) + Integer.parseInt(n3_score18.getText().toString());

                        name3_back_total.setText(String.valueOf(back_calc3));
                    }
                    if (front_calc3 != 0 && back_calc3 != 0) {
                        name3_total.setText(String.valueOf(front_calc3 + back_calc3));
                    }
                }

                if (Integer.valueOf(players) == 4) {
                    if (n4_score1.length() > 0 && n4_score2.length() > 0 && n4_score3.length() > 0 && n4_score4.length() > 0 && n4_score5.length() > 0 && n4_score6.length() > 0 && n4_score7.length() > 0 && n4_score8.length() > 0 && n4_score9.length() > 0) {
                        front_calc4 = Integer.parseInt(n4_score1.getText().toString()) + Integer.parseInt(n4_score2.getText().toString()) + Integer.parseInt(n4_score3.getText().toString()) + Integer.parseInt(n4_score4.getText().toString()) + Integer.parseInt(n4_score5.getText().toString()) + Integer.parseInt(n4_score6.getText().toString()) + Integer.parseInt(n4_score7.getText().toString()) + Integer.parseInt(n4_score8.getText().toString()) + Integer.parseInt(n4_score9.getText().toString());

                        name4_front_total.setText(String.valueOf(front_calc4));
                    }
                    if (n4_score10.length() > 0 && n4_score11.length() > 0 && n4_score12.length() > 0 && n4_score13.length() > 0 && n4_score14.length() > 0 && n4_score15.length() > 0 && n4_score16.length() > 0 && n4_score17.length() > 0 && n4_score18.length() > 0) {
                        back_calc4 = Integer.parseInt(n4_score10.getText().toString()) + Integer.parseInt(n4_score11.getText().toString()) + Integer.parseInt(n4_score12.getText().toString()) + Integer.parseInt(n4_score13.getText().toString()) + Integer.parseInt(n4_score14.getText().toString()) + Integer.parseInt(n4_score15.getText().toString()) + Integer.parseInt(n4_score16.getText().toString()) + Integer.parseInt(n4_score17.getText().toString()) + Integer.parseInt(n4_score18.getText().toString());

                        name4_back_total.setText(String.valueOf(back_calc4));
                    }
                    if (front_calc4 != 0 && back_calc4 != 0) {
                        name4_total.setText(String.valueOf(front_calc4 + back_calc4));
                    }
                }
            }
        };
    }

    public class GeneralTextWatcher implements TextWatcher{

        public View view;
        public GeneralTextWatcher(View view){
            this.view = view;
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {
            Scorecard_Totals sc = new Scorecard_Totals();
            sc.execute();
        }
    }

}
