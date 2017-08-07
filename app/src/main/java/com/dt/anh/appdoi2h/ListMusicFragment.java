package com.dt.anh.appdoi2h;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dt.anh.appdoi2h.controller.MediaManager;
import com.dt.anh.appdoi2h.controller.SongAdapter;
import com.dt.anh.appdoi2h.model.Song;

import org.greenrobot.eventbus.EventBus;


public class ListMusicFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private static final int LEVEL_PAUSE = 1;
    private static final int LEVEL_PLAY = 0;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final int LEVEL_LOOP_OFF = 0;
    public static final int LEVEL_LOOP_ONE = 1;
    public static final int LEVEL_LOOP_ALL = 2;
    public static int whatLoop = LEVEL_LOOP_OFF;


    private MediaManager mediaMgr;
    private ListView mLvSong;
    private SongAdapter mSongAdapter;


    private ImageView mStop;
    private ImageView mPlay;
    private ImageView mNext;
    private ImageView mBack;
    private ImageView mLoop;


    private TextView tvName;
    private TextView tvArtist;
    private TextView tvIndex;
    private TextView tvTime;

    private View oldView;

    private SeekBar seekBar;

    private CheckBox mCheckBox;

    private View viewListMusicFrg;




    private Song currentSong2;

    public ListMusicFragment() {
    }


    public static ListMusicFragment newInstance() {
        ListMusicFragment fragment = new ListMusicFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewListMusicFrg = inflater.inflate(R.layout.fragment_list_music, container, false);

        initViews();
        return viewListMusicFrg;
    }

    private void initViews() {
        mediaMgr = new MediaManager(getActivity().getApplicationContext());


        currentSong2 = mediaMgr.getListSong().get(0);
        mLvSong = (ListView) viewListMusicFrg.findViewById(R.id.lv_music_song);
        mSongAdapter = new SongAdapter(mediaMgr.getListSong(), getActivity().getBaseContext());
        mLvSong.setAdapter(mSongAdapter);
        mLvSong.setOnItemClickListener(this);



        mStop = (ImageView) viewListMusicFrg.findViewById(R.id.iv_music_stop);
        mPlay = (ImageView) viewListMusicFrg.findViewById(R.id.iv_music_play);
        mBack = (ImageView) viewListMusicFrg.findViewById(R.id.iv_music_previous);
        mNext = (ImageView) viewListMusicFrg.findViewById(R.id.iv_music_next);
        mLoop = (ImageView) viewListMusicFrg.findViewById(R.id.iv_music_loop);
        mCheckBox = (CheckBox) viewListMusicFrg.findViewById(R.id.check_box_music_shuffle);



        tvName = (TextView) viewListMusicFrg.findViewById(R.id.tv_name);
        tvArtist = (TextView) viewListMusicFrg.findViewById(R.id.tv_artist);
        tvIndex = (TextView) viewListMusicFrg.findViewById(R.id.tv_index);
        tvTime = (TextView) viewListMusicFrg.findViewById(R.id.tv_time);

        seekBar = (SeekBar) viewListMusicFrg.findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(this);

        mStop.setOnClickListener(this);
        mPlay.setOnClickListener(this);
        mLoop.setOnClickListener(this);
        mNext.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mCheckBox.setOnClickListener(this);

        updateInfoSong();
        mPlay.setImageLevel(LEVEL_PLAY);
        mLoop.setImageLevel(LEVEL_LOOP_OFF);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mediaMgr.play(position)) {
//            updateColor();
            updateInfoSong();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_music_stop:
                mediaMgr.stop();
                mPlay.setImageLevel(LEVEL_PLAY);
                break;
            case R.id.iv_music_play:
                if(!mediaMgr.play()) {
                    mPlay.setImageLevel(LEVEL_PLAY);
                } else {
//                    updateColor();
                    updateInfoSong();
                }

                break;
            case R.id.iv_music_next:
                if (mediaMgr.next()) {
//                    updateColor();
                    updateInfoSong();
                }

                break;
            case R.id.iv_music_previous:
                if(mediaMgr.back()) {
//                    updateColor();
                    updateInfoSong();
                }
                break;

            case R.id.iv_music_loop:
                if(whatLoop == LEVEL_LOOP_OFF) {
                    mLoop.setImageLevel(LEVEL_LOOP_ONE);
                    whatLoop = LEVEL_LOOP_ONE;
                } else if(whatLoop == LEVEL_LOOP_ONE){
                    mLoop.setImageLevel(LEVEL_LOOP_ALL);
                    whatLoop = LEVEL_LOOP_ALL;
                } else if (whatLoop == LEVEL_LOOP_ALL) {
                    mLoop.setImageLevel(LEVEL_LOOP_OFF);
                    whatLoop = LEVEL_LOOP_OFF;
                }
                break;

            case R.id.check_box_music_shuffle:
                if(mCheckBox.isChecked()) {
                    mediaMgr.setShuffle(true);
                }
                else {
                    mediaMgr.setShuffle(false);
                }
                break;

            default:
                break;
        }
    }
//
//    private void updateColor() {
//        View view = mLvSong.getChildAt(mediaMgr.getmIndex());
//        if(oldView != null) {
//            oldView.setBackgroundColor(Color.parseColor("#00000000"));
//        }
//        if (view != null) {
//            view.setBackgroundColor(Color.parseColor("#FFF9C4"));
//            oldView = view;
//        }
//    }

    private void updateInfoSong() {
        currentSong2 = mediaMgr.getCurrentSong();
        tvName.setText(currentSong2.getName());
        tvArtist.setText(currentSong2.getArtist());
        tvIndex.setText(mediaMgr.getIndexText());
        tvTime.setText("00:00/" + mediaMgr.getDuration(currentSong2.getDuration()));
        mPlay.setImageLevel(LEVEL_PAUSE);
        if(mediaMgr.getCurrentTime() == mediaMgr.getDurationSong()) {
            mPlay.setImageLevel(LEVEL_PLAY);
        }
        seekBar.setMax(currentSong2.getDuration());
        new UpdateSeekBar().execute();
        EventBus.getDefault().postSticky(currentSong2);
    }



    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mediaMgr.seek(seekBar.getProgress());
    }

    private class UpdateSeekBar extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            while (mediaMgr.isStarted()) {
                try {
                    Thread.sleep(1000);
                    publishProgress();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            doLoop(); //doLoop để bắt sự kiện lặp 1 bài và không lặp bài nào, còn lặp tất cả đã có bắt sự kiện hết bài hát ở MediaManager rồi
            tvTime.setText(mediaMgr.getCurrentTimeText());
            seekBar.setProgress(mediaMgr.getCurrentTime());
//            if((mediaMgr.getCurrentTime() == (mediaMgr.getDurationSong()-1000)) && whatLoop == LEVEL_LOOP_OFF) {
//                mPlay.setImageLevel(LEVEL_PLAY);
//            }
        }


    }

    @Override
    public void onDetach() {
        super.onDetach();
        mediaMgr.stop();
        whatLoop = LEVEL_LOOP_OFF;
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaMgr.stop();
        whatLoop = LEVEL_LOOP_OFF;
    }

    public void doLoop() {
        if (whatLoop == LEVEL_LOOP_OFF) {
            mediaMgr.loopOff();
        } else if (whatLoop == LEVEL_LOOP_ONE) {
            mediaMgr.loopOne();
        } else if (whatLoop == LEVEL_LOOP_ALL) {
            mediaMgr.loopAll();
            updateInfoSong();
//            updateColor();
        }
    }
}
