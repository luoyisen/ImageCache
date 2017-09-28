package com.example.i.imagecache.api;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.i.imagecache.view.WallpaperBrowser;

import java.util.ArrayList;

/***
 * Created by I on 2017/9/26.
 */

public class IntentUtils {

    public static final String ImagePositionForImageShow = "PositionForImageShow";
    public static final String ImageArrayList = "BigImageArrayList";
    public static final String WebTitleFlag = "WebTitleFlag";
    public static final String WebTitle = "WebTitle";
    public static final String WebUrl = "WebUrl";
    public static final String DayDate = "DayDate";

    public static final String PushMessage = "PushMessage";

    public static void startToImageShow(Context context, ArrayList<String> mDatas, int position, View view) {

       WallpaperBrowser.showImageBrowser(context, view, position, mDatas);
    }
    public static void startAppShareText(Context context, String shareTitle, String shareText) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain"); // 纯文本
        shareIntent.putExtra(Intent.EXTRA_TITLE, shareTitle);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        //设置分享列表的标题，并且每次都显示分享列表
        context.startActivity(Intent.createChooser(shareIntent, "分享到"));
    }

}
