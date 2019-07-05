package com.yang.testservice;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yang.data.Data;
import com.yang.data.ListAngle;
import com.yang.service.LocalService;
import com.yang.service.SampleService;
import com.yang.service.StartService;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lecho.lib.hellocharts.listener.PieChartOnValueSelectListener;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

// 获取时间差 引入命名空间

/**
 * Created by krm on 2017/5/3.
 */
public class SlidingMenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Intent serviceIntent, myGainIntent, myHealthIntent, myScoreIntent, myVedioIntent,AboutOurIntent,mySeetingIntent;


    private PieChartView pieChart;
    private PieChartData pieChardata;
    List<SliceValue> values = new ArrayList<SliceValue>();

    private int[] data = {0,24};

    private TextView totalTime, averageAngle, maxAverage;
    static Date curDate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidingmenu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        totalTime = (TextView) findViewById(R.id.totalTime);
        averageAngle = (TextView) findViewById(R.id.averageAngle);
        maxAverage = (TextView) findViewById(R.id.maxAverage);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        // 绘制饼状图
        pieChart = (PieChartView) findViewById(R.id.pie_chart);
        pieChart.setOnValueTouchListener(selectListener);//设置点击事件监听
        setPieChartData();
        initPieChart();


    }

    // 绘制饼状图

    /**
     * 获取数据
     */
    private void setPieChartData() {
        SliceValue sliceValue = new SliceValue((float) data[0], getResources().getColor(R.color.colorLightRed));
        values.add(sliceValue);
        SliceValue sliceValue1 = new SliceValue((float) data[1], getResources().getColor(R.color.colorBlackGreen));
        values.add(sliceValue1);

    }


    /**
     * 初始化
     */
    private void initPieChart() {
        pieChardata = new PieChartData();
        pieChardata.setHasLabels(true);//显示表情
        pieChardata.setHasLabelsOnlyForSelected(false);//不用点击显示占的百分比
        pieChardata.setHasLabelsOutside(false);//占的百分比是否显示在饼图外面
        pieChardata.setHasCenterCircle(true);//是否是环形显示
        pieChardata.setValues(values);//填充数据
        pieChardata.setCenterCircleColor(Color.WHITE);//设置环形中间的颜色
        pieChardata.setCenterCircleScale(0.65f);//设置环形的大小级别
        int h=Data.getUnhealthy_time()/60;
        System.out.println("小时"+h+"---"+Data.getUnhealthy_time());
        pieChardata.setCenterText1(h+"分钟"); //环形中间的文字1
        pieChardata.setCenterText1Color(Color.BLACK);//文字颜色
        pieChardata.setCenterText1FontSize(25);//文字大小


        pieChart.setPieChartData(pieChardata);
        pieChart.setValueSelectionEnabled(false);//选择饼图某一块变大
        pieChart.setAlpha(0.9f);//设置透明度
        pieChart.setCircleFillRatio(1f);//设置饼图大小

    }

    /**
     * 监听事件
     */
    private PieChartOnValueSelectListener selectListener = new PieChartOnValueSelectListener() {

        @Override
        public void onValueDeselected() {

        }

        @Override
        public void onValueSelected(int arg0, SliceValue value) {
            Toast.makeText(SlidingMenuActivity.this, "Selected: " + value.getValue(), Toast.LENGTH_SHORT).show();
        }
    };

    public void click(View v) {
        int key = v.getId();
        switch (key) {
            case R.id.button1:
                // 开启服务
                startService();
                // 获取开始时间
                break;
            case R.id.button2:
                Date endDate = new Date(System.currentTimeMillis());  // 获取结束时间
                // 停止服务
                //获取角度数组
                List<Double> list= ListAngle.getNeckangle();
                // 获取开始时间startTime
                curDate=Data.getStartTime();
                System.out.println(list.size()+"    list--------"+curDate);
                final long diff = (endDate.getTime() - curDate.getTime())/36000;   // 时间差
                totalTime.setText(String.valueOf(diff));      //使用手机时长
                final Double average = Math.ceil(90-getAverage(list));
                averageAngle.setText(Double.toString(average));   // 平均颈部弯曲角度
                final Double max = Math.ceil(90-getMin(list));
                maxAverage.setText(Double.toString(max));    //最大颈部弯曲角度
                break;
            case R.id.button3:
                // 后台运行
                Intent intent=new Intent(SlidingMenuActivity.this, LongRunningActivity.class);
                startActivity(intent);
                break;
            case R.id.index1:
                // 首页
                Intent intent1 = new Intent(SlidingMenuActivity.this, SlidingMenuActivity.class);
                startActivity(intent1);
                break;
            case R.id.index2:
                // 我的勋章
                myGainIntent = new Intent(SlidingMenuActivity.this, MyGain2.class);
                startActivity(myGainIntent);
                break;
            case R.id.index3:
                // 我的成绩
                myScoreIntent = new Intent(SlidingMenuActivity.this, MyScoreActivity.class);
                startActivity(myScoreIntent);
                break;
            case R.id.index4:
                // 视频教程
                AboutOurIntent = new Intent(SlidingMenuActivity.this, AboutOurActivity.class);
                startActivity(AboutOurIntent);
                break;
            default:
                break;
        }

    }

    private void startService() {
        serviceIntent=new Intent(SlidingMenuActivity.this,MainActivity2.class);

        startActivity(serviceIntent);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.consult) {      // 我的勋章

            Intent consultIntent = new Intent(SlidingMenuActivity.this, consultActivity.class);
            startActivity(consultIntent);


        } else if (id == R.id.my_health) {   // 图文教程

            myHealthIntent = new Intent(SlidingMenuActivity.this, MyHealthPlan.class);
            startActivity(myHealthIntent);

        }
        else if (id == R.id.my_health_video) {   // 视频教程

            myVedioIntent = new Intent(SlidingMenuActivity.this, MyHealthVedio.class);
            startActivity(myVedioIntent);

        }
        else if (id == R.id.my_settings) {   // 个人设置
            mySeetingIntent = new Intent(SlidingMenuActivity.this, MySettingActivity.class);
            startActivity(mySeetingIntent);

        } else if (id == R.id.users_manage) {  // 切换用户
            myHealthIntent = new Intent(SlidingMenuActivity.this, LoginActivity.class);
            startActivity(myHealthIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private static double getMin(List<Double> array) {
        double Min = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if (Min > array.get(i)) {
                Min = array.get(i);
            }
        }
        return Min;
    }

    private static double getAverage(List<Double> array) {
        double total = 0;
        for (int i = 0; i < array.size(); i++) {
            total = array.get(i) + total;
        }
        return total / array.size();
    }
}







