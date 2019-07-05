package com.yang.testservice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yang.service.QuestionService;

import java.util.List;
import java.util.Map;

/**
 * Created by krm on 2017/6/27.
 */

public class ContactWithUs extends AppCompatActivity {

    private Intent backIntent;
    private TextView user;
    private EditText text;
    private Button send;
    private String mIdString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactwithus);

        Toolbar mToolbarTb = (Toolbar) findViewById(R.id.toolbartwo);
        setSupportActionBar(mToolbarTb);


    }
}