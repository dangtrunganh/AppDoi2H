package com.dt.anh.appdoi2h.view;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dt.anh.appdoi2h.R;
import com.dt.anh.appdoi2h.Zap;
import com.dt.anh.appdoi2h.ZapAdapter;
import com.dt.anh.appdoi2h.ZapYoutubeActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;



public class ZapFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Zap> zaps;


    public ZapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_zap, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager
                = new LinearLayoutManager(getActivity().getBaseContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);


        zaps = new ArrayList<>();
        zaps.add(new Zap("Nhảy zap 4", R.drawable.ic_video_zap4));
        zaps.add(new Zap("Nhảy zap 6 (cao + thấp)", R.drawable.ic_video_zap6));
        zaps.add(new Zap("Nhảy zap 9", R.drawable.ic_video_zap9));
        zaps.add(new Zap("Nhảy zap 16", R.drawable.ic_video_zap16));


        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        //Adapter
//        Log.e("ABC:", "OK đã qua đến đây");
        mAdapter = new ZapAdapter(getActivity().getBaseContext(), zaps);
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }
}

