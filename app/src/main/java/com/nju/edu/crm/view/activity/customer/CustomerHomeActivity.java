package com.nju.edu.crm.view.activity.customer;

import android.os.Bundle;

import com.nju.edu.crm.R;
import com.nju.edu.crm.view.activity.BaseActivity;
import com.nju.edu.crm.view.iview.customer.ICustomerHomeView;

public class CustomerHomeActivity extends BaseActivity implements ICustomerHomeView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);
    }
}
