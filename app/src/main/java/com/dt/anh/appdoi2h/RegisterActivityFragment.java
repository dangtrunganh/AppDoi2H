package com.dt.anh.appdoi2h;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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



public class RegisterActivityFragment extends Fragment {
    private View registerActivityView;
//    private Toolbar toolbarDetail;

    private TextView tvTitle;


    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference storageRef;

    private ArrayList<HinhAnh> listHinhAnh;
    private HinhAnhAdapter  hinhAnhAdapter;

    private DatabaseReference mData;
    private ListView lvRegisterActivity;

    private TextView tvTimeWeek;
    private SwipeRefreshLayout swipeRefreshLayout;

    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private String fullName;

    public RegisterActivityFragment() {
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
        registerActivityView =  inflater.inflate(R.layout.fragment_register_activity, container, false);
        mAuth = FirebaseAuth.getInstance();
        mData = FirebaseDatabase.getInstance().getReference();
        storageRef = storage.getReferenceFromUrl("gs://connectfb-8d0a5.appspot.com");
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
        hinhAnhAdapter = new HinhAnhAdapter(getActivity().getBaseContext(), R.layout.item_activity_week, listHinhAnh);
        lvRegisterActivity.setAdapter(hinhAnhAdapter);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser != null) {
            fullName = firebaseUser.getDisplayName();
        }

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
                swipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
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
        swipeRefreshLayout = (SwipeRefreshLayout) registerActivityView.findViewById(R.id.swipeToRefresh);


        tvTimeWeek = (TextView) registerActivityView.findViewById(R.id.tv_time_week);
        lvRegisterActivity = (ListView) registerActivityView.findViewById(R.id.lv_detail_member);
        lvRegisterActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String s = listHinhAnh.get(position).getTenHinh();
                FragmentManager fm = getActivity().getSupportFragmentManager();

                Bundle bundle = new Bundle();
                bundle.putString("DATAA", s);
                bundle.putString("FULLNAME", fullName);
                bundle.putString("HISTORY", firebaseUser.getUid());
                MyDialogFragment dialogFragment = new MyDialogFragment();
                dialogFragment.setArguments(bundle);
                dialogFragment.show(fm, "TAG");

            }
        });
        updateTimeWeek();
    }
}
