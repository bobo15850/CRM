package com.nju.edu.crm.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nju.edu.crm.R;
import com.nju.edu.crm.presenter.IMainPresenter;
import com.nju.edu.crm.presenter.impl.MainPresenterImpl;
import com.nju.edu.crm.view.IMainView;

public class MainActivity extends BaseActivity implements IMainView, View.OnClickListener {
    private IMainPresenter mainPresenter;
    private Button customerButton;
    private Button opportunityButton;
    private Button contractButton;
    private Button contactButton;
    private Button productButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initComponent();//初始化组件
        mainPresenter = new MainPresenterImpl(this);
    }


    private void initComponent() {
        //初始化按钮
        customerButton = (Button) this.findViewById(R.id.customer_button);
        opportunityButton = (Button) this.findViewById(R.id.opportunity_button);
        contractButton = (Button) this.findViewById(R.id.contract_button);
        contactButton = (Button) this.findViewById(R.id.contact_button);
        productButton = (Button) this.findViewById(R.id.product_button);
        //添加监听
        customerButton.setOnClickListener(this);
        opportunityButton.setOnClickListener(this);
        contractButton.setOnClickListener(this);
        contactButton.setOnClickListener(this);
        productButton.setOnClickListener(this);
    }

    @Override
    public void toCustomer() {
        Intent intent = new Intent(MainActivity.this, CustomerListActivity.class);
        startActivity(intent);
    }

    @Override
    public void toOpportunity() {
        Toast.makeText(MainActivity.this, "toOpportunity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toContract() {
        Toast.makeText(MainActivity.this, "toContract", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toContact() {
        Toast.makeText(MainActivity.this, "toContact", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toProduct() {
        Toast.makeText(MainActivity.this, "toProduct", Toast.LENGTH_SHORT).show();
    }

    //整个页面的所有的监听
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customer_button:
                mainPresenter.toCustomer();
                break;
            case R.id.opportunity_button:
                mainPresenter.toOpportunity();
                break;
            case R.id.contract_button:
                mainPresenter.toContract();
                break;
            case R.id.contact_button:
                mainPresenter.toContact();
                break;
            case R.id.product_button:
                mainPresenter.toProduct();
        }
    }
}
