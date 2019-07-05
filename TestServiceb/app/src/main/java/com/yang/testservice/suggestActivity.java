package com.yang.testservice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yang.data.Data;
import com.yang.service.QuestionService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by krm on 2017/6/27.
 */

public class suggestActivity extends AppCompatActivity {

    private Intent backIntent;
    private TextView user;
    private EditText text;
    private Button send;
    private String mIdString;
    List<Map<String,Object>> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);

        Toolbar mToolbarTb = (Toolbar) findViewById(R.id.toolbartwo);
        setSupportActionBar(mToolbarTb);

        user = (TextView) findViewById(R.id.user);
        send = (Button) findViewById(R.id.send);
        text = (EditText) findViewById(R.id.text);

        //从后台服务中查询数据
        final QuestionService questionService=new QuestionService();
        SharedPreferences userSettings= getSharedPreferences("setting", 0);
        final String name = userSettings.getString("username","默认值");
        System.out.println(name+"excute------");

            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    data=questionService.HttpPost3(name);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String suggestion="";
                            String time="";
                            String result="";
                            System.out.println(data);
                            for(int i=0;i<data.size();i++){
                                Map<String,Object>  map = data.get(i);
                                time = map.get("time").toString();
                                suggestion = map.get("suggestion").toString();
                                result=time+"   "+suggestion+"\n"+result;
                            }
                            user.setText(result);
                            user.setHorizontallyScrolling(false);
                            user.setEnabled(false);
                        }
                    });
                }
            });
            thread.start();


        //执行监听，提交数据
        setListener();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbarTb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                backIntent = new Intent(suggestActivity.this, SlidingMenuActivity.class);
                startActivity(backIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setListener() {
        text.addTextChangedListener(new TextWatcher() {


            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                mIdString = s.toString();
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     // 输入不为空时
                    final QuestionService questionService = new QuestionService();
                    final Thread thread = new Thread(new Runnable(){
                        public void run() {
                             questionService.HttpPost4(mIdString);
                        }
                    });
                    thread.start();
                    Intent intent=new Intent(suggestActivity.this, suggestActivity.class);
                    startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
       Intent intent = new Intent(suggestActivity.this,MySettingActivity.class);
        startActivity(intent);
    }
}