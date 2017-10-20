package com.ep.eric.golfscorecardbuddy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by T00229613 on 2/6/2017.
 */


public class DBAdapter {

    public static final String KEY_ROWID = "_id";
    public static final int COL_ROWID = 0;
    public static final String NAME = "name";
    public static final String PAR1 = "par1";
    public static final String PAR2 = "par2";
    public static final String PAR3 = "par3";
    public static final String PAR4 = "par4";
    public static final String PAR5 = "par5";
    public static final String PAR6 = "par6";
    public static final String PAR7 = "par7";
    public static final String PAR8 = "par8";
    public static final String PAR9 = "par9";
    public static final String PAR10 = "par10";
    public static final String PAR11 = "par11";
    public static final String PAR12 = "par12";
    public static final String PAR13 = "par13";
    public static final String PAR14 = "par14";
    public static final String PAR15 = "par15";
    public static final String PAR16 = "par16";
    public static final String PAR17 = "par17";
    public static final String PAR18 = "par18";
    public static final String YARD1 = "yard1";
    public static final String YARD2 = "yard2";
    public static final String YARD3 = "yard3";
    public static final String YARD4 = "yard4";
    public static final String YARD5 = "yard5";
    public static final String YARD6 = "yard6";
    public static final String YARD7 = "yard7";
    public static final String YARD8 = "yard8";
    public static final String YARD9 = "yard9";
    public static final String YARD10 = "yard10";
    public static final String YARD11 = "yard11";
    public static final String YARD12 = "yard12";
    public static final String YARD13 = "yard13";
    public static final String YARD14 = "yard14";
    public static final String YARD15 = "yard15";
    public static final String YARD16 = "yard16";
    public static final String YARD17 = "yard17";
    public static final String YARD18 = "yard18";
    public static final String COURSE_RATING = "course_rating";
    public static final String SLOPE_RATING = "slope_rating";

    public static final String KEY_ROWID2 = "_id2";
    public static final String TEMPLATE = "template";
    public static final String PLAYERS = "players";
    public static final String N1_SC1 = "n1_sc1";
    public static final String N1_SC2 = "n1_sc2";
    public static final String N1_SC3 = "n1_sc3";
    public static final String N1_SC4 = "n1_sc4";
    public static final String N1_SC5 = "n1_sc5";
    public static final String N1_SC6 = "n1_sc6";
    public static final String N1_SC7 = "n1_sc7";
    public static final String N1_SC8 = "n1_sc8";
    public static final String N1_SC9 = "n1_sc9";
    public static final String N1_SC10 = "n1_sc10";
    public static final String N1_SC11 = "n1_sc11";
    public static final String N1_SC12 = "n1_sc12";
    public static final String N1_SC13 = "n1_sc13";
    public static final String N1_SC14 = "n1_sc14";
    public static final String N1_SC15 = "n1_sc15";
    public static final String N1_SC16 = "n1_sc16";
    public static final String N1_SC17 = "n1_sc17";
    public static final String N1_SC18 = "n1_sc18";
    public static final String N2_SC1 = "n2_sc1";
    public static final String N2_SC2 = "n2_sc2";
    public static final String N2_SC3 = "n2_sc3";
    public static final String N2_SC4 = "n2_sc4";
    public static final String N2_SC5 = "n2_sc5";
    public static final String N2_SC6 = "n2_sc6";
    public static final String N2_SC7 = "n2_sc7";
    public static final String N2_SC8 = "n2_sc8";
    public static final String N2_SC9 = "n2_sc9";
    public static final String N2_SC10 = "n2_sc10";
    public static final String N2_SC11 = "n2_sc11";
    public static final String N2_SC12 = "n2_sc12";
    public static final String N2_SC13 = "n2_sc13";
    public static final String N2_SC14 = "n2_sc14";
    public static final String N2_SC15 = "n2_sc15";
    public static final String N2_SC16 = "n2_sc16";
    public static final String N2_SC17 = "n2_sc17";
    public static final String N2_SC18 = "n2_sc18";
    public static final String N3_SC1 = "n3_sc1";
    public static final String N3_SC2 = "n3_sc2";
    public static final String N3_SC3 = "n3_sc3";
    public static final String N3_SC4 = "n3_sc4";
    public static final String N3_SC5 = "n3_sc5";
    public static final String N3_SC6 = "n3_sc6";
    public static final String N3_SC7 = "n3_sc7";
    public static final String N3_SC8 = "n3_sc8";
    public static final String N3_SC9 = "n3_sc9";
    public static final String N3_SC10 = "n3_sc10";
    public static final String N3_SC11 = "n3_sc11";
    public static final String N3_SC12 = "n3_sc12";
    public static final String N3_SC13 = "n3_sc13";
    public static final String N3_SC14 = "n3_sc14";
    public static final String N3_SC15 = "n3_sc15";
    public static final String N3_SC16 = "n3_sc16";
    public static final String N3_SC17 = "n3_sc17";
    public static final String N3_SC18 = "n3_sc18";
    public static final String N4_SC1 = "n4_sc1";
    public static final String N4_SC2 = "n4_sc2";
    public static final String N4_SC3 = "n4_sc3";
    public static final String N4_SC4 = "n4_sc4";
    public static final String N4_SC5 = "n4_sc5";
    public static final String N4_SC6 = "n4_sc6";
    public static final String N4_SC7 = "n4_sc7";
    public static final String N4_SC8 = "n4_sc8";
    public static final String N4_SC9 = "n4_sc9";
    public static final String N4_SC10 = "n4_sc10";
    public static final String N4_SC11 = "n4_sc11";
    public static final String N4_SC12 = "n4_sc12";
    public static final String N4_SC13 = "n4_sc13";
    public static final String N4_SC14 = "n4_sc14";
    public static final String N4_SC15 = "n4_sc15";
    public static final String N4_SC16 = "n4_sc16";
    public static final String N4_SC17 = "n4_sc17";
    public static final String N4_SC18 = "n4_sc18";
    public static final String N2 = "n2";
    public static final String N3 = "n3";
    public static final String N4 = "n4";

