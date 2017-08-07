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
import com.dt.anh.appdoi2h.model.ItemRegularActivity;

import java.util.ArrayList;

/**
 * Created by ALIENWARE on 4/7/2017.
 */

public class RegularActivityAdapter extends BaseAdapter{
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<ItemRegularActivity> arrayRegularActivities;

    public RegularActivityAdapter(Context context, ArrayList<ItemRegularActivity> arrayRegularActivities) {
        this.context = context;
        this.arrayRegularActivities = arrayRegularActivities;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return arrayRegularActivities.size();
    }

    @Override
    public ItemRegularActivity getItem(int position) {
        return arrayRegularActivities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolderRegularActivity holder;
        if(convertView == null) {
            //Nếu converView bằng null thì tạo mới = inflate
            convertView = inflater.inflate(R.layout.item_regular_activity, parent, false /*Phai la false*/);

            //holer như cái giỏ, chỉ thêm vào giỏ ở lần đầu
            holder = new ViewHolderRegularActivity();
            holder.imgPhoto =  (ImageView) convertView.findViewById(R.id.iv_item_regular_activity);  //Lấy id từ convertView
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_item_regular_activity);

            convertView.setTag(holder); //Nhét cái giỏ và convertView
        } else {
            holder = (ViewHolderRegularActivity) convertView.getTag(); //Vì đã lưu rồi nên chỉ việc get ra
        }

        //Buoc 2: Đổ dữ liệu tương ứng từ mảng
        ItemRegularActivity itemRegularActivity = arrayRegularActivities.get(position);

        holder.imgPhoto.setImageResource(itemRegularActivity.getImage());
        holder.tvName.setText(itemRegularActivity.getName());


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

    private class ViewHolderRegularActivity {
        private ImageView imgPhoto; //Vì trong nội class nên vẫn truy cập được các thuộc tính bình thường.
        private TextView tvName;
    }
}
