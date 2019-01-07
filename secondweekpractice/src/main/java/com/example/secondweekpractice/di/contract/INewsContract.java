package com.example.secondweekpractice.di.contract;

public interface INewsContract {

    //V 层接口
    public interface INewsView{
        void showData(String message);
    }

    public interface INewsPresenter<INewsView>{
        void attahView(INewsView iNewsView);
        void detachView(INewsView INewsView);
        void requestData();
    }
    public interface INewsModel{

        void containData(MyCallBack myCallBack);

        public interface MyCallBack{
            void onCallBack(String message);
        }
    }
}