    public static final String KEY_ROWID3 = "_id3";
    public static final String COURSE_NAME = "course_name";
    public static final String YEAR = "year";
    public static final String MONTH = "month";
    public static final String DATE = "date";
    public static final String HOUR = "hour";
    public static final String MINUTE = "minute";
    public static final String NOTIFICATION = "notification";

    public static final int COL_ROWID3 = 0;
    public static final int COL_COURSE_NAME = 1;
    public static final int COL_YEAR = 2;
    public static final int COL_MONTH = 3;
    public static final int COL_DATE = 4;
    public static final int COL_HOUR = 5;
    public static final int COL_MINUTE = 6;
    public static final int COL_NOTIFICATION = 7;

    public static final int COL_ROWID2 = 0;
    public static final int COL_NAME = 1;
    public static final int COL_PAR1 = 2;
    public static final int COL_PAR2 = 3;
    public static final int COL_PAR3 = 4;
    public static final int COL_PAR4 = 5;
    public static final int COL_PAR5 = 6;
    public static final int COL_PAR6 = 7;
    public static final int COL_PAR7 = 8;
    public static final int COL_PAR8 = 9;
    public static final int COL_PAR9 = 10;
    public static final int COL_PAR10 = 11;
    public static final int COL_PAR11 = 12;
    public static final int COL_PAR12 = 13;
    public static final int COL_PAR13 = 14;
    public static final int COL_PAR14 = 15;
    public static final int COL_PAR15 = 16;
    public static final int COL_PAR16 = 17;
    public static final int COL_PAR17 = 18;
    public static final int COL_PAR18 = 19;
    public static final int COL_YARD1 = 20;
    public static final int COL_YARD2 = 21;
    public static final int COL_YARD3 = 22;
    public static final int COL_YARD4 = 23;
    public static final int COL_YARD5 = 24;
    public static final int COL_YARD6 = 25;
    public static final int COL_YARD7 = 26;
    public static final int COL_YARD8 = 27;
    public static final int COL_YARD9 = 28;
    public static final int COL_YARD10 = 29;
    public static final int COL_YARD11 = 30;
    public static final int COL_YARD12 = 31;
    public static final int COL_YARD13 = 32;
    public static final int COL_YARD14 = 33;
    public static final int COL_YARD15 = 34;
    public static final int COL_YARD16 = 35;
    public static final int COL_YARD17 = 36;
    public static final int COL_YARD18 = 37;
    public static final int COL_COURSE_RATING = 38;
    public static final int COL_SLOPE_RATING= 39;

