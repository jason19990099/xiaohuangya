package com.aigoule.starapp.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.aigoule.starapp.R;
import com.aigoule.starapp.adapter.GradviewvideoAdapter;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.base.BaseActivity;
import com.aigoule.starapp.model.ThemeDetailModel;
import com.aigoule.starapp.views.MyGridView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonalvideoActivity extends BaseActivity {
    @BindView(R.id.pic_top)
    ImageView picTop;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.gv_video)
    MyGridView gvVideo;
    @BindView(R.id.scrollView)
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalvideo);
        ButterKnife.bind(this);
        int video_id = getIntent().getIntExtra("video_id", 0);
        getThemeDetail(video_id);
    }


    private void getThemeDetail(int theme_id) {
        HttpRequest.getInstance().getThemeDetail(PersonalvideoActivity.this, theme_id, new HttpCallback<ThemeDetailModel>() {
            @Override
            public void onSuccess(ThemeDetailModel data) {
                Picasso.get().load(data.getData().getTheme_detail().getPicture())
                        .placeholder(R.mipmap.ic_yellow)
                        .error(R.mipmap.ic_yellow)
                        .config(Bitmap.Config.RGB_565)
                        .fit()
                        .centerCrop()
                        .into(picTop);
                tvTitle.setText(data.getData().getTheme_detail().getTitle());
                tvDescription.setText(data.getData().getTheme_detail().getDescription());

                GradviewvideoAdapter adapter = new GradviewvideoAdapter(data.getData().getTheme_video(), PersonalvideoActivity.this);
                gvVideo.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                scrollView.fullScroll(View.FOCUS_UP) ;
            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {

            }
        });
    }
}
