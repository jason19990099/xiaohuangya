package com.aigoule.starapp.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.aigoule.starapp.R;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.event.GoWhereEvent;
import com.aigoule.starapp.event.LoginDataEvent;
import com.aigoule.starapp.model.LoginModel;
import com.aigoule.starapp.model.RegistMosdel;
import com.aigoule.starapp.utils.SharePreferencesUtil;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 登陸注冊
 */
public class LoginRegistFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.rb_login)
    RadioButton rbLogin;
    @BindView(R.id.rb_reg)
    RadioButton rbReg;
    @BindView(R.id.radiogroup)
    RadioGroup radiogroup;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_psw)
    EditText etPsw;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.login_getbackpsw)
    TextView loginGetbackpsw;
    @BindView(R.id.login_reg)
    TextView loginReg;
    @BindView(R.id.ll_login)
    LinearLayout llLogin;
    @BindView(R.id.editext_mail)
    EditText editextMail;
    @BindView(R.id.editext_psw)
    EditText editextPsw;
    @BindView(R.id.editext_psw_makesure)
    EditText editextPswMakesure;
    @BindView(R.id.bt_reg)
    Button btReg;
    @BindView(R.id.ll_reg)
    LinearLayout llReg;
    @BindView(R.id.editext_regname)
    EditText editextRegname;
    @BindView(R.id.editext_tuiguang)
    EditText editextTuiguang;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, null);
        unbinder = ButterKnife.bind(this, view);

        radiogroup.check(R.id.rb_login);
        rbLogin.setBackgroundColor(getResources().getColor(R.color.rb_yellow));
        rbReg.setBackgroundColor(getResources().getColor(R.color.white));
        llLogin.setVisibility(View.VISIBLE);
        llReg.setVisibility(View.GONE);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View checkView = view.findViewById(checkedId);
                if (!checkView.isPressed()) {
                    return;
                }
                switch (checkedId) {
                    case R.id.rb_login:
                        rbLogin.setBackgroundColor(getResources().getColor(R.color.rb_yellow));
                        rbReg.setBackgroundColor(getResources().getColor(R.color.white));
                        llLogin.setVisibility(View.VISIBLE);
                        llReg.setVisibility(View.GONE);
                        break;
                    case R.id.rb_reg:
                        rbLogin.setBackgroundColor(getResources().getColor(R.color.white));
                        rbReg.setBackgroundColor(getResources().getColor(R.color.rb_yellow));
                        llReg.setVisibility(View.VISIBLE);
                        llLogin.setVisibility(View.GONE);
                        break;
                }
            }
        });
        return view;
    }

    @OnClick({R.id.bt_login, R.id.login_getbackpsw, R.id.login_reg, R.id.bt_reg})
    public void onViewClicked(View view) {
        if (null == getActivity()) return;
        switch (view.getId()) {
            case R.id.bt_login:
                String name = etName.getText().toString().replace(" ", "");
                String psw = etPsw.getText().toString().replace(" ", "");
                HttpRequest.getInstance().login(LoginRegistFragment.this, name, psw, new HttpCallback<LoginModel>() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onSuccess(LoginModel data) {
                        if (data.isStatus()) {
                            Toast.makeText(getActivity(), "登录成功！", Toast.LENGTH_SHORT).show();
                            EventBus.getDefault().postSticky(new GoWhereEvent(4));
                            EventBus.getDefault().postSticky(new LoginDataEvent(data.getData()));
                            HttpRequest.getInstance().setOid(String.valueOf(data.getData().getId()));
                            SharePreferencesUtil.addString(getActivity(), "id", String.valueOf(data.getData().getId()));
                        } else {
                            Toast.makeText(getActivity(), data.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(int msgCode, String errorMsg) {
                        Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.login_getbackpsw:
                break;
            case R.id.bt_reg:
                String name2 = editextRegname.getText().toString().replace(" ", "");
                String email = editextMail.getText().toString().replace(" ", "");
                String password = editextPsw.getText().toString().replace(" ", "");
                String password_confirm = editextPswMakesure.getText().toString().replace(" ", "");
                String tg=editextTuiguang.getText().toString().replace(" ","");
                HttpRequest.getInstance().registe(LoginRegistFragment.this, name2, email, password, password_confirm,tg, new HttpCallback<RegistMosdel>() {
                    @Override
                    public void onSuccess(RegistMosdel data) {
                        if (data.isStatus()) {
                            Toast.makeText(getActivity(), "注册成功,请登录.", Toast.LENGTH_SHORT).show();
                            radiogroup.check(R.id.rb_login);
                            rbLogin.setBackgroundColor(getResources().getColor(R.color.rb_yellow));
                            rbReg.setBackgroundColor(getResources().getColor(R.color.white));
                            llLogin.setVisibility(View.VISIBLE);
                            llReg.setVisibility(View.GONE);

                        } else {
                            Toast.makeText(getActivity(), data.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(int msgCode, String errorMsg) {
                        Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.login_reg:
                radiogroup.check(R.id.rb_reg);
                rbReg.setBackgroundColor(getResources().getColor(R.color.rb_yellow));
                rbLogin.setBackgroundColor(getResources().getColor(R.color.white));
                llLogin.setVisibility(View.GONE);
                llReg.setVisibility(View.VISIBLE);
                break;
        }
    }
}
