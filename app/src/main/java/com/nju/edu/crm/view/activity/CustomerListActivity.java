package com.nju.edu.crm.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.nju.edu.crm.R;
import com.nju.edu.crm.adapter.CustomerAdapter;
import com.nju.edu.crm.model.entity.Customer;
import com.nju.edu.crm.presenter.ICustomerListPresenter;
import com.nju.edu.crm.presenter.impl.CustomerPresenterImpl;
import com.nju.edu.crm.view.ICustomerListView;

import java.util.List;

public class CustomerListActivity extends BaseActivity implements ICustomerListView, View.OnClickListener, AdapterView.OnItemClickListener {
    private List<Customer> customerList;
    private ListView listView;
    private Button allCustomerButton;
    private Button myCustomerButton;

    private ICustomerListPresenter customerListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        initComponent();
        customerListPresenter = new CustomerPresenterImpl(this);
        customerListPresenter.initCustomerList();
        Log.d("onCreate", String.valueOf(Thread.currentThread().getId()));
    }

    private void initComponent() {
        allCustomerButton = (Button) this.findViewById(R.id.all_customer_button);
        myCustomerButton = (Button) this.findViewById(R.id.my_customer_button);
        listView = (ListView) this.findViewById(R.id.customer_list);
        //添加监听
        allCustomerButton.setOnClickListener(this);
        myCustomerButton.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void initCustomerList(List<Customer> customerList) {
        final CustomerAdapter adapter = new CustomerAdapter(CustomerListActivity.this, R.layout.customer_item, customerList);
        final ListView listView = (ListView) this.findViewById(R.id.customer_list);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                listView.setAdapter(adapter);
            }
        });
        this.customerList = customerList;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.all_customer_button:
                Log.d("点击按钮:", "全部客户");
                break;
            case R.id.my_customer_button:
                Log.d("点击按钮:", "我的客户");
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (R.id.customer_list == parent.getId()) {
            Customer customer = customerList.get(position);
            Log.d("点击条目:", customer.getCustomername());
        }
    }
}
