package com.example.secondweekpractice.di.model;

import com.example.secondweekpractice.data.OkHttpUtils.OkHttpUtils;
import com.example.secondweekpractice.data.apils.Apils;
import com.example.secondweekpractice.data.bean.NewsBean;
import com.example.secondweekpractice.di.contract.INewsContract;

import java.io.IOException;

import javax.security.auth.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

public class INewsModellmpl implements INewsContract.INewsModel {

    @Override
    public void containData(final MyCallBack myCallBack) {
        OkHttpUtils.getInstanse().getEnqueue(Apils.NEWS_URL, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                myCallBack.onCallBack(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                myCallBack.onCallBack(response.body().string());
            }
        });
    }
}
