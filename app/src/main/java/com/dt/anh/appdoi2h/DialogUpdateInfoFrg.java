package com.dt.anh.appdoi2h;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * Created by ALIENWARE on 4/23/2017.
 */

public class DialogUpdateInfoFrg extends android.support.v4.app.DialogFragment implements View.OnClickListener {
    private EditText edtPhoneNumber, edtNickName;
    private Button btnUpdate;

    private String idClient, phoneNumber, nickName;
    private DatabaseReference mData;
    private UserClient userClient;

    public DialogUpdateInfoFrg() {
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_change_information, container, false);
        getDialog().setTitle("Chỉnh sửa thông tin");


        edtPhoneNumber = (EditText) rootView.findViewById(R.id.edt_phone_number_information_update);
        edtNickName = (EditText) rootView.findViewById(R.id.edt_nick_name_information_update);
        btnUpdate = (Button) rootView.findViewById(R.id.btn_update_information);


        Bundle bundle = getArguments();
        idClient = bundle.getString("CLIENT");
        phoneNumber = bundle.getString("PHONE");
        nickName = bundle.getString("NICKNAME");
        edtPhoneNumber.setText(phoneNumber);
        edtNickName.setText(nickName);
        mData = FirebaseDatabase.getInstance().getReference();


        btnUpdate.setOnClickListener(this);
        getInfo();
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update_information:
                if(edtNickName.getText().toString().equals("")) {
                    Toast.makeText(getActivity().getBaseContext(), "Nick name is empty", Toast.LENGTH_SHORT).show();
                    return;
                } else if(edtPhoneNumber.getText().toString().equals("")){
                    Toast.makeText(getActivity().getBaseContext(), "Phone number is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                sendData();
                break;
            default:
                break;
        }
    }

    private void sendData() {
        String idTmp = userClient.getIdUserClient();
        String firstName = userClient.getFirtsName();
        String lastName = userClient.getLastName();
        String grade = userClient.getGrade();
        String email = userClient.getEmail();
        String phoneNumber = edtPhoneNumber.getText().toString();
        String nickName = edtNickName.getText().toString();
        String password = userClient.getPassword();
        String linkCover = userClient.getImgCover();
        String linkAvatar = userClient.getImgAvatar();
        UserClient userTemp = new UserClient(idTmp, firstName, lastName, email,
                grade, phoneNumber, nickName, password, linkCover, linkAvatar);
        mData.child("User").child(userTemp.getIdUserClient()).child("UserInfo-" + userTemp.getIdUserClient())
                .setValue(userTemp, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if(databaseError != null) {
                            Toast.makeText(getActivity().getBaseContext(), "Error while update information", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(getActivity().getBaseContext(), "Update information successfully", Toast.LENGTH_SHORT).show();
                            dismiss();
                        }
                    }
                });
    }
    private void getInfo() {
        mData.child("User").child(idClient).
                addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        //Khi đọc dữ liệu về
                        userClient = dataSnapshot.getValue(UserClient.class);
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        //Khi dữ liệu thay đổi
                        userClient = dataSnapshot.getValue(UserClient.class);
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
}