    public static final int COL_TEMPLATE = 1;
    public static final int COL_PLAYERS = 2;
    public static final int COL_N1_SC1 = 3;
    public static final int COL_N1_SC2 = 4;
    public static final int COL_N1_SC3 = 5;
    public static final int COL_N1_SC4 = 6;
    public static final int COL_N1_SC5 = 7;
    public static final int COL_N1_SC6 = 8;
    public static final int COL_N1_SC7 = 9;
    public static final int COL_N1_SC8 = 10;
    public static final int COL_N1_SC9 = 11;
    public static final int COL_N1_SC10 = 12;
    public static final int COL_N1_SC11 = 13;
    public static final int COL_N1_SC12 = 14;
    public static final int COL_N1_SC13 = 15;
    public static final int COL_N1_SC14 = 16;
    public static final int COL_N1_SC15 = 17;
    public static final int COL_N1_SC16 = 18;
    public static final int COL_N1_SC17 = 19;
    public static final int COL_N1_SC18 = 20;
    public static final int COL_N2_SC1 = 21;
    public static final int COL_N2_SC2 = 22;
    public static final int COL_N2_SC3 = 23;
    public static final int COL_N2_SC4 = 24;
    public static final int COL_N2_SC5 = 25;
    public static final int COL_N2_SC6 = 26;
    public static final int COL_N2_SC7 = 27;
    public static final int COL_N2_SC8 = 28;
    public static final int COL_N2_SC9 = 29;
    public static final int COL_N2_SC10 = 30;
    public static final int COL_N2_SC11 = 31;
    public static final int COL_N2_SC12 = 32;
    public static final int COL_N2_SC13 = 33;
    public static final int COL_N2_SC14 = 34;
    public static final int COL_N2_SC15= 35;
    public static final int COL_N2_SC16= 36;
    public static final int COL_N2_SC17 = 37;
    public static final int COL_N2_SC18 = 38;
    public static final int COL_N3_SC1 = 30;
    public static final int COL_N3_SC2 = 40;
    public static final int COL_N3_SC3 = 41;
    public static final int COL_N3_SC4 = 42;
    public static final int COL_N3_SC5 = 43;
    public static final int COL_N3_SC6 = 44;
    public static final int COL_N3_SC7 = 45;
    public static final int COL_N3_SC8 = 46;
    public static final int COL_N3_SC9 = 47;
    public static final int COL_N3_SC10 = 48;
    public static final int COL_N3_SC11 = 49;
    public static final int COL_N3_SC12 = 50;
    public static final int COL_N3_SC13 = 51;
    public static final int COL_N3_SC14 = 52;
    public static final int COL_N3_SC15 = 53;
    public static final int COL_N3_SC16 = 54;
    public static final int COL_N3_SC17 = 55;
    public static final int COL_N3_SC18 = 56;
    public static final int COL_N4_SC1 = 57;
    public static final int COL_N4_SC2 = 58;
    public static final int COL_N4_SC3 = 59;
    public static final int COL_N4_SC4 = 60;
    public static final int COL_N4_SC5 = 61;
    public static final int COL_N4_SC6 = 62;
    public static final int COL_N4_SC7 = 63;
    public static final int COL_N4_SC8 = 64;
    public static final int COL_N4_SC9 = 65;
    public static final int COL_N4_SC10 = 66;
    public static final int COL_N4_SC11 = 67;
    public static final int COL_N4_SC12 = 68;
    public static final int COL_N4_SC13 = 69;
    public static final int COL_N4_SC14 = 70;
    public static final int COL_N4_SC15= 71;
    public static final int COL_N4_SC16= 72;
    public static final int COL_N4_SC17 = 73;
    public static final int COL_N4_SC18 = 74;
    public static final int COL_N2 = 75;
    public static final int COL_N3= 76;
    public static final int COL_N4 = 77;

    public static final String[] ALL_KEYS = {KEY_ROWID, NAME, PAR1, PAR2, PAR3, PAR4, PAR5, PAR6, PAR7, PAR8, PAR9,
            PAR10, PAR11, PAR12, PAR13, PAR14, PAR15, PAR16, PAR17, PAR18, YARD1, YARD2, YARD3, YARD4, YARD5,
            YARD6, YARD7, YARD8, YARD9, YARD10, YARD11, YARD12, YARD13, YARD14, YARD15, YARD15, YARD16, YARD17,
            YARD18, COURSE_RATING, SLOPE_RATING};

    public static final String[] ALL_KEYS2 = {KEY_ROWID2, TEMPLATE, PLAYERS, N1_SC1, N1_SC2, N1_SC3, N1_SC4, N1_SC5, N1_SC6,
            N1_SC7, N1_SC8, N1_SC9, N1_SC10, N1_SC11, N1_SC12, N1_SC13, N1_SC14, N1_SC15, N1_SC16, N1_SC17, N1_SC18,
            N2_SC1, N2_SC2, N2_SC3, N2_SC4, N2_SC5, N2_SC6, N2_SC7, N2_SC8, N2_SC9, N2_SC10, N2_SC11, N2_SC12, N2_SC13,
            N2_SC14, N2_SC15, N2_SC16, N2_SC17, N2_SC18, N3_SC1, N3_SC2, N3_SC3, N3_SC4, N3_SC5, N3_SC6, N3_SC6, N3_SC7,
            N3_SC8, N3_SC8, N3_SC9, N3_SC10, N3_SC11, N3_SC12, N3_SC13, N3_SC14, N3_SC15, N3_SC16, N3_SC17, N3_SC18,
            N4_SC1, N4_SC2, N4_SC3, N4_SC4, N4_SC5, N4_SC6, N4_SC7, N4_SC8, N4_SC9, N4_SC10, N4_SC11, N4_SC12, N4_SC13,
            N4_SC14, N4_SC15, N4_SC17, N4_SC18, N2, N3, N4};

