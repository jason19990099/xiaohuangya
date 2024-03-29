package com.aigoule.starapp.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.aigoule.starapp.R;
import com.aigoule.starapp.adapter.ListAllAdapter;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.event.OpenEvent;
import com.aigoule.starapp.model.BannerModel;
import com.aigoule.starapp.model.FirstpageModel;
import com.aigoule.starapp.utils.LogUtil;
import com.aigoule.starapp.utils.setListViewHeightBasedOnChildren;
import com.aigoule.starapp.views.banners.BannerBaseView;
import com.aigoule.starapp.views.banners.MainBannerView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FirstFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    Unbinder unbinder;
    @BindView(R.id.banner_cont)
    RelativeLayout bannerCont;
    @BindView(R.id.lv_all)
    ListView lvAll;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeContainer;
    private FirstpageModel datas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newfragment, null);
        unbinder = ButterKnife.bind(this, view);

        swipeContainer.setOnRefreshListener(FirstFragment.this);
        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        getBanner();//轮播图
        getHomeAll();//轮播图外的其他信息
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }


    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(OpenEvent event) {
        lvAll.setFocusable(false);
        ListAllAdapter adapter = new ListAllAdapter(datas.getData(), getActivity(),event.isOpen());
        lvAll.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        setListViewHeightBasedOnChildren.setListViewHeightBasedOnChildren(lvAll);
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


    private void getHomeAll() {
        HttpRequest.getInstance().getFirstAllmessage(FirstFragment.this, new HttpCallback<FirstpageModel>() {
            @Override
            public void onSuccess(FirstpageModel data) {
                datas=data;
                lvAll.setFocusable(false);
                ListAllAdapter adapter = new ListAllAdapter(data.getData(), getActivity(),false);
                lvAll.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                setListViewHeightBasedOnChildren.setListViewHeightBasedOnChildren(lvAll);
            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {
                Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onRefresh() {
        getBanner();//轮播图
        getHomeAll();//轮播图外的其他信息
        swipeContainer.setRefreshing(false);
    }
}
