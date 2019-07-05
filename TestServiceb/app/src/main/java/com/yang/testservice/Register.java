package com.yang.testservice;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.yang.data.Data;
import com.yang.database.Accounts;
import com.yang.service.LoginService;
import com.yang.service.RegisterService;

import org.litepal.crud.DataSupport;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by liu on 2017/7/22.
 */

public class Register extends AppCompatActivity {

    private Button button_reg ;
    private EditText user;//用户名输入框
    private EditText passwd ;//密码输入框
    private EditText confirm;//确认密码输入框
    private EditText tel ;//电话号码输入框
    private String USER ;
    private String PWD ;
    private String CONFIRM ;
    private String TEL ;
    String TAG = "Register";
    private RadioGroup mSex_group;
    private RadioButton mMale;//男 选择按钮
    private RadioButton mFemale;//女 选择按钮
    private String sexName;//性格选择框
    private Intent jump_login;
    private Intent jump_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //加载页面
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //初始化
        init();
        setListener();
        mSex_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (mMale.getId() == checkedId) {
                    sexName = mMale.getText().toString();
                } else if (mFemale.getId() == checkedId) {
                    sexName = mFemale.getText().toString();
                }
            }
        });
        Log.i(TAG, USER + PWD + CONFIRM + TEL + sexName);

    }
    //初始化属性值
    private void init(){
    //c初始化用户名，密码，电话，性别
        user = (EditText) findViewById(R.id.editText_user);//用户名
        USER = user.getText().toString();
        passwd = (EditText) findViewById(R.id.editText_passwd);//密码
        PWD = passwd.getText().toString();
        confirm = (EditText) findViewById(R.id.editText_confirm);//确认密码
        CONFIRM = confirm.getText().toString();
        tel = (EditText) findViewById(R.id.editText_tel);//电话
        TEL = tel.getText().toString();

        button_reg = (Button) findViewById(R.id.button_reg);
        mSex_group = (RadioGroup) findViewById(R.id.sex_group);
        mMale = (RadioButton) findViewById(R.id.male);
        mFemale = (RadioButton) findViewById(R.id.female);
    }
    private void setListener() {
        user.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                USER = s.toString();
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });
        passwd.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                PWD = s.toString();
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }

        });
        tel.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                TEL = s.toString();
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });
        confirm.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                CONFIRM = s.toString();
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });
        //点击注册按钮
        button_reg.setOnClickListener(new OnClickListener() {
            public static final int IS_OK = 1;
            public static final int IS_NOT = 2;
            private Handler handler = new Handler() {
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case IS_OK:
                            Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();
                            jump_login = new Intent(Register.this,LoginActivity.class);
                            startActivity(jump_login);
                            break;
                        case IS_NOT:
                            Toast.makeText(Register.this, "注册失败", Toast.LENGTH_SHORT).show();
                            jump_register = new Intent(Register.this,Register.class);
                            startActivity(jump_register);
                            break;
                    }
                }
            };
            @Override
            public void onClick(View view) {
                final RegisterService registerService = new RegisterService();
                final Thread thread = new Thread(new Runnable() {
                    public void run() {
                        boolean is = registerService.HttpPost(USER, PWD, TEL);
                        Message message = new Message();

                        if (is) {
                            message.what = IS_OK;
                            handler.sendMessage(message);
                        } else {
                            message.what = IS_NOT;
                            handler.sendMessage(message);
                        }
                    }
                });
                thread.start();
            }
        });

    }
}