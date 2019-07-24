package com.aigoule.starapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.aigoule.starapp.R;
import com.aigoule.starapp.adapter.PicdetailAdapter;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.event.PicEvent;
import com.aigoule.starapp.model.PicdetailModel;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PicFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.lv_pic)
    ListView lvPic;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pic, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void getPicdetail(String id) {

        HttpRequest.getInstance().getPicdetail(PicFragment.this, id, new HttpCallback<PicdetailModel>() {
            @Override
            public void onSuccess(PicdetailModel data) {
            PicdetailAdapter adapter = new PicdetailAdapter(getActivity(), data.getData());
                lvPic.setAdapter(adapter);
                adapter.notifyDataSetChanged();
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
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(PicEvent event) {
        getPicdetail(event.getLinl_url());
    }
}
