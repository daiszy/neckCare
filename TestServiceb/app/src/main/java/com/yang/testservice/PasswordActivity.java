package com.yang.testservice;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yang.data.Data;
import com.yang.service.ChangePwdService;
import com.yang.service.LoginService;

import java.util.Date;

public class PasswordActivity extends AppCompatActivity {

    public EditText login_edtId;
    public EditText oldPwd;
    public EditText newPwd;
    public Button change;
    public String login_edtIdText;
    public String oldPwdText;
    public String newPwdText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepwd);
        // 返回箭头
        Toolbar mToolbarTb = (Toolbar) findViewById(R.id.toolbartwo);
        setSupportActionBar(mToolbarTb);

        //初始化控件
        init();
        setListener();
    }

    public  void init(){
        login_edtId = (EditText) findViewById(R.id.login_edtId);
        login_edtIdText = login_edtId.getText().toString();
        oldPwd = (EditText) findViewById(R.id.oldPwd);
        oldPwdText = oldPwd.getText().toString();
        newPwd = (EditText) findViewById(R.id.newPwd);
        newPwdText = newPwd.getText().toString();
        change = (Button)findViewById(R.id.change);

    }

    //设置监听
    public void setListener(){
        login_edtId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                login_edtIdText=charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        oldPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                oldPwdText=charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        newPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                newPwdText=charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
       change.setOnClickListener(new View.OnClickListener() {

           public static final int IS_OK = 1;
           public static final int IS_NOT = 2;
           private Handler handler = new Handler(){
               public void handleMessage(Message msg){
                   switch(msg.what){
                       //返回值正确，执行修改操作
                       case IS_OK:
                           final ChangePwdService changePwdService = new ChangePwdService();
                           final  Thread thread =new Thread(new Runnable() {
                               @Override
                               public void run() {
                                    System.out.println(newPwdText+"newPwdText");
                                   System.out.println(oldPwdText+"oldPwdText");
                                    Boolean is =changePwdService.HttpPost(login_edtIdText,newPwdText);
                                    if (is==true){
                                        //修改成功，跳回登录页面
                                        Intent intent = new Intent(PasswordActivity.this,LoginActivity.class);
                                        startActivity(intent);
                                    }else{
                                        //修改失败
                                        Intent intent = new Intent(PasswordActivity.this,PasswordActivity.class);
                                        startActivity(intent);
                                        Toast.makeText(PasswordActivity.this,"修改失败", Toast.LENGTH_SHORT).show();
                                    }
                               }
                           });
                           thread.start();
                           break;
                       case IS_NOT:
                           //返回值错误，提示修改失败，密码错误
                           Toast.makeText(PasswordActivity.this, "修改失败，请输入正确密码！", Toast.LENGTH_SHORT)
                                   .show();
                           break;
                   }
               }
           };

           @Override
           public void onClick(View view) {
               //判断输入为空时
                if (login_edtIdText==null || login_edtIdText.equals("")){
                    Toast.makeText(PasswordActivity.this, "请输入账号", Toast.LENGTH_SHORT)
                            .show();
                }
                else if(oldPwdText==null || oldPwdText.equals("")){
                    Toast.makeText(PasswordActivity.this, "请输入旧密码", Toast.LENGTH_SHORT)
                            .show();
                }else if(newPwdText==null || newPwdText.equals("")){
                    Toast.makeText(PasswordActivity.this, "请输入新密码", Toast.LENGTH_SHORT)
                            .show();
                }else {
                    //账号和密码都不为空时
                    final LoginService loginService = new LoginService();
                    final Thread thread = new Thread(new Runnable(){
                        public void run() {
                            boolean is = loginService.HttpPost(login_edtIdText,oldPwdText);
                            Message message = new Message();
                            if(is){
                                message.what = IS_OK;
                                handler.sendMessage(message);
                            }else {
                                message.what = IS_NOT;
                                handler.sendMessage(message);
                            }
                        }
                    });
                    thread.start();
                }
           }
       });
    }
}
