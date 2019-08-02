package com.aigoule.starapp.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.widget.ZoomButtonsController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.aigoule.starapp.R;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.model.LotteryLinkModel;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FourthFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    Unbinder unbinder;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeContainer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, null);
        unbinder = ButterKnife.bind(this, view);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setBlockNetworkImage(false);// 解决图片不显示
        webSettings.setAllowContentAccess(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setAllowFileAccess(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        webview.requestFocus();
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        swipeContainer.setOnRefreshListener(FourthFragment.this);
        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        getLotterylink();
        return view;
    }

    /**
     * 获取彩票连接
     */
    private void getLotterylink() {
        HttpRequest.getInstance().getLotteryLinlk(FourthFragment.this, new HttpCallback<LotteryLinkModel>() {
            @Override
            public void onSuccess(LotteryLinkModel data) {
                String url = data.getData();
                webview.loadUrl(url);
                setZoomControlGone(webview);
                webview.setWebViewClient(new MyWebViewClient());
            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {
                Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onRefresh() {
        getLotterylink();
        swipeContainer.setRefreshing(false);
    }

    /**
     * 为了能够响应链接继续在本webview控件中显示，要声明此类。
     * 如果没有这个类，点击了一个链接后，系统会自动选择浏览器浏览
     */
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


    /**
     * 隐藏放大缩小控件
     */
    public void setZoomControlGone(View view) {
        Class classType;
        Field field;
        try {
            classType = WebView.class;
            field = classType.getDeclaredField("mZoomButtonsController");
            field.setAccessible(true);
            ZoomButtonsController mZoomButtonsController = new ZoomButtonsController(
                    view);
            mZoomButtonsController.getZoomControls().setVisibility(View.GONE);
            try {
                field.set(view, mZoomButtonsController);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
