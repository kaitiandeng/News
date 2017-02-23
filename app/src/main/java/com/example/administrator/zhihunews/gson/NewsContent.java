package com.example.administrator.zhihunews.gson;

import java.util.List;

/**
 * Created by lenovo on 2017/2/23.
 */

public class NewsContent {
    private String body;
    private String title;
    private String image;
    private String image_source;
    private List<String> css;

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }

    public List<String> getCss() {
        return css;
    }
}
