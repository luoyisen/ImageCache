package com.example.i.imagecache.presenter;

import com.example.i.imagecache.bean.GankEntity;

import java.util.List;

/***
 * Created by I on 2017/9/27.
 */

public interface IWelFareView {

    void setWelFareList(List<GankEntity> welFareList);

    void setRandomList(List<GankEntity> randomList);

    void showToast(String msg);

    void overRefresh();

    void setLoadMoreEnabled(boolean flag);

}
