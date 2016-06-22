package com.nju.edu.crm.presenter.customer.impl;

import com.nju.edu.crm.common.consts.BaseValue;
import com.nju.edu.crm.common.enums.RemoteMethod;
import com.nju.edu.crm.common.utils.ResultCallback;
import com.nju.edu.crm.model.entity.Customer;
import com.nju.edu.crm.model.ModelUtil;
import com.nju.edu.crm.presenter.customer.ICustomerListPresenter;
import com.nju.edu.crm.view.iview.customer.ICustomerListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张波波 on 2016-06-20.
 */
public class CustomerListPresenterImpl implements ICustomerListPresenter {
    private ICustomerListView customerListView;

    public CustomerListPresenterImpl(ICustomerListView customerListView) {
        this.customerListView = customerListView;
    }

    @Override
    public void initAllCustomerList() {
        final Map<String, String> params = new HashMap<>();
        params.put("currentpage", "0");
        final List<Customer> customerList = new ArrayList<>();
        ModelUtil.queryEntityList(RemoteMethod.common_customer_json, params, Customer.class, customerList, new ResultCallback() {
            @Override
            public void success() {
                customerListView.initCustomerList(customerList);
            }

            @Override
            public void failure() {
                customerListView.netWorkError();
            }
        });
    }

    @Override
    public void initMyCustomerList() {
        final Map<String, String> params = new HashMap<>();
        params.put("currentpage", "0");
        params.put("staffid", String.valueOf(BaseValue.LOGIN_STAFF_ID));
        final List<Customer> customerList = new ArrayList<>();
        ModelUtil.queryEntityList(RemoteMethod.common_customer_json, params, Customer.class, customerList, new ResultCallback() {
            @Override
            public void success() {
                customerListView.initCustomerList(customerList);
            }

            @Override
            public void failure() {
                customerListView.netWorkError();
            }
        });
    }
}
