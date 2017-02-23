package com.example.administrator.zhihunews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.zhihunews.gson.Latest;


import java.util.List;

/**
 * Created by Administrator on 2017/2/14.
 */

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

    private Context mContext;
    private List<Latest.StoriesBean> mStorieslist;


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


    public ContentAdapter(List<Latest.StoriesBean> storiesList) {
        mStorieslist = storiesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {                                       //创建ViewHolder实例
        mContext = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item, parent, false);          //加载content_item布局
        final ViewHolder holder = new ViewHolder(v);                                                                    //在创建ViewHolder实例
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Latest.StoriesBean storiesBean = mStorieslist.get(position);
                Toast.makeText(mContext,mStorieslist.get(position).getTitle(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(mContext,WebActivity.class);
                intent.putExtra("id",storiesBean.getId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ContentAdapter.ViewHolder holder, int position) {                              //对ViewHolder子项进行赋值
        Latest.StoriesBean stories = mStorieslist.get(position);                                                         //每个被滚动到屏幕内的子项都会被得到position参数
        holder.contentTitle.setText(stories.getTitle());                                                     //将数据设置到ImageView和TextView里);
        //Glide.with(mContext).load(stories.getImages()).placeholder(R.mipmap.ic_icon).into(holder.contentImg);
    }


    @Override
    public int getItemCount() {
        return mStorieslist.size();
    }
}
