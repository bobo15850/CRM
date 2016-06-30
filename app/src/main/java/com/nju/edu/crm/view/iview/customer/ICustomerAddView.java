package com.nju.edu.crm.view.iview.customer;

import com.nju.edu.crm.model.entity.Customer;

/**
 * Created by 张波波 on 2016-06-30.
 */
public interface ICustomerAddView {
    void confirmAddCustomer();

    void cancleAddCustomer();

    Customer getInputCustomer();

}
