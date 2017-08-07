package com.dt.anh.appdoi2h.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dt.anh.appdoi2h.R;
import com.dt.anh.appdoi2h.model.ItemLeader;

import java.util.ArrayList;

/**
 * Created by ALIENWARE on 4/7/2017.
 */

public class LeaderAdapter extends BaseAdapter{
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<ItemLeader> arrayLeaders;


    public LeaderAdapter(Context context, ArrayList<ItemLeader> arrayLeaders) {
        this.context = context;
        this.arrayLeaders = arrayLeaders;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayLeaders.size();
    }

    @Override
    public ItemLeader getItem(int position) {
        return arrayLeaders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            //Nếu converView bằng null thì tạo mới = inflate
            convertView = inflater.inflate(R.layout.item_leader, parent, false /*Phai la false*/);

            //holer như cái giỏ, chỉ thêm vào giỏ ở lần đầu
            holder = new ViewHolder();
            holder.imgPhoto =  (ImageView) convertView.findViewById(R.id.iv_item_leader);  //Lấy id từ convertView
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_item_leader_name);
            holder.tvPosition = (TextView) convertView.findViewById(R.id.tv_item_leader_position);

            convertView.setTag(holder); //Nhét cái giỏ và convertView
        } else {
            holder = (ViewHolder) convertView.getTag(); //Vì đã lưu rồi nên chỉ việc get ra
        }

        //Buoc 2: Đổ dữ liệu tương ứng từ mảng
        ItemLeader itemLeader = arrayLeaders.get(position);

        holder.imgPhoto.setImageResource(itemLeader.getImage());
        holder.tvName.setText(itemLeader.getName());
        holder.tvPosition.setText(itemLeader.getPosition());


        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            //Ưu tiên chạy sự kiện click vào photo trước
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Photo Click:" + position, Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;//Tra ve View con
    }

    private class ViewHolder {
        private ImageView imgPhoto; //Vì trong nội class nên vẫn truy cập được các thuộc tính bình thường.
        private TextView tvName;
        private TextView tvPosition;
    }
}
