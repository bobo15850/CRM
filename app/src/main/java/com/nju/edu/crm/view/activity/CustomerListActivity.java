package com.nju.edu.crm.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.nju.edu.crm.R;
import com.nju.edu.crm.view.ICustomerListView;

public class CustomerListActivity extends AppCompatActivity implements ICustomerListView {
    private ListView listView;
    private Button allCustomerButton;
    private Button myCustomerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
    }

    private void initComponent() {
        listView = (ListView) this.findViewById(R.id.customer_list);
    }
}
