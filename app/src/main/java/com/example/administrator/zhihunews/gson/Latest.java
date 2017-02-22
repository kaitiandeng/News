package com.example.administrator.zhihunews.gson;


import java.util.List;

/**
 * Created by Administrator on 2017/2/19.
 */

public class Latest {

    private String date;

    private List<Stories> stories;

    private List<Top> top_stories;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setStories(List<Stories> stories) {
        this.stories = stories;
    }

    public List<Stories> getStories() {
        return stories;
    }

    public void setTop_stories(List<Top> top_stories) {
        this.top_stories = top_stories;
    }

    public List<Top> getTop_stories() {
        return top_stories;
    }

    public static class Top {
        private int id;
        private String title;
        private String ga_prefix;
        private String image;
        private int type;

        public int setId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public String getImage() {
            return image;
        }

        public int getType() {
            return type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setType(int type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "TopStories{" +
                    "id=" + id +
                    ", title = '" + title + '\'' +
                    ",ga_prefix='" + ga_prefix + '\'' +
                    ", image='" + image + '\'' +
                    ",type=" + type +
                    "}";
        }
    }

    @Override
    public String toString() {
        return "Latest{" +
                " date '" + date + '\'' +
                ",stories" + stories +
                ",top_stories" + top_stories +
                '}';
    }
}
