package com.nju.edu.crm.presenter.customer.impl;

import com.nju.edu.crm.common.utils.ResultCallback;
import com.nju.edu.crm.model.ICustomerModel;
import com.nju.edu.crm.model.ModelFactory;
import com.nju.edu.crm.model.entity.Customer;
import com.nju.edu.crm.presenter.customer.ICustomerAddPresenter;
import com.nju.edu.crm.view.iview.customer.ICustomerAddView;

/**
 * Created by 张波波 on 2016-06-30.
 */
public class CustomerAddPresenter implements ICustomerAddPresenter {

    private ICustomerAddView customerAddView;
    private ICustomerModel customerModel;

    public CustomerAddPresenter(ICustomerAddView customerAddView) {
        this.customerAddView = customerAddView;
        this.customerModel = ModelFactory.getCustomerModel();
    }

    @Override
    public void confirmAddCustomer() {
        Customer customer = customerAddView.getInputCustomer();
        customerModel.addCustomer(customer, new ResultCallback() {
            @Override
            public void success() {
                customerAddView.confirmAddCustomer();
            }

            @Override
            public void failure() {
                customerAddView.confirmAddCustomer();
            }
        });
    }

    @Override
    public void cancleAddCustomer() {
        customerAddView.cancleAddCustomer();
    }
}
