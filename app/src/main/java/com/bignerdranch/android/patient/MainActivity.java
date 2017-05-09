package com.bignerdranch.android.patient;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;


public class MainActivity extends BaseActivity implements View.OnClickListener{

    Button btn_add, btn_delete, btn_update, btn_query;
    Patient mPatient;
    private String objectId = "15be8df57d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化View
        initView();
        initListener();
    }

    private void initView() {
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_query = (Button) findViewById(R.id.btn_query);
    }

    private void initListener() {
        btn_add.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_query.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_add) {
            createData();
        } else if (v == btn_delete) {
            deleteData();
        } else if (v == btn_update) {
            updateData();
        } else if (v == btn_query) {
            queryData();
        }
    }

    /**
     * 创建一行数据
     */
    private void createData() {
        mPatient = new Patient();
        mPatient.setPatientName("张三");
        mPatient.setPatientSex("男");
        mPatient.setComfortData(6.5);
        mPatient.setPatientAge(12);
        mPatient.setPressData(2615.50);

        mPatient.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if (e == null){
                    ShowToast("创建成功：" + objectId);
                } else {
                    Log.i("bmob", "失败： "+e.getMessage()+"," + e.getErrorCode());
                }
            }
        });
    }

    /**
     * 更新数据
     */
    private void updateData() {
        Patient mPatient = new Patient();
        mPatient.setPatientName("张三");
        mPatient.setPatientSex("男");
        mPatient.setComfortData(6.5);
        mPatient.setPatientAge(12);
        mPatient.setPressData(3000.20);
        mPatient.update(objectId, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null){
                    ShowToast("更新成功：");
                } else {
                    Log.i("bmob", "更新失败： "+e.getMessage()+"," + e.getErrorCode());
                }
            }
        });
    }

    /**
     * 删除数据
     */
    private void deleteData() {
        Patient mPatient = new Patient();
       mPatient.setObjectId(objectId);
        mPatient.delete(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null){
                    ShowToast("删除成功");
                } else {
                    Log.i("bmob", "删除失败： "+e.getMessage()+"," + e.getErrorCode());
                }
            }
        });
    }

    /**
     * 查询数据
     */
    public void queryData() {
        BmobQuery<Patient> query = new BmobQuery<Patient>();
        query.getObject(objectId, new QueryListener<Patient>() {
            @Override
            public void done(Patient patient, BmobException e) {
                if (e == null) {
                    ShowToast("查询成功！" + objectId );
                } else {
                    ShowToast("查询失败！");
                }
            }
        });
    }
}
