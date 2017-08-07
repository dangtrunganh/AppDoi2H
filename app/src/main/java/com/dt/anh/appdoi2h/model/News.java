package com.dt.anh.appdoi2h.model;

/**
 * Created by ALIENWARE on 4/6/2017.
 */

public class News {
    private String title;
    private String link;
    private String linkImg;
    private String time;

    public News() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public News(String title, String link, String linkImg, String time) {
        this.title = title;
        this.link = link;
        this.linkImg = linkImg;
        this.time = time;
    }

    public News(String title, int image) {
        this.title = title;
    }
}
