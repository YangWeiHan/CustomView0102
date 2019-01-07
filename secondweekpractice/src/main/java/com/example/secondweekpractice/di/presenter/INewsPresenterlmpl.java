package com.example.secondweekpractice.di.presenter;

import com.example.secondweekpractice.di.contract.INewsContract;
import com.example.secondweekpractice.di.model.INewsModellmpl;

import java.lang.ref.SoftReference;

public class INewsPresenterlmpl implements INewsContract.INewsPresenter<INewsContract.INewsView> {
    INewsContract.INewsView iNewsView;
    private SoftReference<INewsContract.INewsView> reference;
    private INewsContract.INewsModel modellmpl;

    @Override
    public void attahView(INewsContract.INewsView iNewsView) {
        this.iNewsView = iNewsView;
        reference = new SoftReference<>(iNewsView);
        modellmpl = new INewsModellmpl();
    }

    @Override
    public void detachView(INewsContract.INewsView INewsView) {
        reference.clear();
    }

    @Override
    public void requestData() {
        modellmpl.containData(new INewsContract.INewsModel.MyCallBack() {
            @Override
            public void onCallBack(String message) {
               iNewsView.showData(message);
            }
        });
    }
}
