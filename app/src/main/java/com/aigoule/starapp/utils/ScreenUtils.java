package com.aigoule.starapp.utils;

import android.content.Context;
import android.telephony.TelephonyManager;


public class ScreenUtils {
    /**
     *  获取屏幕的宽度
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        if (null ==context) {
            return 1080;
        }
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;

    }


    /**
     * 获取手机IMEI号
     *
     * 需要动态权限: android.permission.READ_PHONE_STATE
     */
    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();

        return imei;
    }
}
