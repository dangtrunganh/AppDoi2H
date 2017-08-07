package com.dt.anh.appdoi2h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ALIENWARE on 4/24/2017.
 */

public class HinhAnhAdapter2 extends BaseAdapter{
    private Context context;
    private int myLayout;
    private ArrayList<HinhAnh> listHinhAnh;

    public HinhAnhAdapter2(Context context, int myLayout, ArrayList<HinhAnh> listHinhAnh) {
        this.context = context;
        this.myLayout = myLayout;
        this.listHinhAnh = listHinhAnh;
    }

    @Override
    public int getCount() {
        return listHinhAnh.size();
    }

    @Override
    public HinhAnh getItem(int position) {
        return listHinhAnh.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder2{
        ImageView imgHinh;
        TextView txtTen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = convertView;
        HinhAnhAdapter2.ViewHolder2 holder = new HinhAnhAdapter2.ViewHolder2();
        if(rowView == null) {
            rowView = inflater.inflate(myLayout, null);
            holder.txtTen = (TextView) rowView.findViewById(R.id.tv_activity_item2);
            holder.imgHinh = (ImageView) rowView.findViewById(R.id.iv_activity_item2);
            rowView.setTag(holder);

        } else {
            holder = (HinhAnhAdapter2.ViewHolder2) rowView.getTag();

        }

        //Gán giá trị
        holder.txtTen.setText(listHinhAnh.get(position).getTenHinh());
        Picasso.with(context).load(listHinhAnh.get(position).getLinkHinh()).into(holder.imgHinh);
        return rowView;
    }
}
