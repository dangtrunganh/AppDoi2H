package com.dt.anh.appdoi2h.model;

/**
 * Created by ALIENWARE on 4/7/2017.
 */

public class ItemLeader {
    private int image;
    private String name;
    private String position;

    public ItemLeader(int image, String name, String position) {
        this.image = image;
        this.name = name;
        this.position = position;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
