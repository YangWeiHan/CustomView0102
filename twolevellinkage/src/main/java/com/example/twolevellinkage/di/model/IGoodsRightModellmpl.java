package com.example.twolevellinkage.di.model;

import com.example.twolevellinkage.data.aplis.Aplis;
import com.example.twolevellinkage.data.bean.RightGoodsBean;
import com.example.twolevellinkage.di.contract.IGoodRightContract;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class IGoodsRightModellmpl implements IGoodRightContract.IGoodsLRightModel {
    @Override
    public void containRightData(int cid, final MyCallBack myCallBack) {
        OkGo.<String>get(Aplis.RIGHT_GOODS_URL+cid).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String rightResult = response.body().toString();
                Gson gson = new Gson();
                RightGoodsBean rightGoodsBean = gson.fromJson(rightResult, RightGoodsBean.class);
                myCallBack.onCallBack(rightGoodsBean);
            }
        });
    }
}
