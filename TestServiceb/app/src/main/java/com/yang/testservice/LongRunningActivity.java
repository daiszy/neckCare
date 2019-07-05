package com.yang.testservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.yang.service.backService;


public class LongRunningActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, backService.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
        startService(intent);
    }
}
