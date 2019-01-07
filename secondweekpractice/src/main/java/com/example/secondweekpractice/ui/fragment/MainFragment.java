package com.example.secondweekpractice.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.secondweekpractice.R;
import com.example.secondweekpractice.data.adapter.LeftGoodsAdapter;
import com.example.secondweekpractice.data.bean.LeftGoodsBean;
import com.example.secondweekpractice.di.contract.ILeftGoodConteact;
import com.example.secondweekpractice.di.presenter.ILeftGoodsPresenterlmpl;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainFragment extends Fragment implements ILeftGoodConteact.ILeftGoodsView {
    @BindView(R.id.left_recyclerView)
    RecyclerView leftRecyclerView;
    @BindView(R.id.right_recyclerView)
    RecyclerView rightRecyclerView;
    Unbinder unbinder;
    private ILeftGoodsPresenterlmpl presenterlmpl;
    private LeftGoodsAdapter goodsAdapter;

    private Handler handler = new Handler(){
        private List<LeftGoodsBean.DataBean> dataBeans;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100){
                String mseeageData = (String) msg.obj;
                Gson gson = new Gson();
                LeftGoodsBean leftGoodsBean = gson.fromJson(mseeageData, LeftGoodsBean.class);
                dataBeans = leftGoodsBean.getData();
                goodsAdapter = new LeftGoodsAdapter(getActivity());
                goodsAdapter.setList(getActivity(),dataBeans);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                leftRecyclerView.setLayoutManager(layoutManager);
                leftRecyclerView.setAdapter(goodsAdapter);
                goodsAdapter.notifyDataSetChanged();
            }

        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_item, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenterlmpl = new ILeftGoodsPresenterlmpl();
        presenterlmpl.attchView(this);
        presenterlmpl.responseLeftGoodsData();
        /*goodsAdapter.setClickListener(new LeftGoodsAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int cid) {
                Toast.makeText(getActivity(),cid+"",Toast.LENGTH_LONG).show();
            }
        });*/
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenterlmpl.detachView(this);
    }

    @Override
    public void setLeftGoodsData(String message) {
        Message leftmessageData = handler.obtainMessage();
        leftmessageData.what = 100;
        leftmessageData.obj = message;
        handler.sendMessage(leftmessageData);

    }
}
