package com.nju.edu.crm.model.impl;

import com.nju.edu.crm.common.enums.RemoteMethod;
import com.nju.edu.crm.common.utils.HttpUtil;
import com.nju.edu.crm.common.utils.ResultCallback;
import com.nju.edu.crm.model.ICustomerInfo;
import com.nju.edu.crm.model.entity.Customer;

import java.io.IOException;
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
    public void getCustomerList(final List<Customer> customerList, final Map<String, String> params, final ResultCallback callback) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String responseStr = httpUtil.sendRequest(RemoteMethod.common_customer_json, params);
                    callback.success();
                } catch (IOException e) {
                    callback.failure();
                }
            }
        }).start();
    }
}
