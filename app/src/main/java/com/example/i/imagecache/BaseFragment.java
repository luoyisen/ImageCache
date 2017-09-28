package com.example.i.imagecache;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.bigkoo.svprogresshud.SVProgressHUD;

/***
 * Created by I on 2017/9/26.
 */

public class BaseFragment extends Fragment {

    //统计名字判断
    public String className;

    private SVProgressHUD mSVProgressHUD;


    public Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        className = this.getClass().getSimpleName();

        context = getActivity();

        initDialog();

    }


    private void initDialog() {
        mSVProgressHUD = new SVProgressHUD(getActivity());
    }

    public void showProgressDialog() {
        dissmissProgressDialog();
        mSVProgressHUD.showWithStatus("加载中...", SVProgressHUD.SVProgressHUDMaskType.BlackCancel);
    }

    public void dissmissProgressDialog() {
        if (mSVProgressHUD.isShowing()) {
            mSVProgressHUD.dismiss();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //CategoryFragment 内嵌套Fragment,统计子页面
        if (!"CategoryFragment".equals(className)) {
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        //CategoryFragment 内嵌套Fragment,统计子页面
        if (!"CategoryFragment".equals(className)) {
        }

    }

}
