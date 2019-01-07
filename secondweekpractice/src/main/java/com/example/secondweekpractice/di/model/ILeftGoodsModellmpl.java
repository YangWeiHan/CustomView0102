package com.example.secondweekpractice.di.model;

import com.example.secondweekpractice.data.OkHttpUtils.OkHttpUtils;
import com.example.secondweekpractice.data.apils.Apils;
import com.example.secondweekpractice.di.contract.ILeftGoodConteact;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ILeftGoodsModellmpl implements ILeftGoodConteact.ILeftGoodsModel {

    @Override
    public void containLeftGoodsData(final LeftCallBack leftCallBack) {
        OkHttpUtils.getInstanse().getEnqueue(Apils.LEFT_GOODS_UTL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                leftCallBack.onCallBack(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                leftCallBack.onCallBack(response.body().string());
            }
        });

    }
}
