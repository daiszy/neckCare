package com.yang.testservice;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yang.data.ListAngle;
import com.yang.service.CameraView;
import com.yang.service.FaceView;
import com.yang.service.NeckAngleService;
import com.yang.service.StartService;

import java.util.List;


public class MainActivity2 extends Activity {

    CameraView cameraView;
    FaceView faceView;
    Bitmap fullBitmap;
    String tag;
    private SensorManager sensorManager;
    private Sensor sensor;
    private MySensorListener mySensorListener;
    private float sensorBright=0;
    private float a=0;
    public int i=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        if(!hasFrontCamera()) {
            Toast.makeText(this, "没有前置摄像头", Toast.LENGTH_SHORT).show();
            return ;
        }

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        mySensorListener = new MySensorListener();
        sensorManager.registerListener(mySensorListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        initView();
       //开辟线程，将颈部弯曲角度传给后台服务器
        /**获取用户名*/
        SharedPreferences userSettings= getSharedPreferences("setting", 0);
        final String userName = userSettings.getString("username","默认值");
        final NeckAngleService neckAngle = new NeckAngleService();
        Thread thread=new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean is=neckAngle.HttpPost(a,userName);
                if (is==true){
                    Log.i(tag,"已成功上传服务器");
                }else{
                    Log.i(tag,"上传服务器失败");
                }
            }
        });
        thread.start();


    }

    private void initView(){
        cameraView = (CameraView) findViewById(R.id.camera_view);
        faceView = (FaceView) findViewById(R.id.face_view);
        cameraView.setFaceView(faceView);
        cameraView.setOnFaceDetectedListener(new CameraView.OnFaceDetectedListener() {
            @Override
            public void onFaceDetected(Bitmap bm) {
                //检测到人脸后的回调方法
                fullBitmap = bm;
                if(!MainActivity2.this.isFinishing()) //xActivity即为本界面的Activity
                {
                    showDialog();
                }

            }
        });
    }

    private class MySensorListener implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            //传感器改变
            sensorBright =sensorEvent.values[1];
            System.out.println(sensorBright+"传感器角度");

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }


    }

    private void showDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("计算结果");
        View contentView = LayoutInflater.from(this).inflate(R.layout.pop_win_layout, null);
        ImageView imageView = (ImageView) contentView.findViewById(R.id.imageview);
        TextView textView = (TextView) contentView.findViewById(R.id.textview);
        builder.setView(contentView);
        Bitmap bm = faceView.getFaceArea();
        sensorBright=sensorBright*(-1);
        a=sensorBright;
        imageView.setImageBitmap(bm);
        //开服务，获取颈部弯曲角度
        StartService startService=new StartService();
        List<Double> list=startService.test(bm,sensorBright);
        setAngleList(list);
        List<Float> faceList = ListAngle.getFaceAngle();
        if(faceList.get(0)<faceList.get(faceList.size()-1)){
            textView.setText(Html.fromHtml("<font color=\"#d40000\">颈部弯曲角度过大！请调整姿势"+"<font color=\"#d400\">"));
        }
        //获取列表的最后一个值（脖子弯曲角度）
        else if (list.get(list.size()-1)>45){
            textView.setText(Html.fromHtml("<font color=\"#d40000\">颈部弯曲角度过大！请调整姿势"+"<font color=\"#d400\">"));
        }else{
            textView.setText(Html.fromHtml("<font color=\"#d40000\">当前颈部弯曲正常"+"<font color=\"#d400\">"));
        }
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cameraView.reset();
            }

        });
        builder.setCancelable(false);
        builder.create().show();
    }

    public void setAngleList(List<Double> angleList){
        ListAngle listAngle=new ListAngle();
        listAngle.setNeckangle(angleList);

    }

    /**
     * 判断是否有前置摄像
     * @return
     */
    @SuppressLint("NewApi")
    public static boolean hasFrontCamera(){
        Camera.CameraInfo info = new Camera.CameraInfo();
        int count = Camera.getNumberOfCameras();
        for(int i = 0; i < count; i++){
            Camera.getCameraInfo(i, info);
            if(info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT){
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(mySensorListener);
    }


}
