package com.dt.anh.appdoi2h;

/**
 * Created by ALIENWARE on 4/22/2017.
 */

public class Confession {
    private String fullName;
    private String email;
    private String grade;
    private String address;
    private String username;
    private String content;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Confession(String fullName, String email, String grade, String address, String username, String content) {
        this.fullName = fullName;
        this.email = email;
        this.grade = grade;
        this.address = address;
        this.username = username;
        this.content = content;
    }

    public Confession() {

    }
}
