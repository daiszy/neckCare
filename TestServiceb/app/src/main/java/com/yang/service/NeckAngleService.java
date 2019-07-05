package com.yang.service;

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

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy on 2017/9/26.
 */

public class NeckAngleService {
    private static String URL = "http://[2001:da8:270:2021::54]:8080/MapMutilNaviagtion/RecordNeckAngleServlet";
    public boolean HttpPost(float neckangle,String username){

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(URL);
        try{
            String neck= String.valueOf(neckangle);
            List<NameValuePair> parms = new ArrayList<>();
            parms.add(new BasicNameValuePair("mIdNeck",neck));
            parms.add(new BasicNameValuePair("mIdName",username));
            //设置请求参数
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parms,"UTF-8");
            httpPost.setEntity(entity);

            // 请求超时
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
            // 读取超时
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);

            //发送POST请求
            HttpResponse response = httpClient.execute(httpPost);
            response.getStatusLine().getStatusCode();
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
