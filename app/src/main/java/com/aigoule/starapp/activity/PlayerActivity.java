package com.aigoule.starapp.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.aigoule.starapp.R;
import com.aigoule.starapp.adapter.PlayerAdapter;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.base.BaseActivity;
import com.aigoule.starapp.event.LoginEvent;
import com.aigoule.starapp.event.playerEvent;
import com.aigoule.starapp.model.ClassDataModel;
import com.aigoule.starapp.model.PlaydetailModel;
import com.aigoule.starapp.utils.SharePreferencesUtil;
import com.aigoule.starapp.views.MyGridView;
import com.squareup.picasso.Picasso;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class PlayerActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.videoplayer)
    JCVideoPlayerStandard videoplayer;
    @BindView(R.id.iv_fiction)
    ImageView ivFiction;
    @BindView(R.id.tv_fiction)
    TextView tvFiction;
    @BindView(R.id.iv_fiction_more)
    ImageView ivFictionMore;
    @BindView(R.id.gv_fiction)
    MyGridView gvFiction;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeContainer;
    @BindView(R.id.iv_backs)
    ImageView ivBacks;
    @BindView(R.id.iv_new_video)
    ImageView ivNewVideo;
    @BindView(R.id.tv_title_newvideo)
    TextView tvTitleNewvideo;
    @BindView(R.id.editext_videos)
    EditText editextVideos;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    private PlayerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_player);
        ButterKnife.bind(this);
        swipeContainer.setOnRefreshListener(PlayerActivity.this);
        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        getClassData();

    }

    private void getClassData() {
        HttpRequest.getInstance().getClassData(PlayerActivity.this, new HttpCallback<ClassDataModel>() {
            @Override
            public void onSuccess(ClassDataModel data) {
                adapter = new PlayerAdapter(PlayerActivity.this, data.getData().getList());
                gvFiction.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                Picasso.get().load(data.getData().getIcon_image())
                        .placeholder(R.mipmap.yellow_duck)
                        .error(R.mipmap.ic_launcher)
                        .config(Bitmap.Config.RGB_565)
                        .fit()
                        .centerCrop()
                        .into(ivFiction);
                tvFiction.setText(data.getData().getTitle());
            }


            @Override
            public void onFailure(int msgCode, String errorMsg) {

            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(playerEvent event) {
        gvFiction.setFocusable(false);
        initPlayDetail(event.getVideourl());
    }


    private void initPlayDetail(String play) {
        if (null == play) {
            Toast.makeText(PlayerActivity.this, "参数传递错误", Toast.LENGTH_LONG).show();
            return;
        }


        HttpRequest.getInstance().getPlayDetail(PlayerActivity.this, play, SharePreferencesUtil.getString(PlayerActivity.this, "id", ""), Build.SERIAL, new HttpCallback<PlaydetailModel>() {
            @Override
            public void onSuccess(PlaydetailModel data) {
                if (data.getCode() == -1) {
                    Toast.makeText(PlayerActivity.this, data.getMessage(), Toast.LENGTH_LONG).show();

                    EventBus.getDefault().postSticky(new LoginEvent());

                } else {
                    initPlayer(data.getData().getVideo_url(), data.getData().getTitle());
                }

            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {
                Toast.makeText(PlayerActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });

    }


    /**
     * 初始化視頻播放
     *
     * @param url
     * @param videoname
     */
    private void initPlayer(String url, String videoname) {
        if (null == url || url.equals("")) {
            Toast.makeText(PlayerActivity.this, "参数传递错误", Toast.LENGTH_LONG).show();
            return;
        }

        if (null != videoplayer) {
            if (videoname.length()>40){
                videoplayer.setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,videoname.substring(0,35));
            }else{
                videoplayer.setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,videoname);
            }

        }
        if (null != scrollView) {
            scrollView.fullScroll(View.FOCUS_UP);
        }

    }

    @Override
    public void onRefresh() {
        getClassData();
        swipeContainer.setRefreshing(false);
    }


    @OnClick({R.id.iv_backs,R.id.iv_search})
    public void onViewClicked(View view) {
        if (view.getId()==R.id.iv_backs){
            finish();
        }

        if (view.getId()==R.id.iv_search){
            Intent intent=new Intent(this,SearchActivity.class);
            intent.putExtra("search_id",editextVideos.getText().toString().replace(" ",""));
            startActivity(intent);
        }

    }


}
