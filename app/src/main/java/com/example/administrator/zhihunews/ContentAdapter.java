package com.example.administrator.zhihunews;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.zhihunews.Util.Tools;
import com.example.administrator.zhihunews.gson.Stories;

import java.util.List;

/**
 * Created by Administrator on 2017/2/14.
 */

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

    private Context mContext;
    private List<Stories> mContentList;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView contentImg;
        TextView contentTitle;

        public ViewHolder(View v) {
            super(v);
            cardView = (CardView) v;
            contentImg = (ImageView) v.findViewById(R.id.content_img);
            contentTitle = (TextView) v.findViewById(R.id.content_title);
        }
    }


    public ContentAdapter(List<Stories> storiesList) {
        mContentList = storiesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {                                       //创建ViewHolder实例
        mContext = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item, parent, false);          //加载content_item布局
        final ViewHolder holder = new ViewHolder(v);                                                                    //在创建ViewHolder实例
        return holder;
    }

    @Override
    public void onBindViewHolder(ContentAdapter.ViewHolder holder, int position) {                              //对ViewHolder子项进行赋值
        Stories stories = mContentList.get(position);                                                         //每个被滚动到屏幕内的子项都会被得到position参数
        holder.contentTitle.setText(stories.getTitle());                                                     //将数据设置到ImageView和TextView里
        Glide.with(mContext).load(Tools.utilString(stories.getImages().toString())).into(holder.contentImg);
    }


    @Override
    public int getItemCount() {
        return mContentList.size();
    }
}
