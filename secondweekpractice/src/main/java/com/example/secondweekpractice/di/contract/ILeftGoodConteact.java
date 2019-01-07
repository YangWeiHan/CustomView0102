package com.example.secondweekpractice.di.contract;

public interface ILeftGoodConteact {

    //V层
    public interface ILeftGoodsView{
        void setLeftGoodsData(String message);
    }

    //P层

    public interface ILeftGoodsPresenter<ILeftGoodsView>{

        void attchView(ILeftGoodsView iLeftGoodsView);

        void detachView(ILeftGoodsView iLeftGoodsView);

        void responseLeftGoodsData();

    }

    public interface ILeftGoodsModel{

        void containLeftGoodsData(LeftCallBack leftCallBack);

        public interface LeftCallBack{


            void onCallBack(String message);
        }
    }
}
