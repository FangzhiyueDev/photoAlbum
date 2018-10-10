package com.mingrisoft.photoAlbum.view;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RequestPermissionActivity extends AppCompatActivity implements RequestPermission {

    List<AppCompatActivity> list = new ArrayList<>();

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list.add(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        list.remove(this);
    }


    /**
     * 清空任务栈
     */
    public void clearTask() {
        for (AppCompatActivity activity : list) {
            activity.finish();
            list.remove(activity);
        }
    }


    public int requestCode;

    @Override
    public void requestPermissionMy(String[] requstPers, int code) {

        requestCode = code;
        List<String> deniet = new ArrayList<>();
        for (String per : requstPers) {
            if (ContextCompat.checkSelfPermission(this, per) !=
                    PackageManager.PERMISSION_GRANTED) {
                deniet.add(per);
            }
        }
        if (deniet.size() != 0) {
            ActivityCompat.requestPermissions(this, (String[]) deniet.toArray(), code);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == this.requestCode) {
            for (int value : grantResults) {
                if (value == PackageManager.PERMISSION_DENIED) {
                    requestFail();
                }
            }
            requestSecessful();
        }

    }

    @Override
    public void requestSecessful() {
        Toast.makeText(this, "权限申请成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void requestFail() {
        Toast.makeText(this, "权限申请失败", Toast.LENGTH_SHORT).show();
    }
}
