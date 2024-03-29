package com.aigoule.starapp.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.aigoule.starapp.R;
import com.aigoule.starapp.adapter.ThematicVideoAdapter2;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.base.BaseActivity;
import com.aigoule.starapp.model.AllthemeVideoModel;
import com.aigoule.starapp.views.MyGridView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 全部的专题
 */
public class VideoAllActivitry extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.iv_pic)
    ImageView ivPic;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.gv_video)
    MyGridView gvVideo;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeContainer;
    @BindView(R.id.iv_backs)
    ImageView ivBacks;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoall);
        ButterKnife.bind(this);

        swipeContainer.setOnRefreshListener(VideoAllActivitry.this);
        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        id = getIntent().getStringExtra("themeType");
        getAllTheme(id);
    }


    private void getAllTheme(String id) {
        HttpRequest.getInstance().getALLThemeDetail(VideoAllActivitry.this, id, new HttpCallback<AllthemeVideoModel>() {
            @Override
            public void onSuccess(AllthemeVideoModel data) {
                tvName.setText(data.getData().getTitle());
                Picasso.get().load(data.getData().getLogo())
                        .placeholder(R.mipmap.ic_yellow)
                        .error(R.mipmap.ic_yellow)
                        .config(Bitmap.Config.RGB_565)
                        .fit()
                        .centerCrop()
                        .into(ivPic);


                ThematicVideoAdapter2 adapter = new ThematicVideoAdapter2(data.getData().getList(), VideoAllActivitry.this);
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
        getAllTheme(id);
        swipeContainer.setRefreshing(false);
    }

    @OnClick(R.id.iv_backs)
    public void onViewClicked() {
        finish();
    }
}
