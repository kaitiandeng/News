package com.example.administrator.zhihunews.gson;

import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */

public class Content {
    private int id;
    private List<Recommenders> recommenders;
    private String body;
    private String title;
    private String ga_prefix;
    private String share_url;
    private String image;
    private int type;
    private List<String> css;
    private String image_source;

    public void setId(int id) {
        this.id = id;
    }

    public void setRecommenderses(List<Recommenders>recommenders){
        this.recommenders =recommenders;
    }

    public void setBody(String body){
        this.body = body;
    }

    public void setTitlle(String title){
        this.title = title;
    }

    public void setGa_prefix(String ga_prefix){
        this.ga_prefix = ga_prefix;
    }

    public void setShare_url(String share_url){
        this.share_url = share_url;
    }

    public void setImage(String image){
        this.image = image;
    }

    public void setImage_source(String image_source){
        this.image_source = image_source;
    }

    public void setType(int type){
        this.type = type;
    }

    public void setCss(List<String>css){
        this.css = css;
    }

    public int getId(){
        return id;
    }

    public int getType(){
        return type;
    }

    public String getBody(){
        return body;
    }

    public String getTitle(){
        return title;
    }

    public String getGa_prefix(){
        return ga_prefix;
    }

    public String getShare_url(){
        return share_url;
    }
    public String getImage(){
        return image;
    }

    public String getImage_source(){
        return image_source;
    }

    public List<Recommenders> getRecommenders(){
        return recommenders;
    }

    public List<String> getCss(){
        return css;
    }

    public static class Recommenders{
        private String avatar;

        public void setAvatar(String avatar){
            this.avatar = avatar;
        }

        public String getAvatar(){
            return avatar;
        }
    }
}

