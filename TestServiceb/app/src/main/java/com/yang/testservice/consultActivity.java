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

public class consultActivity extends AppCompatActivity {

    private Intent backIntent;
    private TextView user;
    private EditText text;
    private Button send;
    private String mIdString;
    List<Map<String,Object>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        Toolbar mToolbarTb = (Toolbar) findViewById(R.id.toolbartwo);
        setSupportActionBar(mToolbarTb);

        user = (TextView) findViewById(R.id.user);
        send = (Button) findViewById(R.id.send);
        text = (EditText) findViewById(R.id.text);
        //从后台服务中查询数据
        SharedPreferences userSettings= getSharedPreferences("setting", 0);
        final String name = userSettings.getString("username","默认值");
        final QuestionService questionService=new QuestionService();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                data=questionService.HttpPost2(name);
                runOnUiThread(new Runnable() {
                                  @Override
                                  public void run() {
                                      String questions="";
                                      for(int i=0;i<data.size();i++){
                                          Map<String,Object>  map = data.get(i);
                                          String name =map.get("name").toString();
                                          String time = map.get("time").toString();
                                          String content = map.get("question").toString();
                                          String result = map.get("result").toString();
                                          String tag = map.get("tag").toString();
                                          if (tag.equals("1")){
                                              questions=questions+"\n"+name+"发布于"+time+"\n"+content+"\n\n"+"医生回复:"+result+"\n";
                                          }else if(tag.equals("0")){
                                              questions=questions+"\n"+name+"发布于"+time+"\n"+content+"\n";
                                          }
                                      }
                                      user.setText(questions);
                                      user.setHorizontallyScrolling(false);
                                      user.setEnabled(false);
                                  }
                              }

                );
                }
        });
        thread.start();

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
                backIntent = new Intent(consultActivity.this, SlidingMenuActivity.class);
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
                             questionService.HttpPost(mIdString);
                        }
                    });
                    thread.start();
                    Intent intent=new Intent(consultActivity.this,consultActivity.class);
                    startActivity(intent);
            }
        });
    }
}