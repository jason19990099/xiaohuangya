package com.aigoule.starapp.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.aigoule.starapp.R;
import com.aigoule.starapp.adapter.FictionAdapter;
import com.aigoule.starapp.adapter.GradviewAdapter;
import com.aigoule.starapp.adapter.GradviewPicAdapter;
import com.aigoule.starapp.adapter.ThemeGradviewAdapter;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.event.GoWhereEvent;
import com.aigoule.starapp.model.BannerModel;
import com.aigoule.starapp.model.FictionModel;
import com.aigoule.starapp.model.Fpicmodel;
import com.aigoule.starapp.model.MainTheme;
import com.aigoule.starapp.model.NewVideosModel;
import com.aigoule.starapp.views.MyGridView;
import com.aigoule.starapp.views.banners.BannerBaseView;
import com.aigoule.starapp.views.banners.MainBannerView;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FirstFragment extends Fragment  {
    Unbinder unbinder;
    @BindView(R.id.banner_cont)
    RelativeLayout bannerCont;
    @BindView(R.id.iv_new_video)
    ImageView ivNewVideo;
    @BindView(R.id.tv_title_newvideo)
    TextView tvTitleNewvideo;
    @BindView(R.id.iv_new_video_more)
    ImageView ivNewVideoMore;
    @BindView(R.id.gv_newvideo)
    MyGridView gvNewvideo;
    @BindView(R.id.mygradview_theme)
    MyGridView mygradviewTheme;
    @BindView(R.id.iv_hot_video)
    ImageView ivHotVideo;
    @BindView(R.id.tv_title_hotvideo)
    TextView tvTitleHotvideo;
    @BindView(R.id.iv_hot_video_more)
    ImageView ivHotVideoMore;
    @BindView(R.id.gv_hotvideo)
    MyGridView gvHotvideo;
    @BindView(R.id.iv_fiction)
    ImageView ivFiction;
    @BindView(R.id.tv_fiction)
    TextView tvFiction;
    @BindView(R.id.iv_fiction_more)
    ImageView ivFictionMore;
    @BindView(R.id.gv_fiction)
    MyGridView gvFiction;
    @BindView(R.id.iv_pic)
    ImageView ivPic;
    @BindView(R.id.tv_pic)
    TextView tvPic;
    @BindView(R.id.iv_pic_more)
    ImageView ivPicMore;
    @BindView(R.id.gv_pic)
    MyGridView gvPic;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, null);
        unbinder = ButterKnife.bind(this, view);

        getBanner();
        getMainTheme();
        getNewVideos();
        getHotVideos();
//        getFiction();//小説
        getPictures();
        return view;
    }

    private void getBanner() {
        HttpRequest.getInstance().getBanner(FirstFragment.this, new HttpCallback<BannerModel>() {
            @Override
            public void onSuccess(BannerModel data) {
                try {
                    List list = new ArrayList();
                    int size = data.getData().size();
                    for (int i = 0; i < size; i++) {
                        list.add(data.getData().get(i).getL_logo());
                    }
                    if (null != getActivity()) {
                        BannerBaseView banner = new MainBannerView(getActivity());
                        bannerCont.addView(banner);
                        banner.update(list);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {
                Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMainTheme() {
        HttpRequest.getInstance().getMainTheme(FirstFragment.this, new HttpCallback<MainTheme>() {
            @Override
            public void onSuccess(MainTheme data) {
//                ThemeGradviewAdapter adapter = new ThemeGradviewAdapter(data.getData(), getActivity());
//                mygradviewTheme.setAdapter(adapter);
            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {

            }
        });
    }

    /**
     * 获取最新视频
     */
    private void getNewVideos() {
        HttpRequest.getInstance().getNewvideos(FirstFragment.this, new HttpCallback<NewVideosModel>() {
            @Override
            public void onSuccess(NewVideosModel data) {
                GradviewAdapter adapter = new GradviewAdapter(data.getData(), getActivity());
                gvNewvideo.setAdapter(adapter);
                Picasso.get().load(data.getData().getIcon_image())
                        .placeholder(R.mipmap.ic_yellow)
                        .error(R.mipmap.ic_yellow)
                        .config(Bitmap.Config.RGB_565)
                        .fit()
                        .centerCrop()
                        .into(ivNewVideo);
                tvTitleNewvideo.setText(data.getData().getTitle());
            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {

            }
        });
    }


    /**
     * 获取最热视频
     */
    private void getHotVideos() {
        HttpRequest.getInstance().getHotvideos(FirstFragment.this, new HttpCallback<NewVideosModel>() {
            @Override
            public void onSuccess(NewVideosModel data) {
                GradviewAdapter adapter = new GradviewAdapter(data.getData(), getActivity());
                gvHotvideo.setAdapter(adapter);
                Picasso.get().load(data.getData().getIcon_image())
                        .placeholder(R.mipmap.ic_yellow)
                        .error(R.mipmap.ic_yellow)
                        .config(Bitmap.Config.RGB_565)
                        .fit()
                        .centerCrop()
                        .into(ivHotVideo);
                tvTitleHotvideo.setText(data.getData().getTitle());

            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {

            }
        });


    }

    /**
     * 获取小说
     */
    private void getFiction() {
        HttpRequest.getInstance().getFiction(FirstFragment.this, new HttpCallback<FictionModel>() {
            @Override
            public void onSuccess(FictionModel data) {
                FictionAdapter adapter = new FictionAdapter(getActivity(), data);
                gvFiction.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                Picasso.get().load(data.getData().getIcon_image())
                        .placeholder(R.mipmap.ic_yellow)
                        .error(R.mipmap.ic_yellow)
                        .config(Bitmap.Config.RGB_565)
                        .fit()
                        .centerCrop()
                        .into(ivFiction);
            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {

            }
        });
    }

    /**
     * 获取首页的8个图片
     */
    private void getPictures() {
        HttpRequest.getInstance().getHomepic(FirstFragment.this, new HttpCallback<Fpicmodel>() {
            @Override
            public void onSuccess(Fpicmodel data) {
                GradviewPicAdapter adapter = new GradviewPicAdapter(data.getData().getList(), getActivity());
                gvPic.setAdapter(adapter);
                Picasso.get().load(data.getData().getIcon_image())
                        .placeholder(R.mipmap.ic_yellow)
                        .error(R.mipmap.ic_yellow)
                        .config(Bitmap.Config.RGB_565)
                        .fit()
                        .centerCrop()
                        .into(ivPic);
                tvPic.setText(data.getData().getTitle());
            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_new_video_more, R.id.iv_hot_video_more, R.id.iv_fiction_more, R.id.iv_pic_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_new_video_more:
                EventBus.getDefault().postSticky(new GoWhereEvent(1));
                break;
            case R.id.iv_hot_video_more:
                EventBus.getDefault().postSticky(new GoWhereEvent(1));
                break;
            case R.id.iv_fiction_more:
                EventBus.getDefault().postSticky(new GoWhereEvent(1));
                break;
            case R.id.iv_pic_more:
                EventBus.getDefault().postSticky(new GoWhereEvent(2));
                break;
        }
    }

}
