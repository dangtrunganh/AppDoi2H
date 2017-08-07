package com.dt.anh.appdoi2h;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.dt.anh.appdoi2h.view.BigActivityFragment;
import com.dt.anh.appdoi2h.view.ContactFragment;
import com.dt.anh.appdoi2h.view.IntroduceFragment;
import com.dt.anh.appdoi2h.view.LeaderFragment;
import com.dt.anh.appdoi2h.view.MusicFragment2;
import com.dt.anh.appdoi2h.view.RegularActivityFragment;
import com.github.clans.fab.FloatingActionMenu;

public class MainActivity2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private AlertDialog alertDialog;
    private AlertDialog alertDialog2;
    private FloatingActionMenu materialDesignFAM;
    private com.github.clans.fab.FloatingActionButton floatingActionButton2, floatingActionButton3,
            floatingActionButton4, floatingActionButton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initFloatingAction();
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

//        setStatusBarColor(R.color.ab_introduce_status_bar);
        toolbar.setBackgroundColor(R.color.ab_introduce);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(this);
        callFragment(new IntroduceFragment(), "Giới thiệu chung", "#03A9F4", R.color.ab_introduce_status_bar);
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
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_DOWN) {
            if(materialDesignFAM.isOpened()) {
                materialDesignFAM.close(true);
            }
        }

        return super.dispatchTouchEvent(ev);
    }

    private void initFloatingAction() {
        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu2);
        materialDesignFAM.setClosedOnTouchOutside(true);

        floatingActionButton2 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item_leader2);
        floatingActionButton3 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item_regular_activity2);
        floatingActionButton4 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item_big_activity2);
        floatingActionButton5 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item_register_activity2);


        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                materialDesignFAM.close(true);
                callFragment(new LeaderFragment(), "Các đời đội trưởng", "#039BE5", R.color.ab_leader_status_bar);

            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                materialDesignFAM.close(true);
                toolbar.setTitle("Hoạt động thường kỳ");
                toolbar.setBackgroundColor(Color.parseColor("#32d21a"));
                callFragment(new RegularActivityFragment(), "Hoạt động thường kỳ", "#ff8bc34a", R.color.ab_regular_activity_status_bar);

            }
        });
        floatingActionButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                materialDesignFAM.close(true);
                toolbar.setTitle("Chương trình lớn");
                toolbar.setBackgroundColor(Color.parseColor("#e10a1c"));
                callFragment(new BigActivityFragment(), "Chương trình lớn", "#ff607d8b", R.color.ab_big_activity_status_bar);
            }
        });
        floatingActionButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                materialDesignFAM.close(true);
                initAlertDialogRegister();
                alertDialog2.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
//        musicFragment.showNotification(MusicFragment.mediaMgr.getCurrentSong());
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            initAlertDialog();
            alertDialog.show();
