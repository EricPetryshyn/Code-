package com.ep.eric.golfscorecardbuddy;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.infinitetaco.cheese.NewDesign;

import static android.R.attr.animation;
import static android.R.attr.width;
import static android.animation.ObjectAnimator.ofFloat;
import static com.ep.eric.golfscorecardbuddy.R.string.six;

public class MainActivity extends AppCompatActivity implements NewDesign.OnFragmentInteractionListener{

    EditText user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager FragMgr = getSupportFragmentManager();
        NewDesign MyFrag = (NewDesign)FragMgr.findFragmentById(R.id.fragment_layout_01);
        MyFrag.Change_text("Welcome Android");

        final SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this);
        user_name = new EditText(this);

        if(!sharedpreferences.contains("user_name")){

            user_name.setHint("Name");

            new AlertDialog.Builder(this)
                    .setMessage("Enter Your Name Here:")
                    .setView(user_name)
                    .setPositiveButton("OK", listener)
                    .setCancelable(false)
                    .create()
                    .show();


        }

        Button scorecard = (Button) findViewById(R.id.button_scorecard);
        scorecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Scorecard_DB.class);
                startActivity(intent);
            }
        });

        Button teetimes = (Button) findViewById(R.id.button_teetimes);
        teetimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Teetime_DB.class);
                startActivity(intent);
            }
        });

        Button maps = (Button) findViewById(R.id.button_handicap);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Handicap.class);
                startActivity(intent);
            }
        });

        final ImageButton settings = (ImageButton) findViewById(R.id.button_settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObjectAnimator animation;

                float source = 0;
                float dest = 360;

                animation = ofFloat(settings,"rotation", source, dest);
                animation.setDuration(2000);
                animation.setInterpolator(new LinearInterpolator());
                animation.setRepeatCount(1); // how many times
                animation.setRepeatMode(ValueAnimator.RESTART);
                animation.start();

                user_name.setText(sharedpreferences.getString("user_name", ""));

                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Change Your Name Here:")
                        .setView(user_name)
                        .setPositiveButton("OK", listener)
                        .setCancelable(false)
                        .create()
                        .show();
            }
        });

        final TextView title = (TextView) findViewById(R.id.title);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ObjectAnimator animation;

                float source = 0;
                float dest = 10;

                //animation = ObjectAnimator.ofFloat(title,"alpha", 0.5f);
               // animation.setDuration(400);
                //animation.start();

                animation = ofFloat(title,"rotation", source, dest);
                animation.setDuration(200);
                animation.setInterpolator(new LinearInterpolator());
                animation.setRepeatMode(ValueAnimator.RESTART);
                animation.start();

                source = 10;
                dest = -10;

                //animation = ObjectAnimator.ofFloat(title,"alpha", 0.5f, 1f);
                //animation.setDuration(400);
                //animation.setStartDelay(400);
                //animation.start();

                animation = ofFloat(title,"rotation", source, dest);
                animation.setDuration(400);
                animation.setStartDelay(200);
                animation.setInterpolator(new LinearInterpolator());
                animation.setRepeatMode(ValueAnimator.RESTART);
                animation.start();

                source = -10;
                dest = 0;

                animation = ofFloat(title,"rotation", source, dest);
                animation.setDuration(200);
                animation.setStartDelay(600);
                animation.setInterpolator(new LinearInterpolator());
                animation.setRepeatMode(ValueAnimator.RESTART);
                animation.start();
            }
        });

        final ImageView golf_ball = (ImageView)findViewById(R.id.imageView_golf_ball);

        Display display = getWindowManager().getDefaultDisplay();
        final float width;
        if(Build.VERSION.SDK_INT >= 13) {
            Point size = new Point();
            display.getSize(size);
            width = size.x;
        }
        else {
            width = display.getWidth();
        }

        ObjectAnimator animation = ObjectAnimator.ofFloat(golf_ball,"translationX", -100, width + 50);
        animation.setDuration(3000);
        animation.start();

        ObjectAnimator animation2 = ofFloat(golf_ball,"rotation", 0, 360);
        animation2.setDuration(1000);
        animation2.setRepeatCount(3);
        animation2.start();
    }

    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {

        final int BUTTON_POSITIVE = -1;

        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {

                case BUTTON_POSITIVE:

                    final SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    sharedpreferences.edit().putString("user_name", user_name.getText().toString()).commit();

                    ((ViewManager)user_name.getParent()).removeView(user_name);

                    dialog.dismiss();

                    break;
            }
        }
    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
