package com.nju.edu.crm.common.utils;

import com.nju.edu.crm.common.consts.BaseValue;
import com.nju.edu.crm.common.enums.RemoteMethod;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 张波波 on 2016-06-22.
 */
public class HttpUtil {
    private static HttpUtil instance;
    private OkHttpClient client;

    private HttpUtil() {
        client = new OkHttpClient.Builder()
                .connectTimeout(BaseValue.BASE_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(BaseValue.BASE_TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    public static HttpUtil getInstance() {
        if (instance == null) {
            instance = new HttpUtil();
        }
        return instance;
    }

    public String sendRequest(RemoteMethod remoteMethod, Map<String, String> params) throws IOException {
        Request request = remoteMethod.getRequest(params);
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
