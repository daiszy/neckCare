package com.yang.data;

import java.util.List;

/**
 * Created by GaoXixi on 2017/11/29.
 */

public class ListAngle {
    private static List<Double> neckangle;
    private static List<Float> faceAngle;
    public  static List<Double> getNeckangle(){
        return neckangle;
    }
    public  void setNeckangle(List<Double> neckangle){
        this.neckangle = neckangle;
    }

    public static List<Float> getFaceAngle() {
        return faceAngle;
    }

    public static void setFaceAngle(List<Float> faceAngle) {
        ListAngle.faceAngle = faceAngle;
    }
}
