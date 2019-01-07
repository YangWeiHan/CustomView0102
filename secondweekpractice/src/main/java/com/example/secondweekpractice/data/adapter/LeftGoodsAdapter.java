package com.example.secondweekpractice.data.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.secondweekpractice.R;
import com.example.secondweekpractice.data.bean.LeftGoodsBean;

import java.util.ArrayList;
import java.util.List;

public class LeftGoodsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<LeftGoodsBean.DataBean> list;

    public LeftGoodsAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(FragmentActivity activity, List<LeftGoodsBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        View view = View.inflate(context,R.layout.left_item,null);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.leftgoods_name.setText(list.get(i).getName());

        holder.leftgoods_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener !=null){
                    clickListener.OnItemClickListener(list.get(i).getCid());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView leftgoods_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leftgoods_name = itemView.findViewById(R.id.left_title);
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
