package com.nju.edu.crm.presenter.impl;

import com.nju.edu.crm.model.ICustomerInfo;
import com.nju.edu.crm.model.ModelFactory;
import com.nju.edu.crm.model.entity.Customer;
import com.nju.edu.crm.presenter.ICustomerListPresenter;
import com.nju.edu.crm.view.ICustomerListView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张波波 on 2016-06-20.
 */
public class CustomerPresenterImpl implements ICustomerListPresenter {
    private ICustomerListView customerListView;
    private ICustomerInfo customerInfo;

    public CustomerPresenterImpl(ICustomerListView customerListView) {
        this.customerListView = customerListView;
        this.customerInfo = ModelFactory.getCustomerInfo();
    }

    @Override
    public void initCustomerList() {
        Map<String, String> params = new HashMap<>();
        List<Customer> customerList = null;
        try {
            customerList = customerInfo.getCustomerList(params);
        } catch (IOException e) {
            e.printStackTrace();
        }
        customerListView.initCustomerList(customerList);
    }
}
