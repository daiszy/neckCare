package com.yang.data;

import java.util.Date;


/**
 * Created by GaoXixi on 2017/11/29.
 */

public class Data {
        public static String userName;
        public static Date startTime;
        public static int unhealthy_time;
        public static float faceangel;
        public static String getUserName(){
            return userName;
        }
        public static void setUserName(String userName){
            Data.userName = userName;
        }
        public static Date getStartTime(){
            return  startTime;
    }
    public static void setStartTime(Date time) {
        startTime=time;
    }
    public  static void setUnhealthy_time(int time){
        unhealthy_time=time;
    }
    public static int getUnhealthy_time(){
        return  unhealthy_time;
    }

    public static float getFaceangel() {
        return faceangel;
    }

    public static void setFaceangel(float neckangel) {
        Data.faceangel = neckangel;
    }
}
