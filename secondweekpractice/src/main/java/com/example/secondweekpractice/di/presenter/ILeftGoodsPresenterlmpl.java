package com.example.secondweekpractice.di.presenter;

import com.example.secondweekpractice.di.contract.ILeftGoodConteact;
import com.example.secondweekpractice.di.model.ILeftGoodsModellmpl;

import java.lang.ref.SoftReference;

public class ILeftGoodsPresenterlmpl implements ILeftGoodConteact.ILeftGoodsPresenter<ILeftGoodConteact.ILeftGoodsView> {

    ILeftGoodConteact.ILeftGoodsView iLeftGoodsView;
    private SoftReference<ILeftGoodConteact.ILeftGoodsView> reference;
    private ILeftGoodConteact.ILeftGoodsModel modellmpl;

    @Override
    public void attchView(ILeftGoodConteact.ILeftGoodsView iLeftGoodsView) {
        this.iLeftGoodsView = iLeftGoodsView;
        reference = new SoftReference<>(iLeftGoodsView);
        modellmpl = new ILeftGoodsModellmpl();
    }

    @Override
    public void detachView(ILeftGoodConteact.ILeftGoodsView iLeftGoodsView) {
        reference.clear();

    }

    @Override
    public void responseLeftGoodsData() {
        modellmpl.containLeftGoodsData(new ILeftGoodConteact.ILeftGoodsModel.LeftCallBack() {
            @Override
            public void onCallBack(String message) {
                iLeftGoodsView.setLeftGoodsData(message);
            }
        });
    }
}