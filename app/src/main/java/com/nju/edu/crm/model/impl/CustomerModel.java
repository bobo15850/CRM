package com.nju.edu.crm.model.impl;

import com.nju.edu.crm.common.consts.BaseValue;
import com.nju.edu.crm.common.enums.RemoteMethod;
import com.nju.edu.crm.common.utils.HttpUtil;
import com.nju.edu.crm.common.utils.ResultCallback;
import com.nju.edu.crm.model.ICustomerModel;
import com.nju.edu.crm.model.entity.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张波波 on 2016-06-23.
 */
public class CustomerModel implements ICustomerModel {
    @Override
    public void getAllCustomersByPage(List<Customer> customerList, int page, ResultCallback callback) {
        Map<String, String> params = new HashMap<>();
        params.put("currentpage", "0");
        HttpUtil.queryEntityList(RemoteMethod.common_customer_json, params, Customer.class, customerList, callback);
    }

    @Override
    public void getMyCustomersByPage(List<Customer> customerList, int page, ResultCallback callback) {
        final Map<String, String> params = new HashMap<>();
        params.put("currentpage", "0");
        params.put("staffid", String.valueOf(BaseValue.LOGIN_STAFF_ID));
        HttpUtil.queryEntityList(RemoteMethod.common_customer_json, params, Customer.class, customerList, callback);
    }

    @Override
    public void addCustomer(Customer customer, ResultCallback callback) {
        final Map<String, String> params = new HashMap<>();
        params.put("staffid", String.valueOf(BaseValue.LOGIN_STAFF_ID));
        params.put("customername", customer.getCustomername());
        params.put("profile", customer.getProfile());
        params.put("telephone", customer.getTelephone());
        params.put("address", customer.getAddress());
        params.put("website", customer.getWebsite());
        HttpUtil.addEntity(RemoteMethod.customer_create_json, params, callback);
    }

    @Override
    public void getCsutomerById(List<Customer> customerList, int customerid, ResultCallback callback) {
        final Map<String, String> params = new HashMap<>();
        params.put("currentpage", "0");
        params.put("customerid", String.valueOf(customerid));
        HttpUtil.queryEntityList(RemoteMethod.common_customer_json, params, Customer.class, customerList, callback);
    }
}
