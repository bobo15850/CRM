package com.nju.edu.crm.view.activity.customer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nju.edu.crm.R;
import com.nju.edu.crm.common.enums.CustomerType;
import com.nju.edu.crm.model.entity.Customer;
import com.nju.edu.crm.presenter.customer.ICustomerHomePresenter;
import com.nju.edu.crm.presenter.customer.impl.CustomerHomePresenter;
import com.nju.edu.crm.view.activity.BaseActivity;
import com.nju.edu.crm.view.iview.customer.ICustomerHomeView;

public class CustomerHomeActivity extends BaseActivity implements ICustomerHomeView, View.OnClickListener {
    private ICustomerHomePresenter customerHomePresenter;
    private TextView customerNameText;
    private TextView customerTypeText;
    private Button toDetailButton;
    private int customerid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);
        Intent intent = getIntent();
        customerid = intent.getIntExtra("customerid", 611);
        this.initComponent();
        customerHomePresenter = new CustomerHomePresenter(this);
        customerHomePresenter.initCustomer(customerid);
    }

    private void initComponent() {
        Log.d("customerid", String.valueOf(customerid));
        this.customerNameText = (TextView) findViewById(R.id.customer_home_name);
        this.customerTypeText = (TextView) findViewById(R.id.customer_home_type);
        this.toDetailButton = (Button) findViewById(R.id.customer_home_to_detail_button);
        //添加监听
        this.toDetailButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initCustomerInfo(final Customer customer) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                customerNameText.setText(customer.getCustomername());
                customerTypeText.setText(CustomerType.getCustomerType(customer.getCustomertype()).getStrValue());
            }
        });
    }
}
