package com.ep.eric.golfscorecardbuddy;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by Eric on 3/12/2017.
 */

public class Handicap extends AppCompatActivity {

    DBAdapter myDB;
    String template, sc1, sc2, sc3, sc4, sc5, sc6, sc7, sc8, sc9, sc10, sc11, sc12, sc13, sc14, sc15, sc16, sc17, sc18, course_rating, course_slope;
    int number_of_courses = 0, score_total = 0, best_score = 1000, best_front = 1000, best_back = 1000, front_total = 0, back_total = 0;
    Double handicap_differential[] = new Double[20];
    Double top_differentials[];
    double handicap_index, course_handicap;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handicap);

        getIntent();

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6098990941180338/3743650809");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();//.addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("EFD7155B8B2BFAD02ECD1BF0BEDEF1C0").build();
        mAdView.loadAd(adRequest);


        openDB();

        TextView handicap = (TextView) findViewById(R.id.textView_handicap);

        Cursor cursor = myDB.getAllRows2();


        if (cursor.moveToFirst()) {
            do {
                template = cursor.getString(DBAdapter.COL_TEMPLATE);
                sc1 = cursor.getString(DBAdapter.COL_N1_SC1);
                sc2 = cursor.getString(DBAdapter.COL_N1_SC2);
                sc3 = cursor.getString(DBAdapter.COL_N1_SC3);
                sc4 = cursor.getString(DBAdapter.COL_N1_SC4);
                sc5 = cursor.getString(DBAdapter.COL_N1_SC5);
                sc6 = cursor.getString(DBAdapter.COL_N1_SC6);
                sc7 = cursor.getString(DBAdapter.COL_N1_SC7);
                sc8 = cursor.getString(DBAdapter.COL_N1_SC8);
                sc9 = cursor.getString(DBAdapter.COL_N1_SC9);
                sc10 = cursor.getString(DBAdapter.COL_N1_SC10);
                sc11 = cursor.getString(DBAdapter.COL_N1_SC11);
                sc12 = cursor.getString(DBAdapter.COL_N1_SC12);
                sc13 = cursor.getString(DBAdapter.COL_N1_SC13);
                sc14 = cursor.getString(DBAdapter.COL_N1_SC14);
                sc15 = cursor.getString(DBAdapter.COL_N1_SC15);
                sc16 = cursor.getString(DBAdapter.COL_N1_SC16);
                sc17 = cursor.getString(DBAdapter.COL_N1_SC17);
                sc18 = cursor.getString(DBAdapter.COL_N1_SC18);

                Cursor cursor2 = myDB.getParYardageInfo(template.substring(0, template.length() - 1));

                if (cursor2.moveToFirst()) {
                    do {
                        course_rating = cursor2.getString(DBAdapter.COL_COURSE_RATING);
                        course_slope = cursor2.getString(DBAdapter.COL_SLOPE_RATING);
                    }
                    while (cursor2.moveToNext());
                }

                if (!(template.equals("Blank Template")) && !(sc1.equals("")) && !(sc2.equals("")) && !(sc3.equals("")) && !(sc4.equals("")) && !(sc5.equals("")) && !(sc6.equals("")) && !(sc7.equals("")) && !(sc8.equals(""))
                        && !(sc9.equals("")) && !(sc10.equals("")) && !(sc11.equals("")) && !(sc12.equals("")) && !(sc13.equals("")) && !(sc14.equals("")) && !(sc15.equals("")) && !(sc16.equals("")) && !(sc17.equals("")) && !(sc18.equals(""))){

                    score_total = Integer.parseInt(sc1) + Integer.parseInt(sc2) + Integer.parseInt(sc3) + Integer.parseInt(sc4) + Integer.parseInt(sc5) + Integer.parseInt(sc6)
                            + Integer.parseInt(sc7) + Integer.parseInt(sc8) + Integer.parseInt(sc9) + Integer.parseInt(sc10) + Integer.parseInt(sc11) + Integer.parseInt(sc12)
                            + Integer.parseInt(sc13) + Integer.parseInt(sc14) + Integer.parseInt(sc15) + Integer.parseInt(sc16) + Integer.parseInt(sc17) + Integer.parseInt(sc18);
                    if (score_total < best_score) {
                        best_score = score_total;
                    }
                    if(!(course_rating.equals("")) && !(course_slope.equals(""))) {
                        number_of_courses++;
                        handicap_differential[(number_of_courses - 1) % 20] = ((score_total - Double.parseDouble(course_rating)) * 113) / Double.parseDouble(course_slope);
                    }
                }
            } while (cursor.moveToNext());
        }

            if (number_of_courses < 5) {
                handicap.setText("Play at least 5 full rounds to receive a handicap.");
            } else if (number_of_courses >= 5 && number_of_courses < 7) {
                //top one
                top_differentials = new Double[1];
                top_differentials[0] = handicap_differential[0];
                for (int i = 1; i < number_of_courses; i++) {
                    if (handicap_differential[i] < top_differentials[0]) {
                        top_differentials[0] = handicap_differential[i];
                    }
                }
                handicap_index = top_differentials[0] * 0.96;
                handicap_index = Math.floor(handicap_index * 10);
                handicap_index = handicap_index * 0.1;
                handicap.setText("Handicap Index: \n\n" + String.format("%.1f", handicap_index));
            } else if (number_of_courses >= 7 && number_of_courses < 9) {
                //top two
                top_differentials = new Double[2];
                top_differentials[0] = handicap_differential[0];
                top_differentials[1] = handicap_differential[1];
                Quicksort quick = new Quicksort();
                quick.quickSort(top_differentials);
                for (int i = 2; i < number_of_courses; i++) {
                    if (handicap_differential[i] < top_differentials[1]) {
                        top_differentials[1] = handicap_differential[i];
                        quick.quickSort(top_differentials);
                    }
                }
                handicap_index = ((top_differentials[0] + top_differentials[1])/2) * 0.96;
                handicap_index = Math.floor(handicap_index * 10);
                handicap_index = handicap_index * 0.1;
                handicap.setText("Handicap Index: \n\n" + String.format("%.1f", handicap_index));
            } else if (number_of_courses >= 9 && number_of_courses < 11) {
                //top three
                top_differentials = new Double[3];
                top_differentials[0] = handicap_differential[0];
                top_differentials[1] = handicap_differential[1];
                top_differentials[2] = handicap_differential[2];
                Quicksort quick = new Quicksort();
                quick.quickSort(top_differentials);
                for (int i = 3; i < number_of_courses; i++) {
                    if (handicap_differential[i] < top_differentials[2]) {
                        top_differentials[2] = handicap_differential[i];
                        quick.quickSort(top_differentials);
                    }
                }
                handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2])/3) * 0.96;
                handicap_index = Math.floor(handicap_index * 10);
                handicap_index = handicap_index * 0.1;
                handicap.setText("Handicap Index: \n\n" + String.format("%.1f", handicap_index));
            } else if (number_of_courses >= 11 && number_of_courses < 13) {
                //top four
                top_differentials = new Double[4];
                top_differentials[0] = handicap_differential[0];
                top_differentials[1] = handicap_differential[1];
                top_differentials[2] = handicap_differential[2];
                top_differentials[3] = handicap_differential[3];
                Quicksort quick = new Quicksort();
                quick.quickSort(top_differentials);
                for (int i = 4; i < number_of_courses; i++) {
                    if (handicap_differential[i] < top_differentials[3]) {
                        top_differentials[3] = handicap_differential[i];
                        quick.quickSort(top_differentials);
                    }
                }
                handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2] + top_differentials[3])/4) * 0.96;
                handicap_index = Math.floor(handicap_index * 10);
                handicap_index = handicap_index * 0.1;
                handicap.setText("Handicap Index: \n\n" + String.format("%.1f", handicap_index));
            } else if (number_of_courses >= 13 && number_of_courses < 15) {
                //top five
                top_differentials = new Double[5];
                top_differentials[0] = handicap_differential[0];
                top_differentials[1] = handicap_differential[1];
                top_differentials[2] = handicap_differential[2];
                top_differentials[3] = handicap_differential[3];
                top_differentials[4] = handicap_differential[4];
                Quicksort quick = new Quicksort();
                quick.quickSort(top_differentials);
                for (int i = 5; i < number_of_courses; i++) {
                    if (handicap_differential[i] < top_differentials[4]) {
                        top_differentials[4] = handicap_differential[i];
                        quick.quickSort(top_differentials);
                    }
                }
                handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2] + top_differentials[3] + top_differentials[4])/5) * 0.96;
                handicap_index = Math.floor(handicap_index * 10);
                handicap_index = handicap_index * 0.1;
                handicap.setText("Handicap Index: \n\n" + String.format("%.1f", handicap_index));
            } else if (number_of_courses >= 15 && number_of_courses < 17) {
                //top six
                top_differentials = new Double[6];
                top_differentials[0] = handicap_differential[0];
                top_differentials[1] = handicap_differential[1];
                top_differentials[2] = handicap_differential[2];
                top_differentials[3] = handicap_differential[3];
                top_differentials[4] = handicap_differential[4];
                top_differentials[5] = handicap_differential[5];
                Quicksort quick = new Quicksort();
                quick.quickSort(top_differentials);
                for (int i = 6; i < number_of_courses; i++) {
                    if (handicap_differential[i] < top_differentials[5]) {
                        top_differentials[5] = handicap_differential[i];
                        quick.quickSort(top_differentials);
                    }
                }
                handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2] + top_differentials[3] + top_differentials[4]
                        + top_differentials[5])/6) * 0.96;
                handicap_index = Math.floor(handicap_index * 10);
                handicap_index = handicap_index * 0.1;
                handicap.setText("Handicap Index: \n\n" + String.format("%.1f", handicap_index));
            } else if (number_of_courses == 17) {
                //top seven
                top_differentials = new Double[7];
                top_differentials[0] = handicap_differential[0];
                top_differentials[1] = handicap_differential[1];
                top_differentials[2] = handicap_differential[2];
                top_differentials[3] = handicap_differential[3];
                top_differentials[4] = handicap_differential[4];
                top_differentials[5] = handicap_differential[5];
                top_differentials[6] = handicap_differential[6];
                Quicksort quick = new Quicksort();
                quick.quickSort(top_differentials);
                for (int i = 7; i < number_of_courses; i++) {
                    if (handicap_differential[i] < top_differentials[6]) {
                        top_differentials[6] = handicap_differential[i];
                        quick.quickSort(top_differentials);
                    }
                }
                handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2] + top_differentials[3] + top_differentials[4]
                        + top_differentials[5] + top_differentials[6])/7) * 0.96;
                handicap_index = Math.floor(handicap_index * 10);
                handicap_index = handicap_index * 0.1;
                handicap.setText("Handicap Index: \n\n" + String.format("%.1f", handicap_index));
            } else if (number_of_courses == 18) {
                //top eight
                top_differentials = new Double[8];
                top_differentials[0] = handicap_differential[0];
                top_differentials[1] = handicap_differential[1];
                top_differentials[2] = handicap_differential[2];
                top_differentials[3] = handicap_differential[3];
                top_differentials[4] = handicap_differential[4];
                top_differentials[5] = handicap_differential[5];
                top_differentials[6] = handicap_differential[6];
                top_differentials[7] = handicap_differential[7];
                Quicksort quick = new Quicksort();
                quick.quickSort(top_differentials);
                for (int i = 8; i < number_of_courses; i++) {
                    if (handicap_differential[i] < top_differentials[7]) {
                        top_differentials[7] = handicap_differential[i];
                        quick.quickSort(top_differentials);
                    }
                }
                handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2] + top_differentials[3] + top_differentials[4]
                        + top_differentials[5] + top_differentials[6] + top_differentials[7])/8) * 0.96;
                handicap_index = Math.floor(handicap_index * 10);
                handicap_index = handicap_index * 0.1;
                handicap.setText("Handicap Index: \n\n" + String.format("%.1f", handicap_index));
            } else if (number_of_courses == 19) {
                //top nine
                top_differentials = new Double[9];
                top_differentials[0] = handicap_differential[0];
                top_differentials[1] = handicap_differential[1];
                top_differentials[2] = handicap_differential[2];
                top_differentials[3] = handicap_differential[3];
                top_differentials[4] = handicap_differential[4];
                top_differentials[5] = handicap_differential[5];
                top_differentials[6] = handicap_differential[6];
                top_differentials[7] = handicap_differential[7];
                top_differentials[8] = handicap_differential[8];
                Quicksort quick = new Quicksort();
                quick.quickSort(top_differentials);
                for (int i = 9; i < number_of_courses; i++) {
                    if (handicap_differential[i] < top_differentials[8]) {
                        top_differentials[8] = handicap_differential[i];
                        quick.quickSort(top_differentials);
                    }
                }
                handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2] + top_differentials[3] + top_differentials[4]
                        + top_differentials[5] + top_differentials[6] + top_differentials[7] + top_differentials[8])/9) * 0.96;
                handicap_index = Math.floor(handicap_index * 10);
                handicap_index = handicap_index * 0.1;
                handicap.setText("Handicap Index: \n\n" + String.format("%.1f", handicap_index));
            } else {
                //top ten
                top_differentials = new Double[10];
                top_differentials[0] = handicap_differential[0];
                top_differentials[1] = handicap_differential[1];
                top_differentials[2] = handicap_differential[2];
                top_differentials[3] = handicap_differential[3];
                top_differentials[4] = handicap_differential[4];
                top_differentials[5] = handicap_differential[5];
                top_differentials[6] = handicap_differential[6];
                top_differentials[7] = handicap_differential[7];
                top_differentials[8] = handicap_differential[8];
                top_differentials[9] = handicap_differential[9];
                Quicksort quick = new Quicksort();
                quick.quickSort(top_differentials);
                for (int i = 10; i < 20; i++) {
                    if (handicap_differential[i] < top_differentials[9]) {
                        top_differentials[9] = handicap_differential[i];
                        quick.quickSort(top_differentials);
                    }
                }
                handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2] + top_differentials[3] + top_differentials[4]
                        + top_differentials[5] + top_differentials[6] + top_differentials[7] + top_differentials[8] + top_differentials[9])/10) * 0.96;
                handicap_index = Math.floor(handicap_index * 10);
                handicap_index = handicap_index * 0.1;
                handicap.setText("Handicap Index: \n\n" + String.format("%.1f", handicap_index));
            }

            if(best_score != 1000) {
                handicap.append("\n\n\nLowest 18 Hole Score: \n\n" + best_score + "\n");
            }



        cursor = myDB.getAllUniqueTemplates();

        if (cursor.moveToFirst()) {
            do {
                template = cursor.getString(DBAdapter.COL_TEMPLATE);

                number_of_courses = 0;
                best_score = 1000;
                best_front = 1000;
                best_back = 1000;

                Cursor cursor2 = myDB.getParYardageInfo(template.substring(0, template.length() - 1));

                if (cursor2.moveToFirst()) {
                    do {
                        course_rating = cursor2.getString(DBAdapter.COL_COURSE_RATING);
                        course_slope = cursor2.getString(DBAdapter.COL_SLOPE_RATING);
                    }
                    while (cursor2.moveToNext());
                }

                Cursor cursor3 = myDB.getCourseScore(template);

                if (cursor3.moveToFirst()) {
                    do {
                        sc1 = cursor3.getString(DBAdapter.COL_N1_SC1);
                        sc2 = cursor3.getString(DBAdapter.COL_N1_SC2);
                        sc3 = cursor3.getString(DBAdapter.COL_N1_SC3);
                        sc4 = cursor3.getString(DBAdapter.COL_N1_SC4);
                        sc5 = cursor3.getString(DBAdapter.COL_N1_SC5);
                        sc6 = cursor3.getString(DBAdapter.COL_N1_SC6);
                        sc7 = cursor3.getString(DBAdapter.COL_N1_SC7);
                        sc8 = cursor3.getString(DBAdapter.COL_N1_SC8);
                        sc9 = cursor3.getString(DBAdapter.COL_N1_SC9);
                        sc10 = cursor3.getString(DBAdapter.COL_N1_SC10);
                        sc11 = cursor3.getString(DBAdapter.COL_N1_SC11);
                        sc12 = cursor3.getString(DBAdapter.COL_N1_SC12);
                        sc13 = cursor3.getString(DBAdapter.COL_N1_SC13);
                        sc14 = cursor3.getString(DBAdapter.COL_N1_SC14);
                        sc15 = cursor3.getString(DBAdapter.COL_N1_SC15);
                        sc16 = cursor3.getString(DBAdapter.COL_N1_SC16);
                        sc17 = cursor3.getString(DBAdapter.COL_N1_SC17);
                        sc18 = cursor3.getString(DBAdapter.COL_N1_SC18);

                        if (!(template.equals("Blank Template")) && !(sc1.equals("")) && !(sc2.equals("")) && !(sc3.equals("")) && !(sc4.equals("")) && !(sc5.equals("")) && !(sc6.equals("")) && !(sc7.equals("")) && !(sc8.equals(""))
                                && !(sc9.equals(""))) {
                            front_total = Integer.parseInt(sc1) + Integer.parseInt(sc2) + Integer.parseInt(sc3) + Integer.parseInt(sc4) + Integer.parseInt(sc5) + Integer.parseInt(sc6)
                                    + Integer.parseInt(sc7) + Integer.parseInt(sc8) + Integer.parseInt(sc9);
                            if (front_total < best_front) {
                                best_front = front_total;
                            }
                        }
                        if (!(template.equals("Blank Template")) && !(sc10.equals("")) && !(sc11.equals("")) && !(sc12.equals("")) && !(sc13.equals("")) && !(sc14.equals("")) && !(sc15.equals("")) && !(sc16.equals("")) && !(sc17.equals("")) && !(sc18.equals(""))) {
                            back_total = Integer.parseInt(sc10) + Integer.parseInt(sc11) + Integer.parseInt(sc12) + Integer.parseInt(sc13) + Integer.parseInt(sc14) + Integer.parseInt(sc15)
                                    + Integer.parseInt(sc16) + Integer.parseInt(sc17) + Integer.parseInt(sc18);
                            if (back_total < best_back) {
                                best_back = back_total;
                            }
                        }
                        if (!(template.equals("Blank Template")) && !(sc1.equals("")) && !(sc2.equals("")) && !(sc3.equals("")) && !(sc4.equals("")) && !(sc5.equals("")) && !(sc6.equals("")) && !(sc7.equals("")) && !(sc8.equals(""))
                                && !(sc9.equals("")) && !(sc10.equals("")) && !(sc11.equals("")) && !(sc12.equals("")) && !(sc13.equals("")) && !(sc14.equals("")) && !(sc15.equals("")) && !(sc16.equals("")) && !(sc17.equals("")) && !(sc18.equals(""))){

                            score_total = Integer.parseInt(sc1) + Integer.parseInt(sc2) + Integer.parseInt(sc3) + Integer.parseInt(sc4) + Integer.parseInt(sc5) + Integer.parseInt(sc6)
                                    + Integer.parseInt(sc7) + Integer.parseInt(sc8) + Integer.parseInt(sc9) + Integer.parseInt(sc10) + Integer.parseInt(sc11) + Integer.parseInt(sc12)
                                    + Integer.parseInt(sc13) + Integer.parseInt(sc14) + Integer.parseInt(sc15) + Integer.parseInt(sc16) + Integer.parseInt(sc17) + Integer.parseInt(sc18);
                            if (score_total < best_score) {
                                best_score = score_total;
                            }
                            if(!(course_rating.equals("")) && !(course_slope.equals(""))) {
                                number_of_courses++;
                                handicap_differential[(number_of_courses - 1) % 20] = ((score_total - Double.parseDouble(course_rating)) * 113) / Double.parseDouble(course_slope);
                            }
                        }

                    } while (cursor3.moveToNext());
                }

                if (number_of_courses < 5) {

                } else if (number_of_courses >= 5 && number_of_courses < 7) {
                    //top one
                    top_differentials = new Double[1];
                    top_differentials[0] = handicap_differential[0];
                    for (int i = 1; i < number_of_courses; i++) {
                        if (handicap_differential[i] < top_differentials[0]) {
                            top_differentials[0] = handicap_differential[i];
                        }
                    }
                    handicap_index = top_differentials[0] * 0.96;
                    handicap_index = Math.floor(handicap_index * 10);
                    handicap_index = handicap_index * 0.1;
                    course_handicap = (handicap_index * Double.parseDouble(course_slope)) / 113;
                    handicap.append("\n\n\n\n" + template.substring(0, template.length() - 1) + " Handicap: \n\n" + Math.round(course_handicap));
                } else if (number_of_courses >= 7 && number_of_courses < 9) {
                    //top two
                    top_differentials = new Double[2];
                    top_differentials[0] = handicap_differential[0];
                    top_differentials[1] = handicap_differential[1];
                    Quicksort quick = new Quicksort();
                    quick.quickSort(top_differentials);
                    for (int i = 2; i < number_of_courses; i++) {
                        if (handicap_differential[i] < top_differentials[1]) {
                            top_differentials[1] = handicap_differential[i];
                            quick.quickSort(top_differentials);
                        }
                    }
                    handicap_index = ((top_differentials[0] + top_differentials[1])/2) * 0.96;
                    handicap_index = Math.floor(handicap_index * 10);
                    handicap_index = handicap_index * 0.1;
                    course_handicap = (handicap_index * Double.parseDouble(course_slope)) / 113;
                    handicap.append("\n\n\n\n" + template.substring(0, template.length() - 1) + " Handicap: \n\n" + Math.round(course_handicap));
                } else if (number_of_courses >= 9 && number_of_courses < 11) {
                    //top three
                    top_differentials = new Double[3];
                    top_differentials[0] = handicap_differential[0];
                    top_differentials[1] = handicap_differential[1];
                    top_differentials[2] = handicap_differential[2];
                    Quicksort quick = new Quicksort();
                    quick.quickSort(top_differentials);
                    for (int i = 3; i < number_of_courses; i++) {
                        if (handicap_differential[i] < top_differentials[2]) {
                            top_differentials[2] = handicap_differential[i];
                            quick.quickSort(top_differentials);
                        }
                    }
                    handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2])/3) * 0.96;
                    handicap_index = Math.floor(handicap_index * 10);
                    handicap_index = handicap_index * 0.1;
                    course_handicap = (handicap_index * Double.parseDouble(course_slope)) / 113;
                    handicap.append("\n\n\n\n" + template.substring(0, template.length() - 1) + " Handicap: \n\n" + Math.round(course_handicap));
                } else if (number_of_courses >= 11 && number_of_courses < 13) {
                    //top four
                    top_differentials = new Double[4];
                    top_differentials[0] = handicap_differential[0];
                    top_differentials[1] = handicap_differential[1];
                    top_differentials[2] = handicap_differential[2];
                    top_differentials[3] = handicap_differential[3];
                    Quicksort quick = new Quicksort();
                    quick.quickSort(top_differentials);
                    for (int i = 4; i < number_of_courses; i++) {
                        if (handicap_differential[i] < top_differentials[3]) {
                            top_differentials[3] = handicap_differential[i];
                            quick.quickSort(top_differentials);
                        }
                    }
                    handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2] + top_differentials[3])/4) * 0.96;
                    handicap_index = Math.floor(handicap_index * 10);
                    handicap_index = handicap_index * 0.1;
                    course_handicap = (handicap_index * Double.parseDouble(course_slope)) / 113;
                    handicap.append("\n\n\n\n" + template.substring(0, template.length() - 1) + " Handicap: \n\n" + Math.round(course_handicap));
                } else if (number_of_courses >= 13 && number_of_courses < 15) {
                    //top five
                    top_differentials = new Double[5];
                    top_differentials[0] = handicap_differential[0];
                    top_differentials[1] = handicap_differential[1];
                    top_differentials[2] = handicap_differential[2];
                    top_differentials[3] = handicap_differential[3];
                    top_differentials[4] = handicap_differential[4];
                    Quicksort quick = new Quicksort();
                    quick.quickSort(top_differentials);
                    for (int i = 5; i < number_of_courses; i++) {
                        if (handicap_differential[i] < top_differentials[4]) {
                            top_differentials[4] = handicap_differential[i];
                            quick.quickSort(top_differentials);
                        }
                    }
                    handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2] + top_differentials[3] + top_differentials[4])/5) * 0.96;
                    handicap_index = Math.floor(handicap_index * 10);
                    handicap_index = handicap_index * 0.1;
                    course_handicap = (handicap_index * Double.parseDouble(course_slope)) / 113;
                    handicap.append("\n\n\n\n" + template.substring(0, template.length() - 1) + " Handicap: \n\n" + Math.round(course_handicap));
                } else if (number_of_courses >= 15 && number_of_courses < 17) {
                    //top six
                    top_differentials = new Double[6];
                    top_differentials[0] = handicap_differential[0];
                    top_differentials[1] = handicap_differential[1];
                    top_differentials[2] = handicap_differential[2];
                    top_differentials[3] = handicap_differential[3];
                    top_differentials[4] = handicap_differential[4];
                    top_differentials[5] = handicap_differential[5];
                    Quicksort quick = new Quicksort();
                    quick.quickSort(top_differentials);
                    for (int i = 6; i < number_of_courses; i++) {
                        if (handicap_differential[i] < top_differentials[5]) {
                            top_differentials[5] = handicap_differential[i];
                            quick.quickSort(top_differentials);
                        }
                    }
                    handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2] + top_differentials[3] + top_differentials[4]
                            + top_differentials[5])/6) * 0.96;
                    handicap_index = Math.floor(handicap_index * 10);
                    handicap_index = handicap_index * 0.1;
                    course_handicap = (handicap_index * Double.parseDouble(course_slope)) / 113;
                    handicap.append("\n\n\n\n" + template.substring(0, template.length() - 1) + " Handicap: \n\n" + Math.round(course_handicap));
                } else if (number_of_courses == 17) {
                    //top seven
                    top_differentials = new Double[7];
                    top_differentials[0] = handicap_differential[0];
                    top_differentials[1] = handicap_differential[1];
                    top_differentials[2] = handicap_differential[2];
                    top_differentials[3] = handicap_differential[3];
                    top_differentials[4] = handicap_differential[4];
                    top_differentials[5] = handicap_differential[5];
                    top_differentials[6] = handicap_differential[6];
                    Quicksort quick = new Quicksort();
                    quick.quickSort(top_differentials);
                    for (int i = 7; i < number_of_courses; i++) {
                        if (handicap_differential[i] < top_differentials[6]) {
                            top_differentials[6] = handicap_differential[i];
                            quick.quickSort(top_differentials);
                        }
                    }
                    handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2] + top_differentials[3] + top_differentials[4]
                            + top_differentials[5] + top_differentials[6])/7) * 0.96;
                    handicap_index = Math.floor(handicap_index * 10);
                    handicap_index = handicap_index * 0.1;
                    course_handicap = (handicap_index * Double.parseDouble(course_slope)) / 113;
                    handicap.append("\n\n\n\n" + template.substring(0, template.length() - 1) + " Handicap: \n\n" + Math.round(course_handicap));
                } else if (number_of_courses == 18) {
                    //top eight
                    top_differentials = new Double[8];
                    top_differentials[0] = handicap_differential[0];
                    top_differentials[1] = handicap_differential[1];
                    top_differentials[2] = handicap_differential[2];
                    top_differentials[3] = handicap_differential[3];
                    top_differentials[4] = handicap_differential[4];
                    top_differentials[5] = handicap_differential[5];
                    top_differentials[6] = handicap_differential[6];
                    top_differentials[7] = handicap_differential[7];
                    Quicksort quick = new Quicksort();
                    quick.quickSort(top_differentials);
                    for (int i = 8; i < number_of_courses; i++) {
                        if (handicap_differential[i] < top_differentials[7]) {
                            top_differentials[7] = handicap_differential[i];
                            quick.quickSort(top_differentials);
                        }
                    }
                    handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2] + top_differentials[3] + top_differentials[4]
                            + top_differentials[5] + top_differentials[6] + top_differentials[7])/8) * 0.96;
                    handicap_index = Math.floor(handicap_index * 10);
                    handicap_index = handicap_index * 0.1;
                    course_handicap = (handicap_index * Double.parseDouble(course_slope)) / 113;
                    handicap.append("\n\n\n\n" + template.substring(0, template.length() - 1) + " Handicap: \n\n" + Math.round(course_handicap));
                } else if (number_of_courses == 19) {
                    //top nine
                    top_differentials = new Double[9];
                    top_differentials[0] = handicap_differential[0];
                    top_differentials[1] = handicap_differential[1];
                    top_differentials[2] = handicap_differential[2];
                    top_differentials[3] = handicap_differential[3];
                    top_differentials[4] = handicap_differential[4];
                    top_differentials[5] = handicap_differential[5];
                    top_differentials[6] = handicap_differential[6];
                    top_differentials[7] = handicap_differential[7];
                    top_differentials[8] = handicap_differential[8];
                    Quicksort quick = new Quicksort();
                    quick.quickSort(top_differentials);
                    for (int i = 9; i < number_of_courses; i++) {
                        if (handicap_differential[i] < top_differentials[8]) {
                            top_differentials[8] = handicap_differential[i];
                            quick.quickSort(top_differentials);
                        }
                    }
                    handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2] + top_differentials[3] + top_differentials[4]
                            + top_differentials[5] + top_differentials[6] + top_differentials[7] + top_differentials[8])/9) * 0.96;
                    handicap_index = Math.floor(handicap_index * 10);
                    handicap_index = handicap_index * 0.1;
                    course_handicap = (handicap_index * Double.parseDouble(course_slope)) / 113;
                    handicap.append("\n\n\n\n" + template.substring(0, template.length() - 1) + " Handicap: \n\n" + Math.round(course_handicap));
                } else {
                    //top ten
                    top_differentials = new Double[10];
                    top_differentials[0] = handicap_differential[0];
                    top_differentials[1] = handicap_differential[1];
                    top_differentials[2] = handicap_differential[2];
                    top_differentials[3] = handicap_differential[3];
                    top_differentials[4] = handicap_differential[4];
                    top_differentials[5] = handicap_differential[5];
                    top_differentials[6] = handicap_differential[6];
                    top_differentials[7] = handicap_differential[7];
                    top_differentials[8] = handicap_differential[8];
                    top_differentials[9] = handicap_differential[9];
                    Quicksort quick = new Quicksort();
                    quick.quickSort(top_differentials);
                    for (int i = 10; i < 20; i++) {
                        if (handicap_differential[i] < top_differentials[9]) {
                            top_differentials[9] = handicap_differential[i];
                            quick.quickSort(top_differentials);
                        }
                    }
                    handicap_index = ((top_differentials[0] + top_differentials[1] + top_differentials[2] + top_differentials[3] + top_differentials[4]
                            + top_differentials[5] + top_differentials[6] + top_differentials[7] + top_differentials[8] + top_differentials[9])/10) * 0.96;
                    handicap_index = Math.floor(handicap_index * 10);
                    handicap_index = handicap_index * 0.1;
                    course_handicap = (handicap_index * Double.parseDouble(course_slope)) / 113;
                    handicap.append("\n\n\n\n" + template.substring(0, template.length() - 1) + " Handicap: \n\n" + Math.round(course_handicap));
                }

                if(best_score != 1000) {
                    handicap.append("\n\n\n" + template.substring(0, template.length() - 1) + " Lowest 18 Hole Score: \n\n" + best_score + "\n");
                }
                if(best_front != 1000) {
                    handicap.append("\n\n\n" + template.substring(0, template.length() - 1) + " Lowest Front 9 Score: \n\n" + best_front + "\n");
                }
                if(best_back != 1000) {
                    handicap.append("\n\n\n" + template.substring(0, template.length() - 1) + " Lowest Back 9 Score: \n\n" + best_back + "\n");
                }

            } while (cursor.moveToNext());
        }
    }

    private void openDB() {
        myDB = new DBAdapter(this);
        myDB.open();
    }

    private void closeDB() {
        myDB.close();
    }


    public class Quicksort {

        private int count = 0;

        public <T extends Comparable<T>> void quickSort(T[] data) {
            quickSort(data, 0, data.length - 1);
        }

        private <T extends Comparable<T>> void quickSort(T[] data, int min, int max) {
            if (min < max) {
                // create partitions
                int indexofpartition = partition(data, min, max);

                // sort the left partition (lower values)
                quickSort(data, min, indexofpartition - 1);

                // sort the right partition (higher values)
                quickSort(data, indexofpartition + 1, max);
            }
        }

        public <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
            T temp = data[index1];
            data[index1] = data[index2];
            data[index2] = temp;
        }

        public <T extends Comparable<T>> int partition(T[] data, int min, int max) {
            T partitionelement;
            int left, right;
            int middle = (min + max) / 2;

            partitionelement = data[middle];
            swap(data, middle, min);

            left = min;
            right = max;

            while (left < right) {
                while (left < right && data[left].compareTo(partitionelement) <= 0) {
                    left++;
                    count++;
                }
                while (data[right].compareTo(partitionelement) > 0) {
                    right--;
                    count++;
                }
                if (left < right) {
                    swap(data, left, right);
                    count++;
                }
            }
            swap(data, min, right);

            return right;
        }

        public String count() {
            String result = "Number of quickSort comparisons: " + count;
            count = 0;
            return result;
        }
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

    @Override
    protected void onResume() {
        super.onResume();
        mAdView.resume();
    }
}
