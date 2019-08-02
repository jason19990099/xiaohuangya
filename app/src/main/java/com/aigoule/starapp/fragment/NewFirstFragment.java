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
import com.aigoule.starapp.R;
import com.aigoule.starapp.adapter.ListAllAdapter;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.model.BannerModel;
import com.aigoule.starapp.model.FirstpageModel;
import com.aigoule.starapp.utils.setListViewHeightBasedOnChildren;
import com.aigoule.starapp.views.banners.BannerBaseView;
import com.aigoule.starapp.views.banners.MainBannerView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NewFirstFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.banner_cont)
    RelativeLayout bannerCont;
    @BindView(R.id.lv_all)
    ListView lvAll;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newfragment, null);
        unbinder = ButterKnife.bind(this, view);
        getBanner();//轮播图
        getHomeAll();//轮播图外的其他信息
        return view;
    }

    private void getBanner() {
        HttpRequest.getInstance().getBanner(NewFirstFragment.this, new HttpCallback<BannerModel>() {
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
        HttpRequest.getInstance().getFirstAllmessage(NewFirstFragment.this, new HttpCallback<FirstpageModel>() {
            @Override
            public void onSuccess(FirstpageModel data) {
                ListAllAdapter adapter=new ListAllAdapter(data.getData(),getActivity());
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


}
