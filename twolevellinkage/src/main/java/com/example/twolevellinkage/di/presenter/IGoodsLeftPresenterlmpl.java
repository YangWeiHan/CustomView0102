package com.example.twolevellinkage.di.presenter;

import com.example.twolevellinkage.data.bean.LeftGoodsBean;
import com.example.twolevellinkage.di.contract.IGoodLeftContract;
import com.example.twolevellinkage.di.model.IGoodsLeftModellmpl;

import java.lang.ref.SoftReference;

public class IGoodsLeftPresenterlmpl implements IGoodLeftContract.IGoodsLeftPresenter<IGoodLeftContract.IGoodsLeftView> {
    IGoodLeftContract.IGoodsLeftView iGoodsLeftView;
    private SoftReference<IGoodLeftContract.IGoodsLeftView> reference;
    private IGoodsLeftModellmpl modellmpl;

    @Override
    public void attahView(IGoodLeftContract.IGoodsLeftView iGoodsLeftView) {
        this.iGoodsLeftView = iGoodsLeftView;
        reference = new SoftReference<>(iGoodsLeftView);
        modellmpl = new IGoodsLeftModellmpl();
    }

    @Override
    public void detachView(IGoodLeftContract.IGoodsLeftView iGoodsLeftView) {
        reference.clear();
    }

    @Override
    public void requestLeftData() {
        modellmpl.containLeftData(new IGoodLeftContract.IGoodsLeftModel.MyCallBack() {
            @Override
            public void onCallBack(LeftGoodsBean leftGoodsBean) {
                iGoodsLeftView.setLeftData(leftGoodsBean);
            }
        });
    }
}
