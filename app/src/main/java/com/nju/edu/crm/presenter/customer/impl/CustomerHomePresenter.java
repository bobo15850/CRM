package com.nju.edu.crm.presenter.customer.impl;

import android.util.Log;

import com.nju.edu.crm.common.utils.ResultCallback;
import com.nju.edu.crm.model.ICustomerModel;
import com.nju.edu.crm.model.ModelFactory;
import com.nju.edu.crm.model.entity.Customer;
import com.nju.edu.crm.presenter.customer.ICustomerHomePresenter;
import com.nju.edu.crm.view.iview.customer.ICustomerHomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张波波 on 2016-06-23.
 */
public class CustomerHomePresenter implements ICustomerHomePresenter {
    private ICustomerHomeView customerHomeView;
    private ICustomerModel customerModel;

    public CustomerHomePresenter(ICustomerHomeView customerHomeView) {
        this.customerHomeView = customerHomeView;
        customerModel = ModelFactory.getCustomerModel();
    }

    @Override
    public void initCustomer(int customerid) {
        final List<Customer> customerList = new ArrayList<>();
        customerModel.getCsutomerById(customerList, customerid, new ResultCallback() {
            @Override
            public void success() {
                if (customerList.size() == 1) {
                    Customer customer = customerList.get(0);
                    customerHomeView.initCustomerInfo(customer);
                }
            }

            @Override
            public void failure() {
                Log.d("设置客户主页信息", "失败");
            }
        });
    }
}
