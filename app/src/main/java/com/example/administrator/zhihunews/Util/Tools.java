package com.example.administrator.zhihunews.Util;

/**
 * Created by Administrator on 2017/2/21.
 */

public class Tools {
    public static String utilString(String oldstring){
        int beginIndex = oldstring.indexOf("h");
        int endIndex = oldstring.indexOf("g");
        String news = oldstring.substring(beginIndex,endIndex+1);
        return news;
    }
}
