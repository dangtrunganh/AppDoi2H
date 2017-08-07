package com.dt.anh.appdoi2h.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dt.anh.appdoi2h.ImgHome;
import com.dt.anh.appdoi2h.ImgHomeAdapter;
import com.dt.anh.appdoi2h.controller.HomeFeaturedImagesAdapter;
import com.dt.anh.appdoi2h.controller.HomeFeaturedNewsAdapter;
import com.dt.anh.appdoi2h.controller.HomeNewUpdateAdapter;
import com.dt.anh.appdoi2h.model.News;
import com.dt.anh.appdoi2h.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;

import me.relex.circleindicator.CircleIndicator;


public class HomeFragment extends Fragment {

    private static final String TAG = "Home Fragment";
    private ArrayList<ImgHome> homes;
    private cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager vpgFaces;
    private CircleIndicator indicator;

    private ViewPager vpgHomeNewUpdate;
    private ArrayList<News> arrayNewsUpdate;
    private HomeNewUpdateAdapter vpgHomeNewUpdateAdapter;

    private ViewPager vpgHomeFeaturedNews;
    private ArrayList<News> arrayFeaturedNews;
    private HomeFeaturedNewsAdapter vpgHomeFeaturedNewsAdapter;

    private ViewPager vpgHomeFeaturedImages;
    private ArrayList<Integer> arrayFeaturedImages;
    private HomeFeaturedImagesAdapter vpgHomeFeaturedImagesAdapter;

    private DatabaseReference mData;

    public HomeFragment() {
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
        View v =  inflater.inflate(R.layout.fragment_home, container, false);
        mData = FirebaseDatabase.getInstance().getReference();
        vpgHomeNewUpdate = (ViewPager) v.findViewById(R.id.vpg_home_new_update);
        vpgHomeFeaturedNews = (ViewPager) v.findViewById(R.id.vpg_home_featured_news);
        vpgHomeFeaturedImages = (ViewPager) v.findViewById(R.id.vpg_home_featured_images);

        vpgFaces = (cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager) v.findViewById(R.id.vpg_faces);
        indicator = (CircleIndicator) v.findViewById(R.id.indicator);


        loadDataFromFb();
        initImagesFeatured();
        initItemHomes();
        return v;
    }

