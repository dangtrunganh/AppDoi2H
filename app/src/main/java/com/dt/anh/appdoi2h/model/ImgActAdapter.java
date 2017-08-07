package com.dt.anh.appdoi2h.model;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.dt.anh.appdoi2h.ImgHome;
import com.dt.anh.appdoi2h.R;

import java.util.ArrayList;

/**
 * Created by ALIENWARE on 5/5/2017.
 */

public class ImgActAdapter extends PagerAdapter{
    private ArrayList<Integer> homes;
    private LayoutInflater inflater;
    private Context context;

    public ImgActAdapter(Context context, ArrayList<Integer> homes) {
//        if(homes.size() == 0) {
//            Toast.makeText(context, "NULL", Toast.LENGTH_SHORT).show();
//        }
        this.homes = homes;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return homes.size();
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        //Khoi tao view con
        //Tạo view, đính vào ViewPager, sau đó đổ dữ liệu lên. (ViewPager là 1 ViewGroup)


        //Bước 1: Tạo View Item
        View itemView = inflater.inflate(
                R.layout.item_image_home, container, false); //Nếu là false thì chỉ tạo ra chứ không đính vào luôn, còn nếu là true thì tạo ra đính vào luôn.

        ImageView imgHome = (ImageView) itemView.findViewById(R.id.img_item_home);

        //Bước 2: Đổ dữ liệu
        final int itemHomes = homes.get(position);
//        Toast.makeText(context, "ID: " + itemHomes, Toast.LENGTH_SHORT).show();
        imgHome.setImageResource(itemHomes);


        //Thêm itemView vào viewPager
        container.addView(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, ": position= " + position, Toast.LENGTH_SHORT).show();
            }
        });
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //Xoa view con khoi man hinh chinh
        if(object instanceof View) {
            return;
        }
        container.removeView((View) object); //Vì là object nên phải ép kiểu mới xóa được
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        //Kiểm tra, vì chỉ là view mới dùng đc.
        return object.equals(view); //Neu object la view thi return true, nguoc lai return false. Chỉ trả về true thì mới được dùng.
    }
}
