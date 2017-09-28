package com.example.i.imagecache.presenter;

/***
 * Created by I on 2017/9/26.
 */

public class BasePresenterImpl<T> implements BasePresenter {

    T mView;

    void attachView(T mView) {
        this.mView = mView;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}