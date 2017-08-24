package com.tanner.study.model;

/**
 * Created by Tanner on 2017/7/24.
 * 文章
 */

public class Catalog {
    String title;
    String url;
    Class<?> activity;

    public Catalog(String title, String url, Class<?> activity) {
        this.title = title;
        this.url = url;
        this.activity = activity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Class<?> getActivity() {
        return activity;
    }

    public void setActivity(Class<?> activity) {
        this.activity = activity;
    }
}
