package com.yang.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.WindowManager;


import com.yang.data.Data;
import com.yang.testservice.AutoUpdateReceiver;
import com.yang.testservice.MainActivity;


public class backService extends Service {
    private int unhealthy_time =0;
    private SensorManager sensorManager;
    private Sensor sensor;
    private backService.MySensorListener mySensorListener;
    private float sensorValue;
    @Override
    public void onCreate(){
        Intent intent= new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //如果是服务里调用，必须加入new task标识
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        mySensorListener = new MySensorListener();
        sensorManager.registerListener(mySensorListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onDestroy() {
        Intent sevices = new Intent(this, backService.class);
        this.startService(sevices);
        super.onDestroy();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    private void showDialog() {


    }
    @Override
    public int onStartCommand(final Intent intent, int flags, final int startId) {
        if (sensorValue<45){
            Vibrator vibrator = (Vibrator)this.getSystemService(this.VIBRATOR_SERVICE);
            vibrator.vibrate(1000);
            unhealthy_time=unhealthy_time+6;
            Data.setUnhealthy_time(unhealthy_time);
            Log.d("LongRunningService", "executed at " +" " +sensorValue +" "+unhealthy_time);

        }
        if(unhealthy_time==12){
            showDialog();
        }
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int anHour = 6 * 1000;   // 这是六秒的毫秒数
        long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
        Intent i = new Intent(this, AutoUpdateReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
       /* return super.onStartCommand(intent, flags, startId);*/
        return START_STICKY;
    }

    private class MySensorListener implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            //传感器改变
            sensorValue =sensorEvent.values[1]* -1;
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

    }

}
