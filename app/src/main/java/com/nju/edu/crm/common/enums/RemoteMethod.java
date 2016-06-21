package com.nju.edu.crm.common.enums;

import com.nju.edu.crm.common.consts.BaseValue;

import java.util.Map;

import okhttp3.Request;

/**
 * Created by 张波波 on 2016-06-22.
 */
public enum RemoteMethod {
    //通用查询接口
    common_staff_json("common_staff_json", RequestMethod.POST),
    common_contacts_json("common_contacts_json", RequestMethod.POST),
    common_followup_json("common_followup_json", RequestMethod.POST),
    common_opportunity_json("common_opportunity_json", RequestMethod.POST),
    common_product_json("common_product_json", RequestMethod.POST),
    common_customer_json("common_customer_json", RequestMethod.POST),
    common_department_json("common_department_json", RequestMethod.POST),
    //用户信息接口
    staff_que客户信息接口ry_json("staff_query_json", RequestMethod.GET),
    staff_create_json("staff_create_json", RequestMethod.POST),
    staff_modify_json("staff_modify_json", RequestMethod.POST),
    //客户信息接口
    customer_query_json("customer_query_json", RequestMethod.GET),
    customer_create_json("customer_create_json", RequestMethod.POST),
    customer_modify_json("customer_modify_json", RequestMethod.POST),
    //商品信息接口
    product_query_json("product_query_json", RequestMethod.GET),
    product_create_json("product_create_json", RequestMethod.POST),
    product_modify_json("product_modify_json", RequestMethod.POST),
    //商机信息接口
    opportunity_query_json("opportunity_query_json", RequestMethod.GET),
    opportunity_create_json("opportunity_create_json", RequestMethod.POST),
    opportunity_modify_json("opportunity_modify_json", RequestMethod.POST),
    //合同信息接口
    contract_query_json("contract_query_json", RequestMethod.GET),
    contract_create_json("contract_create_json", RequestMethod.POST),
    contract_modify_json("contract_modify_json", RequestMethod.POST),
    //跟进信息接口
    followup_query_json("followup_query_json", RequestMethod.GET),
    followup_create_json("followup_create_json", RequestMethod.POST),
    followup_modify_json("followup_modify_json", RequestMethod.POST),
    //联系人信息接口
    contact_query_json("contact_query_json", RequestMethod.GET),
    contact_create_json("contact_create_json", RequestMethod.POST),
    contact_modify_json("contact_modify_json", RequestMethod.POST);


    private final String methodName;
    private final RequestMethod requestMethod;

    RemoteMethod(String methodName, RequestMethod requestMethod) {
        this.methodName = methodName;
        this.requestMethod = requestMethod;
    }

    private String getUrlStr() {
        return BaseValue.BASE_URL + this.methodName;
    }

    public Request getRequest(Map<String, String> params) {
        return this.requestMethod.getRequest(this.getUrlStr(), params);
    }
}
