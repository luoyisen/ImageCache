package com.example.i.imagecache.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.example.i.imagecache.BaseFragment;
import com.example.i.imagecache.MainActivity;
import com.example.i.imagecache.R;
import com.example.i.imagecache.adapter.RecyclePicAdapter;
import com.example.i.imagecache.bean.GankEntity;
import com.example.i.imagecache.presenter.IWelFareView;
import com.example.i.imagecache.presenter.WelFarePresenterImpl;
import com.example.i.imagecache.view.MySnackbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/***
 * Created by I on 2017/9/27.
 */
public class WallpaperFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener, IWelFareView {

    @BindView(R.id.swipe_target)
    RecyclerView swipeTarget;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;

    private Unbinder unbinder;
    private RecyclePicAdapter recyclePicAdapter;

    private WelFarePresenterImpl welFarePresenter;

    public static WallpaperFragment newInstance() {
        return new WallpaperFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wel_fare, container, false);
        unbinder = ButterKnife.bind(this, view);

        initRefresh();

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        welFarePresenter = new WelFarePresenterImpl(getActivity(), this);

        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(true);
            }
        }, 100);
    }

    private void initRecycleView(List<GankEntity> welFareList) {

        ((MainActivity) getActivity()).setPicList(welFareList);

        if (recyclePicAdapter == null) {
            recyclePicAdapter = new RecyclePicAdapter(context, welFareList);
            swipeTarget.setAdapter(recyclePicAdapter);
            //点击事件
            recyclePicAdapter.setOnItemClickLitener(new RecyclePicAdapter.OnItemClickLitener() {
                @Override
                public void onItemClick(View view, int position) {
                    welFarePresenter.itemClick(view,position);
                }
            });
            //获取头条随机
            welFarePresenter.getRandomDatas();
        } else {
            recyclePicAdapter.updateDatas(welFareList);
        }

    }

    private void initRefresh() {
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        swipeTarget.setLayoutManager(staggeredGridLayoutManager);
        swipeTarget.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onRefresh() {
        welFarePresenter.getNewDatas();
    }

    @Override
    public void setWelFareList(List<GankEntity> welFareList) {
        initRecycleView(welFareList);
    }

    @Override
    public void setRandomList(List<GankEntity> randomList) {
        if (recyclePicAdapter != null) {
            recyclePicAdapter.updateHeadLines(randomList);
        }
    }

    @Override
    public void showToast(String msg) {
        MySnackbar.makeSnackBarRed(swipeTarget, msg);
    }

    @Override
    public void overRefresh() {
        swipeToLoadLayout.setRefreshing(false);
        swipeToLoadLayout.setLoadingMore(false);
    }

    @Override
    public void setLoadMoreEnabled(boolean flag) {
        swipeToLoadLayout.setLoadMoreEnabled(flag);
    }

    @Override
    public void onLoadMore() {
        welFarePresenter.getMoreDatas();
    }


    @Override
    public void onDestroyView() {
        if (recyclePicAdapter != null) {
            recyclePicAdapter.destroyList();
        }
        welFarePresenter.detachView();
        super.onDestroyView();
        unbinder.unbind();
    }

}
