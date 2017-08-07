package com.dt.anh.appdoi2h;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dt.anh.appdoi2h.model.Song;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class LyricMusicFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private TextView tvSongName;
    private TextView tvSongArtist;
    private TextView tvSongLyric;

    private View lyricView;

    public LyricMusicFragment() {
    }

    public void setContent123(String tvSongName12, String tvSongArtist12, String tvSongLyric12) {

    }


    public static LyricMusicFragment newInstance() {
        return new LyricMusicFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        lyricView = inflater.inflate(R.layout.fragment_lyric_music, container, false);

        tvSongName = (TextView) lyricView.findViewById(R.id.textview_name_song);
        tvSongArtist = (TextView) lyricView.findViewById(R.id.textview_artist_song);
        tvSongLyric = (TextView) lyricView.findViewById(R.id.textview_lyric_song);

        return lyricView;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);

        Song songEventReceive = EventBus.getDefault().getStickyEvent(Song.class);
        if(songEventReceive != null) {
            EventBus.getDefault().removeStickyEvent(songEventReceive);
        }
        super.onStop();
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(Song songEvent) {
        tvSongName.setText(songEvent.getName());
        tvSongArtist.setText("Sáng tác: " + songEvent.getArtist());
        tvSongLyric.setText(songEvent.getLyric());
    }
}
