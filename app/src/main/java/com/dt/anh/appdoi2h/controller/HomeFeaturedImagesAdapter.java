package com.dt.anh.appdoi2h.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dt.anh.appdoi2h.NewsActivity;
import com.dt.anh.appdoi2h.R;

import java.util.ArrayList;

/**
 * Created by ALIENWARE on 4/7/2017.
 */

public class HomeFeaturedImagesAdapter extends PagerAdapter{
    private ArrayList<Integer> arrayImages;
    private LayoutInflater inflater;
    private Context context;

    public HomeFeaturedImagesAdapter(ArrayList<Integer> arrayImages, Context context) {
        this.arrayImages = arrayImages;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object.equals(view);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View itemView = inflater.inflate(
                R.layout.item_pager_featured_images, container, false);
        ImageView imgNewsUpdate = (ImageView) itemView.findViewById(R.id.iv_item_home_featured_images);

        final Integer intImage = arrayImages.get(position);
        imgNewsUpdate.setImageResource(intImage);

        container.addView(itemView);

//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(context, ": position + Images= " + position, Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context, NewsActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
//            }
//        });
        return itemView;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.44f;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if(object instanceof View) {
            return;
        }
        container.removeView((View) object);
    }
}
