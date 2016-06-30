package com.nju.edu.crm.view.activity.customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nju.edu.crm.R;
import com.nju.edu.crm.model.entity.Customer;
import com.nju.edu.crm.presenter.customer.ICustomerAddPresenter;
import com.nju.edu.crm.presenter.customer.impl.CustomerAddPresenter;
import com.nju.edu.crm.view.iview.customer.ICustomerAddView;

public class CustomerAddActivity extends AppCompatActivity implements View.OnClickListener, ICustomerAddView {
    private Button confirmAddCustomer;
    private Button cancleAddCustomer;
    private EditText customerNameInput;
    private EditText customerProfileInput;
    private EditText customerPhoneInput;
    private EditText customerAddressInput;
    private EditText customerWebsiteInput;
    private ICustomerAddPresenter customerAddPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_customer_add);
        this.initComponent();
        this.customerAddPresenter = new CustomerAddPresenter(this);
    }

    private void initComponent() {
        this.confirmAddCustomer = (Button) findViewById(R.id.customer_add_confirm);
        this.cancleAddCustomer = (Button) findViewById(R.id.customer_add_cancle);
        this.customerNameInput = (EditText) findViewById(R.id.customer_name_input);
        this.customerProfileInput = (EditText) findViewById(R.id.customer_profile_input);
        this.customerPhoneInput = (EditText) findViewById(R.id.customer_phone_input);
        this.customerAddressInput = (EditText) findViewById(R.id.customer_address_input);
        this.customerWebsiteInput = (EditText) findViewById(R.id.customer_website_input);

        this.confirmAddCustomer.setOnClickListener(this);
        this.cancleAddCustomer.setOnClickListener(this);
    }

    @Override
    public void confirmAddCustomer() {
        Intent intent = new Intent(CustomerAddActivity.this, CustomerListActivity.class);
        startActivity(intent);
    }

    @Override
    public void cancleAddCustomer() {
        Intent intent = new Intent(CustomerAddActivity.this, CustomerListActivity.class);
        startActivity(intent);
    }

    @Override
    public Customer getInputCustomer() {
        String name = customerNameInput.getText().toString();
        String profile = customerProfileInput.getText().toString();
        String phone = customerPhoneInput.getText().toString();
        String address = customerAddressInput.getText().toString();
        String website = customerWebsiteInput.getText().toString();
        Customer customer = new Customer();
        customer.setCustomername(name);
        customer.setProfile(profile);
        customer.setTelephone(phone);
        customer.setAddress(address);
        customer.setWebsite(website);
        return customer;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.customer_add_confirm) {
            customerAddPresenter.confirmAddCustomer();
        } else if (v.getId() == R.id.customer_add_cancle) {
            customerAddPresenter.cancleAddCustomer();
        }
    }
}
