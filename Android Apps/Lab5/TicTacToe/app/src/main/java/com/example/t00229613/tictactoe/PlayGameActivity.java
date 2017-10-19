package com.example.t00229613.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

/**
 * Created by T00229613 on 11/10/2016.
 */


public class PlayGameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView text6;
    TextView text7;
    TextView text8;
    TextView text9;
    TextView text10;
    TextView text11;
    TextView text12;
    int num;
    int score;
    int turn = 0;
    private Context context;
    int sp1;
    int sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game_activity);

        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());

        Intent intent = getIntent();
        context = this;
        TextView text1 = (TextView) findViewById(R.id.textView1);
        text1.setOnClickListener(this);
        TextView text2 = (TextView) findViewById(R.id.textView2);
        text2.setOnClickListener(this);
        TextView text3 = (TextView) findViewById(R.id.textView3);
        text3.setOnClickListener(this);
        TextView text4 = (TextView) findViewById(R.id.textView4);
        text4.setOnClickListener(this);
        TextView text5 = (TextView) findViewById(R.id.textView5);
        text5.setOnClickListener(this);
        TextView text6 = (TextView) findViewById(R.id.textView6);
        text6.setOnClickListener(this);
        TextView text7 = (TextView) findViewById(R.id.textView7);
        text7.setOnClickListener(this);
        TextView text8 = (TextView) findViewById(R.id.textView8);
        text8.setOnClickListener(this);
        TextView text9 = (TextView) findViewById(R.id.textView9);
        text9.setOnClickListener(this);
        TextView text10 = (TextView) findViewById(R.id.textView10);
        TextView text12 = (TextView) findViewById(R.id.textView12);
        Button reset = (Button) findViewById(R.id.buttonreset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text1 = (TextView) findViewById(R.id.textView1);
                TextView text2 = (TextView) findViewById(R.id.textView2);
                TextView text3 = (TextView) findViewById(R.id.textView3);
                TextView text4 = (TextView) findViewById(R.id.textView4);
                TextView text5 = (TextView) findViewById(R.id.textView5);
                TextView text6 = (TextView) findViewById(R.id.textView6);
                TextView text7 = (TextView) findViewById(R.id.textView7);
                TextView text8 = (TextView) findViewById(R.id.textView8);
                TextView text9 = (TextView) findViewById(R.id.textView9);
                TextView text11 = (TextView) findViewById(R.id.textView11);

                turn = 0;
                text1.setText("");
                text2.setText("");
                text3.setText("");
                text4.setText("");
                text5.setText("");
                text6.setText("");
                text7.setText("");
                text8.setText("");
                text9.setText("");
                text11.setText("");
            }
        });

        final Button mode = (Button) findViewById(R.id.buttonmode);
        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text1 = (TextView) findViewById(R.id.textView1);
                TextView text2 = (TextView) findViewById(R.id.textView2);
                TextView text3 = (TextView) findViewById(R.id.textView3);
                TextView text4 = (TextView) findViewById(R.id.textView4);
                TextView text5 = (TextView) findViewById(R.id.textView5);
                TextView text6 = (TextView) findViewById(R.id.textView6);
                TextView text7 = (TextView) findViewById(R.id.textView7);
                TextView text8 = (TextView) findViewById(R.id.textView8);
                TextView text9 = (TextView) findViewById(R.id.textView9);
                TextView text10 = (TextView) findViewById(R.id.textView10);
                TextView text11 = (TextView) findViewById(R.id.textView11);
                TextView text12 = (TextView) findViewById(R.id.textView12);

                turn = 0;
                text1.setText("");
                text2.setText("");
                text3.setText("");
                text4.setText("");
                text5.setText("");
                text6.setText("");
                text7.setText("");
                text8.setText("");
                text9.setText("");
                text11.setText("");
                SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
                if(sharedpreferences.getInt("gametype", 0)==0) {
                    sharedpreferences.edit().putInt("gametype", 1).commit();
                    text10.setText("0");
                    text12.setText("0");
                    mode.setText("Switch to One Player");
                }
                else{
                    sharedpreferences.edit().putInt("gametype", 0).commit();

                    String currentDateTime = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                    num = sharedpreferences.getInt("num", -1);
                    sharedpreferences.edit().putString("t"+num, currentDateTime).commit();
                    score = sharedpreferences.getInt("s"+num, -1);
                    text10.setText(String.valueOf(score));
                    score = sharedpreferences.getInt("AIscore", 0);
                    text12.setText(String.valueOf(score));
                    mode.setText("Switch to Two Player");
                }
                sp1 = 0;
                sp2 = 0;

            }
        });

        String currentDateTime = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        if(sharedpreferences.getInt("gametype", 0)==1){
            text10.setText("0");
            text12.setText("0");
            mode.setText("Switch to One Player");
        }
        else{
            num = sharedpreferences.getInt("num", -1);
            sharedpreferences.edit().putString("t"+num, currentDateTime).commit();
            score = sharedpreferences.getInt("s"+num, -1);
            text10.setText(String.valueOf(score));
            score = sharedpreferences.getInt("AIscore", 0);
            text12.setText(String.valueOf(score));
            mode.setText("Switch to Two Player");
        }
    }



    @Override
    public void onClick(View view) {

        TextView text1 = (TextView) findViewById(R.id.textView1);
        TextView text2 = (TextView) findViewById(R.id.textView2);
        TextView text3 = (TextView) findViewById(R.id.textView3);
        TextView text4 = (TextView) findViewById(R.id.textView4);
        TextView text5 = (TextView) findViewById(R.id.textView5);
        TextView text6 = (TextView) findViewById(R.id.textView6);
        TextView text7 = (TextView) findViewById(R.id.textView7);
        TextView text8 = (TextView) findViewById(R.id.textView8);
        TextView text9 = (TextView) findViewById(R.id.textView9);
        TextView text10 = (TextView) findViewById(R.id.textView10);
        TextView text11 = (TextView) findViewById(R.id.textView11);
        TextView text12 = (TextView) findViewById(R.id.textView12);
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);

        if(sharedpreferences.getInt("gametype", 0)==0) {
            if (turn < 5) {
                switch (view.getId()) {
                    case R.id.textView1:
                        if (text1.getText().equals("")) {
                            text1.setText("O");
                            text1.setTextColor(Color.parseColor("#e10303"));
                            turn++;
                        }
                        break;

                    case R.id.textView2:
                        if (text2.getText().equals("")) {
                            text2.setText("O");
                            text2.setTextColor(Color.parseColor("#e10303"));
                            turn++;
                        }
                        break;

                    case R.id.textView3:
                        if (text3.getText().equals("")) {
                            text3.setText("O");
                            text3.setTextColor(Color.parseColor("#e10303"));
                            turn++;
                        }
                        break;

                    case R.id.textView4:
                        if (text4.getText().equals("")) {
                            text4.setText("O");
                            text4.setTextColor(Color.parseColor("#e10303"));
                            turn++;
                        }
                        break;

                    case R.id.textView5:
                        if (text5.getText().equals("")) {
                            text5.setText("O");
                            text5.setTextColor(Color.parseColor("#e10303"));
                            turn++;
                        }
                        break;

                    case R.id.textView6:
                        if (text6.getText().equals("")) {
                            text6.setText("O");
                            text6.setTextColor(Color.parseColor("#e10303"));
                            turn++;
                        }
                        break;

                    case R.id.textView7:
                        if (text7.getText().equals("")) {
                            text7.setText("O");
                            text7.setTextColor(Color.parseColor("#e10303"));
                            turn++;
                        }
                        break;

                    case R.id.textView8:
                        if (text8.getText().equals("")) {
                            text8.setText("O");
                            text8.setTextColor(Color.parseColor("#e10303"));
                            turn++;
                        }
                        break;

                    case R.id.textView9:
                        if (text9.getText().equals("")) {
                            text9.setText("O");
                            text9.setTextColor(Color.parseColor("#e10303"));
                            turn++;
                        }
                        break;
                }
            }
            String username = sharedpreferences.getString("u"+num, "");

            if (turn < 5) {
                if (text1.getText().equals(text2.getText()) && text2.getText().equals(text3.getText()) && !(text1.getText().equals(""))) {
                    if (text1.getText().equals("O")) {
                        text11.setText(username + " Wins!");
                        score = sharedpreferences.getInt("s" + num, 0) + 1;
                        sharedpreferences.edit().putInt("s" + num, score).commit();
                        text10.setText(String.valueOf(score));
                    }
                    turn = 5;
                }

                if (text4.getText().

                        equals(text5.getText()

                        ) && text5.getText().

                        equals(text6.getText()

                        ) && !(text4.getText().

                        equals("")

                ))

                {
                    if (text4.getText().equals("O")) {
                        text11.setText(username + " Wins!");
                        score = sharedpreferences.getInt("s" + num, 0) + 1;
                        sharedpreferences.edit().putInt("s" + num, score).commit();
                        text10.setText(String.valueOf(score));
                    }
                    turn = 5;
                }

                if (text7.getText().

                        equals(text8.getText()

                        ) && text8.getText().

                        equals(text9.getText()

                        ) && !(text7.getText().

                        equals("")

                ))

                {
                    if (text7.getText().equals("O")) {
                        text11.setText(username + " Wins!");
                        score = sharedpreferences.getInt("s" + num, 0) + 1;
                        sharedpreferences.edit().putInt("s" + num, score).commit();
                        text10.setText(String.valueOf(score));
                    }
                    turn = 5;
                }

                if (text1.getText().

                        equals(text4.getText()

                        ) && text4.getText().

                        equals(text7.getText()

                        ) && !(text1.getText().

                        equals("")

                ))

                {
                    if (text1.getText().equals("O")) {
                        text11.setText(username + " Wins!");
                        score = sharedpreferences.getInt("s" + num, 0) + 1;
                        sharedpreferences.edit().putInt("s" + num, score).commit();
                        text10.setText(String.valueOf(score));
                    }
                    turn = 5;
                }

                if (text2.getText().

                        equals(text5.getText()

                        ) && text5.getText().

                        equals(text8.getText()

                        ) && !(text2.getText().

                        equals("")

                ))

                {
                    if (text2.getText().equals("O")) {
                        text11.setText(username + " Wins!");
                        score = sharedpreferences.getInt("s" + num, 0) + 1;
                        sharedpreferences.edit().putInt("s" + num, score).commit();
                        text10.setText(String.valueOf(score));
                    }
                    turn = 5;
                }

                if (text3.getText().

                        equals(text6.getText()

                        ) && text6.getText().

                        equals(text9.getText()

                        ) && !(text3.getText().

                        equals("")

                ))

                {
                    if (text3.getText().equals("O")) {
                        text11.setText(username + " Wins!");
                        score = sharedpreferences.getInt("s" + num, 0) + 1;
                        sharedpreferences.edit().putInt("s" + num, score).commit();
                        text10.setText(String.valueOf(score));
                    }
                    turn = 5;
                }

                if (text1.getText().

                        equals(text5.getText()

                        ) && text5.getText().

                        equals(text9.getText()

                        ) && !(text1.getText().

                        equals("")

                ))

                {
                    if (text1.getText().equals("O")) {
                        text11.setText(username + " Wins!");
                        score = sharedpreferences.getInt("s" + num, 0) + 1;
                        sharedpreferences.edit().putInt("s" + num, score).commit();
                        text10.setText(String.valueOf(score));
                    }
                    turn = 5;
                }

                if (text3.getText().

                        equals(text5.getText()

                        ) && text5.getText().

                        equals(text7.getText()

                        ) && !(text3.getText().

                        equals("")

                ))

                {
                    if (text3.getText().equals("O")) {
                        text11.setText(username + " Wins!");
                        score = sharedpreferences.getInt("s" + num, 0) + 1;
                        sharedpreferences.edit().putInt("s" + num, score).commit();
                        text10.setText(String.valueOf(score));
                    }
                    turn = 5;
                }
            }

            TicTacToe tictactoe = new TicTacToe();
            tictactoe.execute();
        }else{
                switch (view.getId()) {
                    case R.id.textView1:
                        if (text1.getText().equals("")) {
                            if (turn == 0) {
                                text1.setText("O");
                                text1.setTextColor(Color.parseColor("#e10303"));
                                turn++;
                            } else {
                                text1.setText("X");
                                text1.setTextColor(Color.parseColor("#0016de"));
                                turn = 0;
                            }
                        }
                        break;

                    case R.id.textView2:
                        if (text2.getText().equals("")) {
                            if (turn == 0) {
                                text2.setText("O");
                                text2.setTextColor(Color.parseColor("#e10303"));
                                turn++;
                            } else {
                                text2.setText("X");
                                text2.setTextColor(Color.parseColor("#0016de"));
                                turn = 0;
                            }
                        }
                        break;

                    case R.id.textView3:
                        if (text3.getText().equals("")) {
                            if (turn == 0) {
                                text3.setText("O");
                                text3.setTextColor(Color.parseColor("#e10303"));
                                turn++;
                            } else {
                                text3.setText("X");
                                text3.setTextColor(Color.parseColor("#0016de"));
                                turn = 0;
                            }
                        }
                        break;

                    case R.id.textView4:
                        if (text4.getText().equals("")) {
                            if (turn == 0) {
                                text4.setText("O");
                                text4.setTextColor(Color.parseColor("#e10303"));
                                turn++;
                            } else {
                                text4.setText("X");
                                text4.setTextColor(Color.parseColor("#0016de"));
                                turn = 0;
                            }
                        }
                        break;

                    case R.id.textView5:
                        if (text5.getText().equals("")) {
                            if (turn == 0) {
                                text5.setText("O");
                                text5.setTextColor(Color.parseColor("#e10303"));
                                turn++;
                            } else {
                                text5.setText("X");
                                text5.setTextColor(Color.parseColor("#0016de"));
                                turn = 0;
                            }
                        }
                        break;

                    case R.id.textView6:
                        if (text6.getText().equals("")) {
                            if (turn == 0) {
                                text6.setText("O");
                                text6.setTextColor(Color.parseColor("#e10303"));
                                turn++;
                            } else {
                                text6.setText("X");
                                text6.setTextColor(Color.parseColor("#0016de"));
                                turn = 0;
                            }
                        }
                        break;

                    case R.id.textView7:
                        if (text7.getText().equals("")) {
                            if (turn == 0) {
                                text7.setText("O");
                                text7.setTextColor(Color.parseColor("#e10303"));
                                turn++;
                            } else {
                                text7.setText("X");
                                text7.setTextColor(Color.parseColor("#0016de"));
                                turn = 0;
                            }
                        }
                        break;

                    case R.id.textView8:
                        if (text8.getText().equals("")) {
                            if (turn == 0) {
                                text8.setText("O");
                                text8.setTextColor(Color.parseColor("#e10303"));
                                turn++;
                            } else {
                                text8.setText("X");
                                text8.setTextColor(Color.parseColor("#0016de"));
                                turn = 0;
                            }
                        }
                        break;

                    case R.id.textView9:
                        if (text9.getText().equals("")) {
                            if (turn == 0) {
                                text9.setText("O");
                                text9.setTextColor(Color.parseColor("#e10303"));
                                turn++;
                            } else {
                                text9.setText("X");
                                text9.setTextColor(Color.parseColor("#0016de"));
                                turn = 0;
                            }
                        }
                        break;
                }

                String username = sharedpreferences.getString("username", "");


                if (text1.getText().equals(text2.getText()) && text2.getText().equals(text3.getText()) && !(text1.getText().equals(""))) {
                    if (text1.getText().equals("O")) {
                        text11.setText("Player 1 Wins!");
                        sp1++;
                        text10.setText(String.valueOf(sp1));
                    }
                    else {
                        text11.setText("Player 2 Wins!");
                        sp2++;
                        text12.setText(String.valueOf(sp2));
                    }
                }

                if (text4.getText().

                        equals(text5.getText()

                        ) && text5.getText().

                        equals(text6.getText()

                        ) && !(text4.getText().

                        equals("")

                ))

                {
                    if (text4.getText().equals("O")) {
                        text11.setText("Player 1 Wins!");
                        sp1++;
                        text10.setText(String.valueOf(sp1));
                    }
                    else {
                        text11.setText("Player 2 Wins!");
                        sp2++;
                        text12.setText(String.valueOf(sp2));
                    }
                }

                if (text7.getText().

                        equals(text8.getText()

                        ) && text8.getText().

                        equals(text9.getText()

                        ) && !(text7.getText().

                        equals("")

                ))

                {
                    if (text7.getText().equals("O")) {
                        text11.setText("Player 1 Wins!");
                        sp1++;
                        text10.setText(String.valueOf(sp1));
                    }
                    else {
                        text11.setText("Player 2 Wins!");
                        sp2++;
                        text12.setText(String.valueOf(sp2));
                    }
                }

                if (text1.getText().

                        equals(text4.getText()

                        ) && text4.getText().

                        equals(text7.getText()

                        ) && !(text1.getText().

                        equals("")

                ))

                {
                    if (text1.getText().equals("O")) {
                        text11.setText("Player 1 Wins!");
                        sp1++;
                        text10.setText(String.valueOf(sp1));
                    }
                    else {
                        text11.setText("Player 2 Wins!");
                        sp2++;
                        text12.setText(String.valueOf(sp2));
                    }
                }

                if (text2.getText().

                        equals(text5.getText()

                        ) && text5.getText().

                        equals(text8.getText()

                        ) && !(text2.getText().

                        equals("")

                ))

                {
                    if (text2.getText().equals("O")) {
                        text11.setText("Player 1 Wins!");
                        sp1++;
                        text10.setText(String.valueOf(sp1));
                    }
                    else {
                        text11.setText("Player 2 Wins!");
                        sp2++;
                        text12.setText(String.valueOf(sp2));
                    }
                }

                if (text3.getText().

                        equals(text6.getText()

                        ) && text6.getText().

                        equals(text9.getText()

                        ) && !(text3.getText().

                        equals("")

                ))

                {
                    if (text3.getText().equals("O")) {
                        text11.setText("Player 1 Wins!");
                        sp1++;
                        text10.setText(String.valueOf(sp1));
                    }
                    else {
                        text11.setText("Player 2 Wins!");
                        sp2++;
                        text12.setText(String.valueOf(sp2));
                    }
                }

                if (text1.getText().

                        equals(text5.getText()

                        ) && text5.getText().

                        equals(text9.getText()

                        ) && !(text1.getText().

                        equals("")

                ))

                {
                    if (text1.getText().equals("O")) {
                        text11.setText("Player 1 Wins!");
                        sp1++;
                        text10.setText(String.valueOf(sp1));
                    }
                    else {
                        text11.setText("Player 2 Wins!");
                        sp2++;
                        text12.setText(String.valueOf(sp2));
                    }
                }

                if (text3.getText().

                        equals(text5.getText()

                        ) && text5.getText().

                        equals(text7.getText()

                        ) && !(text3.getText().

                        equals("")

                ))

                {
                    if (text3.getText().equals("O")) {
                        text11.setText("Player 1 Wins!");
                        sp1++;
                        text10.setText(String.valueOf(sp1));
                    }
                    else {
                        text11.setText("Player 2 Wins!");
                        sp2++;
                        text12.setText(String.valueOf(sp2));
                    }
                }
            }
        }


    public class TicTacToe extends AsyncTask<Integer, String, Integer> {

        Handler handler = new Handler();

        public TicTacToe() {
            super();
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            if (turn < 5)

            {
                runAI();
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Integer integer) {
            super.onCancelled(integer);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }


        public void runAI() {



            handler.post(runnable);
        }

        private Runnable runnable = new Runnable() {
            @Override
            public void run() {

                TextView text1 = (TextView) findViewById(R.id.textView1);
                TextView text2 = (TextView) findViewById(R.id.textView2);
                TextView text3 = (TextView) findViewById(R.id.textView3);
                TextView text4 = (TextView) findViewById(R.id.textView4);
                TextView text5 = (TextView) findViewById(R.id.textView5);
                TextView text6 = (TextView) findViewById(R.id.textView6);
                TextView text7 = (TextView) findViewById(R.id.textView7);
                TextView text8 = (TextView) findViewById(R.id.textView8);
                TextView text9 = (TextView) findViewById(R.id.textView9);
                TextView text10 = (TextView) findViewById(R.id.textView10);
                TextView text11 = (TextView) findViewById(R.id.textView11);
                TextView text12 = (TextView) findViewById(R.id.textView12);

                SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);

                if (text1.getText().equals(text2.getText()) && text2.getText().equals("X") && text3.getText().equals("")) {
                    text3.setText("X");
                    text3.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text2.getText().equals(text3.getText()) && text3.getText().equals("X") && text1.getText().equals("")) {
                    text1.setText("X");
                    text1.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text1.getText().equals(text3.getText()) && text3.getText().equals("X") && text2.getText().equals("")) {
                    text2.setText("X");
                    text2.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text4.getText().equals(text5.getText()) && text5.getText().equals("X") && text6.getText().equals("")) {
                    text6.setText("X");
                    text6.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text4.getText().equals(text6.getText()) && text6.getText().equals("X") && text5.getText().equals("")) {
                    text5.setText("X");
                    text5.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text5.getText().equals(text6.getText()) && text6.getText().equals("X") && text4.getText().equals("")) {
                    text4.setText("X");
                    text4.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text7.getText().equals(text8.getText()) && text8.getText().equals("X") && text9.getText().equals("")) {
                    text9.setText("X");
                    text9.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text7.getText().equals(text9.getText()) && text9.getText().equals("X") && text8.getText().equals("")) {
                    text8.setText("X");
                    text8.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text8.getText().equals(text9.getText()) && text9.getText().equals("X") && text7.getText().equals("")) {
                    text7.setText("X");
                    text7.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text1.getText().equals(text4.getText()) && text4.getText().equals("X") && text7.getText().equals("")) {
                    text7.setText("X");
                    text7.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text1.getText().equals(text7.getText()) && text7.getText().equals("X") && text4.getText().equals("")) {
                    text4.setText("X");
                    text4.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text4.getText().equals(text7.getText()) && text7.getText().equals("X") && text1.getText().equals("")) {
                    text1.setText("X");
                    text1.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text2.getText().equals(text5.getText()) && text5.getText().equals("X") && text8.getText().equals("")) {
                    text8.setText("X");
                    text8.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text2.getText().equals(text8.getText()) && text8.getText().equals("X") && text5.getText().equals("")) {
                    text5.setText("X");
                    text5.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text5.getText().equals(text8.getText()) && text8.getText().equals("X") && text2.getText().equals("")) {
                    text2.setText("X");
                    text2.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text3.getText().equals(text6.getText()) && text6.getText().equals("X") && text9.getText().equals("")) {
                    text9.setText("X");
                    text9.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text3.getText().equals(text9.getText()) && text9.getText().equals("X") && text6.getText().equals("")) {
                    text6.setText("X");
                    text6.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text6.getText().equals(text9.getText()) && text9.getText().equals("X") && text3.getText().equals("")) {
                    text3.setText("X");
                    text3.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text1.getText().equals(text5.getText()) && text5.getText().equals("X") && text9.getText().equals("")) {
                    text9.setText("X");
                    text9.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text1.getText().equals(text9.getText()) && text9.getText().equals("X") && text5.getText().equals("")) {
                    text5.setText("X");
                    text5.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text5.getText().equals(text9.getText()) && text9.getText().equals("X") && text1.getText().equals("")) {
                    text1.setText("X");
                    text1.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text3.getText().equals(text5.getText()) && text5.getText().equals("X") && text7.getText().equals("")) {
                    text7.setText("X");
                    text7.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text3.getText().equals(text7.getText()) && text7.getText().equals("X") && text5.getText().equals("")) {
                    text5.setText("X");
                    text5.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text5.getText().equals(text7.getText()) && text7.getText().equals("X") && text3.getText().equals("")) {
                    text3.setText("X");
                    text3.setTextColor(Color.parseColor("#0016de"));
                    text11.setText("AI Wins!");
                    score = sharedpreferences.getInt("AIscore", 0) + 1;
                    sharedpreferences.edit().putInt("AIscore", score).commit();
                    text12.setText(String.valueOf(score));
                    turn = 5;
                } else if (text1.getText().equals(text2.getText()) && text2.getText().equals("O") && text3.getText().equals("")) {
                    text3.setText("X");
                    text3.setTextColor(Color.parseColor("#0016de"));
                } else if (text2.getText().equals(text3.getText()) && text3.getText().equals("O") && text1.getText().equals("")) {
                    text1.setText("X");
                    text1.setTextColor(Color.parseColor("#0016de"));
                } else if (text1.getText().equals(text3.getText()) && text3.getText().equals("O") && text2.getText().equals("")) {
                    text2.setText("X");
                    text2.setTextColor(Color.parseColor("#0016de"));
                } else if (text4.getText().equals(text5.getText()) && text5.getText().equals("O") && text6.getText().equals("")) {
                    text6.setText("X");
                    text6.setTextColor(Color.parseColor("#0016de"));
                } else if (text4.getText().equals(text6.getText()) && text6.getText().equals("O") && text5.getText().equals("")) {
                    text5.setText("X");
                    text5.setTextColor(Color.parseColor("#0016de"));
                } else if (text5.getText().equals(text6.getText()) && text6.getText().equals("O") && text4.getText().equals("")) {
                    text4.setText("X");
                    text4.setTextColor(Color.parseColor("#0016de"));
                } else if (text7.getText().equals(text8.getText()) && text8.getText().equals("O") && text9.getText().equals("")) {
                    text9.setText("X");
                    text9.setTextColor(Color.parseColor("#0016de"));
                } else if (text7.getText().equals(text9.getText()) && text9.getText().equals("O") && text8.getText().equals("")) {
                    text8.setText("X");
                    text8.setTextColor(Color.parseColor("#0016de"));
                } else if (text8.getText().equals(text9.getText()) && text9.getText().equals("O") && text7.getText().equals("")) {
                    text7.setText("X");
                    text7.setTextColor(Color.parseColor("#0016de"));
                } else if (text1.getText().equals(text4.getText()) && text4.getText().equals("O") && text7.getText().equals("")) {
                    text7.setText("X");
                    text7.setTextColor(Color.parseColor("#0016de"));
                } else if (text1.getText().equals(text7.getText()) && text7.getText().equals("O") && text4.getText().equals("")) {
                    text4.setText("X");
                    text4.setTextColor(Color.parseColor("#0016de"));
                } else if (text4.getText().equals(text7.getText()) && text7.getText().equals("O") && text1.getText().equals("")) {
                    text1.setText("X");
                    text1.setTextColor(Color.parseColor("#0016de"));
                } else if (text2.getText().equals(text5.getText()) && text5.getText().equals("O") && text8.getText().equals("")) {
                    text8.setText("X");
                    text8.setTextColor(Color.parseColor("#0016de"));
                } else if (text2.getText().equals(text8.getText()) && text8.getText().equals("O") && text5.getText().equals("")) {
                    text5.setText("X");
                    text5.setTextColor(Color.parseColor("#0016de"));
                } else if (text5.getText().equals(text8.getText()) && text8.getText().equals("O") && text2.getText().equals("")) {
                    text2.setText("X");
                    text2.setTextColor(Color.parseColor("#0016de"));
                } else if (text3.getText().equals(text6.getText()) && text6.getText().equals("O") && text9.getText().equals("")) {
                    text9.setText("X");
                    text9.setTextColor(Color.parseColor("#0016de"));
                } else if (text3.getText().equals(text9.getText()) && text9.getText().equals("O") && text6.getText().equals("")) {
                    text6.setText("X");
                    text6.setTextColor(Color.parseColor("#0016de"));
                } else if (text6.getText().equals(text9.getText()) && text9.getText().equals("O") && text3.getText().equals("")) {
                    text3.setText("X");
                    text3.setTextColor(Color.parseColor("#0016de"));
                } else if (text1.getText().equals(text5.getText()) && text5.getText().equals("O") && text9.getText().equals("")) {
                    text9.setText("X");
                    text9.setTextColor(Color.parseColor("#0016de"));
                } else if (text1.getText().equals(text9.getText()) && text9.getText().equals("O") && text5.getText().equals("")) {
                    text5.setText("X");
                    text5.setTextColor(Color.parseColor("#0016de"));
                } else if (text5.getText().equals(text9.getText()) && text9.getText().equals("O") && text1.getText().equals("")) {
                    text1.setText("X");
                    text1.setTextColor(Color.parseColor("#0016de"));
                } else if (text3.getText().equals(text5.getText()) && text5.getText().equals("O") && text7.getText().equals("")) {
                    text7.setText("X");
                    text7.setTextColor(Color.parseColor("#0016de"));
                } else if (text3.getText().equals(text7.getText()) && text7.getText().equals("O") && text5.getText().equals("")) {
                    text5.setText("X");
                    text5.setTextColor(Color.parseColor("#0016de"));
                } else if (text5.getText().equals(text7.getText()) && text7.getText().equals("O") && text3.getText().equals("")) {
                    text3.setText("X");
                    text3.setTextColor(Color.parseColor("#0016de"));
                } else {
                    int loop = 1;
                    while (loop == 1){
                    Random rnd = new Random();
                    int number;
                    number = rnd.nextInt(9);

                    switch (number) {

                        case 0:
                            if (text1.getText().equals("")) {
                                text1.setText("X");
                                text1.setTextColor(Color.parseColor("#0016de"));
                                loop = 0;
                            }
                            break;
                        case 1:
                            if (text2.getText().equals("")) {
                                text2.setText("X");
                                text2.setTextColor(Color.parseColor("#0016de"));
                                loop = 0;
                            }
                            break;
                        case 2:
                            if (text3.getText().equals("")) {
                                text3.setText("X");
                                text3.setTextColor(Color.parseColor("#0016de"));
                                loop = 0;
                            }
                            break;
                        case 3:
                            if (text4.getText().equals("")) {
                                text4.setText("X");
                                text4.setTextColor(Color.parseColor("#0016de"));
                                loop = 0;
                            }
                            break;
                        case 4:
                            if (text5.getText().equals("")) {
                                text5.setText("X");
                                text5.setTextColor(Color.parseColor("#0016de"));
                                loop = 0;
                            }
                            break;
                        case 5:
                            if (text6.getText().equals("")) {
                                text6.setText("X");
                                text6.setTextColor(Color.parseColor("#0016de"));
                                loop = 0;
                            }
                            break;
                        case 6:
                            if (text7.getText().equals("")) {
                                text7.setText("X");
                                text7.setTextColor(Color.parseColor("#0016de"));
                                loop = 0;
                            }
                            break;
                        case 7:
                            if (text8.getText().equals("")) {
                                text8.setText("X");
                                text8.setTextColor(Color.parseColor("#0016de"));
                                loop = 0;
                            }
                            break;
                        case 8:
                            if (text9.getText().equals("")) {
                                text9.setText("X");
                                text9.setTextColor(Color.parseColor("#0016de"));
                                loop = 0;
                            }
                            break;
                    }
                    }
                }
            }

        };
    }
}

