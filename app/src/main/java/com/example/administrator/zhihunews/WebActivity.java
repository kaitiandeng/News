package com.example.administrator.zhihunews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.zhihunews.Util.HttpCallbackListener;
import com.example.administrator.zhihunews.Util.HttpUtil;
import com.example.administrator.zhihunews.gson.NewsContent;
import com.google.gson.Gson;

public class WebActivity extends AppCompatActivity {

    private String contentUrl = "http://news-at.zhihu.com/api/4/news/";
    private ImageView wv_iv;
    public String id;
    public String body;
    private String htmlImage;
    private String htmlImageRousouse;
    private String htmlMode = "<img class=\"avatar\" src=";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Intent intent = new Intent();
        id = intent.getStringExtra("id");
        wv_iv = (ImageView)findViewById(R.id.wv_iv);
        webView = (WebView)findViewById(R.id.wv);
        webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());                //设置网页跳转时仍在该view中展示
        initWebView();
    }

    private void initWebView(){
        String address = contentUrl + id;
        HttpUtil.sendRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(final String response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        parseJson(response);
                        Log.d("WebActivity.this","1146565146");
                    }
                });
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
            }
        });
    }
    public void parseJson(String response){
        Gson gson = new Gson();
        final NewsContent newsContent = gson.fromJson(response,NewsContent.class);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                body = newsContent.getBody();
                htmlImage = newsContent.getImage();
                htmlImageRousouse = "<p>" +newsContent.getImage_source()+"</p>";
                body = "<head><style>img{max-width:320px !important;}</style></head>"+body;
                webView.loadDataWithBaseURL(newsContent.getCss().toString(),body,"text/html","UTF-8",null);
                Glide.with(WebActivity.this).load(newsContent.getImage()).placeholder(R.mipmap.ic_icon).into(wv_iv);
            }
        });
    }
}
