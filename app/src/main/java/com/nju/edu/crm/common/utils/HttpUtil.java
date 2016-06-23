package com.nju.edu.crm.common.utils;

import com.nju.edu.crm.common.consts.BaseValue;
import com.nju.edu.crm.common.enums.RemoteMethod;
import com.nju.edu.crm.model.entity.BaseEntity;
import com.nju.edu.crm.model.entity.ResData;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 张波波 on 2016-06-22.
 */
public class HttpUtil {
    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(BaseValue.BASE_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(BaseValue.BASE_TIME_OUT, TimeUnit.SECONDS)
            .build();


    public static String sendRequest(RemoteMethod remoteMethod, Map<String, String> params) throws IOException {
        Request request = remoteMethod.getRequest(params);
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

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
