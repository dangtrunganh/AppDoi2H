package com.dt.anh.appdoi2h;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ALIENWARE on 4/24/2017.
 */

public class MyDialogFragment2 extends android.support.v4.app.DialogFragment implements View.OnClickListener{
    private TextView tvNameActivity;
        private EditText edtName2, edtGrade2;
    private Button btnParticipation;
    private String title, fullName;


    private DatabaseReference mData;
    public MyDialogFragment2() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_activity_week2, container, false);
        getDialog().setTitle("Đăng ký tham gia");

        edtName2 = (EditText) rootView.findViewById(R.id.edt_name_register_activity_week2);
        edtGrade2 = (EditText) rootView.findViewById(R.id.edt_grade_register_activity_week2);
        tvNameActivity = (TextView) rootView.findViewById(R.id.tv_register_title2);
        btnParticipation = (Button) rootView.findViewById(R.id.btn_participation2);

        Bundle bundle = getArguments();
        title = bundle.getString("DATAA2");
        tvNameActivity.setText(title);
        mData = FirebaseDatabase.getInstance().getReference();
        btnParticipation.setOnClickListener(this);
        return rootView;
    }


    @Override
    public void onClick(View v) {
        if(edtName2.getText().toString().equals("") || edtGrade2.getText().toString().equals("") || edtName2 == null || edtGrade2 == null) {
            Toast.makeText(getActivity().getBaseContext(), "Lỗi, không được bỏ trống!", Toast.LENGTH_SHORT).show();
            return;
        }
        fullName = edtName2.getText().toString() + " - K" + edtGrade2.getText().toString();
        mData.child("Detail").push().setValue(title + ": " + fullName, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if(databaseError == null) {
                    Toast.makeText(getActivity().getBaseContext(), "Đăng ký tham gia hoạt động thành công!", Toast.LENGTH_SHORT).show();
                    dismiss();
                } else {
                    Toast.makeText(getActivity().getBaseContext(), "Đăng ký thất bại!", Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            }
        });
    }
}
