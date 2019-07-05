package com.yang.service;

import android.content.SharedPreferences;

import com.yang.data.Data;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zy on 2017/9/26.
 */

public class QuestionService {
    private static String URL = "http://[2001:da8:270:2021::54]:8080/MapMutilNaviagtion/GetQuestionServlet";
    private static String URL2 = "http://[2001:da8:270:2021::54]:8080/MapMutilNaviagtion/SearchQuestionServlet";
    private static String URL3= "http://[2001:da8:270:2021::54]:8080/MapMutilNaviagtion/getSuggestionServlet";
    private static String URL4= "http://[2001:da8:270:2021::54]:8080/MapMutilNaviagtion/suggestionServlet";
    private HttpEntity httpEntity;
    List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
    public boolean HttpPost(final String mIdString){
        String username=Data.getUserName();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(URL);
        try{
            List<NameValuePair> parms = new ArrayList<>();
            parms.add(new BasicNameValuePair("question",mIdString));
            parms.add(new BasicNameValuePair("username",username));
            //设置请求参数
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parms,"UTF-8");
            httpPost.setEntity(entity);

            // 请求超时
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
            // 读取超时
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);

            //发送POST请求
            HttpResponse response = httpClient.execute(httpPost);
            int ret = response.getStatusLine().getStatusCode();
            if(ret == 200)
            {
                httpEntity = response.getEntity();
                InputStream is  = httpEntity.getContent();
                byte[] data = QuestionService.read(is);
                String acceptData = new String(data,"UTF-8");
                if("提交成功".equals(acceptData.toString().trim()))
                {
                    return true;
                }else {
                    return false;
                }
            }else {
                httpPost.abort();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public   List<Map<String,Object>>  HttpPost2(String username){

        //String username=Data.getUserName();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(URL2);
        try{
            List<NameValuePair> parms = new ArrayList<>();
            parms.add(new BasicNameValuePair("username",username));
            //设置请求参数
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parms,"UTF-8");
            httpPost.setEntity(entity);

            // 请求超时
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
            // 读取超时
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);

            //发送POST请求
            HttpResponse response = httpClient.execute(httpPost);
            int ret = response.getStatusLine().getStatusCode();
            if(ret == 200)
            {
                httpEntity = response.getEntity();
               String result = EntityUtils.toString(httpEntity);
                //解析数据
                lists = userInfoJsonTool(result);
                int i=lists.size();
                return lists;
            }else {
                httpPost.abort();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public   List<Map<String,Object>>  HttpPost3(String username){


        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(URL3);
        try{
            List<NameValuePair> parms = new ArrayList<>();
            parms.add(new BasicNameValuePair("username",username));
            //设置请求参数
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parms,"UTF-8");
            httpPost.setEntity(entity);

            // 请求超时
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
            // 读取超时
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);

            //发送POST请求
            HttpResponse response = httpClient.execute(httpPost);
            int ret = response.getStatusLine().getStatusCode();
            if(ret == 200)
            {
                httpEntity = response.getEntity();
                String result = EntityUtils.toString(httpEntity);
                //解析数据
                lists = userInfoJsonTool2(result);
                int i=lists.size();
                return lists;
            }else {
                httpPost.abort();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean HttpPost4(final String mIdString){
        String username=Data.getUserName();
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(URL4);
        try{
            List<NameValuePair> parms = new ArrayList<>();
            parms.add(new BasicNameValuePair("suggestion",mIdString));
            parms.add(new BasicNameValuePair("username",username));
            //设置请求参数
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parms,"UTF-8");
            httpPost.setEntity(entity);

            // 请求超时
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
            // 读取超时
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);

            //发送POST请求
            HttpResponse response = httpClient.execute(httpPost);
            int ret = response.getStatusLine().getStatusCode();
            if(ret == 200)
            {
                httpEntity = response.getEntity();
                InputStream is  = httpEntity.getContent();
                byte[] data = QuestionService.read(is);
                String acceptData = new String(data,"UTF-8");
                if("提交成功".equals(acceptData.toString().trim()))
                {
                    return true;
                }else {
                    return false;
                }
            }else {
                httpPost.abort();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    // 将输入流转化为byte型
    public static byte[] read(InputStream inStream) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        inStream.close();
        return outputStream.toByteArray();
    }

    public List<Map<String,Object>> userInfoJsonTool(String result){
        List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            JSONArray jsonArray = new JSONArray(result);

            for (int i = 0; i < jsonArray.length(); i++) {
                map=new HashMap<String, Object>();
                map.clear();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String question = jsonObject.getString("question");
                String time = jsonObject.getString("time");
                String tag = jsonObject.getString("tag");
                String name = jsonObject.getString("name");
                String result0 = jsonObject.getString("result");
                map.put("question",question);
                map.put("time",time);
                map.put("tag",tag);
                map.put("name",name);
                map.put("result",result0);
                lists.add(map);
            }
            return lists;
        }catch (Exception e){
            e.printStackTrace();
        }

        return lists;
    }

    public List<Map<String,Object>> userInfoJsonTool2(String result) {
        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            JSONArray jsonArray = new JSONArray(result);

            for (int i = 0; i < jsonArray.length(); i++) {
                map = new HashMap<String, Object>();
                map.clear();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String suggestion = jsonObject.getString("suggestion");
                String time = jsonObject.getString("time");
                String name = jsonObject.getString("name");
                map.put("suggestion", suggestion);
                map.put("time", time);
                map.put("name", name);
                lists.add(map);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lists;
    }
    }
