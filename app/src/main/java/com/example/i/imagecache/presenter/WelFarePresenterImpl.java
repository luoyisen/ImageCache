package com.example.i.imagecache.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.example.i.imagecache.api.Constants;
import com.example.i.imagecache.api.GankApi;
import com.example.i.imagecache.api.IntentUtils;
import com.example.i.imagecache.api.SharePreUtil;
import com.example.i.imagecache.bean.GankEntity;

import java.util.ArrayList;
import java.util.List;

/***
 * Created by I on 2017/9/27.
 */

public class WelFarePresenterImpl extends BasePresenterImpl<IWelFareView> implements IWelFarePresenter {

    private Context context;

    private List<GankEntity> welFareLists;
    private List<GankEntity> randomLists;
    private int pageSize = 20;
    private int pageIndex = 1;
    private ArrayList<String> imagesList = new ArrayList<>();

    public WelFarePresenterImpl(Context context, IWelFareView iWelFareView) {
        this.context = context;
        attachView(iWelFareView);
    }

    private MyCallBack httpCallBack = new MyCallBack() {
        @Override
        public void onSuccessList(int what, List results) {
            if(mView == null){
                return;
            }
            switch (what) {
                case 0x001:
                    if (results == null) {
                        mView.overRefresh();
                        return;
                    }
                    if (welFareLists == null) {
                        welFareLists = new ArrayList<>();
                    }
                    if (pageIndex == 1 && welFareLists.size() > 0) {
                        welFareLists.clear();
                    }
                    welFareLists.addAll(results);
                    mView.setWelFareList(welFareLists);
                    if (welFareLists == null || welFareLists.size() == 0 || welFareLists.size() < pageIndex * pageSize) {
                        mView.setLoadMoreEnabled(false);
                    } else {
                        mView.setLoadMoreEnabled(true);
                    }
                    pageIndex++;
                    mView.overRefresh();
                    break;
                case 0x002: //下拉刷新
                    if (results == null) {
                        mView.overRefresh();
                        return;
                    }
                    pageIndex = 1;
                    pageIndex++;
                    welFareLists = results;
                    if (welFareLists.size() > 0) {
                        mView.setWelFareList(welFareLists);
                    }
                    mView.overRefresh();
                    break;
                case 0x003: //头条，10条随机数
                    randomLists = results;
                    mView.setRandomList(randomLists);
                    break;
            }
        }

        @Override
        public void onSuccess(int what, Object result) {

        }

        @Override
        public void onFail(int what, String result) {
            if(mView == null){
                return;
            }
            mView.overRefresh();
            if (!TextUtils.isEmpty(result)) {
                mView.showToast(result);
            }
        }
    };

    @Override
    public void getNewDatas() {
        GankApi.getCommonDataNew(Constants.FlagWelFare, pageSize, 1, 0x002, httpCallBack);
        getRandomDatas();
    }

    @Override
    public void getMoreDatas() {
        GankApi.getCommonDataNew(Constants.FlagWelFare, pageSize, pageIndex, 0x001, httpCallBack);
    }

    @Override
    public void getRandomDatas() {
        //查看配置的干活类型:默认Android
        String headLineType = SharePreUtil.getStringData(context, Constants.SPSwitcherDataType, "Android");
        GankApi.getRandomDatas(headLineType,10, 0x003, httpCallBack);
    }

    @Override
    public void itemClick(View view, int position) {
        imagesList.clear();
        for (int i = 0; i < welFareLists.size(); i++) {
            imagesList.add(welFareLists.get(i).getUrl());
        }
        IntentUtils.startToImageShow(context, imagesList, position,view);
    }

}
