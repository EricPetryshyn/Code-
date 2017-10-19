package com.example.t00229613.codzombieseastereggguide;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.Binder;
import android.support.annotation.Nullable;
import android.view.KeyEvent;

/**
 * Created by T00229613 on 11/30/2016.
 */
public class BackgroundService extends Service {

    private IBinder mBinder = new MyBinder();
    private static final String TAG = null;
    MediaPlayer player;
    public IBinder onBind(Intent arg0){
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        final SharedPreferences sharedpreferences = getSharedPreferences("Page", 0);

        if(sharedpreferences.getInt("page1", 0) == 0) {
            player = MediaPlayer.create(this, R.raw.snakeskin_boots);
        }
        else if(sharedpreferences.getInt("page1", 0) == 1) {
            player = MediaPlayer.create(this, R.raw.beauty_of_annihilation);
        }
        else if(sharedpreferences.getInt("page1", 0) == 2) {
            player = MediaPlayer.create(this, R.raw.dead_again);
        }
        else if(sharedpreferences.getInt("page1", 0) == 3) {
            player = MediaPlayer.create(this, R.raw.dead_flowers);
        }
        else if(sharedpreferences.getInt("page1", 0) == 4) {
            player = MediaPlayer.create(this, R.raw.dead_ended);
        }
        else{
            player = MediaPlayer.create(this, R.raw.the_gift);
        }

        player.setLooping(true);
        player.setVolume(100, 100);
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        player.start();
        return 1;
    }

    public void onStart(Intent intent, int startId){

    }

    public IBinder onUnBind(Intent arg0){
        return null;
    }

    public void onStop(){
        if(player.isPlaying()){
            player.stop();
            player.release();
        }
    }

    public void onPause(){
        if(player.isPlaying()){
            player.stop();
            player.release();
        }
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public class MyBinder extends Binder{
        BackgroundService getService(){
            return BackgroundService.this;
        }
    }
}
