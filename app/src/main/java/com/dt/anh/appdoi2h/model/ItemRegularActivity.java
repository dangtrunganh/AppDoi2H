package com.dt.anh.appdoi2h.model;

/**
 * Created by ALIENWARE on 4/7/2017.
 */

public class ItemRegularActivity {
    private int image;
    private String name;
    private String content;

    public ItemRegularActivity(int image, String name, String content) {
        this.image = image;
        this.name = name;
        this.content = content;
    }

    public ItemRegularActivity() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
