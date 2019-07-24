package com.aigoule.starapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.aigoule.starapp.R;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.event.LoginDataEvent;
import com.aigoule.starapp.event.LoginEvent;
import com.aigoule.starapp.fragment.personalcenter.AccountFragment;
import com.aigoule.starapp.fragment.personalcenter.CollectionFragment;
import com.aigoule.starapp.fragment.personalcenter.InvitationFragment;
import com.aigoule.starapp.fragment.personalcenter.PersonSetFragment;
import com.aigoule.starapp.fragment.personalcenter.PlayrecordsFragment;
import com.aigoule.starapp.model.LoginModel;
import com.aigoule.starapp.utils.LogUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 个人中心
 */
public class PersonalCenterFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.tv_account)
    TextView tvAccount;
    @BindView(R.id.tv_personset)
    TextView tvPersonset;
    @BindView(R.id.tv_inviterecords)
    TextView tvInviterecords;
    @BindView(R.id.tv_playRecords)
    TextView tvPlayRecords;
    @BindView(R.id.tv_shoucangRecords)
    TextView tvShoucangRecords;
    @BindView(R.id.tv_loginout)
    TextView tvLoginout;
    @BindView(R.id.view_fragment)
    FrameLayout viewFragment;

    private LoginModel.DataBean logindata;
    private FragmentManager mFragmentManager;  // Fragment管理器
    private Fragment[] fragments;
    private View[] mllViews;
    private int currentFragmentIndex = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, null);
        unbinder = ButterKnife.bind(this, view);

        AccountFragment accountFragment = new AccountFragment();
        PersonSetFragment personSetFragment = new PersonSetFragment();
        InvitationFragment invitationFragment = new InvitationFragment();
        PlayrecordsFragment playrecordsFragment = new PlayrecordsFragment();
        CollectionFragment collectionFragment = new CollectionFragment();

        mFragmentManager = getChildFragmentManager();
        mllViews = new View[]{tvAccount, tvPersonset, tvInviterecords, tvPlayRecords, tvShoucangRecords};
        fragments = new Fragment[]{accountFragment, personSetFragment, invitationFragment, playrecordsFragment, collectionFragment};
        changeShowFragment(0);
        return view;
    }

    private void changeShowFragment(int index) {
        changeSelectState(index);
        if (index != currentFragmentIndex) {
        Fragment showFragment = fragments[index];
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (!showFragment.isAdded()) {
            transaction.add(R.id.view_fragment, showFragment);
        }
        if (currentFragmentIndex != -1) {
            transaction.hide(fragments[currentFragmentIndex]);
        }
        transaction.show(showFragment);
        transaction.commitAllowingStateLoss();
        currentFragmentIndex = index;
        }
    }

    private void changeSelectState(int index) {
        for (int i = 0; i < mllViews.length; i++) {
            mllViews[i].setSelected(index == i);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (HttpRequest.getInstance().getOid().equals("")) {
            EventBus.getDefault().postSticky(new LoginEvent());
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            if (HttpRequest.getInstance().getOid().equals("")) {
                EventBus.getDefault().postSticky(new LoginEvent());
            }
        }
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
    }


    @OnClick({R.id.tv_account,R.id.tv_personset, R.id.tv_inviterecords, R.id.tv_playRecords, R.id.tv_shoucangRecords, R.id.tv_loginout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_account:
                changeShowFragment(0);
                break;
            case R.id.tv_personset:
                changeShowFragment(1);
                break;
            case R.id.tv_inviterecords:
                changeShowFragment(2);
                break;
            case R.id.tv_playRecords:
                changeShowFragment(3);
                break;
            case R.id.tv_shoucangRecords:
                changeShowFragment(4);
                break;
            case R.id.tv_loginout:
                HttpRequest.getInstance().setOid();
                EventBus.getDefault().postSticky(new LoginEvent());
                break;
        }
    }


}
