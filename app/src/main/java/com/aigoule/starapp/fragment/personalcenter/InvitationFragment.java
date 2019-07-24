package com.aigoule.starapp.fragment.personalcenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aigoule.starapp.R;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.event.LoginEvent;
import com.aigoule.starapp.model.InvitationListModel;
import com.aigoule.starapp.views.MyListview;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class InvitationFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.tv_inviteurl)
    TextView tvInviteurl;
    @BindView(R.id.lv_playrecords)
    MyListview lvPlayrecords;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invitation, null);
        unbinder = ButterKnife.bind(this, view);
        getInvitationList();
        return view;
    }

    private void getInvitationList() {
        HttpRequest.getInstance().getInvitationList(InvitationFragment.this, new HttpCallback<InvitationListModel>() {
            @Override
            public void onSuccess(InvitationListModel data) {
                if (data.isStatus()){
                    tvInviteurl.setText(data.getData().getInvite_url());
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
