package com.nju.edu.crm.model;

import com.nju.edu.crm.common.consts.BaseValue;
import com.nju.edu.crm.common.enums.RemoteMethod;
import com.nju.edu.crm.common.utils.HttpUtil;
import com.nju.edu.crm.common.utils.JsonUtil;
import com.nju.edu.crm.common.utils.ResultCallback;
import com.nju.edu.crm.model.entity.BaseEntity;
import com.nju.edu.crm.model.entity.ResData;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by 张波波 on 2016-06-23.
 */
//由于给的api比较简单，把model层抽象为一个工具类
public class ModelUtil {
    public static <T extends BaseEntity> void queryEntityList(final RemoteMethod method, final Map<String, String> params, final Class<T> clazz, final List<T> list, final ResultCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String responseStr = HttpUtil.sendRequest(method, params);
                    ResData resData = JsonUtil.getObject(responseStr, ResData.class);
                    if (resData != null && resData.getResultcode() == BaseValue.SUCCESS_RESULT_CODE) {
                        JsonUtil.fillObjectList(list, responseStr, clazz);
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
