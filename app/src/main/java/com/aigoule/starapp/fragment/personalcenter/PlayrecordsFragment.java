package com.aigoule.starapp.fragment.personalcenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aigoule.starapp.R;
import com.aigoule.starapp.adapter.PlayRecordsAdapter;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.event.LoginEvent;
import com.aigoule.starapp.model.PlayRecordsModel;
import com.aigoule.starapp.views.MyListview;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PlayrecordsFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.lv_playrecords)
    MyListview lvPlayrecords;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playrecords, null);
        unbinder = ButterKnife.bind(this, view);
        getuserHisetory();
        return view;
    }

    private void getuserHisetory() {
        HttpRequest.getInstance().getUserHistory(PlayrecordsFragment.this, "1",
                new HttpCallback<PlayRecordsModel>() {
                    @Override
                    public void onSuccess(PlayRecordsModel data) {
                        if (data.isStatus()){
                            PlayRecordsAdapter playRecordsAdapter = new PlayRecordsAdapter(getActivity(), data);
                            lvPlayrecords.setAdapter(playRecordsAdapter);
                            playRecordsAdapter.notifyDataSetChanged();
                        }else{
                            EventBus.getDefault().postSticky(new LoginEvent());
                        }

                    }

                    @Override
                    public void onFailure(int msgCode, String errorMsg) {
                        Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
                    }
                });
    }

}


