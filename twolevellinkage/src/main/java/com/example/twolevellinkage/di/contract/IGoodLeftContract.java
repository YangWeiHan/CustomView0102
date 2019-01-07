package com.example.twolevellinkage.di.contract;

import com.example.twolevellinkage.data.bean.LeftGoodsBean;

public interface IGoodLeftContract {

    public interface IGoodsLeftView{
        void setLeftData(LeftGoodsBean leftGoodsBean);
    }

    public interface IGoodsLeftPresenter<IGoodsLeftView>{

        void attahView(IGoodsLeftView iGoodsLeftView);

        void detachView(IGoodsLeftView iGoodsLeftView);

        void requestLeftData();
    }

    public interface IGoodsLeftModel{

        void containLeftData(MyCallBack myCallBack);

        public interface MyCallBack{
            void onCallBack(LeftGoodsBean leftGoodsBean);
        }

    }
}
