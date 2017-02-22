package com.example.administrator.zhihunews;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class ContentDetail extends AppCompatActivity {

    public static final String CONTENT_TITLE = "contentTitle";
    public static final String CONTENT_IMG = "contentImg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_detail);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_contentDetail);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Intent intent = getIntent();
        String contentTitle = intent.getStringExtra(CONTENT_TITLE);
        int contentImg = intent.getIntExtra(CONTENT_IMG,0);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ImageView contentImage = (ImageView)findViewById(R.id.content_img);
        TextView Title = (TextView)findViewById(R.id.content_title);
        collapsingToolbarLayout.setTitle(contentTitle);
        Glide.with(this).load(contentImg).into(contentImage);
        String content = generateContentTitle(contentTitle);
        Title.setText(content);
    }

    private String generateContentTitle(String contentTitle){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<100;i++){
            stringBuilder.append(contentTitle);
        }
        return contentTitle.toString();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
