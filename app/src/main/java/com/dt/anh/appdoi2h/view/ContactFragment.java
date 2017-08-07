package com.dt.anh.appdoi2h.view;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.dt.anh.appdoi2h.R;
import com.dt.anh.appdoi2h.model.Song;
import com.hanks.htextview.line.LineTextView;
import com.hanks.htextview.typer.TyperTextView;

import org.json.JSONException;
import org.json.JSONObject;

public class ContactFragment extends Fragment implements View.OnClickListener {
    private ImageButton imgBtnFbDTA, imgBtnGmailDTA, imgBtnFbLTD, imgBtnGmailLTD;

    private LineTextView hTextView;
    private TyperTextView typerTextView, typerEngine, typerInformation;
    public ContactFragment() {
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
        View v =  inflater.inflate(R.layout.fragment_contact, container, false);
        LottieAnimationView animationView = (LottieAnimationView) v.findViewById(R.id.animation_view);
//        animationView.setAnimation("lottiefiles.com - Video Camera.json");
        animationView.setAnimation("MotionCorpse-Jrcanest.json");
        animationView.loop(true);
        animationView.playAnimation();

        imgBtnFbDTA = (ImageButton) v.findViewById(R.id.imgbtn_fb_dta);
        imgBtnGmailDTA = (ImageButton) v.findViewById(R.id.imgbtn_gmail_dta);
        imgBtnFbLTD = (ImageButton) v.findViewById(R.id.imgbtn_fb_ltd);
        imgBtnGmailLTD = (ImageButton) v.findViewById(R.id.imgbtn_gmail_ltd);
        hTextView = (LineTextView) v.findViewById(R.id.line_text);

        hTextView.setAnimationDuration(2000);

        typerTextView = (TyperTextView) v.findViewById(R.id.typer_text);

        typerEngine = (TyperTextView) v.findViewById(R.id.typer_text_engine);
        typerInformation = (TyperTextView) v.findViewById(R.id.typer_text_information);

        imgBtnGmailDTA.setOnClickListener(this);
        imgBtnFbDTA.setOnClickListener(this);
        imgBtnFbLTD.setOnClickListener(this);
        imgBtnGmailLTD.setOnClickListener(this);

        hTextView.animateText("Liên hệ");
        typerTextView.animateText("Hệ thống được phát triển bới AD TEAM");
        typerEngine.animateText("Báo lỗi kỹ thuật:");
        typerInformation.animateText("Báo lỗi thông tin:");
        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgbtn_gmail_dta:
//                String message = "Bạn muốn hỗ trợ điều gì nhỉ?";
//                Intent share = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
//                share.setType("text/plain");
//                share.putExtra(Intent.EXTRA_TEXT, message);
//
//                startActivity(Intent.createChooser(share, "Title of the dialog the system will open"));

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"dangtrunganh.hust@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Phản hồi về ứng dụng \"Hai Hòn\"");
                email.putExtra(Intent.EXTRA_TEXT, "Bạn muốn phản hồi điều gì?");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Chọn ứng dụng để Liên hệ :"));

                break;
            case R.id.imgbtn_fb_dta:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/trunganh.trunganh.14"));
                startActivity(intent);

                break;
            case R.id.imgbtn_fb_ltd:
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_VIEW);
                intent1.addCategory(Intent.CATEGORY_BROWSABLE);
                intent1.setData(Uri.parse("https://www.facebook.com/dung.lee.1806"));
                startActivity(intent1);
                break;
            case R.id.imgbtn_gmail_ltd:
                Intent email1 = new Intent(Intent.ACTION_SEND);
                email1.putExtra(Intent.EXTRA_EMAIL, new String[]{"ledung070697@gmail.com"});
                email1.putExtra(Intent.EXTRA_SUBJECT, "Phản hồi về ứng dụng \"Hai Hòn\"");
                email1.putExtra(Intent.EXTRA_TEXT, "Bạn muốn phản hồi điều gì?");
                email1.setType("message/rfc822");
                startActivity(Intent.createChooser(email1, "Chọn ứng dụng để liên hệ :"));
                break;
            default:
                break;
        }
    }
}
