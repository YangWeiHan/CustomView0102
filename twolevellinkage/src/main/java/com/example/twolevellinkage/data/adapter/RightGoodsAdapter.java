package com.example.twolevellinkage.data.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.twolevellinkage.R;
import com.example.twolevellinkage.data.bean.RightGoodsBean;

import java.util.ArrayList;
import java.util.List;

public class RightGoodsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<RightGoodsBean.DataBean> rightList;

    public RightGoodsAdapter(Context context) {
        this.context = context;
        rightList = new ArrayList<>();
    }

    public void setRightList(List<RightGoodsBean.DataBean> rightList) {
        this.rightList = rightList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (i){
            case 0:
                View view1 = View.inflate(context,R.layout.right_item_one,null);
                viewHolder = new OneViewHolder(view1);
                break;
            case 1:
                View view2 = View.inflate(context,R.layout.right_item_two,null);
                viewHolder = new TwoViewHolder(view2);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        OneViewHolder oneViewHolder = (OneViewHolder) viewHolder;
        TwoViewHolder twoViewHolder = (TwoViewHolder) viewHolder;
        switch (getItemViewType(i)){
            case 0:
                oneViewHolder.right_name_item.setText(rightList.get(i).getName());
                break;
            case 1:
               // GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false);
                Glide.with(context).load(rightList.get(i).getList().get(i).getIcon()).into(twoViewHolder.iv_icon);
        }
    }

    @Override
    public int getItemCount() {
        return rightList.size();
    }

    class OneViewHolder extends RecyclerView.ViewHolder{
        TextView right_name_item;
        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            right_name_item = itemView.findViewById(R.id.right_name_item);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_icon;
        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_icon = itemView.findViewById(R.id.iv_icon);
        }
    }

}
