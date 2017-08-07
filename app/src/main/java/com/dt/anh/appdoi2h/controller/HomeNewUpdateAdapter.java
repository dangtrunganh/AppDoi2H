package com.dt.anh.appdoi2h.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dt.anh.appdoi2h.NewsActivity;
import com.dt.anh.appdoi2h.model.News;
import com.dt.anh.appdoi2h.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ALIENWARE on 4/6/2017.
 */

public class HomeNewUpdateAdapter extends PagerAdapter {
    private ArrayList<News> arrayNews;
    private LayoutInflater inflater;
    private Context context;


    public HomeNewUpdateAdapter(ArrayList<News> arrayNews, Context context) {
        this.arrayNews = arrayNews;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayNews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object.equals(view);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        //Bước 1: Tạo View Item
        View itemView = inflater.inflate(
                R.layout.item_pager_new_update, container, false); //Nếu là false thì chỉ tạo ra chứ không đính vào luôn, còn nếu là true thì tạo ra đính vào luôn.

//        RelativeLayout rltContainer = (RelativeLayout) itemView.findViewById(R.id.container_item_home_news_update);
        ImageView imgNewsUpdate = (ImageView) itemView.findViewById(R.id.iv_item_home_news_update);
        TextView tvNewsUpdate = (TextView) itemView.findViewById(R.id.tv_item_home_new_update_title);
        TextView tvTime = (TextView) itemView.findViewById(R.id.tv_item_home_new_update_date);
        //Bước 2: Đổ dữ liệu
        final News news = arrayNews.get(position);
        Picasso.with(context).load(news.getLinkImg()).into(imgNewsUpdate);
        tvNewsUpdate.setText(news.getTitle());
        tvTime.setText(news.getTime());


        //Thêm itemView vào viewPager
        container.addView(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, ": position + New Update= " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, NewsActivity.class);
                String link = arrayNews.get(position).getLink();
                intent.putExtra("LINKNEWS", link);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
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
