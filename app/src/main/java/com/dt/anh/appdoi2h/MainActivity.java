package com.dt.anh.appdoi2h;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dt.anh.appdoi2h.view.BigActivityFragment;
import com.dt.anh.appdoi2h.view.ConfessionFragment;
import com.dt.anh.appdoi2h.view.ContactFragment;
import com.dt.anh.appdoi2h.view.HomeFragment;
import com.dt.anh.appdoi2h.view.IntroduceFragment;
import com.dt.anh.appdoi2h.view.LeaderFragment;
import com.dt.anh.appdoi2h.view.MusicFragment;
import com.dt.anh.appdoi2h.view.ZapFragment;
import com.dt.anh.appdoi2h.view.RegularActivityFragment;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private static final int HOME = 1;
    private static final int GIOI_THIEU_CHUNG = 2;
    private static final int CAC_DOI_DOI_TRUONG = 3;
    private static final int HOAT_DONG_THUONG_KY = 4;
    private static final int CHUONG_TRINH_LON = 5;
    private static final int NHAC_TINH_NGUYEN = 6;
    private static final int ZAP = 7;
    private static final int DANG_KY_HOAT_DONG = 8;
    private static final int CONFESSION = 9;
    private static final int CHIA_SE = 10;
    private static final int LIEN_HE = 11;
    private static final int PHIEN_BAN = 12;
    private static final int DANG_XUAT = 13;
    private static final int DANH_GIA = 14;
    private static final int ABOUT_HAI_HON = 15;
    private int flag = HOME;
    private boolean flagClicked = false;


    private Toolbar toolbar;

    private MusicFragment musicFragment;

    private FloatingActionMenu materialDesignFAM;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3,
            floatingActionButton4, floatingActionButton5, floatingActionButton6;
    private TextView tvTitleFullName;
    private TextView tvTitleEmail;
    private ImageView ivEditAccount, ivImageAvatar;
    private RelativeLayout ivRealativeCover;

    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference storageRef;
    private DatabaseReference mData;
    private UserClient userClient;
    private AlertDialog alertDialog;
    private AlertDialog alertDialog3;

    private Fragment fragmentContent;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main);
        new Dismiss().execute();
    }

    private void loadInMain() {
        initFloatingAction();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#00bcd4"));
        setStatusBarColor(R.color.ab_home_status_bar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                if(!flagClicked) {
                    return;
                }
                switch (flag) {
                    case HOME:
                        materialDesignFAM.setVisibility(View.VISIBLE);
                        callFragment(new HomeFragment(), "Trang chủ", "#00bcd4", R.color.ab_home_status_bar);
                        break;
                    case GIOI_THIEU_CHUNG:
                        materialDesignFAM.setVisibility(View.VISIBLE);
                        callFragment(new IntroduceFragment(), "Giới thiệu chung", "#03A9F4", R.color.ab_introduce_status_bar);
                        break;
                    case CAC_DOI_DOI_TRUONG:
                        materialDesignFAM.setVisibility(View.VISIBLE);
                        callFragment(new LeaderFragment(), "Các đời đội trưởng", "#039BE5", R.color.ab_leader_status_bar);
                        break;
                    case HOAT_DONG_THUONG_KY:
                        materialDesignFAM.setVisibility(View.VISIBLE);
                        callFragment(new RegularActivityFragment(), "Hoạt động thường kỳ", "#ff8bc34a", R.color.ab_regular_activity_status_bar);
                        break;
                    case CHUONG_TRINH_LON:
                        materialDesignFAM.setVisibility(View.VISIBLE);
                        callFragment(new BigActivityFragment(), "Chương trình lớn", "#ff607d8b", R.color.ab_big_activity_status_bar);
                        break;
                    case NHAC_TINH_NGUYEN:
                        materialDesignFAM.setVisibility(View.INVISIBLE);
                        callFragment(new MusicFragment(), "Nhạc tình nguyện", "#303F9F", R.color.ab_music_status_bar);
                        break;
                    case ZAP:
                        materialDesignFAM.setVisibility(View.VISIBLE);
                        callFragment(new ZapFragment(), "Các bài zap chính", "#009688", R.color.ab_zap_amin_status_bar);
                        break;
                    case DANG_KY_HOAT_DONG:
                        materialDesignFAM.setVisibility(View.VISIBLE);
                        callFragment(new RegisterActivityFragment(), "Đăng ký hoạt động", "#8713d4", R.color.ab_register_activity_status_bar);
                        break;
                    case CONFESSION:
                        materialDesignFAM.setVisibility(View.VISIBLE);
                        ConfessionFragment confessionFragment = new ConfessionFragment();
                        callFragment(confessionFragment, "Hai Hòn Confession", "#ffff9800", R.color.ab_confession_status_bar);
                        if(userClient != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("FULLNAME", firebaseUser.getDisplayName());
                            bundle.putString("EMAIL", userClient.getEmail());
                            bundle.putString("GRADE", userClient.getGrade());
                            bundle.putString("ADDRESS", userClient.getAddress());
                            bundle.putString("USERNAME", userClient.getUsername());
                            confessionFragment.setArguments(bundle);
                        }
                        break;
                    case CHIA_SE:
//                        callFragment(new ShareFragment(), "Chia sẻ", "#ff795548", R.color.ab_share_status_bar);
                        share(); //Chia sẻ
                        flagClicked = false;
                        break;
                    case LIEN_HE:
                        materialDesignFAM.setVisibility(View.VISIBLE);
                        callFragment(new ContactFragment(), "Liên hệ", "#E91E63", R.color.ab_contact_status_bar);
                        break;
                    case PHIEN_BAN:
                        flagClicked = false;
                        break;
                    case DANG_XUAT:
                        flagClicked = false;
                        initAlertDialogLogout();
                        alertDialog3.show();
                        break;
                    case DANH_GIA:
                        flagClicked = false;
                        rate(); //Đánh giá
                        break;
                    case ABOUT_HAI_HON:
                        flagClicked = false;
                        Intent intentAbout = new Intent(MainActivity.this, NewsActivity.class);
                        intentAbout.putExtra("ABOUT_HAI_HON", "Về ứng dụng “Hai Hòn”");
                        intentAbout.putExtra("LINKNEWS", "http://www.dangtrunganh.com/dta/uncategorized/doi-loi-ve-ung-dung-hai-hon/");
                        startActivity(intentAbout);
                        break;
                    default:
                        break;
                }
            }
            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        callFragment(new HomeFragment(), "Trang chủ", "#00bcd4", R.color.ab_home_status_bar);
        View header = navigationView.getHeaderView(0);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        tvTitleEmail = (TextView) header.findViewById(R.id.title_mail);
        tvTitleFullName = (TextView) header.findViewById(R.id.title_full_name);
        ivEditAccount = (ImageView) header.findViewById(R.id.iv_edit_account);
        ivRealativeCover = (RelativeLayout) header.findViewById(R.id.relative_layout_cover);
        ivImageAvatar = (ImageView) header.findViewById(R.id.image_view_avatar);
        ivEditAccount.setOnClickListener(this);
        loadDataAvatar();
        loadDataIntro();
    }
    private class Dismiss extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Loading..");
            dialog.setCancelable(false);
            dialog.show();
            loadInMain();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
        }
    }

    private void setStatusBarColor(int color) {
        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, color));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void instantiateFragments(Bundle inState) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (inState != null) {
            fragmentContent = (MusicFragment) manager.getFragment(inState, MusicFragment.TAG);
        } else {
            fragmentContent = new MusicFragment();
            transaction.replace(R.id.main_fragment, fragmentContent, MusicFragment.TAG);
            transaction.commit();
        }
    }

    private void loadDataIntro() {
        String fullName = "";
        if(firebaseUser != null) {
            fullName = firebaseUser.getDisplayName();
            Toast.makeText(this, "Welcome " + fullName, Toast.LENGTH_SHORT).show();
//            email = firebaseUser.getEmail();
        }
    }

    private void loadDataAvatar() {
        mData = FirebaseDatabase.getInstance().getReference();
        mData.child("User").child(firebaseUser.getUid()).
                addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //Khi đọc dữ liệu về
                userClient = dataSnapshot.getValue(UserClient.class);

                String fullNameedt = userClient.getFirtsName() + " " + userClient.getLastName() + " - K" + userClient.getGrade();
//                Toast.makeText(MainActivity.this, "Welcome " + fullNameedt, Toast.LENGTH_SHORT).show();
                tvTitleFullName.setText(fullNameedt);


//                tvTitleFullName.setText(firebaseUser.getDisplayName());
                tvTitleEmail.setText(userClient.getEmail());
                Picasso.with(getBaseContext()).load(userClient.getImgAvatar()).into(ivImageAvatar);
                Picasso.with(getBaseContext()).load(userClient.getImgCover()).into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        ivRealativeCover.setBackground(new BitmapDrawable(bitmap));
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                //Khi dữ liệu thay đổi
                UserClient userClient = dataSnapshot.getValue(UserClient.class);
//                tvTitleFullName.setText(userClient.getFirtsName() + " " + userClient.getLastName() + " - K" + userClient.getGrade());
//                tvTitleFullName.setText(firebaseUser.getDisplayName());

                String fullNameedt = userClient.getFirtsName() + " " + userClient.getLastName() + " - K" + userClient.getGrade();
//                Toast.makeText(MainActivity.this, "Welcome " + fullNameedt, Toast.LENGTH_SHORT).show();
                tvTitleFullName.setText(fullNameedt);
                tvTitleEmail.setText(userClient.getEmail());
                Picasso.with(getBaseContext()).load(userClient.getImgAvatar()).into(ivImageAvatar);
                Picasso.with(getBaseContext()).load(userClient.getImgCover()).into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        ivRealativeCover.setBackground(new BitmapDrawable(bitmap));
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });
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

    private void rate() {
        String str ="https://play.google.com/store/apps/details?id=com.dt.anh.appdoi2h";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(str)));
    }

    private void share() {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_SUBJECT, "Chia sẻ ứng dụng \"Hai Hòn\"");
        email.putExtra(Intent.EXTRA_TEXT, "Cùng download về sử dụng nhé mọi người. \n https://play.google.com/store/apps/details?id=com.dt.anh.appdoi2h");
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Chọn ứng dụng để chia sẻ :"));
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_DOWN) {
            if(materialDesignFAM.isOpened()) {
                materialDesignFAM.close(true);
            }
        }

        return super.dispatchTouchEvent(ev);
    }

    private void initFloatingAction() {
        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        materialDesignFAM.setClosedOnTouchOutside(true);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item_home);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item_leader);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item_regular_activity);
        floatingActionButton4 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item_big_activity);
        floatingActionButton5 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item_register_activity);
        floatingActionButton6 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item_confession);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                materialDesignFAM.close(true);
                callFragment(new HomeFragment(), "Trang chủ", "#00bcd4", R.color.ab_home_status_bar);
                flag = HOME;

            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                materialDesignFAM.close(true);
                callFragment(new LeaderFragment(), "Các đời đội trưởng", "#039BE5", R.color.ab_leader_status_bar);
                flag = CAC_DOI_DOI_TRUONG;

            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                materialDesignFAM.close(true);
                callFragment(new RegularActivityFragment(), "Hoạt động thường kỳ", "#ff8bc34a", R.color.ab_regular_activity_status_bar);
                flag = HOAT_DONG_THUONG_KY;

            }
        });
        floatingActionButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                materialDesignFAM.close(true);
                callFragment(new BigActivityFragment(), "Chương trình lớn", "#ff607d8b", R.color.ab_big_activity_status_bar);
                flag = CHUONG_TRINH_LON;

            }
        });
        floatingActionButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                materialDesignFAM.close(true);
                callFragment(new RegisterActivityFragment(), "Đăng ký hoạt động", "#8713d4", R.color.ab_register_activity_status_bar);
                flag = DANG_KY_HOAT_DONG;

            }
        });
        floatingActionButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                materialDesignFAM.setVisibility(View.VISIBLE);

                flag = CONFESSION;
                materialDesignFAM.close(true);
                ConfessionFragment confessionFragment = new ConfessionFragment();
                callFragment(confessionFragment, "Hai Hòn Confession", "#ffff9800", R.color.ab_confession_status_bar);
                if(userClient != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("FULLNAME", firebaseUser.getDisplayName());
                    bundle.putString("EMAIL", userClient.getEmail());
                    bundle.putString("GRADE", userClient.getGrade());
                    bundle.putString("ADDRESS", userClient.getAddress());
                    bundle.putString("USERNAME", userClient.getUsername());
                    confessionFragment.setArguments(bundle);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            initAlertDialog();
            alertDialog.show();
        }
    }

    private void initAlertDialog() {
        alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("");
        alertDialog.setMessage("Thoát chương trình?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Noi dung xu ly khi click vao button, mac dinh dialog se close sau khi click vao
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Noi dung xu ly khi click vao button, mac dinh dialog se close sau khi click vao
            }
        });
        alertDialog.setCanceledOnTouchOutside(false); //Vo hieu hoa khong cho kich ra ngoai de tat dialog
        alertDialog.setCancelable(false); //Vo hieu hoa khong cho an back de tat dialog
    }

    private void initAlertDialogLogout() {
        alertDialog3 = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog3.setTitle("");
        alertDialog3.setMessage("Bạn có muốn đăng xuất?");
        alertDialog3.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Noi dung xu ly khi click vao button, mac dinh dialog se close sau khi click vao
                mAuth.signOut();
                finish();
            }
        });
        alertDialog3.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Noi dung xu ly khi click vao button, mac dinh dialog se close sau khi click vao
            }
        });
        alertDialog3.setCanceledOnTouchOutside(false); //Vo hieu hoa khong cho kich ra ngoai de tat dialog
        alertDialog3.setCancelable(false); //Vo hieu hoa khong cho an back de tat dialog
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings_1) {
            initAlertDialogLogout();
            alertDialog3.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                flag = HOME;
                flagClicked = true;
                break;
            case R.id.nav_gioi_thieu_chung:
                flag = GIOI_THIEU_CHUNG;
                flagClicked = true;
                break;
            case R.id.nav_cac_doi_dt:
                flag = CAC_DOI_DOI_TRUONG;
                flagClicked = true;
                break;
            case R.id.nav_hd_thuong_ky:
                flag = HOAT_DONG_THUONG_KY;
                flagClicked = true;
                break;
            case R.id.nav_chuong_trinh_lon:
                flag = CHUONG_TRINH_LON;
                flagClicked = true;
                break;
            case R.id.nav_music:
                flag = NHAC_TINH_NGUYEN;
                flagClicked = true;
                break;
            case R.id.nav_zap:
                flag = ZAP;
                flagClicked = true;
                break;
            case R.id.nav_share:
                flag = CHIA_SE;
                flagClicked = true;
                break;
            case R.id.nav_contact:
                flag = LIEN_HE;
                flagClicked = true;
                break;
            case R.id.nav_rate:
                flag = DANH_GIA;
                flagClicked = true;
                break;
            case R.id.nav_version:
                flagClicked = true;
//                materialDesignFAM.setVisibility(View.VISIBLE);
//                toolbar.setTitle("Phiên bản");
//                toolbar.setBackgroundColor(Color.parseColor("#9E9E9E"));
//                callFragment(new VersionFragment());
                break;
            case R.id.nav_register_activity:
                flag = DANG_KY_HOAT_DONG;
                flagClicked = true;
                break;
            case R.id.nav_log_out:
                flagClicked = true;
                flag = DANG_XUAT;
                break;
            case R.id.nav_confession:
                flag = CONFESSION;
                flagClicked = true;
                break;
            case R.id.nav_about_hai_hon:
                flag = ABOUT_HAI_HON;
                flagClicked = true;
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void callFragment(Fragment fragment, String nameFrg, String colorToolbar, int colorStatusBar) {
        toolbar.setTitle(nameFrg);
        setStatusBarColor(colorStatusBar);
        toolbar.setBackgroundColor(Color.parseColor(colorToolbar));
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_fragment, fragment);
        transaction.commit();
        flagClicked = false;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_edit_account:
                Intent intent = new Intent(this, PersonalInfomationActivity.class);
                if(firebaseUser != null) {
                    intent.putExtra("KEY", firebaseUser.getUid());
                }
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
