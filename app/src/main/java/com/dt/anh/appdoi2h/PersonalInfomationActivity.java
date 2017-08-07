package com.dt.anh.appdoi2h;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class PersonalInfomationActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE_COVER = 123;
    private static final int REQUEST_CODE_AVATAR = 256;
    private static final int REQUEST_SELECT_PHOTO_COVER = 512;
    private static final int REQUEST_SELECT_PHOTO_AVATAR = 1024;

    private static final int COVER = 1;
    private static final int AVATAR = 2;
    private TabHost mTabHost;
    private ImageView imgBack, ivCoverIfm, ivAvatarIfm;
    private LinearLayout lnlCover, lnlAvatar;
    private Uri imageUri;
    private DatabaseReference mData;
    private UserClient userClient;
    private FirebaseUser firebaseUser;
    private String idClient;
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference storageRef;
    private ArrayAdapter adapter = null;
    private ArrayList<String> listActivityString;

    private TextView tvFirstName, tvLastName, tvGrade, tvEmail, tvPhoneNumber, tvNickName, tvFixInfo, tvFullNameInfo;
    private String linkTemp;
    private ListView lvHistoryActivity;
//    private String firstName, lastName, email, phoneNumber, nickName, linkAvatar, linkCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_infomation);
        storageRef = storage.getReferenceFromUrl("gs://connectfb-8d0a5.appspot.com");
        initViews();
        loadTab();
        listenAndLoadDataAvatar();
        loadHistory();
        imgBack.setOnClickListener(this);
        lnlCover.setOnClickListener(this);
        lnlAvatar.setOnClickListener(this);
    }

    private void loadHistory() {
            listActivityString = new ArrayList<>();
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listActivityString);
            lvHistoryActivity.setAdapter(adapter);
            mData = FirebaseDatabase.getInstance().getReference();
            mData.child("UserHistoryActivity").child(idClient).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String history = dataSnapshot.getValue(String.class);
                    listActivityString.add(history);
                    adapter.notifyDataSetChanged();
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

    private void initViews() {
        imgBack = (ImageView) findViewById(R.id.iv_back_edt);
        lnlCover = (LinearLayout) findViewById(R.id.lnl_edit_cover);
        lnlAvatar = (LinearLayout) findViewById(R.id.lnl_edit_avatar);
        ivCoverIfm = (ImageView) findViewById(R.id.iv_cover_ifm);
        ivAvatarIfm = (ImageView) findViewById(R.id.iv_avatar_ifm);

        tvFirstName = (TextView) findViewById(R.id.tv_first_name_edt_ifm);
        tvLastName = (TextView) findViewById(R.id.tv_last_name_edt_ifm);
        tvGrade = (TextView) findViewById(R.id.tv_grade_edt_ifm);
        tvEmail = (TextView) findViewById(R.id.tv_email_edt_ifm);
        tvPhoneNumber = (TextView) findViewById(R.id.tv_phone_number_edt_ifm);
        tvNickName = (TextView) findViewById(R.id.tv_nick_name_edt_ifm);
        tvFixInfo = (TextView) findViewById(R.id.tv_fix_info);
        tvFullNameInfo = (TextView) findViewById(R.id.tv_full_name_main_info);
        lvHistoryActivity = (ListView) findViewById(R.id.lv_history_activity);
        tvFixInfo.setOnClickListener(this);
    }

    private void loadTab() {
        mTabHost = (TabHost) findViewById(R.id.tabhost);
        mTabHost.setup();

        TabHost.TabSpec spec;

        //Tạo tab 1:
        spec = mTabHost.newTabSpec("T1");
        spec.setContent(R.id.history_edit);
        spec.setIndicator("History");
        mTabHost.addTab(spec);

        //Tạo tab 2:
        spec = mTabHost.newTabSpec("T2");
        spec.setContent(R.id.profile_edit);
        spec.setIndicator("Profile");
        mTabHost.addTab(spec);

        //Thiết lập tab mặc định được chọn ban đầu là 0
        mTabHost.setCurrentTab(0);

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                String s = "Tab tag = " + tabId + "; index = "+
                        mTabHost.getCurrentTab();
//                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void listenAndLoadDataAvatar() {
        if(getIntent() != null) {
            idClient = getIntent().getStringExtra("KEY");
            loadDetail();
        }
    }

    private void loadDetail() {
        mData = FirebaseDatabase.getInstance().getReference();
        mData.child("User").child(idClient).
                addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        //Khi đọc dữ liệu về
                        userClient = dataSnapshot.getValue(UserClient.class);
                        tvFullNameInfo.setText(userClient.getFirtsName() + " " + userClient.getLastName() + " (" + userClient.getUsername() + ")");
                        tvFirstName.setText(userClient.getFirtsName());
                        tvLastName.setText(userClient.getLastName());
                        tvGrade.setText(userClient.getGrade());
                        tvEmail.setText(userClient.getEmail());
                        tvPhoneNumber.setText(userClient.getAddress());
                        tvNickName.setText(userClient.getUsername());
                        Picasso.with(getBaseContext()).load(userClient.getImgAvatar()).into(ivAvatarIfm);
                        Picasso.with(getBaseContext()).load(userClient.getImgCover()).into(ivCoverIfm);
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        //Khi dữ liệu thay đổi
                        userClient = dataSnapshot.getValue(UserClient.class);
                        tvFullNameInfo.setText(userClient.getFirtsName() + " " + userClient.getLastName() + " (" + userClient.getUsername() + ")");
                        tvFirstName.setText(userClient.getFirtsName());
                        tvLastName.setText(userClient.getLastName());
                        tvGrade.setText(userClient.getGrade());
                        tvEmail.setText(userClient.getEmail());
                        tvPhoneNumber.setText(userClient.getAddress());
                        tvNickName.setText(userClient.getUsername());
                        Picasso.with(getBaseContext()).load(userClient.getImgAvatar()).into(ivAvatarIfm);
                        Picasso.with(getBaseContext()).load(userClient.getImgCover()).into(ivCoverIfm);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_edt:
//                Intent intent = new Intent(this, MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                intent.putExtra("Exit me", true);
//                startActivity(intent);
                finish();
                break;
            case R.id.lnl_edit_cover:
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(this, lnlCover);

                //Ánh xạ popup với menu xml
                popup.getMenuInflater().inflate(R.menu.menu_selector_camera, popup.getMenu());

                //Đăng ký bắt sự kiện với OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId() == R.id.menu_camera_edit) {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, REQUEST_CODE_COVER);

                        } else if(item.getItemId() == R.id.menu_gallery_edit){
                            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                            startActivityForResult(intent, REQUEST_SELECT_PHOTO_COVER);
                        }
                        return true;
                    }
                });
                popup.show();
                break;
            case R.id.lnl_edit_avatar:
                PopupMenu popupAvatar = new PopupMenu(this, lnlAvatar);

                //Ánh xạ popup với menu xml
                popupAvatar.getMenuInflater().inflate(R.menu.menu_selector_camera, popupAvatar.getMenu());

                //Đăng ký bắt sự kiện với OnMenuItemClickListener
                popupAvatar.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId() == R.id.menu_camera_edit) {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, REQUEST_CODE_AVATAR);

                        } else if(item.getItemId() == R.id.menu_gallery_edit){
                            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                            startActivityForResult(intent, REQUEST_SELECT_PHOTO_AVATAR);
                        }
                        return true;
                    }
                });
                popupAvatar.show();
                break;

            case R.id.tv_fix_info:
                if(userClient != null) {
                    FragmentManager fm = this.getSupportFragmentManager();
                    Bundle bundle = new Bundle();
                    bundle.putString("CLIENT", userClient.getIdUserClient());
                    bundle.putString("PHONE", userClient.getAddress());
                    bundle.putString("NICKNAME", userClient.getUsername());
                    DialogUpdateInfoFrg dialogInfoFragment = new DialogUpdateInfoFrg();
                    dialogInfoFragment.setArguments(bundle);
                    dialogInfoFragment.show(fm, "TAGS");
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap;
        if(requestCode == REQUEST_CODE_COVER && resultCode == RESULT_OK) {
            bitmap = (Bitmap) data.getExtras().get("data");
            ivCoverIfm.setImageBitmap(bitmap);
            if(idClient != null) {
                //===================================================
                Calendar calendar = Calendar.getInstance();
                StorageReference mountainsRef = storageRef.child("image" + calendar.getTimeInMillis() + ".png");

                Bitmap bitmapCover = ((BitmapDrawable) ivCoverIfm.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmapCover.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] dataCover = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(dataCover);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(PersonalInfomationActivity.this, "Loi khi upLoad!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        String idTmp = userClient.getIdUserClient();
                        String firstName = userClient.getFirtsName();
                        String lastName = userClient.getLastName();
                        String grade = userClient.getGrade();
                        String email = userClient.getEmail();
                        String phoneNumber = userClient.getAddress();
                        String nickName = userClient.getUsername();
                        String password = userClient.getPassword();
                        String linkCover = taskSnapshot.getDownloadUrl().toString();

//                        Toast.makeText(PersonalInfomationActivity.this, "LINK: " + linkCover, Toast.LENGTH_SHORT).show();

                        String linkAvatar = userClient.getImgAvatar();
                        UserClient userTemp = new UserClient(idTmp, firstName, lastName, email,
                                grade, phoneNumber, nickName, password, linkCover, linkAvatar);
                        mData.child("User").child(userTemp.getIdUserClient()).child("UserInfo-" + userTemp.getIdUserClient())
                                .setValue(userTemp, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                        if(databaseError == null) {

                                        } else {
                                            Toast.makeText(getApplicationContext(), "Lỗi khi lưu dữ liệu!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                });
                //================================================
            }
        } else if(requestCode == REQUEST_SELECT_PHOTO_COVER && resultCode == RESULT_OK) {
            imageUri = data.getData();
            ivCoverIfm.setImageURI(imageUri);
            if(idClient != null) {
                //===================================================
                Calendar calendar = Calendar.getInstance();
                StorageReference mountainsRef = storageRef.child("image" + calendar.getTimeInMillis() + ".png");

                Bitmap bitmapCover = ((BitmapDrawable) ivCoverIfm.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmapCover.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] dataCover = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(dataCover);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(PersonalInfomationActivity.this, "Loi khi upLoad!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        String idTmp = userClient.getIdUserClient();
                        String firstName = userClient.getFirtsName();
                        String lastName = userClient.getLastName();
                        String grade = userClient.getGrade();
                        String email = userClient.getEmail();
                        String phoneNumber = userClient.getAddress();
                        String nickName = userClient.getUsername();
                        String password = userClient.getPassword();
                        String linkCover = taskSnapshot.getDownloadUrl().toString();

//                        Toast.makeText(PersonalInfomationActivity.this, "LINK: " + linkCover, Toast.LENGTH_SHORT).show();

                        String linkAvatar = userClient.getImgAvatar();
                        UserClient userTemp = new UserClient(idTmp, firstName, lastName, email,
                                grade, phoneNumber, nickName, password, linkCover, linkAvatar);
                        mData.child("User").child(userTemp.getIdUserClient()).child("UserInfo-" + userTemp.getIdUserClient())
                                .setValue(userTemp, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                        if(databaseError == null) {

                                        } else {
                                            Toast.makeText(getApplicationContext(), "Lỗi khi lưu dữ liệu!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                });
                //================================================
            }
        } else if(requestCode == REQUEST_CODE_AVATAR && resultCode == RESULT_OK) {
            bitmap = (Bitmap) data.getExtras().get("data");
            ivAvatarIfm.setImageBitmap(bitmap);
            if(idClient != null) {
                //===================================================
                Calendar calendar = Calendar.getInstance();
                StorageReference mountainsRef = storageRef.child("image" + calendar.getTimeInMillis() + ".png");

                Bitmap bitmapCover = ((BitmapDrawable) ivAvatarIfm.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmapCover.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] dataCover = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(dataCover);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(PersonalInfomationActivity.this, "Loi khi upLoad!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        String idTmp = userClient.getIdUserClient();
                        String firstName = userClient.getFirtsName();
                        String lastName = userClient.getLastName();
                        String grade = userClient.getGrade();
                        String email = userClient.getEmail();
                        String phoneNumber = userClient.getAddress();
                        String nickName = userClient.getUsername();
                        String password = userClient.getPassword();
                        String linkAvatar = taskSnapshot.getDownloadUrl().toString();

//                        Toast.makeText(PersonalInfomationActivity.this, "LINK: " + linkAvatar, Toast.LENGTH_SHORT).show();

                        String linkCover = userClient.getImgCover();
                        UserClient userTemp = new UserClient(idTmp, firstName, lastName, email,
                                grade, phoneNumber, nickName, password, linkCover, linkAvatar);
                        mData.child("User").child(userTemp.getIdUserClient()).child("UserInfo-" + userTemp.getIdUserClient())
                                .setValue(userTemp, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                        if(databaseError == null) {

                                        } else {
                                            Toast.makeText(getApplicationContext(), "Lỗi khi lưu dữ liệu!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                });
                //================================================
            }
        } else if(requestCode == REQUEST_SELECT_PHOTO_AVATAR && resultCode == RESULT_OK) {
            imageUri = data.getData();
            ivAvatarIfm.setImageURI(imageUri);
            if(idClient != null) {
                //===================================================
                Calendar calendar = Calendar.getInstance();
                StorageReference mountainsRef = storageRef.child("image" + calendar.getTimeInMillis() + ".png");

                Bitmap bitmapCover = ((BitmapDrawable) ivAvatarIfm.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmapCover.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] dataCover = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(dataCover);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(PersonalInfomationActivity.this, "Loi khi upLoad!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        String idTmp = userClient.getIdUserClient();
                        String firstName = userClient.getFirtsName();
                        String lastName = userClient.getLastName();
                        String grade = userClient.getGrade();
                        String email = userClient.getEmail();
                        String phoneNumber = userClient.getAddress();
                        String nickName = userClient.getUsername();
                        String password = userClient.getPassword();
                        String linkAvatar = taskSnapshot.getDownloadUrl().toString();

//                        Toast.makeText(PersonalInfomationActivity.this, "LINK: " + linkAvatar, Toast.LENGTH_SHORT).show();

                        String linkCover = userClient.getImgCover();
                        UserClient userTemp = new UserClient(idTmp, firstName, lastName, email,
                                grade, phoneNumber, nickName, password, linkCover, linkAvatar);
                        mData.child("User").child(userTemp.getIdUserClient()).child("UserInfo-" + userTemp.getIdUserClient())
                                .setValue(userTemp, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                        if(databaseError == null) {

                                        } else {
                                            Toast.makeText(getApplicationContext(), "Lỗi khi lưu dữ liệu!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                });
                //================================================
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.putExtra("CHECK", "TRUE");
//        startActivity(intent);
        finish();
    }
}
