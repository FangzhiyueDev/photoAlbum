package com.mingrisoft.photoAlbum.view;

public interface RequestPermission {


    void requestPermissionMy(String[] requstPers,int code);

    void requestSecessful();

    void requestFail();


}
