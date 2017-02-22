package com.example.administrator.zhihunews.gson;

import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */

public class Before {
    private List<Stories>stories;

    private String date;

    public void setStories(List<Stories>stories){
        this.stories = stories;
    }

    public void setDate(String date){
        this.date = date;
    }
    public List<Stories> getStories(){
        return stories;
    }

    public String getDate(){
        return date;
    }
}
