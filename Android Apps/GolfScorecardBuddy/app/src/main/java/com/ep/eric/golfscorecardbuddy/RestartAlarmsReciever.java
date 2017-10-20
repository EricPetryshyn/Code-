package com.ep.eric.golfscorecardbuddy;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static com.google.android.gms.plus.PlusOneDummyView.TAG;

/**
 * Created by Eric on 3/7/2017.
 */

public class RestartAlarmsReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Intent i = new Intent(context, BootService.class);
            ComponentName service = context.startService(i);
            if (null == service) {
                Log.e(TAG, "Could not start service ");
            }
            else {
                Log.e(TAG, "Successfully started service ");
            }

        } else {
            Log.e(TAG, "Received unexpected intent " + intent.toString());
        }
    }
}
