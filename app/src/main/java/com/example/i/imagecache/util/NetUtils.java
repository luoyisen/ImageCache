package com.example.i.imagecache.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/***
 * Created by I on 2017/9/27.
 */

public class NetUtils {

    private static ConnectivityManager mConnectivityManager = null;

    private static ConnectivityManager getConnectivityManager(Context context) {
        if (mConnectivityManager == null) {
            mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
        }
        return mConnectivityManager;
    }


    public static boolean isNetworkConnected(Context ctx) {
        NetworkInfo activeNetworkInfo = getConnectivityManager(ctx).getActiveNetworkInfo();
        return (activeNetworkInfo != null && activeNetworkInfo.isAvailable());
    }


    public static boolean isWifiEnabled(Context context) {
        if (context != null) {
            NetworkInfo mWiFiNetworkInfo = getConnectivityManager(context)
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }

}