package com.ep.eric.golfscorecardbuddy;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
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

import static android.media.MediaRecorder.AudioSource.VOICE_RECOGNITION;
import static com.ep.eric.golfscorecardbuddy.R.id.datePicker1;
import static com.ep.eric.golfscorecardbuddy.R.id.timePicker1;

/**
 * Created by Eric on 2/23/2017.
 */

public class Teetime_Update extends AppCompatActivity{

    DBAdapter myDB;
    DatePicker datePicker;
    TimePicker timePicker;
    Spinner reminder_times;
    ArrayList<String> arr;
    ArrayAdapter<String> adapter;
    String c_name, year, month, date, hour, minute, notification;
    EditText course_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teetime);

        course_name = (EditText)findViewById(R.id.editText_name);

        timePicker = (TimePicker) findViewById(timePicker1);
        int hour_id = Resources.getSystem().getIdentifier("hour", "id", "android");
        final NumberPicker hour_numberpicker =(NumberPicker) timePicker.findViewById(hour_id);
        set_picker_details(hour_numberpicker);
        int minute_id = Resources.getSystem().getIdentifier("minute", "id", "android");
        final NumberPicker minute_numberpicker =(NumberPicker) timePicker.findViewById(minute_id);
        set_picker_details(minute_numberpicker);
        int ampm_id = Resources.getSystem().getIdentifier("amPm", "id", "android");
        final NumberPicker ampm_numberpicker =(NumberPicker) timePicker.findViewById(ampm_id);
        set_picker_details(ampm_numberpicker);

        datePicker = (DatePicker) findViewById(datePicker1);
        int year_id = Resources.getSystem().getIdentifier("year", "id", "android");
        final NumberPicker year_numberpicker =(NumberPicker) datePicker.findViewById(year_id);
        set_picker_details(year_numberpicker);
        int month_id = Resources.getSystem().getIdentifier("month", "id", "android");
        final NumberPicker month_numberpicker =(NumberPicker) datePicker.findViewById(month_id);
        set_picker_details(month_numberpicker);
        int day_id = Resources.getSystem().getIdentifier("day", "id", "android");
        final NumberPicker day_numberpicker =(NumberPicker) datePicker.findViewById(day_id);
        set_picker_details(day_numberpicker);

        Resources res = getResources();

        reminder_times = (Spinner)findViewById(R.id.spinner_reminders);
        arr = new ArrayList<String>();
        arr.add(res.getString(R.string.reminder_time0));
        arr.add(res.getString(R.string.reminder_time1));
        arr.add(res.getString(R.string.reminder_time2));
        arr.add(res.getString(R.string.reminder_time3));
        arr.add(res.getString(R.string.reminder_time4));
        adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr){
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
        final long newId = sharedpreferences.getLong("teetime_id", 0);

        final Button cont = (Button) findViewById(R.id.button_save);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= 23) {
                    myDB.updateRow3(newId, course_name.getText().toString(), String.valueOf(datePicker.getYear()), String.valueOf(datePicker.getMonth()), String.valueOf(datePicker.getDayOfMonth()), String.valueOf(timePicker.getHour()), String.valueOf(timePicker.getMinute()), reminder_times.getSelectedItem().toString());
                }
                else{
                    myDB.updateRow3(newId, course_name.getText().toString(), String.valueOf(datePicker.getYear()), String.valueOf(datePicker.getMonth()), String.valueOf(datePicker.getDayOfMonth()), String.valueOf(timePicker.getCurrentHour()), String.valueOf(timePicker.getCurrentMinute()), reminder_times.getSelectedItem().toString());
                }

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

                Toast.makeText(getBaseContext(),"Tee Time Updated",Toast.LENGTH_SHORT).show();

                finish();
            }
        });

        openDB();

        Cursor cursor = myDB.getTeetimeInfo(newId);

        if(cursor.moveToFirst()) {
            do {
                c_name = cursor.getString(DBAdapter.COL_COURSE_NAME);
                year = cursor.getString(DBAdapter.COL_YEAR);
                month = cursor.getString(DBAdapter.COL_MONTH);
                date = cursor.getString(DBAdapter.COL_DATE);
                hour = cursor.getString(DBAdapter.COL_HOUR);
                minute = cursor.getString(DBAdapter.COL_MINUTE);
                notification = cursor.getString(DBAdapter.COL_NOTIFICATION);

            } while (cursor.moveToNext());
        }

        course_name.setText(c_name);
        datePicker.updateDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(date));
        if(Build.VERSION.SDK_INT >= 23) {
            timePicker.setHour(Integer.parseInt(hour));
            timePicker.setMinute(Integer.parseInt(minute));
        }
        else{
            timePicker.setCurrentHour(Integer.parseInt(hour));
            timePicker.setCurrentMinute(Integer.parseInt(minute));
        }
        int position = adapter.getPosition(notification);
        reminder_times.setSelection(position);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            course_name.setText(result.get(0));
        }
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
