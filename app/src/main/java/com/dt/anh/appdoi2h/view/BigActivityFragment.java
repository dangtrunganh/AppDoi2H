package com.dt.anh.appdoi2h.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dt.anh.appdoi2h.ActivityBigRegularDetail;
import com.dt.anh.appdoi2h.R;
import com.dt.anh.appdoi2h.controller.BigActivityAdapter;
import com.dt.anh.appdoi2h.model.ItemBigActivity;

import java.util.ArrayList;


public class BigActivityFragment extends Fragment implements AdapterView.OnItemClickListener {


    public static int DEM_HOI_VUNG_THAN = 0;
    public static int HOI_SINH_VIEN = 1;
    public static int SUOI_AM_VUNG_THAN = 2;
    public static int KHOA_MOI_CHAO_ANH_CHI = 3;
    public static int HANH_TRANG_SI_TU = 4;
    public static int SINH_NHAT_DOI = 5;
    public static int TIEP_SUC_MUA_THI = 6;
    public static int MUA_HE_TN_TINH_NGUYEN = 7;
    public static int TRUNG_THU_CHO_EM  = 8;

    private ArrayList<ItemBigActivity> arrayBigAcitivities;
    private ListView livBigActivity;
    private BigActivityAdapter bigActivityAdapter;
    private View bigAcitivityView;

    public BigActivityFragment() {
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
        bigAcitivityView = inflater.inflate(R.layout.fragment_big_activity, container, false);
        initViews();
        initItemBigActivity();
        return bigAcitivityView;
    }

    private void initItemBigActivity() {
        arrayBigAcitivities = new ArrayList<>();
        arrayBigAcitivities.add(new ItemBigActivity(R.drawable.dem_hoi_vung_than_1, "Chương trình văn nghệ: “Đêm hội vùng than”", ""));
        arrayBigAcitivities.add(new ItemBigActivity(R.drawable.thx1, "Tập huấn kỹ năng tân hội viên Hội sinh viên", ""));
        arrayBigAcitivities.add(new ItemBigActivity(R.drawable.suoi_am_vung_than_1, "Chương trình tình nguyện: “Sưởi Ấm Vùng Than”", ""));
        arrayBigAcitivities.add(new ItemBigActivity(R.drawable.khoa_moi_chao_anh_chi_1, "Đêm giao lưu: “Khóa mới chào anh chị”", ""));
        arrayBigAcitivities.add(new ItemBigActivity(R.drawable.hanh_trang_si_tu_1, "Chương trình tình nguyện: “Hành trang sĩ tử”", ""));
        arrayBigAcitivities.add(new ItemBigActivity(R.drawable.snd1, "Chương trình nội bộ thường niên – Sinh nhật Đội", ""));
        arrayBigAcitivities.add(new ItemBigActivity(R.drawable.tsmt1, "Chương trình tình nguyện: “Tiếp sức mùa thi”", ""));
        arrayBigAcitivities.add(new ItemBigActivity(R.drawable.mua_he_thanh_nien_tinh_nguyen_1, "Chiến dịch “Mùa hè thanh niên tình nguyện”", ""));
        arrayBigAcitivities.add(new ItemBigActivity(R.drawable.ttce1, "Chương trình tình nguyện kết hợp giao lưu văn nghệ: “Trung thu cho em”", ""));

        bigActivityAdapter = new BigActivityAdapter(getActivity().getBaseContext(), arrayBigAcitivities);
        livBigActivity.setAdapter(bigActivityAdapter);
    }

    private void initViews() {
        livBigActivity = (ListView) bigAcitivityView.findViewById(R.id.lv_big_activity);
        livBigActivity.setOnItemClickListener(this);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }





    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getActivity().getBaseContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity().getBaseContext(), ActivityBigRegularDetail.class);
        intent.putExtra("ACTHERE", position);
        startActivity(intent);
    }
}
