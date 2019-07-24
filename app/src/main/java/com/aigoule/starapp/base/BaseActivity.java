package com.aigoule.starapp.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.umeng.analytics.MobclickAgent;
import java.io.Serializable;


public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        //友盟数据统计
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }





    public static void openActivity(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }

    /**
     * 打开 Activity 的同时传递一个数据
     */
    protected <V extends Serializable> void openActivity(Class<?> cls, String key, V value) {
        openActivity(this, cls, key, value);
    }


    /**
     * 打开 Activity 的同时传递一个数据
     */
    public <V extends Serializable> void openActivity(Context context, Class<?> cls, String key, V value) {
        Intent intent = new Intent(context, cls);
        intent.putExtra(key, value);
        context.startActivity(intent);
    }



}
