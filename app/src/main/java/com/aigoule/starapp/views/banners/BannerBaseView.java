package com.aigoule.starapp.views.banners;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.aigoule.starapp.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class BannerBaseView extends RelativeLayout implements BannerViewBehavior {
    /**
     * banner默认高宽比  height/width = 420/640(现在按照750*300)
     */
    private static final float BANNER_RATIO_DEFAULT = 0.65f;

    /**
     * indicator默认高宽比  height/width = 26/750
     */
    private static final float INDICATOR_RATIO_DEFAULT = 0.04f;

    /**
     * banner默认自动切换的时间
     */
    private static final int BANNER_CUT_TIME_DEFAULT = 4000;

    private LoopViewPager mViewPager;

    public LoopViewPager getViewPager() {
        return mViewPager;
    }

    // FIXME 当首页banner数据多于1条时，再添加页码指示器
    private CirclePageIndicator mIndicator;
    private PagerAdapter mAdapter;
    private Handler cutHandler;
    private Runnable cutRunnable;
    //private ResponseDataList bannerData;
    private List<String> bannerData;
    private int cutIndex;
    private Context context;

    public BannerBaseView(Context context) {

        this(context, null);
    }

    public BannerBaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        createView();
    }

    private int getScreenWidth() {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    private void createView() {
        this.setBackgroundColor(0xFFFFFFFF);
        int bannerHeight = (int) ((getScreenWidth() * BANNER_RATIO_DEFAULT));
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, bannerHeight);
        this.setLayoutParams(params);
        mViewPager = new LoopViewPager(getContext());
        mViewPager.setBoundaryCaching(true);
        this.addView(mViewPager, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        int indicatorHeight = (int) (getScreenWidth() * getIndicatorRatio());
        mIndicator = new CirclePageIndicator(getContext());
        setIndicatorParams(mIndicator, indicatorHeight);
        mIndicator.setOnPageChangeListener(new BannerCutListener());
        LayoutParams indicatorParams = new LayoutParams(LayoutParams.MATCH_PARENT, indicatorHeight);
        indicatorParams.bottomMargin = 6;
        indicatorParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        this.addView(mIndicator, indicatorParams);
    }


    //传进来数据
    @Override
    public void update(Object _data) {
        bannerData = (List<String>) _data;
        mAdapter = new BannerAdapter(bannerData);
        mViewPager.setAdapter(mAdapter);
        mIndicator.setViewPager(mViewPager);
        initCutHandler();
    }

    @Override
    public View getView() {

        return this;
    }

    private void initCutHandler() {
        if (cutHandler == null || cutRunnable == null) {
            cutHandler = new Handler();
            cutRunnable = new Runnable() {

                @Override
                public void run() {
                    if (mAdapter == null || bannerData == null || bannerData.size() <= 0) {
                        return;
                    }
                    if (cutIndex == mAdapter.getCount() - 1) {
                        cutIndex = 0;
                    } else {
                        cutIndex += 1;
                    }
                    mViewPager.setCurrentItem(cutIndex, true);
                    cutHandler.removeCallbacks(this);
                    cutHandler.postDelayed(this, getCutTime());
                }
            };
        }
        cutHandler.removeCallbacks(cutRunnable);
        cutHandler.postDelayed(cutRunnable, getCutTime());
    }

    private class BannerCutListener extends ViewPager.SimpleOnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            if (cutHandler != null && cutRunnable != null) {
                if (ViewPager.SCROLL_STATE_DRAGGING == state) {
                    cutHandler.removeCallbacks(cutRunnable);
                } else if (ViewPager.SCROLL_STATE_IDLE == state) {
                    cutHandler.removeCallbacks(cutRunnable);
                    cutHandler.postDelayed(cutRunnable, getCutTime());
                }
            }
        }

        @Override
        public void onPageSelected(int position) {
            cutIndex = position;
        }
    }

    public void onDestroyHandler() {
        if (cutHandler != null && cutRunnable != null) {
            cutHandler.removeCallbacks(cutRunnable);
        }
    }

    public void onStartChange() {
        if (cutHandler != null && cutRunnable != null) {
            cutHandler.removeCallbacks(cutRunnable);
            cutHandler.postDelayed(cutRunnable, getCutTime());
        }
    }

    protected float getBannerRatio() {
        return BANNER_RATIO_DEFAULT;
    }

    protected float getIndicatorRatio() {
        return INDICATOR_RATIO_DEFAULT;
    }

    protected int getCutTime() {
        return BANNER_CUT_TIME_DEFAULT;
    }

    protected void setIndicatorParams(CirclePageIndicator indicator, int indicatorHeight) {
        mIndicator.setPadding(0, indicatorHeight / 4, 0, 0);
        mIndicator.setRadius(indicatorHeight / 4);
        mIndicator.setPageColor(0x00FFFFFF);
        mIndicator.setFillColor(0xFFFFFFFF);
        mIndicator.setStrokeColor(0x66FFFFFF);
        mIndicator.setStrokeWidth(2);
        mIndicator.setSelectedRadius(indicatorHeight / 4 + 1);
        indicator.setCentered(true);
    }

    private class BannerAdapter extends PagerAdapter {
        private List datas;

        protected BannerAdapter(List datas) {
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(getContext());
            String d = (String) datas.get(position);
            Picasso.get().load(d)
                    .placeholder(R.mipmap.ic_yellow)
                    .error(R.mipmap.ic_yellow)
                    .config(Bitmap.Config.RGB_565)
                    .fit()
                    .centerCrop()
                    .into(imageView);

            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public void onDestroy() {
        mAdapter = null;
        mViewPager.setAdapter(null);
    }

}
