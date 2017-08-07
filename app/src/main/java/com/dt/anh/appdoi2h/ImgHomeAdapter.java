package com.dt.anh.appdoi2h;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ALIENWARE on 5/1/2017.
 */

public class ImgHomeAdapter extends PagerAdapter{
    private ArrayList<ImgHome> homes;
    private LayoutInflater inflater;
    private Context context;

    public ImgHomeAdapter(Context context, ArrayList<ImgHome> faces) {
        this.homes = faces;
        this.context = context;
        inflater = LayoutInflater.from(context);
//        Cách 2 để gán giá trị inflater trực tiếp:
//        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        final ImgHome itemHomes = homes.get(position);
        imgHome.setImageResource(itemHomes.getImageId());


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