    public static final String[] ALL_KEYS3 = {KEY_ROWID3, COURSE_NAME, YEAR, MONTH, DATE, HOUR, MINUTE, NOTIFICATION};

    public static final String DATABASE_NAME = "ScorecardDB";
    public static final String DATABASE_TABLE1 = "Course_Info_Table";
    public static final String DATABASE_TABLE2 = "Scores_Table";
    public static final String DATABASE_TABLE3 = "Teetime_Table";

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_CREATE_SQL =
            "create table " + DATABASE_TABLE1
                    + " (" + KEY_ROWID + " integer primary key autoincrement, "
                    + NAME + " text not null, "
                    + PAR1 + " text, "
                    + PAR2 + " text, "
                    + PAR3 + " text, "
                    + PAR4 + " text, "
                    + PAR5 + " text, "
                    + PAR6 + " text, "
                    + PAR7 + " text, "
                    + PAR8 + " text, "
                    + PAR9 + " text, "
                    + PAR10 + " text, "
                    + PAR11 + " text, "
                    + PAR12 + " text, "
                    + PAR13 + " text, "
                    + PAR14 + " text, "
                    + PAR15 + " text, "
                    + PAR16 + " text, "
                    + PAR17 + " text, "
                    + PAR18 + " text, "
                    + YARD1 + " text, "
                    + YARD2 + " text, "
                    + YARD3 + " text, "
                    + YARD4 + " text, "
                    + YARD5 + " text, "
                    + YARD6 + " text, "
                    + YARD7 + " text, "
                    + YARD8 + " text, "
                    + YARD9 + " text, "
                    + YARD10 + " text, "
                    + YARD11 + " text, "
                    + YARD12 + " text, "
                    + YARD13 + " text, "
                    + YARD14 + " text, "
                    + YARD15 + " text, "
                    + YARD16 + " text, "
                    + YARD17 + " text, "
                    + YARD18 + " text, "
                    + COURSE_RATING + " text, "
                    + SLOPE_RATING + " text"
                    + ");";

    public static final String DATABASE_CREATE_SQL2 =
            "create table " + DATABASE_TABLE2
                    + " (" + KEY_ROWID2 + " integer primary key autoincrement, "
                    + TEMPLATE + " text not null, "
                    + PLAYERS + " text not null, "
                    + N1_SC1 + " text, "
                    + N1_SC2 + " text, "
                    + N1_SC3 + " text, "
                    + N1_SC4 + " text, "
                    + N1_SC5 + " text, "
                    + N1_SC6 + " text, "
                    + N1_SC7 + " text, "
                    + N1_SC8 + " text, "
                    + N1_SC9 + " text, "
                    + N1_SC10 + " text, "
                    + N1_SC11 + " text, "
                    + N1_SC12 + " text, "
                    + N1_SC13 + " text, "
                    + N1_SC14 + " text, "
                    + N1_SC15 + " text, "
                    + N1_SC16 + " text, "
                    + N1_SC17 + " text, "
                    + N1_SC18 + " text, "
                    + N2_SC1 + " text, "
                    + N2_SC2 + " text, "
                    + N2_SC3 + " text, "
                    + N2_SC4 + " text, "
                    + N2_SC5 + " text, "
                    + N2_SC6 + " text, "
                    + N2_SC7 + " text, "
                    + N2_SC8 + " text, "
                    + N2_SC9 + " text, "
                    + N2_SC10 + " text, "
                    + N2_SC11 + " text, "
                    + N2_SC12 + " text, "
                    + N2_SC13 + " text, "
                    + N2_SC14 + " text, "
                    + N2_SC15 + " text, "
                    + N2_SC16 + " text, "
                    + N2_SC17 + " text, "
                    + N2_SC18 + " text, "
                    + N3_SC1 + " text, "
                    + N3_SC2 + " text, "
                    + N3_SC3 + " text, "
                    + N3_SC4 + " text, "
                    + N3_SC5 + " text, "
                    + N3_SC6 + " text, "
                    + N3_SC7 + " text, "
                    + N3_SC8 + " text, "
                    + N3_SC9 + " text, "
                    + N3_SC10 + " text, "
                    + N3_SC11 + " text, "
                    + N3_SC12 + " text, "
                    + N3_SC13 + " text, "
                    + N3_SC14 + " text, "
                    + N3_SC15 + " text, "
                    + N3_SC16 + " text, "
                    + N3_SC17 + " text, "
                    + N3_SC18 + " text, "
                    + N4_SC1 + " text, "
                    + N4_SC2 + " text, "
                    + N4_SC3 + " text, "
                    + N4_SC4 + " text, "
                    + N4_SC5 + " text, "
                    + N4_SC6 + " text, "
                    + N4_SC7 + " text, "
                    + N4_SC8 + " text, "
                    + N4_SC9 + " text, "
                    + N4_SC10 + " text, "
                    + N4_SC11 + " text, "
                    + N4_SC12 + " text, "
                    + N4_SC13 + " text, "
                    + N4_SC14 + " text, "
                    + N4_SC15 + " text, "
                    + N4_SC16 + " text, "
                    + N4_SC17 + " text, "
                    + N4_SC18 + " text, "
                    + N2 + " text, "
                    + N3+ " text, "
                    + N4 + " text"
                    + ");";

