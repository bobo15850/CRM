package com.nju.edu.crm.model;

import com.nju.edu.crm.model.impl.CustomerInfoImpl;

/**
 * Created by 张波波 on 2016-06-20.
 */
public class ModelFactory {
    public static ICustomerInfo getCustomerInfo() {
        return CustomerInfoImpl.getInstance();
    }
}
