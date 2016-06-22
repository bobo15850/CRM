package com.nju.edu.crm.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.nju.edu.crm.view.IBaseView;

/**
 * Created by 张波波 on 2016-06-22.
 */
public class BaseActivity extends AppCompatActivity implements IBaseView {
    @Override
    public void netWorkError() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseActivity.this, "网络错误", Toast.LENGTH_SHORT);
            }
        });

    }
}
