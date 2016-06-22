package com.nju.edu.crm.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by 张波波 on 2016-06-22.
 */
public class JsonUtil {
    public static <T> void fillObjectList(List<T> list, String jsonStr, Class<T> clazz) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        for (int i = 0; i < jsonObject.size(); i++) {
            if (jsonObject.containsKey(String.valueOf(i))) {
                T temp = jsonObject.getJSONObject(String.valueOf(i)).toJavaObject(clazz);
                list.add(temp);
            } else {
                break;
            }
        }
    }

    public static <T> T getObject(String jsonStr, Class<T> clazz) {
        T t = JSON.parseObject(jsonStr, clazz);
        return t;
    }
}
