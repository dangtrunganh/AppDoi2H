package com.dt.anh.appdoi2h;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by ALIENWARE on 10/05/2017.
 */

public class ZapAdapter extends RecyclerView.Adapter<ZapAdapter.MyViewHolder>{
    public static final String VIDEO_ID_ZAP_4 = "agFdGcmz6EQ";
    public static final String VIDEO_ID_ZAP_6_LOW_HIGHT = "ZLyiLI6nhRs";
    public static final String VIDEO_ID_ZAP_9 = "9aqa18FZkCM";
    public static final String VIDEO_ID_ZAP_16 = "pI-DcxHacpE";

    private Context mContext;
    private ArrayList<Zap> arrayZaps;

    public ZapAdapter(Context mContext, ArrayList<Zap> arrayZaps) {
        //Khởi tạo
        this.mContext = mContext;
        this.arrayZaps = arrayZaps;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //Lớp để tham chiếu cho các View
        public TextView name;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.title_zap);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentZap = new Intent(mContext, ZapYoutubeActivity.class);
                    intentZap.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    switch (getAdapterPosition()) {
                        case 0:
                            intentZap.putExtra("LINKID", VIDEO_ID_ZAP_4);
                            mContext.startActivity(intentZap);
                            break;
                        case 1:
                            intentZap.putExtra("LINKID", VIDEO_ID_ZAP_6_LOW_HIGHT);
                            mContext.startActivity(intentZap);
                            break;
                        case 2:
                            intentZap.putExtra("LINKID", VIDEO_ID_ZAP_9);
                            mContext.startActivity(intentZap);
                            break;
                        case 3:
                            intentZap.putExtra("LINKID", VIDEO_ID_ZAP_16);
                            mContext.startActivity(intentZap);
                            break;
                        default:
                            break;
                    }
                }
            });

            thumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentZap = new Intent(mContext, ZapYoutubeActivity.class);
                    intentZap.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    switch (getAdapterPosition()) {
                        case 0:
                            intentZap.putExtra("LINKID", VIDEO_ID_ZAP_4);
                            mContext.startActivity(intentZap);
                            break;
                        case 1:
                            intentZap.putExtra("LINKID", VIDEO_ID_ZAP_6_LOW_HIGHT);
                            mContext.startActivity(intentZap);
                            break;
                        case 2:
                            intentZap.putExtra("LINKID", VIDEO_ID_ZAP_9);
                            mContext.startActivity(intentZap);
                            break;
                        case 3:
                            intentZap.putExtra("LINKID", VIDEO_ID_ZAP_16);
                            mContext.startActivity(intentZap);
                            break;
                        default:
                            break;
                    }
                }
            });
        }


    }


    @Override
    public ZapAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Tạo view holder, nhét itemView to vào cho thằng class MyViewHolder
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_video_zap, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //Gắn dữ liệu lên viewHolder
        Zap zap = arrayZaps.get(position);
        holder.name.setText(zap.getName());
        Glide.with(mContext).load(zap.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return arrayZaps.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
