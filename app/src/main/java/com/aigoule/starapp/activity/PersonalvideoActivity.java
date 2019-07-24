package com.aigoule.starapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aigoule.starapp.R;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.model.AllvideoThemeModel;

public class PersonalvideoActivity extends AppCompatActivity {
    private int video_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalvideo);
        video_id=getIntent().getIntExtra("video_id",0);
        getThemeDetail(video_id);

    }


    private void getThemeDetail(int theme_id) {
        HttpRequest.getInstance().getThemeDetail(PersonalvideoActivity.this,theme_id, new HttpCallback<AllvideoThemeModel>() {
            @Override
            public void onSuccess(AllvideoThemeModel data) {

            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {

            }
        });
    }
}