    public static final String DATABASE_CREATE_SQL3 =
            "create table " + DATABASE_TABLE3
                    + " (" + KEY_ROWID3 + " integer primary key autoincrement, "
                    + COURSE_NAME + " text not null, "
                    + YEAR + " text not null, "
                    + MONTH + " text not null, "
                    + DATE + " text not null, "
                    + HOUR + " text not null, "
                    + MINUTE + " text not null, "
                    + NOTIFICATION + " text"
                    + ");";

    private final Context context;
    private DatabaseHelper myDBHelper;
    private SQLiteDatabase db;


    public DBAdapter(Context cx){
        this.context = cx;
        myDBHelper = new DatabaseHelper(context);
    }

    public DBAdapter open(){
        db = myDBHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        myDBHelper.close();
    }

    public long insertRow(String name, String par1, String par2, String par3, String par4,
                          String par5, String par6, String par7, String par8, String par9,
                          String par10, String par11, String par12, String par13, String par14,
                          String par15, String par16, String par17, String par18, String yard1,
                          String yard2, String yard3, String yard4, String yard5, String yard6,
                          String yard7, String yard8, String yard9, String yard10, String yard11,
                          String yard12, String yard13, String yard14, String yard15, String yard16,
                          String yard17, String yard18, String course_rating, String slope_rating){
        ContentValues initialValues = new ContentValues();
        initialValues.put(NAME, name);
        initialValues.put(PAR1, par1);
        initialValues.put(PAR2, par2);
        initialValues.put(PAR3, par3);
        initialValues.put(PAR4, par4);
        initialValues.put(PAR5, par5);
        initialValues.put(PAR6, par6);
        initialValues.put(PAR7, par7);
        initialValues.put(PAR8, par8);
        initialValues.put(PAR9, par9);
        initialValues.put(PAR10, par10);
        initialValues.put(PAR11, par11);
        initialValues.put(PAR12, par12);
        initialValues.put(PAR13, par13);
        initialValues.put(PAR14, par14);
        initialValues.put(PAR15, par15);
        initialValues.put(PAR16, par16);
        initialValues.put(PAR17, par17);
        initialValues.put(PAR18, par18);
        initialValues.put(YARD1, yard1);
        initialValues.put(YARD2, yard2);
        initialValues.put(YARD3, yard3);
        initialValues.put(YARD4, yard4);
        initialValues.put(YARD5, yard5);
        initialValues.put(YARD6, yard6);
        initialValues.put(YARD7, yard7);
        initialValues.put(YARD8, yard8);
        initialValues.put(YARD9, yard9);
        initialValues.put(YARD10, yard10);
        initialValues.put(YARD11, yard11);
        initialValues.put(YARD12, yard12);
        initialValues.put(YARD13, yard13);
        initialValues.put(YARD14, yard14);
        initialValues.put(YARD15, yard15);
        initialValues.put(YARD16, yard16);
        initialValues.put(YARD17, yard17);
        initialValues.put(YARD18, yard18);
        initialValues.put(COURSE_RATING, course_rating);
        initialValues.put(SLOPE_RATING, slope_rating);

        return db.insert(DATABASE_TABLE1, null, initialValues);
    }

