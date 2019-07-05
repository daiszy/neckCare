package com.yang.testservice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yang.data.Data;
import com.yang.service.getUsePhoneTime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by krm on 2017/6/7.
 */
public class MyGain2 extends AppCompatActivity {

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    TextView suggestion;
    TextView plan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mygain);
        Toolbar mToolbarTb = (Toolbar) findViewById(R.id.toolbartwo);
        setSupportActionBar(mToolbarTb);
        init();
        setStar();
    }
    private void init() {
        img1 = (ImageView) findViewById(R.id.imgStar1);
        img2 = (ImageView) findViewById(R.id.imgStar2);
        img3 = (ImageView) findViewById(R.id.imgStar3);
        img4 = (ImageView) findViewById(R.id.imgStar4);
        img5 = (ImageView) findViewById(R.id.imgStar5);
        suggestion = (TextView) findViewById(R.id.suggestion);
        plan = (TextView) findViewById(R.id.plan);
    }
    //获取手机使用时间
    private void setStar() {
        int h=Data.getUnhealthy_time()/3600;
     /*   Date curDate=Data.getStartTime();
        Date endDate = new Date(System.currentTimeMillis());  // 获取结束时间
        final long diff = (endDate.getTime() - curDate.getTime())/36000;   // 时间差
        int time =(int)diff;*/
        int time=h;
        //使用手机时间少于两个小时，为5颗星
        Log.d("星级", Integer.toString(time));
        if(time <= 2 && time >=0){
            img1.setImageResource(R.drawable.star);
            img2.setImageResource(R.drawable.star);
            img3.setImageResource(R.drawable.star);
            img4.setImageResource(R.drawable.star);
            img5.setImageResource(R.drawable.star);
            suggestion.setText("您的健康指数为五颗星，代表着您处于高等状态。您的健康状态较好，希望您能够继续保持。");
            plan.setText("先做立正姿势，两脚稍分开，两手撑腰。练习时头、颈先向右转，双目向右后方看，头颈再向左转，双目向左后方看，还原至预备姿势，低头看地，以下颌能触及胸骨柄为佳，在次还原。动作宜缓慢进行，以呼吸一次做一个动作为宜。");
        }
        //使用手机时间在两小时到四小时之间，为4颗星
        if(time > 2 && time <= 4){
            img1.setImageResource(R.drawable.star);
            img2.setImageResource(R.drawable.star);
            img3.setImageResource(R.drawable.star);
            img4.setImageResource(R.drawable.star);
            img5.setImageResource(R.drawable.nostar);
            suggestion.setText("您的健康指数为四颗星，代表着您处于中等偏上状态。您的健康状态较好，希望您能够继续保持。");
            plan.setText("先做立正姿势，两脚稍分开，两手撑腰。练习时头、颈先向右转，双目向右后方看，头颈再向左转，双目向左后方看，还原至预备姿势，低头看地，以下颌能触及胸骨柄为佳，在次还原。动作宜缓慢进行，以呼吸一次做一个动作为宜。");
        }
        //使用手机时间在四小时到六小时之间，为3颗星
        if(time > 4 && time <= 6){
            img1.setImageResource(R.drawable.star);
            img2.setImageResource(R.drawable.star);
            img3.setImageResource(R.drawable.star);
            img4.setImageResource(R.drawable.nostar);
            img5.setImageResource(R.drawable.nostar);
            suggestion.setText("您的健康指数为三颗星，代表着您处于中等状态。您的健康状态较好，希望您能够继续保持。");
            plan.setText("先做立正姿势，两脚稍分开，两手撑腰。练习时头、颈先向右转，双目向右后方看，头颈再向左转，双目向左后方看，还原至预备姿势，低头看地，以下颌能触及胸骨柄为佳，在次还原。动作宜缓慢进行，以呼吸一次做一个动作为宜。");
        }
        //使用手机时间在六小时到八小时之间，为2颗星
        if(time > 6 && time <= 8){
            img1.setImageResource(R.drawable.star);
            img2.setImageResource(R.drawable.star);
            img3.setImageResource(R.drawable.nostar);
            img4.setImageResource(R.drawable.nostar);
            img5.setImageResource(R.drawable.nostar);
            suggestion.setText("您的健康指数为两颗星，代表着您处于中等偏下状态。这对您的健康有很大的威胁，因为长时间低头会使颈部神经和血管受到挤压，为了您的健康，请多多抬头。");
            plan.setText("先做立正姿势，两脚稍分开，两手撑腰。练习时头、颈先向右转，双目向右后方看，头颈再向左转，双目向左后方看，还原至预备姿势，低头看地，以下颌能触及胸骨柄为佳，在次还原。动作宜缓慢进行，以呼吸一次做一个动作为宜。");
        }
        //使用手机时间大于八小时，为1颗星
        if(time > 8){
            img1.setImageResource(R.drawable.star);
            img2.setImageResource(R.drawable.nostar);
            img3.setImageResource(R.drawable.nostar);
            img4.setImageResource(R.drawable.nostar);
            img5.setImageResource(R.drawable.nostar);
            suggestion.setText("您的健康指数为一颗星，代表着您处于低等状态。这对您的健康有很大的威胁，因为长时间低头会使颈部神经和血管受到挤压，为了您的健康，请多多抬头。");
            plan.setText("先做立正姿势，两脚稍分开，两手撑腰。练习时头、颈先向右转，双目向右后方看，头颈再向左转，双目向左后方看，还原至预备姿势，低头看地，以下颌能触及胸骨柄为佳，在次还原。动作宜缓慢进行，以呼吸一次做一个动作为宜。");
        }
    }

    public void click(View v) {
        int key = v.getId();
        switch (key) {
            case R.id.index1:
                // 首页
                Intent intent = new Intent(MyGain2.this, SlidingMenuActivity.class);
                startActivity(intent);
                break;
            case R.id.index2:
                // 我的勋章
                Intent myGainIntent = new Intent(MyGain2.this, MyGain2.class);
                startActivity(myGainIntent);
                break;
            case R.id.index3:
                // 我的成绩
                Intent myScoreIntent = new Intent(MyGain2.this, MyScoreActivity.class);
                startActivity(myScoreIntent);
                break;
            case R.id.index4:
                // 关于我们
                Intent AboutOurIntent = new Intent(MyGain2.this, AboutOurActivity.class);
                startActivity(AboutOurIntent);
                break;
            default:
                break;
        }
    }
}
