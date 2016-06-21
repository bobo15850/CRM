package com.nju.edu.crm.common.enums;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Created by 张波波 on 2016-06-22.
 */
public enum RequestMethod {
    GET() {
        @Override
        public Request getRequest(String methodUrl, Map<String, String> params) {
            StringBuilder sb = new StringBuilder();
            if (params != null && params.size() > 0) {
                sb.append("?");
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append("=");
                    try {
                        sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    sb.append("&");
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            return new Request.Builder().url(methodUrl + sb.toString()).get().build();
        }
    },
    POST() {
        @Override
        public Request getRequest(String url, Map<String, String> params) {
            FormBody.Builder builder = new FormBody.Builder();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    builder.add(entry.getKey(), entry.getValue());
                }
            }
            return new Request.Builder().url(url).post(builder.build()).build();
        }
    };

    public abstract Request getRequest(String url, Map<String, String> params);
}
