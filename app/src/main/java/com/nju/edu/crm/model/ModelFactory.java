package com.nju.edu.crm.model;

import com.nju.edu.crm.model.impl.CustomerModel;
import com.nju.edu.crm.model.impl.FollowupModel;

/**
 * Created by 张波波 on 2016-06-23.
 */
public class ModelFactory {
    private static ICustomerModel customerModel = null;
    private static IFollowupModel followupModel = null;

    public static ICustomerModel getCustomerModel() {
        if (customerModel == null) {
            customerModel = new CustomerModel();
        }
        return customerModel;
    }

    public static IFollowupModel getFollowupModel() {
        if (followupModel == null) {
            followupModel = new FollowupModel();
        }
        return followupModel;
    }
}
