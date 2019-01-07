package com.example.twolevellinkage.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.twolevellinkage.R;

import com.example.twolevellinkage.data.adapter.LeftGoodsAdapter;
import com.example.twolevellinkage.data.bean.LeftGoodsBean;
import com.example.twolevellinkage.data.bean.RightGoodsBean;
import com.example.twolevellinkage.di.contract.IGoodLeftContract;
import com.example.twolevellinkage.di.contract.IGoodRightContract;
import com.example.twolevellinkage.di.presenter.IGoodsLeftPresenterlmpl;
import com.example.twolevellinkage.di.presenter.IGoodsRightPresenterlmpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity implements IGoodLeftContract.IGoodsLeftView,IGoodRightContract.IGoodsRightView {

    @BindView(R.id.left_recyclerView)
    RecyclerView leftRecyclerView;
    @BindView(R.id.right_recyclerView)
    RecyclerView rightRecyclerView;
    private IGoodsLeftPresenterlmpl leftPresenterlmpl;
    private IGoodsRightPresenterlmpl rightPresenterlmpl;
    private LeftGoodsAdapter leftGoodsAdapter;
    private List<LeftGoodsBean.DataBean> leftListBean;
    private List<RightGoodsBean.DataBean> rightListBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);

        leftInit();
        rightInit();
    }

    private void leftInit() {
        leftPresenterlmpl = new IGoodsLeftPresenterlmpl();
        leftPresenterlmpl.attahView(this);
        leftPresenterlmpl.requestLeftData();
    }
    private void rightInit(){
        rightPresenterlmpl = new IGoodsRightPresenterlmpl();
        rightPresenterlmpl.attahView(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        leftPresenterlmpl.detachView(this);
        rightPresenterlmpl.detachView(this);
    }


    @Override
    public void setLeftData(LeftGoodsBean leftGoodsBean) {
        //数据源
        leftListBean = leftGoodsBean.getData();
        //布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(ShowActivity.this,LinearLayoutManager.VERTICAL,false);
        leftRecyclerView.setLayoutManager(layoutManager);
        //适配器
        leftGoodsAdapter = new LeftGoodsAdapter(this);
        leftGoodsAdapter.setLeft_beanList(leftListBean);
        leftRecyclerView.setAdapter(leftGoodsAdapter);

        leftGoodsAdapter.setClickListener(new LeftGoodsAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int cid) {
                Toast.makeText(ShowActivity.this,leftListBean.get(cid).getCreatetime(),Toast.LENGTH_SHORT).show();
                rightPresenterlmpl.requestRightData(leftListBean.get(cid).getCid());
            }
        });

    }

    @Override
    public void setRightData(RightGoodsBean rightGoodsBean) {

        rightListBean = rightGoodsBean.getData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShowActivity.this,LinearLayoutManager.VERTICAL,false);
        rightRecyclerView.setLayoutManager(linearLayoutManager);



    }
}
