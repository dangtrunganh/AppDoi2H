package com.dt.anh.appdoi2h.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.dt.anh.appdoi2h.R;
import com.dt.anh.appdoi2h.model.ItemLeader;
import com.dt.anh.appdoi2h.controller.LeaderAdapter;

import java.util.ArrayList;


public class LeaderFragment extends Fragment implements AdapterView.OnItemClickListener {
    private static final int K42 = 0;
    private static final int K43 = 1;
    private static final int K44 = 2;
    private static final int K45 = 3;
    private static final int K46 = 4;
    private static final int K47 = 5;
    private static final int K48 = 6;
    private static final int K49 = 7;
    private static final int K50 = 8;
    private static final int K51 = 9;
    private static final int K52 = 10;
    private static final int K53 = 11;
    private static final int K54 = 12;
    private static final int K55 = 13;
    private static final int K56 = 14;
    private static final int K57 = 15;

    private static final int IMAGE = R.drawable.ic_default_avatar;

    private static final String DOI_TRUONG = "Đội trưởng";
    private static final String DOI_PHO = "Đội phó";
    private static final String UY_VIEN = "Ủy viên";

    private static final String TAG = LeaderFragment.class.toString();

    private static final String NO_INFORMATION = "";


    private ArrayList<ItemLeader> arrayLeaders;
    private ListView livLeader;
    private LeaderAdapter leaderAdapter;


    private Spinner spGrade;
    private View leaderView;



    public LeaderFragment() {
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
        leaderView = inflater.inflate(R.layout.fragment_leader, container, false);
        initViews();
        initIteamLeader();
        return leaderView;
    }

    private void initIteamLeader() {
        arrayLeaders = new ArrayList<>();
        arrayLeaders.add(new ItemLeader(IMAGE, "Nịnh Văn Vùng", DOI_TRUONG));
        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));

        setDataForListViewLeader(arrayLeaders);
    }

    private void setDataForListViewLeader(ArrayList<ItemLeader> arrayLeaders) {
        leaderAdapter = new LeaderAdapter(getActivity().getBaseContext(), arrayLeaders);
        livLeader.setAdapter(leaderAdapter);
    }

    private void initViews() {
        spGrade = (Spinner) leaderView.findViewById(R.id.sp_abc);
        livLeader = (ListView) leaderView.findViewById(R.id.lv_grade);
        livLeader.setOnItemClickListener(this);
        String[] leaders = new String[] {
                "K42", "K43", "K44", "K45", "K46", "K47", "K48", "K49", "K50", "K51", "K52", "K53", "K54", "K55", "K56", "K57"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity().getBaseContext(),
                android.R.layout.simple_spinner_dropdown_item,
                leaders);
        spGrade.setAdapter(adapter);
//        spGrade.post(new Runnable() {
//            @Override
//            public void run() {
//                spGrade.setSelection(2);
//            }
//        });
        addListeners();

    }

    private void addListeners() {
        spGrade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case K42:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nịnh Văn Vùng", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K43:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Trung Quân", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K44:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Trung Quân", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K45:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Phạm Thanh Chiến", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K46:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Thị Việt Hòa", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Vũ Đức Đắc", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K47:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Trần Thái Hoan", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Lâm Thị Liên Hương", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K48:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Vũ Hồng Anh", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K49:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Linh Thùy Dương", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K50:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Trần Tiến", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Ngọc Cương", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Đỗ Thị Huyền Trang", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Phạm Đức Quý", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Phạm Hồng Nhung", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Phạm Trọng Cầu", UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K51:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Phạm Thị Hồng Ngọc", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Ngô Ngọc Tân", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Phạm Hải Ninh", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, NO_INFORMATION, UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K52:
                        arrayLeaders.clear();
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Hữu Thắng", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Lê Thị Tuyết Nhung", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Lê Phương Thảo", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Ngọc Chiến", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Phạm Hoàng Tùng", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Phạm Huyền My", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Minh Nguyệt", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Mạnh Toàn", UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K53:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Thị Diễm", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Bùi Trung Kiên", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Ngô Thùy Dương", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Hoàng Thu Trang", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Đào Thị Ngân Hà", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Trần Ngọc Diệp", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Phạm Thị Thanh Huyền", UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K54:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Trần Đức Minh", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Phạm Khánh Huyền", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Hoàng Dương", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Lê Đức Chính", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Hà My", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Hồng Nhung", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Lê Đức Anh", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Vũ Hương Giang", UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K55:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Uông Thanh Tùng", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Văn Mạnh", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Phạm Anh Sơn", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Ngô Quang Nghĩa", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Vũ Thị Thùy Linh", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Hoàng Tùng Sơn", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Quỳnh Trang", UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K56:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Bùi Thùy Dương", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Đức Cảnh", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Chu Thị Minh Trang", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Cao Việt Dũng", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Lý Mạnh Trường", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Nguyễn Thị Thùy Trang", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Mạc Tùng Nam", UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    case K57:
                        arrayLeaders.clear();
                        arrayLeaders.add(new ItemLeader(IMAGE, "Vũ Đức Hoàn", DOI_TRUONG));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Trần Văn Hội", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Đỗ Xuân Hiếu", DOI_PHO));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Lê Trung Dũng", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Hoàng Văn Hùng", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Lê Đình Tùng", UY_VIEN));
                        arrayLeaders.add(new ItemLeader(IMAGE, "Đào Thanh Huyền", UY_VIEN));
                        setDataForListViewLeader(arrayLeaders);
                        break;
                    default:
                        break;

                }
//                Log.i(TAG, String.format("%s %d", "spFruit.onItemSelected", position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//                Log.i(TAG, "onNothingSelected");
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getActivity().getBaseContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
    }
}
