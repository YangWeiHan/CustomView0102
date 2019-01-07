package com.example.secondweekpractice.data.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.secondweekpractice.R;
import com.example.secondweekpractice.data.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<NewsBean.DataBean> dataBeans;

    public NewsAdapter(Context context) {
        this.context = context;
        dataBeans = new ArrayList<>();
    }

    public void setDataBeans(FragmentActivity activity, List<NewsBean.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        View view = View.inflate(context,R.layout.news_item_layout,null);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        Glide.with(context).load(dataBeans.get(i).getThumbnail_pic_s()).into(holder.iv_icon);
        holder.news_time.setText(dataBeans.get(i).getDate());
        holder.news_title.setText(dataBeans.get(i).getTitle());

    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_icon;
        TextView news_title,news_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_icon = itemView.findViewById(R.id.iv_icon);
            news_time = itemView.findViewById(R.id.news_time);
            news_title  = itemView.findViewById(R.id._news_title);


        }
    }
}
