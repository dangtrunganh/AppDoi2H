package com.dt.anh.appdoi2h.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dt.anh.appdoi2h.Confession;
import com.dt.anh.appdoi2h.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ConfessionFragment extends Fragment implements View.OnClickListener {
    private EditText edtConfession;
    private Button btnSend;
    private View view;
    private Animation animation;
    private DatabaseReference mData;
//    private FirebaseUser firebaseUser;
    private Confession cfs;
    
    private String fullName, email, grade, address, username, content;
    public ConfessionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_confession, container, false);
//        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        fullName = getArguments().getString("FULLNAME");
        email = getArguments().getString("EMAIL");
        grade = getArguments().getString("GRADE");
        address = getArguments().getString("ADDRESS");
        username = getArguments().getString("USERNAME");
//        if(firebaseUser != null) {
//            fullName = firebaseUser.getDisplayName();
//            email = firebaseUser.getEmail();
//
//        }
        initViews();
        return view;
    }

    private void initViews() {
        edtConfession = (EditText) view.findViewById(R.id.edt_confession);
        btnSend = (Button) view.findViewById(R.id.btn_send);
        btnSend.setOnClickListener(this);

        animation = AnimationUtils.loadAnimation(getActivity().getBaseContext(), R.anim.animation_rung);


        //============================
        View decorView = getActivity().getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        //============================
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                if(edtConfession.getText().toString().equals("")) {
                    Toast.makeText(getActivity().getBaseContext(), "You must text first", Toast.LENGTH_SHORT).show();
                    edtConfession.startAnimation(animation);
                } else {
                    content = edtConfession.getText().toString();
                    cfs = new Confession(fullName, email, grade, address, username, content);
                    mData = FirebaseDatabase.getInstance().getReference();
                    mData.child("Confession").push().setValue(cfs, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            if(databaseError == null) {
                                //Có nên xóa trắng đi ko nhỉ???
//                                edtConfession.setText("");
                                Toast.makeText(getActivity().getBaseContext(), "Send Confession successfully", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getActivity().getBaseContext(), "Error while sending Confession", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                break;
            default:
                break;
        }
    }
}