    private void loadDataFromFb() {
        //load data về 2 arrayList và lược bỏ đi còn lại số phần tử nhất định
        //arrayFeaturedNews
        //arrayNewsUpdate

        arrayNewsUpdate = new ArrayList<>();
        vpgHomeNewUpdateAdapter = new HomeNewUpdateAdapter(arrayNewsUpdate, getActivity().getBaseContext());
        vpgHomeNewUpdate.setAdapter(vpgHomeNewUpdateAdapter);
        arrayFeaturedNews = new ArrayList<>();
        vpgHomeFeaturedNewsAdapter = new HomeFeaturedNewsAdapter(arrayFeaturedNews, getActivity().getBaseContext());
        vpgHomeFeaturedNews.setAdapter(vpgHomeFeaturedNewsAdapter);
        mData.child("News").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                News news = dataSnapshot.getValue(News.class);
//                if(arrayNewsUpdate.size() == 5) {
//                    arrayNewsUpdate.remove(0);
//                }
//                if(arrayFeaturedImages.size() == 5) {
//                    arrayFeaturedNews.remove(0);
//                }
                arrayNewsUpdate.add(new News(news.getTitle(), news.getLink(), news.getLinkImg(), news.getTime()));
                arrayFeaturedNews.add(new News(news.getTitle(), news.getLink(), news.getLinkImg(), news.getTime()));
                vpgHomeNewUpdateAdapter.notifyDataSetChanged();
                vpgHomeFeaturedNewsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                arrayNewsUpdate = new ArrayList<>();
                vpgHomeNewUpdateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void initItemHomes() {
        homes = new ArrayList<>();
        homes.add(new ImgHome(
                R.drawable.ban_doi));
        homes.add(new ImgHome(
                R.drawable.ban_cm));
        homes.add(new ImgHome(
                R.drawable.ban_ct));
        homes.add(new ImgHome(
                R.drawable.ban_dn));
        homes.add(new ImgHome(
                R.drawable.ban_ns));

        ImgHomeAdapter homeAdapter = new ImgHomeAdapter(getActivity().getBaseContext(), homes);
        vpgFaces.setAdapter(homeAdapter);
        indicator.setViewPager(vpgFaces);
        vpgFaces.startAutoScroll();
        vpgFaces.setInterval(2500);
    }

    private void initImagesFeatured() {
        arrayFeaturedImages = new ArrayList<>();
        arrayFeaturedImages.add(R.drawable.vdl1);
        arrayFeaturedImages.add(R.drawable.tsmt1);
        arrayFeaturedImages.add(R.drawable.khoa_moi_chao_anh_chi_2);
        arrayFeaturedImages.add(R.drawable.mua_he_thanh_nien_tinh_nguyen_2);
        arrayFeaturedImages.add(R.drawable.chua_3);
        arrayFeaturedImages.add(R.drawable.snd4);
        arrayFeaturedImages.add(R.drawable.snd6);
        arrayFeaturedImages.add(R.drawable.suoi_am_vung_than_5);
        arrayFeaturedImages.add(R.drawable.dem_hoi_vung_than_8);
        arrayFeaturedImages.add(R.drawable.thx_n);

        vpgHomeFeaturedImagesAdapter = new HomeFeaturedImagesAdapter(arrayFeaturedImages, getActivity().getBaseContext());
        vpgHomeFeaturedImages.setAdapter(vpgHomeFeaturedImagesAdapter);
    }

//    private void initNewsFeatured() {
//        arrayFeaturedNews = new ArrayList<>();
//        arrayFeaturedNews.add(new News("Sinh nhật đội lần thứ 15 - BLUE MOON", R.drawable.sndoi,
//                "http://www.dangtrunganh.com/wordpress/chuong-trinh-lon/sinnh-nhat-doi-lan-thu-15-blue-moon/", ""));
//        arrayFeaturedNews.add(new News("Tổng duyệt Sinh nhật Đội – Bluemoon", R.drawable.tong_duyet,
//                "http://www.dangtrunganh.com/wordpress/sinh-nhat-doi/tong-duyet-sinh-nhat-doi-bluemoon/", ""));
//        arrayFeaturedNews.add(new News("Mùa hè xanh 2017 – Ba Chẽ", R.drawable.mua_he_thanh_nien_tinh_nguyen_1,
//                "http://www.dangtrunganh.com/wordpress/mua-he-xanh/mua-he-xanh-2017-ba-che/", ""));
//        arrayFeaturedNews.add(new News("Sinh nhật Đội lần thứ 15 – “King and Queen – Nơi tài năng hội tụ”", R.drawable.king_queen_2,
//                "http://www.dangtrunganh.com/wordpress/sinh-nhat-doi/sinh-nhat-doi-lan-thu-15-king-and-queen-noi-tai-nang-hoi-tu/", ""));
//        arrayFeaturedNews.add(new News("Phỏng vấn áo xanh lần 3 K58", R.drawable.ao_xanh_lan_3,
//                "https://www.facebook.com/SVTNDHQN/photos/a.484899804862919.115544.247768961909339/1487138444639045/?type=3&theater", ""));
//
//        vpgHomeFeaturedNewsAdapter = new HomeFeaturedNewsAdapter(arrayFeaturedNews, getActivity().getBaseContext());
//        vpgHomeFeaturedNews.setAdapter(vpgHomeFeaturedNewsAdapter);
//    }
//
//    private void initNewsUpdate() {
//        arrayNewsUpdate = new ArrayList<>();
//        arrayNewsUpdate.add(new News("Sinh nhật đội lần thứ 15 - BLUE MOON", R.drawable.sndoi,
//                "http://www.dangtrunganh.com/wordpress/chuong-trinh-lon/sinnh-nhat-doi-lan-thu-15-blue-moon/", ""));
//        arrayNewsUpdate.add(new News("Tổng duyệt Sinh nhật Đội – Bluemoon", R.drawable.tong_duyet,
//                "http://www.dangtrunganh.com/wordpress/sinh-nhat-doi/tong-duyet-sinh-nhat-doi-bluemoon/", ""));
//        arrayNewsUpdate.add(new News("Mùa hè xanh 2017 – Ba Chẽ", R.drawable.mua_he_thanh_nien_tinh_nguyen_1,
//                "http://www.dangtrunganh.com/wordpress/mua-he-xanh/mua-he-xanh-2017-ba-che/", ""));
//        arrayNewsUpdate.add(new News("Sinh nhật Đội lần thứ 15 – “King and Queen – Nơi tài năng hội tụ”", R.drawable.king_queen_2,
//                "http://www.dangtrunganh.com/wordpress/sinh-nhat-doi/sinh-nhat-doi-lan-thu-15-king-and-queen-noi-tai-nang-hoi-tu/", ""));
//        arrayNewsUpdate.add(new News("Phỏng vấn áo xanh lần 3 K58", R.drawable.ao_xanh_lan_3,
//                "https://www.facebook.com/SVTNDHQN/photos/a.484899804862919.115544.247768961909339/1487138444639045/?type=3&theater", ""));
//
//        vpgHomeNewUpdateAdapter = new HomeNewUpdateAdapter(arrayNewsUpdate, getActivity().getBaseContext());
//        vpgHomeNewUpdate.setAdapter(vpgHomeNewUpdateAdapter);
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        vpgFaces.stopAutoScroll();
        vpgFaces.destroyDrawingCache();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        vpgFaces.stopAutoScroll();
        vpgFaces.destroyDrawingCache();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        vpgFaces.stopAutoScroll();
        vpgFaces.destroyDrawingCache();
    }

    @Override
    public void onStop() {
        super.onStop();
//        vpgFaces.stopAutoScroll();
//        vpgFaces.destroyDrawingCache();
    }

    @Override
    public void onPause() {
        super.onPause();
//        vpgFaces.stopAutoScroll();
//        vpgFaces.destroyDrawingCache();
    }
}
