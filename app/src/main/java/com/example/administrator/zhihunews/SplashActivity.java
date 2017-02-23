package com.example.administrator.zhihunews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;;import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;
import com.example.administrator.zhihunews.Util.HttpCallbackListener;
import com.example.administrator.zhihunews.Util.HttpUtil;
import com.example.administrator.zhihunews.gson.Latest;
import com.google.gson.Gson;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {


    private ImageView iv_start;
    private TextView tv_fuck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);
        iv_start = (ImageView) findViewById(R.id.iv_start);
        tv_fuck = (TextView)findViewById(R.id.tv_fuck);
        loadImage();
    }

    private void loadImage() {
        AlphaAnimation animation = new AlphaAnimation(0.5f, 1.0f);    //设置淡入淡出的动画效果
        animation.setFillAfter(true);             //动画执行完后是否停留在执行完的状态
        animation.setDuration(3000);              //设置动画时间
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(final Animation animation) {
                String address = "https://news-at.zhihu.com/api/7/prefetch-launch-images/1086*1668";
                HttpUtil.sendRequest(address, new HttpCallbackListener() {
                    @Override
                    public void onFinish(final String response) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //parseJson(response);
                                iv_start.startAnimation(animation);      //开始动画
                            }
                        });
                        startActivity();
                    }

                    @Override
                    public void onError(Exception e) {
                        e.printStackTrace();
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        startActivity();
    }

    private void parseJson(String response){
        Gson gson = new Gson();
        StartImg startImg = gson.fromJson(response,StartImg.class);
        String imgUrl = startImg.getCreativesX().get(0).getUrl();
        Glide.with(SplashActivity.this).load(imgUrl).into(iv_start);
    }

    private void startActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();                              //不要忘记销毁该活动，，不然的话按下返回键就会重新回到启动界面。。。。
    }
}
