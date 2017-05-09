package com.bignerdranch.android.patient;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import cn.bmob.v3.Bmob;

/**
 * Created by jacob on 2017/5/9.
 */

public class BaseActivity extends Activity {

    private String Bmob_AppId = "a209c3ad79860d7a95a3373363ed80eb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化Bmob SDK
        Bmob.initialize(this, Bmob_AppId);
    }

    Toast mToast;

    public void ShowToast(String text) {
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
            } else {
                mToast.setText(text);
            }
            mToast.show();
        }
    }
}
