package com.dt.anh.appdoi2h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;


public class RegisterActivityFragment2 extends Fragment {

    private View registerActivityView;

    private ArrayList<HinhAnh> listHinhAnh;
    private HinhAnhAdapter2  hinhAnhAdapter;

    private DatabaseReference mData;
    private ListView lvRegisterActivity;

    private TextView tvTimeWeek;
    private SwipeRefreshLayout swipeRefreshLayout;
    private AlertDialog alertDialog;



    public RegisterActivityFragment2() {
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
        registerActivityView =  inflater.inflate(R.layout.fragment_register_activity_fragment2, container, false);
        mData = FirebaseDatabase.getInstance().getReference();
        initViews();
        loadDataTextAndHinh();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                loadDataTextAndHinh();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        hinhAnhAdapter = new HinhAnhAdapter2(getActivity().getBaseContext(), R.layout.item_activity_week2, listHinhAnh);
        lvRegisterActivity.setAdapter(hinhAnhAdapter);

        return registerActivityView;
    }

    private void loadDataTextAndHinh() {

        listHinhAnh = new ArrayList<>();
        mData.child("Activity").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                swipeRefreshLayout.setRefreshing(true);
                HinhAnh hinhAnh = dataSnapshot.getValue(HinhAnh.class);
                listHinhAnh.add(new HinhAnh(hinhAnh.getTenHinh(), hinhAnh.getLinkHinh()));
                hinhAnhAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void updateTimeWeek() {
        mData.child("Time").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tvTimeWeek.setText("TUẦN TỪ\n" + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void initViews() {
//        toolbarDetail = (Toolbar) registerActivityView.findViewById(R.id.toolbar_detail);
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbarDetail);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Đăng ký tham gia hoạt động");
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        swipeRefreshLayout = (SwipeRefreshLayout) registerActivityView.findViewById(R.id.swipeToRefresh2);


        tvTimeWeek = (TextView) registerActivityView.findViewById(R.id.tv_time_week2);
        lvRegisterActivity = (ListView) registerActivityView.findViewById(R.id.lv_detail_member2);
        lvRegisterActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                final String s = listHinhAnh.get(position).getTenHinh();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putString("DATAA2", s);
                MyDialogFragment2 dialogFragment = new MyDialogFragment2();
                dialogFragment.setArguments(bundle);
                dialogFragment.show(fm, "TAG2");

            }
        });
        updateTimeWeek();
    }




}
