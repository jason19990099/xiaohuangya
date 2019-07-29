package com.aigoule.starapp.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aigoule.starapp.R;
import com.aigoule.starapp.adapter.PlayerAdapter;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
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
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class PlayerFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.iv_fiction)
    ImageView ivFiction;
    @BindView(R.id.tv_fiction)
    TextView tvFiction;
    @BindView(R.id.iv_fiction_more)
    ImageView ivFictionMore;
    @BindView(R.id.gv_fiction)
    MyGridView gvFiction;
    @BindView(R.id.videoplayer)
    JCVideoPlayerStandard videoplayer;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    private PlayerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player, null);
        unbinder = ButterKnife.bind(this, view);

        getClassData();
        return view;
    }


    private void getClassData() {
        HttpRequest.getInstance().getClassData(PlayerFragment.this, new HttpCallback<ClassDataModel>() {
            @Override
            public void onSuccess(ClassDataModel data) {
                adapter = new PlayerAdapter(getActivity(), data.getData().getList());
                gvFiction.setAdapter(adapter);

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



    private void initPlayDetail(int play) {
        if (null != getActivity())
            HttpRequest.getInstance().getPlayDetail(PlayerFragment.this, play,SharePreferencesUtil.getString(getActivity(), "id", ""),android.os.Build.SERIAL, new HttpCallback<PlaydetailModel>() {
                @Override
                public void onSuccess(PlaydetailModel data) {
                    if (data.getCode()==-1){
                        EventBus.getDefault().postSticky(new LoginEvent());
                        Toast.makeText(getActivity(),data.getMessage(),Toast.LENGTH_LONG).show();
                    }
                    initPlayer(data.getData().getVideo_url(), data.getData().getTitle());
                }

                @Override
                public void onFailure(int msgCode, String errorMsg) {
                    Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
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
        videoplayer.setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, videoname);
        scrollView.fullScroll(View.FOCUS_UP);
    }
}
