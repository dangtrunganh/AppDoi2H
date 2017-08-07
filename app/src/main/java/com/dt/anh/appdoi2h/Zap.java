package com.dt.anh.appdoi2h;

/**
 * Created by ALIENWARE on 10/05/2017.
 */

public class Zap {
    private String name;
    private int thumbnail;

    public Zap() {
    }

    public Zap(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
