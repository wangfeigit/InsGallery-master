package com.kuanquan.picture_test.util;

import android.os.Build;
import android.text.TextUtils;

/**
 * @author：luck
 * @date：2019-07-17 15:12
 * @describe：Android Sdk版本判断
 */
public class SdkVersionUtils {
    /**
     * 判断是否是Android Q版本
     *
     * @return
     */
    public static boolean checkedAndroid_Q() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q;
    }

    /**
     * is content://
     *
     * @param url
     * @return
     */
    public static boolean isContent(String url) {
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        return url.startsWith("content://");
    }

}
