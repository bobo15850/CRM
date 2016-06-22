package com.nju.edu.crm.model;

import com.nju.edu.crm.common.utils.ResultCallback;
import com.nju.edu.crm.model.entity.Customer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by 张波波 on 2016-06-20.
 */
public interface ICustomerInfo {
    //通用查询接口
    void getCustomerList(final List<Customer> customerList, Map<String, String> params, ResultCallback callback) throws IOException;
}
