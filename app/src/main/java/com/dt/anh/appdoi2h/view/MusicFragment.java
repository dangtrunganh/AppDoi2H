package com.dt.anh.appdoi2h.view;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dt.anh.appdoi2h.ListMusicFragment;
import com.dt.anh.appdoi2h.LyricMusicFragment;
import com.dt.anh.appdoi2h.R;
import com.dt.anh.appdoi2h.controller.MediaManager;
import com.dt.anh.appdoi2h.model.Song;
import com.dt.anh.appdoi2h.controller.SongAdapter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;


public class MusicFragment extends Fragment{
    public static final String TAG = MusicFragment.class.getName();
    private View musicFragmentView;
    private android.support.v4.view.ViewPager vpgMusics;
    private CircleIndicator indicator;
    private MyPagerAdapter adapterViewPager;
    //====================================
    public MusicFragment() {
    }

    public static MusicFragment newInstance(Context context) {

        MusicFragment fragment = new MusicFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        musicFragmentView = inflater.inflate(R.layout.fragment_music, container, false);
        initViews();
        return musicFragmentView;
    }

    private void initViews() {
        vpgMusics = (android.support.v4.view.ViewPager) musicFragmentView.findViewById(R.id.vpg_music);
        indicator = (CircleIndicator) musicFragmentView.findViewById(R.id.indicator);
        adapterViewPager = new MyPagerAdapter(getChildFragmentManager());
        adapterViewPager.add(new ListMusicFragment());
        adapterViewPager.add(new LyricMusicFragment());

        vpgMusics.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                adapterViewPager.notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vpgMusics.setAdapter(adapterViewPager);
        vpgMusics.setOffscreenPageLimit(2);
        indicator.setViewPager(vpgMusics);
    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 2;
        private ArrayList<Fragment> _fragments;


        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this._fragments = new ArrayList<>();
        }


        public void add(Fragment fragment) {
            this._fragments.add(fragment);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {

            return this._fragments.get(position);
//            switch (position) {
//                case 0:
//                    return ListMusicFragment.newInstance();
//                case 1:
//                    return LyricMusicFragment.newInstance();
//                default:
//                    return null;
//            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            //Restore the fragment's state here

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
