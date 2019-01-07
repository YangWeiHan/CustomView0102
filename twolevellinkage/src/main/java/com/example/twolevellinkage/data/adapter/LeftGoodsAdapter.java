package com.example.twolevellinkage.data.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.twolevellinkage.R;
import com.example.twolevellinkage.data.bean.LeftGoodsBean;
import com.example.twolevellinkage.ui.activity.ShowActivity;

import java.util.ArrayList;
import java.util.List;

public class LeftGoodsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    private List<LeftGoodsBean.DataBean> left_beanList;

    public LeftGoodsAdapter(Context context) {
        this.context = context;
        left_beanList = new ArrayList<>();
    }

   /* public void setLeft_beanList(ShowActivity showActivity, List<LeftGoodsBean.DataBean> left_beanList) {
        this.left_beanList = left_beanList;
        notifyDataSetChanged();
    }*/

    public void setLeft_beanList(List<LeftGoodsBean.DataBean> left_beanList) {
        this.left_beanList = left_beanList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        View view = View.inflate(context,R.layout.leftgoods_item,null);
        viewHolder = new ViweHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
       ViweHolder holder = (ViweHolder) viewHolder;
       holder.leftgoods_name.setText(left_beanList.get(i).getName());
       holder.leftgoods_name.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (clickListener != null){
                   clickListener.OnItemClickListener(left_beanList.get(i).getCid());
               }
           }
       });

    }

    @Override
    public int getItemCount() {
        return left_beanList.size();
    }

    class ViweHolder extends RecyclerView.ViewHolder {
        TextView leftgoods_name;
        public ViweHolder(@NonNull View itemView) {
            super(itemView);
            leftgoods_name = itemView.findViewById(R.id.left_goods_name);
        }
    }
    //点击事件
    public interface OnItemClickListener{
        void OnItemClickListener(int cid);
    }
    private OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
