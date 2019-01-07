package com.example.secondweekpractice.data.OkHttpUtils;

import com.example.secondweekpractice.data.bean.NewsBean;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpUtils {

    public static OkHttpUtils okHttpUtils;

    public  OkHttpClient mclient;
    //构造函数私有化
    private OkHttpUtils(){
        mclient = new OkHttpClient.Builder().build();
    }

    public static OkHttpUtils getInstanse(){
        if (null == okHttpUtils){
            synchronized (OkHttpUtils.class){
                if (okHttpUtils == null){
                    return new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }

    public void getEnqueue(String urlString, Callback callback){
        Request request = new Request.Builder().url(urlString).build();
        mclient.newCall(request).enqueue(callback);

    }
}
