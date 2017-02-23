package com.example.administrator.zhihunews;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/2/21.
 */

public class StartImg {

    @SerializedName("creatives")
    private List<CreativesBean> creativesX;

    public List<CreativesBean> getCreativesX() {
        return creativesX;
    }

    public void setCreativesX(List<CreativesBean> creativesX) {
        this.creativesX = creativesX;
    }

    public static class CreativesBean {
        /**
         * url : https://pic4.zhimg.com/v2-d68cefa1320e27b6fc2bd0fdaec760b7.jpg
         * text : Alessio Lin
         * start_time : 1487768465
         * impression_tracks : ["https://sugar.zhihu.com/track?vs=1&ai=3240&ut=&cg=2&ts=1487768465.69&si=37a7b251ffac4187a60783f29a314d88&lu=0&hn=ad-engine.ad-engine.f08149d4&at=impression&pf=PC&az=11&sg=5eb217929b484506b78a4fb79d6ef5d5"]
         * type : 0
         * id : 3240
         */

        private String url;
        private String text;
        private int start_time;
        private int type;
        private String id;
        private List<String> impression_tracks;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getStart_time() {
            return start_time;
        }

        public void setStart_time(int start_time) {
            this.start_time = start_time;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getImpression_tracks() {
            return impression_tracks;
        }

        public void setImpression_tracks(List<String> impression_tracks) {
            this.impression_tracks = impression_tracks;
        }
    }
}
