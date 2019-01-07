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
import android.widget.ImageView;

import com.example.secondweekpractice.R;
import com.example.secondweekpractice.data.adapter.NewsAdapter;
import com.example.secondweekpractice.data.bean.NewsBean;
import com.example.secondweekpractice.di.contract.INewsContract;
import com.example.secondweekpractice.di.presenter.INewsPresenterlmpl;
import com.example.secondweekpractice.ui.custom.TitleBar;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NewsFragment extends Fragment implements INewsContract.INewsView {
    @BindView(R.id.go_back)
    ImageView goBack;
    @BindView(R.id.titleBar_news)
    TitleBar titleBarNews;
    Unbinder unbinder;
    @BindView(R.id.ry_recyclerView)
    RecyclerView ryRecyclerView;
    private INewsPresenterlmpl presenterlmpl;
    private NewsAdapter newsAdapter;

    Handler handler = new Handler() {

        private List<NewsBean.DataBean> data;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                String mess = (String) msg.obj;
                Gson gson = new Gson();
                NewsBean newsBean = gson.fromJson(mess, NewsBean.class);
                data = newsBean.getData();
                newsAdapter = new NewsAdapter(getActivity());
                newsAdapter.setDataBeans(getActivity(), data);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                ryRecyclerView.setLayoutManager(layoutManager);
                ryRecyclerView.setAdapter(newsAdapter);
                newsAdapter.notifyDataSetChanged();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_item, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenterlmpl = new INewsPresenterlmpl();
        presenterlmpl.attahView(this);
        presenterlmpl.requestData();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenterlmpl.detachView(this);

    }

    @Override
    public void showData(String message) {
        Message messageData = handler.obtainMessage();
        messageData.what = 100;
        messageData.obj = message;
        handler.sendMessage(messageData);


    }
}
