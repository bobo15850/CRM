package com.nju.edu.crm.presenter.customer.impl;

import com.nju.edu.crm.common.utils.ResultCallback;
import com.nju.edu.crm.model.ICustomerModel;
import com.nju.edu.crm.model.ModelFactory;
import com.nju.edu.crm.model.entity.Customer;
import com.nju.edu.crm.presenter.customer.ICustomerListPresenter;
import com.nju.edu.crm.view.iview.customer.ICustomerListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张波波 on 2016-06-20.
 */
public class CustomerListPresenter implements ICustomerListPresenter {
    private ICustomerListView customerListView;
    private ICustomerModel customerModel;

    public CustomerListPresenter(ICustomerListView customerListView) {
        this.customerListView = customerListView;
        this.customerModel = ModelFactory.getCustomerModel();
    }

    @Override
    public void initAllCustomerList() {
        final List<Customer> customerList = new ArrayList<>();
        customerModel.getAllCustomersByPage(customerList, 0, new ResultCallback() {
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
        final List<Customer> customerList = new ArrayList<>();
        customerModel.getMyCustomersByPage(customerList, 0, new ResultCallback() {
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
    public void toAddCustomer() {
        customerListView.toAddCustomer();
    }
}
