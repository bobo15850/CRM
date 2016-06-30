package com.nju.edu.crm.view.iview.customer;

import com.nju.edu.crm.model.entity.Customer;
import com.nju.edu.crm.view.iview.IBaseView;

/**
 * Created by 张波波 on 2016-06-23.
 */
public interface ICustomerHomeView extends IBaseView {
    void initCustomerInfo(Customer customer);
}
