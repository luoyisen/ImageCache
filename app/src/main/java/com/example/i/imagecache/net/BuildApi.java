package com.example.i.imagecache.net;

import com.example.i.imagecache.MyApplication;
import com.example.i.imagecache.api.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/***
 * Created by I on 2017/9/26.
 */

public class BuildApi {

    private static Retrofit retrofit;

    public static WallpaperService getAPIService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(MyApplication.defaultOkHttpClient())
                    .build();
        }
        return retrofit.create(WallpaperService.class);
    }
}
