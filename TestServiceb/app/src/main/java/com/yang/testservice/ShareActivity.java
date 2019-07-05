package com.yang.testservice;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import java.io.File;
import java.io.FileOutputStream;

public class ShareActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);



        /* 实现分享功能 */

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);

        // 分享文本
       /* intent.setType("text/plain"); // text/html ...
        intent.putExtra(Intent.EXTRA_SUBJECT, "我要分享");
        intent.putExtra(Intent.EXTRA_TEXT, "分享的内容");*/


        // 分享本地图片
        intent.setType("image/*");
        /*截取当前页面并获取图片存储路径*/
        String path = getPath();
        /*  File file = new File(Environment.getExternalStorageDirectory()+path);*/
        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        intent.putExtra(Intent.EXTRA_STREAM,uri);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(intent, "分享列表"));

    }

    public String getPath() {
        String filePath="";
        View dView = getWindow().getDecorView();
        dView.setDrawingCacheEnabled(true);
        dView.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(dView.getDrawingCache());
        if (bitmap != null) {
            try {
                // 获取内置SD卡路径
                String sdCardPath = Environment.getExternalStorageDirectory().getPath();
                // 图片文件路径
                filePath = sdCardPath + File.separator + "screenshot.png";
                File file = new File(filePath);
                FileOutputStream os = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, os);
                os.flush();
                os.close();
                System.out.println("存储完成"+ filePath);
            } catch (Exception e) {
                    e.printStackTrace();
            }
        }
        return filePath;
    }
}