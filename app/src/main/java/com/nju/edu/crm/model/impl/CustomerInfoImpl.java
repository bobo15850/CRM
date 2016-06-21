package com.nju.edu.crm.model.impl;

import android.util.Log;

import com.nju.edu.crm.common.enums.RemoteMethod;
import com.nju.edu.crm.common.utils.HttpUtil;
import com.nju.edu.crm.model.ICustomerInfo;
import com.nju.edu.crm.model.entity.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 张波波 on 2016-06-20.
 */
public class CustomerInfoImpl implements ICustomerInfo {

    private static CustomerInfoImpl instance = null;
    private HttpUtil httpUtil;

    private CustomerInfoImpl() {
        httpUtil = HttpUtil.getInstance();
    }

    public static CustomerInfoImpl getInstance() {
        if (instance == null) {
            instance = new CustomerInfoImpl();
        }
        return instance;
    }


    @Override
    public List<Customer> getCustomerList(Map<String, String> params) throws IOException {
        String responseStr = httpUtil.sendRequest(RemoteMethod.common_customer_json, params);
        Log.d("customerres", responseStr);
        List<Customer> customerList = new ArrayList<>();
        Customer customer = new Customer();
        customer.setCustomername("张三");
        customer.setCustomertype(2);
        customerList.add(customer);
        return customerList;
    }
}
