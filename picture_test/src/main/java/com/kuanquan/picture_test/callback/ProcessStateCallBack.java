package com.kuanquan.picture_test.callback;

import android.content.Intent;
import android.widget.ImageView;

import com.kuanquan.picture_test.InstagramMediaProcessActivity;

/**
 * ================================================
 * Created by JessYan on 2020/6/11 17:04
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface ProcessStateCallBack {
    void onBack(InstagramMediaProcessActivity activity);
    void onProcess(InstagramMediaProcessActivity activity);
    void onActivityResult(InstagramMediaProcessActivity activity, int requestCode, int resultCode, Intent data);
}
