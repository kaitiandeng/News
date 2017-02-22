package com.example.administrator.zhihunews;

import java.util.List;

/**
 * Created by Administrator on 2017/2/21.
 */

public class StartImg {

    private List<Creatives> creatives;

    public void setCreatives(List<Creatives>creatives){
        this.creatives = creatives;
    }

    public List<Creatives> getCreatives(){
        return creatives;
    }

    public static class Creatives {
        private String url;
        private String text;
        private String start_time;
        private String impression_tracks;
        private int type;
        private int id;

        public void setUrl(String url) {
            this.url = url;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public void setImpression_tracks(String impression_tracks) {
            this.impression_tracks = impression_tracks;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public String getText() {
            return text;
        }

        public String getStart_time() {
            return start_time;
        }

        public String getImpression_tracks() {
            return impression_tracks;
        }

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }
    }
}
