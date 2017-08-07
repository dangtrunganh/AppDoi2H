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
import com.dt.anh.appdoi2h.model.ItemRegularActivity;
import com.dt.anh.appdoi2h.controller.RegularActivityAdapter;

import java.util.ArrayList;

public class RegularActivityFragment extends Fragment implements AdapterView.OnItemClickListener {


    private ArrayList<ItemRegularActivity> arrayRegularAcitivities;
    private ListView livRegularActivity;
    private RegularActivityAdapter regularActivityAdapter;
    private View regularAcitivityView;

    public RegularActivityFragment() {
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
        regularAcitivityView = inflater.inflate(R.layout.fragment_regular_activity, container, false);
        initViews();
        initItemRegularActivity();
        return regularAcitivityView;
    }

    private void initItemRegularActivity() {
        arrayRegularAcitivities = new ArrayList<>();
        arrayRegularAcitivities.add(new ItemRegularActivity(R.drawable.lang_tre_hoa_binh_1, "Đi làng trẻ Hòa Bình – Thanh Xuân", ""));
        arrayRegularAcitivities.add(new ItemRegularActivity(R.drawable.vien_duong_lao_1, "Đi viện dưỡng lão Bách niên Thiên Đức", ""));
        arrayRegularAcitivities.add(new ItemRegularActivity(R.drawable.chua_1, "Đi hỗ trợ chùa Pháp Vân", ""));
        arrayRegularAcitivities.add(new ItemRegularActivity(R.drawable.phat_chao_1, "Đi phát cháo cùng chùa Pháp Vân tại Bệnh viện K", ""));

        regularActivityAdapter = new RegularActivityAdapter(getActivity().getBaseContext(), arrayRegularAcitivities);
        livRegularActivity.setAdapter(regularActivityAdapter);
    }

    private void initViews() {
        livRegularActivity = (ListView) regularAcitivityView.findViewById(R.id.lv_regular_activity);
        livRegularActivity.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity().getBaseContext(), ActivityBigRegularDetail.class);
        intent.putExtra("ACTHERE", position + 9);
        startActivity(intent);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
