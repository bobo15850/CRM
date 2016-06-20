package com.nju.edu.crm.model.impl;

import com.nju.edu.crm.model.ICustomerInfo;

/**
 * Created by 张波波 on 2016-06-20.
 */
public class CustomerInfoImpl implements ICustomerInfo {

    private static CustomerInfoImpl instance = null;

    private CustomerInfoImpl() {
    }

    public static CustomerInfoImpl getInstance() {
        if (instance == null) {
            instance = new CustomerInfoImpl();
        }
        return instance;
    }


}