    public long insertRow2(String template, String players, String n1_sc1, String n1_sc2, String n1_sc3, String n1_sc4,
                          String n1_sc5, String n1_sc6, String n1_sc7, String n1_sc8, String n1_sc9,
                          String n1_sc10, String n1_sc11, String n1_sc12, String n1_sc13, String n1_sc14,
                          String n1_sc15, String n1_sc16, String n1_sc17, String n1_sc18, String n2_sc1,
                          String n2_sc2, String n2_sc3, String n2_sc4, String n2_sc5, String n2_sc6,
                          String n2_sc7, String n2_sc8, String n2_sc9, String n2_sc10, String n2_sc11,
                          String n2_sc12, String n2_sc13, String n2_sc14, String n2_sc15, String n2_sc16,
                          String n2_sc17, String n2_sc18, String n3_sc1, String n3_sc2, String n3_sc3, String n3_sc4,
                           String n3_sc5, String n3_sc6, String n3_sc7, String n3_sc8, String n3_sc9,
                           String n3_sc10, String n3_sc11, String n3_sc12, String n3_sc13, String n3_sc14,
                           String n3_sc15, String n3_sc16, String n3_sc17, String n3_sc18, String n4_sc1,
                           String n4_sc2, String n4_sc3, String n4_sc4, String n4_sc5, String n4_sc6,
                           String n4_sc7, String n4_sc8, String n4_sc9, String n4_sc10, String n4_sc11,
                           String n4_sc12, String n4_sc13, String n4_sc14, String n4_sc15, String n4_sc16,
                           String n4_sc17, String n4_sc18, String n2, String n3, String n4){
        ContentValues initialValues = new ContentValues();
        initialValues.put(TEMPLATE, template);
        initialValues.put(PLAYERS, players);
        initialValues.put(N1_SC1, n1_sc1);
        initialValues.put(N1_SC2, n1_sc2);
        initialValues.put(N1_SC3, n1_sc3);
        initialValues.put(N1_SC4, n1_sc4);
        initialValues.put(N1_SC5, n1_sc5);
        initialValues.put(N1_SC6, n1_sc6);
        initialValues.put(N1_SC7, n1_sc7);
        initialValues.put(N1_SC8, n1_sc8);
        initialValues.put(N1_SC9, n1_sc9);
        initialValues.put(N1_SC10, n1_sc10);
        initialValues.put(N1_SC11, n1_sc11);
        initialValues.put(N1_SC12, n1_sc12);
        initialValues.put(N1_SC13, n1_sc13);
        initialValues.put(N1_SC14, n1_sc14);
        initialValues.put(N1_SC15, n1_sc15);
        initialValues.put(N1_SC16, n1_sc16);
        initialValues.put(N1_SC17, n1_sc17);
        initialValues.put(N1_SC18, n1_sc18);
        initialValues.put(N2_SC1, n2_sc1);
        initialValues.put(N2_SC2, n2_sc2);
        initialValues.put(N2_SC3, n2_sc3);
        initialValues.put(N2_SC4, n2_sc4);
        initialValues.put(N2_SC5, n2_sc5);
        initialValues.put(N2_SC6, n2_sc6);
        initialValues.put(N2_SC7, n2_sc7);
        initialValues.put(N2_SC8, n2_sc8);
        initialValues.put(N2_SC9, n2_sc9);
        initialValues.put(N2_SC10, n2_sc10);
        initialValues.put(N2_SC11, n2_sc11);
        initialValues.put(N2_SC12, n2_sc12);
        initialValues.put(N2_SC13, n2_sc13);
        initialValues.put(N2_SC14, n2_sc14);
        initialValues.put(N2_SC15, n2_sc15);
        initialValues.put(N2_SC16, n2_sc16);
        initialValues.put(N2_SC17, n2_sc17);
        initialValues.put(N2_SC18, n2_sc18);
        initialValues.put(N3_SC1, n3_sc1);
        initialValues.put(N3_SC2, n3_sc2);
        initialValues.put(N3_SC3, n3_sc3);
        initialValues.put(N3_SC4, n3_sc4);
        initialValues.put(N3_SC5, n3_sc5);
        initialValues.put(N3_SC6, n3_sc6);
        initialValues.put(N3_SC7, n3_sc7);
        initialValues.put(N3_SC8, n3_sc8);
        initialValues.put(N3_SC9, n3_sc9);
        initialValues.put(N3_SC10, n3_sc10);
        initialValues.put(N3_SC11, n3_sc11);
        initialValues.put(N3_SC12, n3_sc12);
        initialValues.put(N3_SC13, n3_sc13);
        initialValues.put(N3_SC14, n3_sc14);
        initialValues.put(N3_SC15, n3_sc15);
        initialValues.put(N3_SC16, n3_sc16);
        initialValues.put(N3_SC17, n3_sc17);
        initialValues.put(N3_SC18, n3_sc18);
        initialValues.put(N4_SC1, n4_sc1);
        initialValues.put(N4_SC2, n4_sc2);
        initialValues.put(N4_SC3, n4_sc3);
        initialValues.put(N4_SC4, n4_sc4);
        initialValues.put(N4_SC5, n4_sc5);
        initialValues.put(N4_SC6, n4_sc6);
        initialValues.put(N4_SC7, n4_sc7);
        initialValues.put(N4_SC8, n4_sc8);
        initialValues.put(N4_SC9, n4_sc9);
        initialValues.put(N4_SC10, n4_sc10);
        initialValues.put(N4_SC11, n4_sc11);
        initialValues.put(N4_SC12, n4_sc12);
        initialValues.put(N4_SC13, n4_sc13);
        initialValues.put(N4_SC14, n4_sc14);
        initialValues.put(N4_SC15, n4_sc15);
        initialValues.put(N4_SC16, n4_sc16);
        initialValues.put(N4_SC17, n4_sc17);
        initialValues.put(N4_SC18, n4_sc18);
        initialValues.put(N2, n2);
        initialValues.put(N3, n3);
        initialValues.put(N4, n4);

        return db.insert(DATABASE_TABLE2, null, initialValues);
    }

