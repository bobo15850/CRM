package com.nju.edu.crm.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.nju.edu.crm.R;
import com.nju.edu.crm.view.IMainView;

public class MainActivity extends AppCompatActivity implements IMainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
