package com.dt.anh.appdoi2h.model;

import java.util.ArrayList;

/**
 * Created by ALIENWARE on 5/5/2017.
 */

public class ActivityBigRegular {
    private String titleAct;
    private String contentFirstAct;
    private int imgAct;
    private String secondFirstAct;
    private ArrayList<Integer> arrayFeaturedImages;

    public ActivityBigRegular(String titleAct, String contentFirstAct, int imgAct, String secondFirstAct, ArrayList<Integer> arrayFeaturedImages) {
        this.titleAct = titleAct;
        this.contentFirstAct = contentFirstAct;
        this.imgAct = imgAct;
        this.secondFirstAct = secondFirstAct;
        this.arrayFeaturedImages = arrayFeaturedImages;
    }

    public String getTitleAct() {
        return titleAct;
    }

    public void setTitleAct(String titleAct) {
        this.titleAct = titleAct;
    }

    public String getContentFirstAct() {
        return contentFirstAct;
    }

    public void setContentFirstAct(String contentFirstAct) {
        this.contentFirstAct = contentFirstAct;
    }

    public int getImgAct() {
        return imgAct;
    }

    public void setImgAct(int imgAct) {
        this.imgAct = imgAct;
    }

    public String getSecondFirstAct() {
        return secondFirstAct;
    }

    public void setSecondFirstAct(String secondFirstAct) {
        this.secondFirstAct = secondFirstAct;
    }

    public ArrayList<Integer> getArrayFeaturedImages() {
        return arrayFeaturedImages;
    }

    public void setArrayFeaturedImages(ArrayList<Integer> arrayFeaturedImages) {
        this.arrayFeaturedImages = arrayFeaturedImages;
    }
}
