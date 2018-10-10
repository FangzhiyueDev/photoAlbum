package com.mingrisoft.photoAlbum.view;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mingrisoft.photoAlbum.R;

public class MainActivity extends RequestPermissionActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //请求访问磁盘的权限
        initComponent();
    }

    /**
     * 初始化控件
     */
    private void initComponent() {



    }

    @Override
    public void requestFail() {
        super.requestFail();
        //异步加载数据
    }

    @Override
    public void requestSecessful() {
        super.requestSecessful();
    }
}
