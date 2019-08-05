package com.aigoule.starapp.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
import butterknife.OnClick;

public class PersonalvideoActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {
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
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeContainer;
    @BindView(R.id.iv_backs)
    ImageView ivBacks;
    private int video_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalvideo);
        ButterKnife.bind(this);

        swipeContainer.setOnRefreshListener(PersonalvideoActivity.this);
        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        video_id = getIntent().getIntExtra("video_id", 0);
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
                gvVideo.setFocusable(false);
                GradviewvideoAdapter adapter = new GradviewvideoAdapter(data.getData().getTheme_video(), PersonalvideoActivity.this);
                gvVideo.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {

            }
        });
    }

    @Override
    public void onRefresh() {
        getThemeDetail(video_id);
        swipeContainer.setRefreshing(false);
    }

    @OnClick(R.id.iv_backs)
    public void onViewClicked() {
        finish();
    }
}
