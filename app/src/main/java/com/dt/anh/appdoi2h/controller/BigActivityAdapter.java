package com.dt.anh.appdoi2h.controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dt.anh.appdoi2h.NewsActivity;
import com.dt.anh.appdoi2h.R;
import com.dt.anh.appdoi2h.model.ItemBigActivity;

import java.util.ArrayList;

/**
 * Created by ALIENWARE on 4/7/2017.
 */

public class BigActivityAdapter extends BaseAdapter{

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<ItemBigActivity> arrayBigActivities;

    public BigActivityAdapter(Context context, ArrayList<ItemBigActivity> arrayBigActivities) {
        this.context = context;
        this.arrayBigActivities = arrayBigActivities;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return arrayBigActivities.size();
    }

    @Override
    public ItemBigActivity getItem(int position) {
        return arrayBigActivities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolderBigActivity holder;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.item_big_activity, parent, false);

            //holer như cái giỏ, chỉ thêm vào giỏ ở lần đầu
            holder = new ViewHolderBigActivity();
            holder.imgPhoto =  (ImageView) convertView.findViewById(R.id.iv_item_big_activity);  //Lấy id từ convertView
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_item_big_activity);

            convertView.setTag(holder); //Nhét cái giỏ và convertView
        } else {
            holder = (ViewHolderBigActivity) convertView.getTag(); //Vì đã lưu rồi nên chỉ việc get ra
        }

        //Buoc 2: Đổ dữ liệu tương ứng từ mảng
        ItemBigActivity itemBigActivity = arrayBigActivities.get(position);

        holder.imgPhoto.setImageResource(itemBigActivity.getImage());
        holder.tvName.setText(itemBigActivity.getName());


//        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
//            //Ưu tiên chạy sự kiện click vào photo trước
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(context, "Photo Click:" + position, Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context, NewsActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
//            }
//        });

        return convertView;//Tra ve View con
    }

    private class ViewHolderBigActivity {
        private ImageView imgPhoto; //Vì trong nội class nên vẫn truy cập được các thuộc tính bình thường.
        private TextView tvName;
    }
}
