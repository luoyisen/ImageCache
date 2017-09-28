package com.example.i.imagecache.presenter;

import android.view.View;

/***
 * Created by I on 2017/9/27.
 */

public interface IWelFarePresenter {

    void getNewDatas();

    void getMoreDatas();

    void getRandomDatas();

    void itemClick(View view, int position);

}