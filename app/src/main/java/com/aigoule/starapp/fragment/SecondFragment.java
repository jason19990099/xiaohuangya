package com.aigoule.starapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.aigoule.starapp.R;
import com.aigoule.starapp.adapter.VideoClassdatAdapter;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.model.AllvidesModel;
import com.aigoule.starapp.model.VideoclassdataModel;
import com.aigoule.starapp.views.MyGridView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SecondFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener  {
    Unbinder unbinder;
    @BindView(R.id.rg_video)
    RadioButton rgVideo;
    @BindView(R.id.rg_fiction)
    RadioButton rgFiction;
    @BindView(R.id.rg_group_call_mute)
    RadioButton rgGroupCallMute;
    @BindView(R.id.rg_call_voice_desc)
    RadioGroup rgCallVoiceDesc;
    @BindView(R.id.rg_videos)
    RadioGroup rgVideos;
    @BindView(R.id.gv_classdata)
    MyGridView gvClassdata;
    @BindView(R.id.huadong)
    HorizontalScrollView huadong;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeContainer;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two, null);
        unbinder = ButterKnife.bind(this, view);
        swipeContainer.setOnRefreshListener(SecondFragment.this);
        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        getAllvideos();
        return view;
    }

    /**
     * 获取全部分類
     */
    private void getAllvideos() {
        HttpRequest.getInstance().getAllvideos(SecondFragment.this, new HttpCallback<AllvidesModel>() {
            @Override
            public void onSuccess(AllvidesModel data) {
                try {
                    getNewVideos(String.valueOf(data.getData().get(0).getClass_id()));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                }


                int size = data.getData().size();
                for (int i = 0; i < size; i++) {
                    RadioButton tempButton = new RadioButton(getActivity());
//                    tempButton.setBackgroundResource(null);	// 设置RadioButton的背景图片
                    tempButton.setButtonDrawable(null);            // 设置按钮的样式
                    tempButton.setPadding(30, 0, 0, 0);                // 设置文字距离按钮四周的距离
                    tempButton.setTextSize(15);
                    tempButton.setText(data.getData().get(i).getName());
                    tempButton.setTextColor(getResources().getColorStateList(R.color.selector_rb_txt_color));
                    rgVideos.addView(tempButton, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                }
                rgVideos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        try {
                            getNewVideos(String.valueOf(data.getData().get(checkedId - 1).getClass_id()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                        }

                    }
                });

            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {

            }
        });
    }

    /**
     * 获取某一类的相关视频
     */
    private void getNewVideos(String cid) {
        HttpRequest.getInstance().getVideoclassdata(SecondFragment.this, cid, new HttpCallback<VideoclassdataModel>() {
            @Override
            public void onSuccess(VideoclassdataModel data) {
                VideoClassdatAdapter adapter = new VideoClassdatAdapter(getActivity(), data.getData());
                gvClassdata.setAdapter(adapter);
            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {
            }
        });
    }

    @Override
    public void onRefresh() {
        getAllvideos();
        swipeContainer.setRefreshing(false);
    }
}
