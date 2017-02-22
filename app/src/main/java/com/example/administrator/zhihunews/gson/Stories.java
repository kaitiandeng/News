package com.example.administrator.zhihunews.gson;

import java.util.List;

/**
 * Created by Administrator on 2017/2/19.
 */

public class Stories {
    private String title;
    private String ga_prefix;
    private List<String> images;
    private int type;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public List<String> getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "Stories{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ga_prefix='" + ga_prefix + '\'' +
                ", images=" + images +
                ", type=" + type +
                '}';
    }
}
