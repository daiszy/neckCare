package com.yang.testservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.yang.service.backService;


public class AutoUpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, backService.class);
        context.startService(i);
    }
}
