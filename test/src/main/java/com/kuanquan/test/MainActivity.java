package com.kuanquan.test;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.kuanquan.picture_test.InstagramMediaProcessActivity;
import com.kuanquan.picture_test.model.LocalMedia;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.image_view);
        EventBus.getDefault().register(this);
        if (PermissionChecker
                .checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) &&
                PermissionChecker
                        .checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        ) {

        } else {
            PermissionChecker.requestPermissions(
                    this, new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 0x01
            );
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String str) {
        Glide.with(mImageView)
                .load(str)
                .into(mImageView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onClick(View view) {
        List<LocalMedia> result = new ArrayList<>();
        LocalMedia localMedia = new LocalMedia();
        localMedia.setFileName("VID_20210929_18262509.mp4");
        localMedia.setDuration(17024); // 毫秒
//        localMedia.setHeight(1200);
//        localMedia.setWidth(1600);
//        localMedia.setSize(5637854);
        localMedia.setParentFolderName("Camera");
        localMedia.setPath("/storage/emulated/0/DCIM/Camera/VID_20210929_18262509.mp4");
        localMedia.setRealPath("/storage/emulated/0/DCIM/Camera/VID_20210929_18262509.mp4");
        result.add(localMedia);

        InstagramMediaProcessActivity.launchActivity(this, result);
    }
}