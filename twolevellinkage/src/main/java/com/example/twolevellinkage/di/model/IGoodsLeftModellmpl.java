package com.example.twolevellinkage.di.model;

import com.example.twolevellinkage.data.aplis.Aplis;
import com.example.twolevellinkage.data.bean.LeftGoodsBean;
import com.example.twolevellinkage.di.contract.IGoodLeftContract;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class IGoodsLeftModellmpl implements IGoodLeftContract.IGoodsLeftModel {
    @Override
    public void containLeftData(final MyCallBack myCallBack) {
        OkGo.<String>get(Aplis.LEFT_GOODS_UTL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String result = response.body().toString();

                Gson gson = new Gson();
                LeftGoodsBean leftGoodsBean = gson.fromJson(result, LeftGoodsBean.class);
                myCallBack.onCallBack(leftGoodsBean);
            }
        });
    }
}
