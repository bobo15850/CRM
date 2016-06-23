package com.nju.edu.crm.model;

import com.nju.edu.crm.model.impl.CustomerModel;
import com.nju.edu.crm.model.impl.FollowupModel;

/**
 * Created by 张波波 on 2016-06-23.
 */
public class ModelFactory {
    public static ICustomerModel getCustomerModel() {
        return new CustomerModel();
    }

    public static IFollowupModel getFollowupModel() {
        return new FollowupModel();
    }
}
