package com.nju.edu.crm.common.enums;

/**
 * Created by 张波波 on 2016-06-21.
 */
public enum CustomerType {
    COMMON(1, "普通客户"), HIGH(2, "高级客户"), VIP(3, "重要客户");

    private final Integer intValue;
    private final String strValue;

    CustomerType(Integer intValue, String strValue) {
        this.intValue = intValue;
        this.strValue = strValue;
    }

    public Integer getIntValue() {
        return this.intValue;
    }

    public String getStrValue() {
        return this.strValue;
    }

    public static CustomerType getCustomerType(Integer value) {
        if (value == null) return COMMON;
        switch (value) {
            case 1:
                return COMMON;
            case 2:
                return HIGH;
            case 3:
                return VIP;
            default:
                return COMMON;
        }
    }

}
