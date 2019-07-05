package com.yang.testservice;

import android.content.Intent;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MySettingActivity extends AppCompatActivity {

    TextView changePwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysetting);

        // 返回箭头
        Toolbar mToolbarTb = (Toolbar) findViewById(R.id.toolbartwo);
        setSupportActionBar(mToolbarTb);

    }

    public void change(View view)
    {
        Intent intent = new Intent();
        intent.setClass(this,AboutOurActivity.class);
        startActivity(intent);
    }

    public void changee(View view){
        Intent intent = new Intent();
        intent.setClass(this,PasswordActivity.class);
        startActivity(intent);
    }

    public void suggest(View view){
        Intent intent = new Intent();
        intent.setClass(this,suggestActivity.class);
        startActivity(intent);
    }

    public void alter(View view){
        Intent intent = new Intent();
        intent.setClass(this,LoginActivity.class);
        startActivity(intent);
    }

}
