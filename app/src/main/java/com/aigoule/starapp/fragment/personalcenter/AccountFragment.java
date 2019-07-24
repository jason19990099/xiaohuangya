package com.aigoule.starapp.fragment.personalcenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aigoule.starapp.R;
import com.aigoule.starapp.event.LoginDataEvent;
import com.aigoule.starapp.model.LoginModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AccountFragment extends Fragment {
    @BindView(R.id.tv_god)
    TextView tvGod;
    @BindView(R.id.tv_points)
    TextView tvPoints;
    @BindView(R.id.tv_logintime)
    TextView tvLogintime;
    @BindView(R.id.tv_login_ip)
    TextView tvLoginIp;
    private LoginModel.DataBean logindata;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_acount, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {//加上判断
            EventBus.getDefault().register(this);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(LoginDataEvent event) {
        logindata = event.getData();
        tvLogintime.setText(logindata.getLogintime());
        tvLoginIp.setText(logindata.getU_loginip());
        tvGod.setText("会员类型：" + logindata.getGroup_name());
        tvPoints.setText(logindata.getU_points() + " 积分");
    }


}
