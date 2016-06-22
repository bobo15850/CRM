package com.nju.edu.crm.view;

import com.nju.edu.crm.model.entity.Customer;

import java.util.List;

/**
 * Created by 张波波 on 2016-06-20.
 */
public interface ICustomerListView extends IBaseView {
    void initCustomerList(List<Customer> customerList);
}
