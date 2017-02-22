package com.example.administrator.zhihunews.Util;

/**
 * Created by Administrator on 2017/2/18.
 */

public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);
}
