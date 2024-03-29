package com.aigoule.starapp.activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.aigoule.starapp.R;
import com.aigoule.starapp.base.BaseActivity;
import com.aigoule.starapp.event.GoWhereEvent;
import com.aigoule.starapp.event.LoginEvent;
import com.aigoule.starapp.event.PicEvent;
import com.aigoule.starapp.event.playerEvent;
import com.aigoule.starapp.fragment.FirstFragment;
import com.aigoule.starapp.fragment.FourthFragment;
import com.aigoule.starapp.fragment.LoginRegistFragment;
import com.aigoule.starapp.fragment.PersonalCenterFragment;
import com.aigoule.starapp.fragment.PicFragment;
import com.aigoule.starapp.fragment.SecondFragment;
import com.aigoule.starapp.fragment.ThematicVideoFragment;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {
    @BindView(R.id.iv_new_video)
    ImageView ivNewVideo;
    @BindView(R.id.tv_title_newvideo)
    TextView tvTitleNewvideo;
    @BindView(R.id.view_fragment)
    FrameLayout viewFragment;
    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.iv_video)
    ImageView ivVideo;
    @BindView(R.id.tv_video)
    TextView tvVideo;
    @BindView(R.id.ll_video)
    LinearLayout llVideo;
    @BindView(R.id.iv_fuli)
    ImageView ivFuli;
    @BindView(R.id.tv_fuli)
    TextView tvFuli;
    @BindView(R.id.ll_fuli)
    LinearLayout llFuli;
    @BindView(R.id.iv_makemoney)
    ImageView ivMakemoney;
    @BindView(R.id.tv_makemoney)
    TextView tvMakemoney;
    @BindView(R.id.ll_makemoney)
    LinearLayout llMakemoney;
    @BindView(R.id.iv_mine)
    ImageView ivMine;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    @BindView(R.id.ll_mine)
    LinearLayout llMine;
    @BindView(R.id.editext_videos)
    EditText editextVideos;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    private FragmentManager mFragmentManager;  // Fragment管理器
    private long mClickTime;
    private int currentFragmentIndex = -1; //记录当前显示的fragment
    private Fragment[] fragments;
    private View[] mllViews;
    private LoginRegistFragment loginRegistFragment;
    private PicFragment PicFragment;
    private ThematicVideoFragment thematicVideoFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FirstFragment firstFragment = new FirstFragment();
        SecondFragment secondFragment = new SecondFragment();
        FourthFragment fourthFragment = new FourthFragment();
        PersonalCenterFragment fiveFragment = new PersonalCenterFragment();
        thematicVideoFragment = new ThematicVideoFragment();

        loginRegistFragment = new LoginRegistFragment();
        PicFragment = new PicFragment();

        mllViews = new View[]{llHome, llVideo, llFuli, llMakemoney, llMine};
        fragments = new Fragment[]{firstFragment, secondFragment, thematicVideoFragment, fourthFragment, fiveFragment};
        mFragmentManager = getSupportFragmentManager();
        changeShowFragment(0);


    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {//加上判断
            EventBus.getDefault().register(this);
        }
    }


    @OnClick({R.id.ll_home, R.id.ll_video, R.id.ll_fuli, R.id.ll_makemoney, R.id.ll_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                changeShowFragment(0);
                break;
            case R.id.ll_video:
                changeShowFragment(1);
                break;
            case R.id.ll_fuli:
                changeShowFragment(2);
                break;
            case R.id.ll_makemoney:
                changeShowFragment(3);
                break;
            case R.id.ll_mine:
                changeShowFragment(4);
                break;
        }
    }

    /**
     * 根据fragment数组下标，切换需要显示的fragment，并且隐藏当前的fragment
     */
    public void changeShowFragment(int index) {
        changeSelectState(index);
//        if (index != currentFragmentIndex) {
        Fragment showFragment = fragments[index];
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (!showFragment.isAdded()) {
            transaction.add(R.id.view_fragment, showFragment);
        }
        if (currentFragmentIndex != -1) {
            transaction.hide(fragments[currentFragmentIndex]);
        }
        transaction.show(showFragment);
        if (null != PicFragment)
            transaction.hide(PicFragment);
        if (null != loginRegistFragment)
            transaction.hide(loginRegistFragment);
        transaction.commitAllowingStateLoss();
        currentFragmentIndex = index;
//        }
    }


    private void changeSelectState(int index) {
        for (int i = 0; i < mllViews.length; i++) {
            mllViews[i].setSelected(index == i);
        }
    }

    /**
     * 跳转到播放界面
     */

    public void goPlayer() {
        startActivity(new Intent(this, PlayerActivity.class));
    }


    /**
     * 去图片的面页
     */
    public void goPicdetail() {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (null == PicFragment) {
            PicFragment = new PicFragment();
        }
        if (!PicFragment.isAdded()) {
            transaction.add(R.id.view_fragment, PicFragment);
        }
        if (currentFragmentIndex != -1) {
            transaction.hide(fragments[currentFragmentIndex]);
        }
        if (null != loginRegistFragment)
            transaction.hide(loginRegistFragment);
        transaction.show(PicFragment);
        transaction.commitAllowingStateLoss();
    }


    /**
     * 跳到登录界面
     */
    public void goLogin() {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (!loginRegistFragment.isAdded()) {
            transaction.add(R.id.view_fragment, loginRegistFragment);
        }
        if (currentFragmentIndex != -1) {
            transaction.hide(fragments[currentFragmentIndex]);
        }
        if (null != PicFragment)
            transaction.hide(PicFragment);
        transaction.show(loginRegistFragment);
        transaction.commitAllowingStateLoss();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(playerEvent event) {
        goPlayer();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(PicEvent event) {
        goPicdetail();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(LoginEvent event) {
        goLogin();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(GoWhereEvent event) {
        changeShowFragment(event.getIndex());
    }

    @Override
    public void onBackPressed() {
        long time = System.currentTimeMillis();
        if (time - mClickTime <= 2000) {
            super.onBackPressed();
            System.exit(0);
        } else {
            mClickTime = time;
            Toast.makeText(mContext, "再次点击退出", Toast.LENGTH_SHORT).show();
        }
    }


    @OnClick(R.id.iv_search)
    public void onViewClicked() {
        Intent intent=new Intent(this,SearchActivity.class);
        intent.putExtra("search_id",editextVideos.getText().toString().replace(" ",""));
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

}
