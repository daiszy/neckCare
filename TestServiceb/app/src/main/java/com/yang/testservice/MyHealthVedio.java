package com.yang.testservice;

/**
 * Created by liu on 2017/7/17.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.List;


public class MyHealthVedio extends AppCompatActivity {

    RecyclerView rlVideoList;
    List<String> videos=new ArrayList<String>();
    String TAG = "MyHealthVedio";
    private Intent backIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        rlVideoList = (RecyclerView) findViewById(R.id.rv_vieo_list);
        //创建默认的线性LayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlVideoList.setLayoutManager(layoutManager);


        /**颈部按摩*/
        String url = "http://[2001:da8:270:2021::54]:8080/examples/111.mp4";
       /**腰部操*/
        String url1 = "http://[2001:da8:270:2021::54]:8080/examples/444.mp4";
        /**肩背拉伸*/
        String url2 = "http://[2001:da8:270:2021::54]:8080/examples/333.mp4";
        System.out.println(url+"ok-------------");
        videos.add(url);
        videos.add(url1);
        videos.add(url2);
        //创建并设置Adapter
        VideoAdapter adapter = new VideoAdapter(this,videos);
        rlVideoList.setAdapter(adapter);
        Toolbar mToolbarTb = (Toolbar) findViewById(R.id.toolbarplan);
        setSupportActionBar(mToolbarTb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbarTb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void click(View v) {
        int key = v.getId();

        switch (key) {
            case R.id.index1:
                // 首页
                Intent intent = new Intent(MyHealthVedio.this, SlidingMenuActivity.class);
                startActivity(intent);
                break;

            case R.id.index2:
                // 我的勋章
                Intent myGainIntent = new Intent(MyHealthVedio.this, MyGain2.class);
                startActivity(myGainIntent);
                break;
            case R.id.index3:
                // 我的成绩
                Intent myScoreIntent = new Intent(MyHealthVedio.this, MyScoreActivity.class);
                startActivity(myScoreIntent);
                break;
            case R.id.index4:
                // 视频教程
               /* Intent myVedioIntent = new Intent(MyHealthVedio.this, MyHealthVedio.class);
                startActivity(myVedioIntent);*/
                break;
            default:
                break;
        }
    }



}