package com.ep.eric.golfscorecardbuddy;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import static android.R.attr.name;
import static android.media.MediaRecorder.AudioSource.VOICE_RECOGNITION;
import static com.ep.eric.golfscorecardbuddy.R.id.datePicker1;
import static com.ep.eric.golfscorecardbuddy.R.id.timePicker1;

/**
 * Created by Eric on 2/21/2017.
 */

public class Teetime extends AppCompatActivity{

    DBAdapter myDB;
    DatePicker datePicker;
    TimePicker timePicker;
    Spinner reminder_times;
    ArrayList<String> arr;
    ArrayAdapter<String> adapter;
    EditText course_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teetime);

        final Resources res = getResources();

        course_name = (EditText)findViewById(R.id.editText_name);

        timePicker = (TimePicker) findViewById(timePicker1);
        int hour_id = Resources.getSystem().getIdentifier("hour", "id", "android");
        final NumberPicker hour =(NumberPicker) timePicker.findViewById(hour_id);
        set_picker_details(hour);
        int minute_id = Resources.getSystem().getIdentifier("minute", "id", "android");
        final NumberPicker minute =(NumberPicker) timePicker.findViewById(minute_id);
        set_picker_details(minute);
        int ampm_id = Resources.getSystem().getIdentifier("amPm", "id", "android");
        final NumberPicker ampm =(NumberPicker) timePicker.findViewById(ampm_id);
        set_picker_details(ampm);

        datePicker = (DatePicker) findViewById(datePicker1);
        int year_id = Resources.getSystem().getIdentifier("year", "id", "android");
        final NumberPicker year =(NumberPicker) datePicker.findViewById(year_id);
        set_picker_details(year);
        int month_id = Resources.getSystem().getIdentifier("month", "id", "android");
        final NumberPicker month =(NumberPicker) datePicker.findViewById(month_id);
        set_picker_details(month);
        int day_id = Resources.getSystem().getIdentifier("day", "id", "android");
        final NumberPicker day =(NumberPicker) datePicker.findViewById(day_id);
        set_picker_details(day);


        reminder_times = (Spinner)findViewById(R.id.spinner_reminders);
       /* Drawable spinnerDrawable = reminder_times.getBackground().getConstantState().newDrawable();
        spinnerDrawable.setColorFilter(getResources().getColor(R.color.sandYellow), PorterDuff.Mode.SRC_ATOP);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            reminder_times.setBackground(spinnerDrawable);
        }
        else{
            reminder_times.setBackgroundDrawable(spinnerDrawable);
        }*/
        arr = new ArrayList<String>();
        arr.add(res.getString(R.string.reminder_time0));
        arr.add(res.getString(R.string.reminder_time1));
        arr.add(res.getString(R.string.reminder_time2));
        arr.add(res.getString(R.string.reminder_time3));
        arr.add(res.getString(R.string.reminder_time4));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arr){
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
                textView.setTextSize(24);

                return view;
            }
        };
        reminder_times.setAdapter(adapter);

        /*if(Build.VERSION.SDK_INT < 24) {
            final LinearLayout layout_notification_title = (LinearLayout) findViewById(R.id.layout_notification_title);
            final LinearLayout layout_notification = (LinearLayout) findViewById(R.id.layout_notification);
            ((ViewManager)layout_notification_title.getParent()).removeView(layout_notification_title);
            ((ViewManager)layout_notification.getParent()).removeView(layout_notification);
        }*/

        if(savedInstanceState != null) {
            course_name.setText(savedInstanceState.getCharSequence("course_name"));
            datePicker.updateDate(savedInstanceState.getInt("year"),savedInstanceState.getInt("month"),savedInstanceState.getInt("day"));
            if(Build.VERSION.SDK_INT >= 23) {
                timePicker.setHour(savedInstanceState.getInt("hour"));
                timePicker.setMinute(savedInstanceState.getInt("minute"));
            }
            else{
                timePicker.setCurrentHour(savedInstanceState.getInt("hour"));
                timePicker.setCurrentMinute(savedInstanceState.getInt("minute"));
            }
            reminder_times.setSelection(savedInstanceState.getInt("reminder_times"));
        }

        Button close = (Button)findViewById(R.id.button_cancel);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());

        final Button save = (Button) findViewById(R.id.button_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long newId;

                if(Build.VERSION.SDK_INT >= 23) {
                    newId = myDB.insertRow3(course_name.getText().toString(), String.valueOf(datePicker.getYear()), String.valueOf(datePicker.getMonth()), String.valueOf(datePicker.getDayOfMonth()), String.valueOf(timePicker.getHour()), String.valueOf(timePicker.getMinute()), reminder_times.getSelectedItem().toString());
                }
                else{
                    newId = myDB.insertRow3(course_name.getText().toString(), String.valueOf(datePicker.getYear()), String.valueOf(datePicker.getMonth()), String.valueOf(datePicker.getDayOfMonth()), String.valueOf(timePicker.getCurrentHour()), String.valueOf(timePicker.getCurrentMinute()), reminder_times.getSelectedItem().toString());
                }

                sharedpreferences.edit().putLong("teetime_id",newId).commit();

                if(!(reminder_times.getSelectedItem().equals("Never"))) {
                    Notification.Builder builder = new Notification.Builder(getBaseContext());
                    builder.setContentText("You have a tee time at " + course_name.getText().toString() + " in " + reminder_times.getSelectedItem().toString().substring(0, reminder_times.getSelectedItem().toString().length() - 7));
                    builder.setSmallIcon(R.mipmap.golf_icon);
                    Notification notification = builder.build();

                    Intent intent = new Intent(getBaseContext(), NotificationReciever.class);
                    intent.putExtra(NotificationReciever.NOTIFICATION_ID, newId);
                    intent.putExtra(NotificationReciever.NOTIFICATION, notification);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), (int)newId, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    long time = 0;
                    Calendar cal = Calendar.getInstance();
                    Calendar cal2 = Calendar.getInstance();

                    if(Build.VERSION.SDK_INT >= 23) {
                        cal.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
                                timePicker.getHour(), timePicker.getMinute(), 0);
                    }
                    else{
                        cal.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
                                timePicker.getCurrentHour(), timePicker.getCurrentMinute(), 0);
                    }
                    //course_name.setText(Long.toString(cal.getTimeInMillis()));
                    if (reminder_times.getSelectedItem().equals("30 minutes before")) {
                        time = cal.getTimeInMillis() - 1800000;
                    }
                    else if(reminder_times.getSelectedItem().equals("1 hour before")) {
                        time = cal.getTimeInMillis() - 3600000;
                    }
                    else if(reminder_times.getSelectedItem().equals("2 hours before")) {
                        time = cal.getTimeInMillis() - 7200000;
                    }
                    else if(reminder_times.getSelectedItem().equals("1 day before")) {
                        time = cal.getTimeInMillis() - 86400000;
                    }

                    if(cal.getTimeInMillis() >= cal2.getTimeInMillis()) {
                        AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                        alarm.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);
                    }
                }
                //}

                Toast.makeText(getBaseContext(),"Tee Time Created",Toast.LENGTH_SHORT).show();

                finish();
            }
        });

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

        openDB();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            course_name.setText(result.get(0));
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("course_name", course_name.getText());
        outState.putInt("year", datePicker.getYear());
        outState.putInt("month", datePicker.getMonth());
        outState.putInt("day", datePicker.getDayOfMonth());
        if(Build.VERSION.SDK_INT >= 23) {
            outState.putInt("hour", timePicker.getHour());
            outState.putInt("minute", timePicker.getMinute());
        }
        else{
            outState.putInt("hour", timePicker.getCurrentHour());
            outState.putInt("minute", timePicker.getCurrentMinute());
        }
        outState.putInt("reminder_times", reminder_times.getSelectedItemPosition());
    }

    private void openDB() {
        myDB = new DBAdapter(this);
        myDB.open();
    }

    private void closeDB(){
        myDB.close();
    }

    private void set_picker_details(NumberPicker numberPicker) {
        final int count = numberPicker.getChildCount();

        for (int i = 0; i < count; i++) {
            View child = numberPicker.getChildAt(i);

            if(child instanceof  EditText) {

                try {
                    Field wheelpaint = numberPicker.getClass().getDeclaredField("mSelectorWheelPaint");
                    wheelpaint.setAccessible(true);
                    ((Paint)wheelpaint.get(numberPicker)).setColor(Color.parseColor("#bba35d"));
                    ((Paint)wheelpaint.get(numberPicker)).setTextSize(72);
                    ((Paint)wheelpaint.get(numberPicker)).setShadowLayer(5,5,5,Color.BLACK);
                    ((EditText) child).setTextSize(24);
                    ((EditText) child).setTextColor(Color.parseColor("#bba35d"));
                    ((EditText) child).setShadowLayer(5,5,5,Color.BLACK);
                    numberPicker.invalidate();
                }
                catch(NoSuchFieldException e){
                    Log.w("setNumberPickerColor", e);
                }
                catch(IllegalAccessException e){
                    Log.w("setNumberPickerColor", e);
                }
                catch(IllegalArgumentException e){
                    Log.w("setNumberPickerColor", e);
                }
            }
        }
    }
}


