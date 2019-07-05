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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RegisterService {
    private static String URL = "http://[2001:da8:270:2021::54]:8080/MapMutilNaviagtion/RegisterServlet";
    private HttpEntity httpEntity;

    public boolean HttpPost(final String user, final String passwd,String tel){

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(URL);
        try{
            List<NameValuePair> parms = new ArrayList<>();
            parms.add(new BasicNameValuePair("name",user));
            parms.add(new BasicNameValuePair("password",passwd));
            parms.add(new BasicNameValuePair("telphone",tel));
           // parms.add(new BasicNameValuePair("sex",sex));
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
                byte[] data = LoginService.read(is);
                String acceptData = new String(data,"UTF-8");
                if("true".equals(acceptData.toString().trim()))
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

}
