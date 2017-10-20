package com.ep.eric.golfscorecardbuddy;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import java.util.Calendar;

/**
 * Created by Eric on 3/7/2017.
 */

public class BootService extends IntentService {

    DBAdapter myDB;

    public BootService(){
        super("BootService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        long newId;
        String course_name, reminder_time, year, month, day, hour, minute;

        openDB();
        Cursor cursor = myDB.getAllRows3();

        if(cursor.moveToFirst()){
            do{

                newId = cursor.getLong(DBAdapter.COL_ROWID3);
                reminder_time = cursor.getString(DBAdapter.COL_NOTIFICATION);
                course_name = cursor.getString(DBAdapter.COL_COURSE_NAME);
                year = cursor.getString(DBAdapter.COL_YEAR);
                month = cursor.getString(DBAdapter.COL_MONTH);
                day = cursor.getString(DBAdapter.COL_DATE);
                hour = cursor.getString(DBAdapter.COL_HOUR);
                minute = cursor.getString(DBAdapter.COL_MINUTE);

                if(!(reminder_time.equals("Never"))) {
                    Notification.Builder builder = new Notification.Builder(getBaseContext());
                    builder.setContentText("You have a tee time at " + course_name + " in " + reminder_time.substring(0, reminder_time.length() - 7));
                    builder.setSmallIcon(R.mipmap.golf_icon);
                    Notification notification = builder.build();

                    Intent i = new Intent(getBaseContext(), NotificationReciever.class);
                    i.putExtra(NotificationReciever.NOTIFICATION_ID, newId);
                    i.putExtra(NotificationReciever.NOTIFICATION, notification);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), (int) newId, i, PendingIntent.FLAG_UPDATE_CURRENT);
                    long time = 0;
                    Calendar cal = Calendar.getInstance();
                    Calendar cal2 = Calendar.getInstance();


                    cal.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute), 0);

                    if (reminder_time.equals("30 minutes before")) {
                        time = cal.getTimeInMillis() - 1800000;
                    } else if (reminder_time.equals("1 hour before")) {
                        time = cal.getTimeInMillis() - 3600000;
                    } else if (reminder_time.equals("2 hours before")) {
                        time = cal.getTimeInMillis() - 7200000;
                    } else if (reminder_time.equals("1 day before")) {
                        time = cal.getTimeInMillis() - 86400000;
                    }

                    if (cal.getTimeInMillis() >= cal2.getTimeInMillis()) {
                        AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                        alarm.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);
                    }
                }

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
}
