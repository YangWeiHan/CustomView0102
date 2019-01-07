package com.example.twolevellinkage.di.presenter;

import com.example.twolevellinkage.data.bean.RightGoodsBean;
import com.example.twolevellinkage.di.contract.IGoodRightContract;
import com.example.twolevellinkage.di.model.IGoodsRightModellmpl;

import java.lang.ref.SoftReference;

public class IGoodsRightPresenterlmpl implements IGoodRightContract.IGoodsLeftPresenter<IGoodRightContract.IGoodsRightView> {
    IGoodRightContract.IGoodsRightView iGoodsRightView;
    private SoftReference<IGoodRightContract.IGoodsRightView> reference;
    private IGoodsRightModellmpl modellmpl;

    @Override
    public void attahView(IGoodRightContract.IGoodsRightView iGoodsRightView) {
        this.iGoodsRightView = iGoodsRightView;
        reference = new SoftReference<>(iGoodsRightView);
        modellmpl = new IGoodsRightModellmpl();


    }

    @Override
    public void detachView(IGoodRightContract.IGoodsRightView iGoodsRightView) {
        reference.clear();
    }

    @Override
    public void requestRightData(int cid) {
        modellmpl.containRightData(cid, new IGoodRightContract.IGoodsLRightModel.MyCallBack() {
            @Override
            public void onCallBack(RightGoodsBean rightGoodsBean) {
                iGoodsRightView.setRightData(rightGoodsBean);
            }
        });
    }


}
