package com.nju.edu.crm.view.activity.customer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nju.edu.crm.R;
import com.nju.edu.crm.presenter.customer.ICustomerHomePresenter;
import com.nju.edu.crm.presenter.customer.impl.CustomerHomePresenter;
import com.nju.edu.crm.view.activity.BaseActivity;
import com.nju.edu.crm.view.iview.customer.ICustomerHomeView;

public class CustomerHomeActivity extends BaseActivity implements ICustomerHomeView, View.OnClickListener {
    private ICustomerHomePresenter customerHomePresenter;
    private TextView customerNameText;
    private TextView customerTypeText;
    private Button toDetailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);
        this.initComponent();
        customerHomePresenter = new CustomerHomePresenter();
    }

    private void initComponent() {
        this.customerNameText = (TextView) findViewById(R.id.customer_home_name);
        this.customerTypeText = (TextView) findViewById(R.id.customer_home_type);
        this.toDetailButton = (Button) findViewById(R.id.customer_home_to_detail_button);
        //添加监听
        this.toDetailButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
