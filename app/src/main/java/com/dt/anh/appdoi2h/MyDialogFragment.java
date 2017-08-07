package com.dt.anh.appdoi2h;

import android.app.DialogFragment;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by ALIENWARE on 4/16/2017.
 */

public class MyDialogFragment extends android.support.v4.app.DialogFragment implements View.OnClickListener {
    private TextView tvNameActivity;
//    private EditText edtName, edtGrade;
    private Button btnParticipation;
    private String title, fullName;
    private FirebaseUser firebaseUser;


    private DatabaseReference mData;
    private DatabaseReference mDataHistory;
    private String idClientJoin;
    public MyDialogFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_activity_week, container, false);
        getDialog().setTitle("Đăng ký tham gia");

//        edtName = (EditText) rootView.findViewById(R.id.edt_name_register_activity_week);
//        edtGrade = (EditText) rootView.findViewById(R.id.edt_grade_register_activity_week);
        tvNameActivity = (TextView) rootView.findViewById(R.id.tv_register_title);
        btnParticipation = (Button) rootView.findViewById(R.id.btn_participation);

        Bundle bundle = getArguments();
        title = bundle.getString("DATAA");
        fullName = bundle.getString("FULLNAME");
        idClientJoin = bundle.getString("HISTORY");
        tvNameActivity.setText(title);
        mData = FirebaseDatabase.getInstance().getReference();
        mDataHistory = FirebaseDatabase.getInstance().getReference();
        btnParticipation.setOnClickListener(this);
        return rootView;
    }


    @Override
    public void onClick(View v) {
//        if(edtName.getText().toString().equals("") || edtGrade.getText().toString().equals("") || edtName == null || edtGrade == null) {
//            Toast.makeText(getActivity().getBaseContext(), "Lỗi, không được bỏ trống!", Toast.LENGTH_SHORT).show();
//            return;
//        }
        mData.child("Detail").push().setValue(title + ": " + fullName, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if(databaseError == null) {
                    Toast.makeText(getActivity().getBaseContext(), "Đăng ký tham gia hoạt động thành công!", Toast.LENGTH_SHORT).show();
                    mDataHistory.child("UserHistoryActivity").child(idClientJoin)
                            .push()
                            .setValue("Bạn đã đăng ký “" + title + "”");
                    dismiss();
                } else {
                    Toast.makeText(getActivity().getBaseContext(), "Đăng ký thất bại!", Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            }
        });
    }


}
