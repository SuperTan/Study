package com.tanner.study.model;

/**
 * Created by Tanner on 2017/7/24.
 * 文章
 */

public class Catalog {
    String title;
    String url;

    public Catalog(String title, String url) {
        this.title = title;
        this.url = url;
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
}
