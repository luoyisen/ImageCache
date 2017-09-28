package com.example.i.imagecache.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import com.example.i.imagecache.R;
import com.example.i.imagecache.ui.WallpaperBrowserActivity;

import java.util.ArrayList;

/***
 * Created by I on 2017/9/28.
 */

public class WallpaperBrowser {
    public static void showImageBrowser(Context context, View view, int position, ArrayList<String> imageList) {
        Intent intent = new Intent(context, WallpaperBrowserActivity.class);
        intent.putExtra(WallpaperBrowserActivity.IntentKey_ImageList, imageList);
        intent.putExtra(WallpaperBrowserActivity.IntentKey_CurrentPosition, position);

        //android V4包的类,用于两个activity转场时的缩放效果实现
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
        try {
            ActivityCompat.startActivity(context, intent, optionsCompat.toBundle());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(R.anim.browser_enter_anim, 0);
        }
    }

}
