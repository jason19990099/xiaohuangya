package com.aigoule.starapp.fragment.personalcenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aigoule.starapp.R;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.event.LoginDataEvent;
import com.aigoule.starapp.model.LoginModel;
import com.aigoule.starapp.model.UpdataModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 个人设置
 */
public class PersonSetFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.editext_psw)
    EditText editextPsw;
    @BindView(R.id.editext_phone)
    EditText editextPhone;
    @BindView(R.id.editext_qq)
    EditText editextQq;
    @BindView(R.id.editext_email)
    EditText editextEmail;
    @BindView(R.id.bt_makesure)
    Button btMakesure;
    private LoginModel.DataBean logindata;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personset, null);
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
        editextPsw.setText("***************");
        editextPhone.setText(logindata.getPhone());
        editextQq.setText(logindata.getQq());
        editextEmail.setText(logindata.getEmail());
    }

    @OnClick(R.id.bt_makesure)
    public void onViewClicked() {
        HttpRequest.getInstance().Update(PersonSetFragment.this,editextPsw.getText().toString(),editextPhone.getText().toString(),
                editextQq.getText().toString(),editextEmail.getText().toString(),
                new HttpCallback<UpdataModel>() {
            @Override
            public void onSuccess(UpdataModel data) {
                Toast.makeText(getActivity(), data.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {
                Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