    public long insertRow3(String course_name, String year, String month, String date, String hour, String minute, String notification){
        ContentValues initialValues = new ContentValues();
        initialValues.put(COURSE_NAME, course_name);
        initialValues.put(YEAR, year);
        initialValues.put(MONTH, month);
        initialValues.put(DATE, date);
        initialValues.put(HOUR, hour);
        initialValues.put(MINUTE, minute);
        initialValues.put(NOTIFICATION, notification);

        return db.insert(DATABASE_TABLE3, null, initialValues);
    }

    public long updateRow2(long id, String template, String players, String n1_sc1, String n1_sc2, String n1_sc3, String n1_sc4,
                           String n1_sc5, String n1_sc6, String n1_sc7, String n1_sc8, String n1_sc9,
                           String n1_sc10, String n1_sc11, String n1_sc12, String n1_sc13, String n1_sc14,
                           String n1_sc15, String n1_sc16, String n1_sc17, String n1_sc18, String n2_sc1,
                           String n2_sc2, String n2_sc3, String n2_sc4, String n2_sc5, String n2_sc6,
                           String n2_sc7, String n2_sc8, String n2_sc9, String n2_sc10, String n2_sc11,
                           String n2_sc12, String n2_sc13, String n2_sc14, String n2_sc15, String n2_sc16,
                           String n2_sc17, String n2_sc18, String n3_sc1, String n3_sc2, String n3_sc3, String n3_sc4,
                           String n3_sc5, String n3_sc6, String n3_sc7, String n3_sc8, String n3_sc9,
                           String n3_sc10, String n3_sc11, String n3_sc12, String n3_sc13, String n3_sc14,
                           String n3_sc15, String n3_sc16, String n3_sc17, String n3_sc18, String n4_sc1,
                           String n4_sc2, String n4_sc3, String n4_sc4, String n4_sc5, String n4_sc6,
                           String n4_sc7, String n4_sc8, String n4_sc9, String n4_sc10, String n4_sc11,
                           String n4_sc12, String n4_sc13, String n4_sc14, String n4_sc15, String n4_sc16,
                           String n4_sc17, String n4_sc18, String n2, String n3, String n4){
        ContentValues values = new ContentValues();
        values.put(TEMPLATE, template);
        values.put(PLAYERS, players);
        values.put(N1_SC1, n1_sc1);
        values.put(N1_SC2, n1_sc2);
        values.put(N1_SC3, n1_sc3);
        values.put(N1_SC4, n1_sc4);
        values.put(N1_SC5, n1_sc5);
        values.put(N1_SC6, n1_sc6);
        values.put(N1_SC7, n1_sc7);
        values.put(N1_SC8, n1_sc8);
        values.put(N1_SC9, n1_sc9);
        values.put(N1_SC10, n1_sc10);
        values.put(N1_SC11, n1_sc11);
        values.put(N1_SC12, n1_sc12);
        values.put(N1_SC13, n1_sc13);
        values.put(N1_SC14, n1_sc14);
        values.put(N1_SC15, n1_sc15);
        values.put(N1_SC16, n1_sc16);
        values.put(N1_SC17, n1_sc17);
        values.put(N1_SC18, n1_sc18);
        values.put(N2_SC1, n2_sc1);
        values.put(N2_SC2, n2_sc2);
        values.put(N2_SC3, n2_sc3);
        values.put(N2_SC4, n2_sc4);
        values.put(N2_SC5, n2_sc5);
        values.put(N2_SC6, n2_sc6);
        values.put(N2_SC7, n2_sc7);
        values.put(N2_SC8, n2_sc8);
        values.put(N2_SC9, n2_sc9);
        values.put(N2_SC10, n2_sc10);
        values.put(N2_SC11, n2_sc11);
        values.put(N2_SC12, n2_sc12);
        values.put(N2_SC13, n2_sc13);
        values.put(N2_SC14, n2_sc14);
        values.put(N2_SC15, n2_sc15);
        values.put(N2_SC16, n2_sc16);
        values.put(N2_SC17, n2_sc17);
        values.put(N2_SC18, n2_sc18);
        values.put(N3_SC1, n3_sc1);
        values.put(N3_SC2, n3_sc2);
        values.put(N3_SC3, n3_sc3);
        values.put(N3_SC4, n3_sc4);
        values.put(N3_SC5, n3_sc5);
        values.put(N3_SC6, n3_sc6);
        values.put(N3_SC7, n3_sc7);
        values.put(N3_SC8, n3_sc8);
        values.put(N3_SC9, n3_sc9);
        values.put(N3_SC10, n3_sc10);
        values.put(N3_SC11, n3_sc11);
        values.put(N3_SC12, n3_sc12);
        values.put(N3_SC13, n3_sc13);
        values.put(N3_SC14, n3_sc14);
        values.put(N3_SC15, n3_sc15);
        values.put(N3_SC16, n3_sc16);
        values.put(N3_SC17, n3_sc17);
        values.put(N3_SC18, n3_sc18);
        values.put(N4_SC1, n4_sc1);
        values.put(N4_SC2, n4_sc2);
        values.put(N4_SC3, n4_sc3);
        values.put(N4_SC4, n4_sc4);
        values.put(N4_SC5, n4_sc5);
        values.put(N4_SC6, n4_sc6);
        values.put(N4_SC7, n4_sc7);
        values.put(N4_SC8, n4_sc8);
        values.put(N4_SC9, n4_sc9);
        values.put(N4_SC10, n4_sc10);
        values.put(N4_SC11, n4_sc11);
        values.put(N4_SC12, n4_sc12);
        values.put(N4_SC13, n4_sc13);
        values.put(N4_SC14, n4_sc14);
        values.put(N4_SC15, n4_sc15);
        values.put(N4_SC16, n4_sc16);
        values.put(N4_SC17, n4_sc17);
        values.put(N4_SC18, n4_sc18);
        values.put(N2, n2);
        values.put(N3, n3);
        values.put(N4, n4);

        return db.update(DATABASE_TABLE2, values, KEY_ROWID2 + " = ?", new String[]{String.valueOf(id)});
    }

