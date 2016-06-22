package com.nju.edu.crm.presenter.impl;

import com.nju.edu.crm.common.utils.ResultCallback;
import com.nju.edu.crm.model.ICustomerInfo;
import com.nju.edu.crm.model.ModelFactory;
import com.nju.edu.crm.model.entity.Customer;
import com.nju.edu.crm.presenter.ICustomerListPresenter;
import com.nju.edu.crm.view.ICustomerListView;

import java.io.IOException;
import java.util.ArrayList;
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
        final Map<String, String> params = new HashMap<>();
        params.put("currentpage", "0");
        final List<Customer> customerList = new ArrayList<>();
        try {
            customerInfo.getCustomerList(customerList, params, new ResultCallback() {
                @Override
                public void success() {
                    customerListView.initCustomerList(customerList);
                }

                @Override
                public void failure() {
                    customerListView.netWorkError();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
