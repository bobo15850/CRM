package com.nju.edu.crm.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张波波 on 2016-06-22.
 */
public class JsonUtil {
    public static <T> void fillObjectList(List<T> list, String jsonStr, Class<T> clazz) {
        Map<String, JSONObject> map = JSON.parseObject(jsonStr, new HashMap<String, JSONObject>().getClass());
        for (int i = 0; i < map.size(); i++) {
            if (map.containsKey(String.valueOf(i))) {
                T temp = map.get(String.valueOf(i)).toJavaObject(clazz);
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
