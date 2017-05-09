package com.bignerdranch.android.patient;

import cn.bmob.v3.BmobObject;

/**
 * Created by jacob on 2017/5/9.
 * 创建一个病人类
 */

public class Patient extends BmobObject {

    private String PatientName;
    private String PatientSex;
    private int    PatientAge;
    private double comfortData;
    private double pressData;


    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public String getPatientSex() {
        return PatientSex;
    }

    public void setPatientSex(String patientSex) {
        PatientSex = patientSex;
    }

    public int getPatientAge() {
        return PatientAge;
    }

    public void setPatientAge(int patientAge) {
        PatientAge = patientAge;
    }

    public double getComfortData() {
        return comfortData;
    }

    public void setComfortData(double comfortData) {
        this.comfortData = comfortData;
    }

    public double getPressData() {
        return pressData;
    }

    public void setPressData(double pressData) {
        this.pressData = pressData;
    }
}
