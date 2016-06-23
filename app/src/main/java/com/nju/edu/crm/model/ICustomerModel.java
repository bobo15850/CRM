package com.nju.edu.crm.model;

import com.nju.edu.crm.common.utils.ResultCallback;
import com.nju.edu.crm.model.entity.Customer;

import java.util.List;

/**
 * Created by 张波波 on 2016-06-23.
 */
public interface ICustomerModel {
    void getAllCustomersByPage(List<Customer> customerList, int page, ResultCallback callback);

    void getMyCustomersByPage(List<Customer> customerList, int page, ResultCallback callback);
}
