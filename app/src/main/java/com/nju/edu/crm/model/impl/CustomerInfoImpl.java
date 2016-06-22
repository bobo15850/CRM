package com.nju.edu.crm.model.impl;

import com.nju.edu.crm.common.consts.BaseValue;
import com.nju.edu.crm.common.enums.RemoteMethod;
import com.nju.edu.crm.common.utils.HttpUtil;
import com.nju.edu.crm.common.utils.JsonUtil;
import com.nju.edu.crm.common.utils.ResultCallback;
import com.nju.edu.crm.model.ICustomerInfo;
import com.nju.edu.crm.model.entity.Customer;
import com.nju.edu.crm.model.entity.ResData;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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


    @Override
    public void getCustomerList(final List<Customer> customerList, final Map<String, String> params, final ResultCallback callback) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String responseStr = HttpUtil.sendRequest(RemoteMethod.common_customer_json, params);
                    ResData resData = JsonUtil.getObject(responseStr, ResData.class);
                    if (resData != null && resData.getResultcode() == BaseValue.SUCCESS_RESULT_CODE) {
                        JsonUtil.fillObjectList(customerList, responseStr, Customer.class);
                        callback.success();
                    } else {
                        callback.failure();
                    }
                } catch (IOException e) {
                    callback.failure();
                }
            }
        }).start();
    }
}
