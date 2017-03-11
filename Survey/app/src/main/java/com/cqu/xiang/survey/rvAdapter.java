package com.cqu.xiang.survey;

import android.app.ActivityOptions;
import android.content.ClipData;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiang on 2017/3/12.
 */

public class rvAdapter extends RecyclerView.Adapter<rvAdapter.MyViewHolder> implements View.OnClickListener{

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    private List<String> mDatas;

    public rvAdapter(List<String> Datas) {
        mDatas = Datas;
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v,(String)v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public rvAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(rvAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));
        holder.itemView.setTag(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public MyViewHolder(View v) {
            super(v);
            tv = (TextView)v.findViewById(R.id.tvItem);
        }
    };
}
