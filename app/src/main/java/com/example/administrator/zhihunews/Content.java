package com.example.administrator.zhihunews;

/**
 * Created by Administrator on 2017/2/14.
 */

public class Content {
    public String contentTitle;
    public int ImageId;
    public Content(String contentTitle,int ImageId){
        this.contentTitle = contentTitle;
        this.ImageId = ImageId;
    }
    public String getContentTitle(){
        return contentTitle;
    }
    public int getContentImageId(){
        return ImageId;
    }
}
