package com.example.twolevellinkage.di.contract;

import com.example.twolevellinkage.data.bean.RightGoodsBean;

public interface IGoodRightContract {

    public interface IGoodsRightView{
        void setRightData(RightGoodsBean rightGoodsBean);
    }

    public interface IGoodsLeftPresenter<IGoodsRightView>{

        void attahView(IGoodsRightView iGoodsRightView);

        void detachView(IGoodsRightView iGoodsRightView);

        void requestRightData(int cid);
    }

    public interface IGoodsLRightModel{

        void containRightData(int cid,MyCallBack myCallBack);

        public interface MyCallBack{
            void onCallBack(RightGoodsBean rightGoodsBean);
        }

    }
}