    public long updateRow3(long id, String course_name, String year, String month, String date, String hour, String minute, String notification){
        ContentValues values = new ContentValues();
        values.put(COURSE_NAME, course_name);
        values.put(YEAR, year);
        values.put(MONTH, month);
        values.put(DATE, date);
        values.put(HOUR, hour);
        values.put(MINUTE, minute);
        values.put(NOTIFICATION, notification);

        return db.update(DATABASE_TABLE3, values, KEY_ROWID3 + " = ?", new String[]{String.valueOf(id)});
    }

    public Cursor getAllRows(){
        String where = null;
        Cursor c = db.query(true, DATABASE_TABLE1, ALL_KEYS,
                where, null, null, null, null, null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getAllRows2(){
        String where = null;
        Cursor c = db.query(true, DATABASE_TABLE2, ALL_KEYS2,
                where, null, null, null, null, null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getAllRows3(){
        String where = null;
        Cursor c = db.query(true, DATABASE_TABLE3, ALL_KEYS3,
                where, null, null, null, null, null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getScorecardInfo(long id){
        String query = "SELECT * FROM Scores_Table WHERE _id2 = " + id;
        Cursor c = db.rawQuery(query, null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getAllUniqueTemplates(){
        String query = "SELECT * FROM Scores_Table GROUP BY template";
        Cursor c = db.rawQuery(query, null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getCourseScore(String template){
        String query = "SELECT * FROM Scores_Table WHERE template = '" + template +"'";
        Cursor c = db.rawQuery(query, null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getParYardageInfo(String name){
        String query = "SELECT * FROM Course_Info_Table WHERE name = '" + name +"'";
        Cursor c = db.rawQuery(query, null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getTeetimeInfo(long id){
        String query = "SELECT * FROM Teetime_Table WHERE _id3 = " + id;
        Cursor c = db.rawQuery(query, null);
        if(c != null){
            c.moveToFirst();
        }
        return c;
    }

    public long deleteScorecardRow(long id){

        return db.delete(DATABASE_TABLE2, KEY_ROWID2 + " = ?", new String[]{String.valueOf(id)});
    }

    public long deleteTeeTime(long id){

        return db.delete(DATABASE_TABLE3, KEY_ROWID3 + " = ?", new String[]{String.valueOf(id)});
    }

    private static class DatabaseHelper extends SQLiteOpenHelper{

        DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(DATABASE_CREATE_SQL);
            sqLiteDatabase.execSQL(DATABASE_CREATE_SQL2);
            sqLiteDatabase.execSQL(DATABASE_CREATE_SQL3);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE1);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE2);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE3);

            onCreate(sqLiteDatabase);
        }
    }
}
