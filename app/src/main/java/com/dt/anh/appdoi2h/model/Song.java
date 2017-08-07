package com.dt.anh.appdoi2h.model;

/**
 * Created by ALIENWARE on 4/7/2017.
 */

public class Song {
    private String name, artist, link, lyric;
    private int duration;

    public Song(String name, String artist, int duration, String link, String lyric) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.link = link;
        this.lyric = lyric;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nArtist: " + artist +
                "\nDuration: " + duration +
                "\nLink: " + link +
                "\nLyric: " + lyric;
    }
}
