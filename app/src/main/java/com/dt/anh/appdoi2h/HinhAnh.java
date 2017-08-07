package com.dt.anh.appdoi2h;

/**
 * Created by ALIENWARE on 4/16/2017.
 */

public class HinhAnh {
    private String tenHinh;
    private String linkHinh;

    public HinhAnh(String tenHinh, String linkHinh) {
        this.tenHinh = tenHinh;
        this.linkHinh = linkHinh;
    }
    public HinhAnh() {

    }

    public String getTenHinh() {
        return tenHinh;
    }

    public void setTenHinh(String tenHinh) {
        this.tenHinh = tenHinh;
    }

    public String getLinkHinh() {
        return linkHinh;
    }

    public void setLinkHinh(String linkHinh) {
        this.linkHinh = linkHinh;
    }
}