//            Intent intent = new Intent(Intent.ACTION_MAIN);
//            intent.addCategory(Intent.CATEGORY_HOME);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
        }
    }

    private void initAlertDialog() {
        alertDialog = new AlertDialog.Builder(MainActivity2.this).create();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    private void initAlertDialogRegister() {
        alertDialog2 = new AlertDialog.Builder(MainActivity2.this).create();
        alertDialog2.setTitle("Chú ý");
        alertDialog2.setMessage("Chức năng này cần INTERNET, bạn có muốn tiếp tục?");
        alertDialog2.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Noi dung xu ly khi click vao button, mac dinh dialog se close sau khi click vao
                toolbar.setTitle("Đăng ký hoạt động");
                toolbar.setBackgroundColor(Color.parseColor("#8713d4"));
                callFragment(new RegisterActivityFragment2(), "Đăng ký hoạt động", "#8713d4", R.color.ab_register_activity_status_bar);
            }
        });
        alertDialog2.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Noi dung xu ly khi click vao button, mac dinh dialog se close sau khi click vao
            }
        });
        alertDialog2.setCanceledOnTouchOutside(false); //Vo hieu hoa khong cho kich ra ngoai de tat dialog
        alertDialog2.setCancelable(false); //Vo hieu hoa khong cho an back de tat dialog
        alertDialog2.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings_2) {
            Intent intentabc = new Intent(this, LoginActivity.class);
            startActivity(intentabc);
            finish();
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
            case R.id.nav_gioi_thieu_chung2:
                materialDesignFAM.setVisibility(View.VISIBLE);
                callFragment(new IntroduceFragment(), "Giới thiệu chung", "#03A9F4", R.color.ab_introduce_status_bar);
                break;
            case R.id.nav_cac_doi_dt2:
                materialDesignFAM.setVisibility(View.VISIBLE);
                callFragment(new LeaderFragment(), "Các đời đội trưởng", "#039BE5", R.color.ab_leader_status_bar);
                break;
            case R.id.nav_hd_thuong_ky2:
                materialDesignFAM.setVisibility(View.VISIBLE);
                callFragment(new RegularActivityFragment(), "Hoạt động thường kỳ", "#ff8bc34a", R.color.ab_regular_activity_status_bar);
                break;
            case R.id.nav_chuong_trinh_lon2:
                materialDesignFAM.setVisibility(View.VISIBLE);
                callFragment(new BigActivityFragment(), "Chương trình lớn", "#ff607d8b", R.color.ab_big_activity_status_bar);
                break;
            case R.id.nav_share2:
                materialDesignFAM.setVisibility(View.VISIBLE);
                share();
//                callFragment(new ShareFragment(), "Chia sẻ", "#ff795548", R.color.ab_share_status_bar);
                break;
            case R.id.nav_contact2:
                materialDesignFAM.setVisibility(View.VISIBLE);
                callFragment(new ContactFragment(), "Liên hệ", "#E91E63", R.color.ab_contact_status_bar);
                break;
            case R.id.nav_rate2:
                rate();
//                materialDesignFAM.setVisibility(View.VISIBLE);
//                toolbar.setTitle("Đánh giá");
//                toolbar.setBackgroundColor(Color.parseColor("#CDDC39"));
//                callFragment(new RateFragment());
                break;
            case R.id.nav_version2:
//                materialDesignFAM.setVisibility(View.VISIBLE);
//                toolbar.setTitle("Phiên bản");
//                toolbar.setBackgroundColor(Color.parseColor("#9E9E9E"));
//                callFragment(new VersionFragment());
                break;
            case R.id.nav_register_activity2:
                materialDesignFAM.setVisibility(View.VISIBLE);
                initAlertDialogRegister();
                alertDialog2.show();
                break;
            case R.id.nav_music2:
                materialDesignFAM.setVisibility(View.INVISIBLE);
                toolbar.setTitle("Nhạc tình nguyện");
                toolbar.setBackgroundColor(Color.parseColor("#FF7043"));
                callFragment(new MusicFragment2(), "Nhạc tình nguyện", "#303F9F", R.color.ab_music_status_bar);
                break;
            case R.id.nav_login_exit_2:
                Intent intentabc = new Intent(this, LoginActivity.class);
                startActivity(intentabc);
                finish();
                break;
            case R.id.nav_about_hai_hon2:
                Intent intentAbout = new Intent(MainActivity2.this, NewsActivity.class);
                intentAbout.putExtra("ABOUT_HAI_HON", "Về ứng dụng Hai Hòn");
                intentAbout.putExtra("LINKNEWS", "http://www.dangtrunganh.com/dta/uncategorized/doi-loi-ve-ung-dung-hai-hon/");
                startActivity(intentAbout);
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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

    private void callFragment(Fragment fragment, String nameFrg, String colorToolbar, int colorStatusBar) {
        toolbar.setTitle(nameFrg);
        setStatusBarColor(colorStatusBar);
        toolbar.setBackgroundColor(Color.parseColor(colorToolbar));
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_fragment2, fragment);
        transaction.commit();
    }
}
