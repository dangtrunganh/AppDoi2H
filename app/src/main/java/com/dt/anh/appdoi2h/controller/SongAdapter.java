package com.dt.anh.appdoi2h.controller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dt.anh.appdoi2h.R;
import com.dt.anh.appdoi2h.model.Song;

import java.util.List;

/**
 * Created by ALIENWARE on 4/7/2017.
 */

public class SongAdapter extends BaseAdapter {
    private List<Song> mListSong;
    private Context mContext;

    public SongAdapter(List<Song> mListSong, Context mContext) {
        this.mListSong = mListSong;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mListSong.size();
    }

    @Override
    public Song getItem(int position) {
        return mListSong.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolderMusic holderMusic;

        if(view == null) {
            view = View.inflate(mContext, R.layout.item_song_view, null);
            holderMusic = new ViewHolderMusic();
            holderMusic.tvName = (TextView) view.findViewById(R.id.tv_song_name);
            holderMusic.tvArtist = (TextView)view.findViewById(R.id.tv_song_artist);
            view.setTag(holderMusic);
        } else {
            holderMusic = (ViewHolderMusic) view.getTag();
        }

        Song song = mListSong.get(position);
        holderMusic.tvName.setText(song.getName());
        holderMusic.tvArtist.setText(song.getArtist());
        return view;
    }

    private class ViewHolderMusic {
        private TextView tvName;
        private TextView tvArtist;
    }
}
