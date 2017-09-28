package com.example.i.imagecache.net;

import com.example.i.imagecache.api.Constants;
import com.example.i.imagecache.bean.DayEntity;
import com.example.i.imagecache.bean.GankEntity;
import com.example.i.imagecache.bean.HttpResult;
import com.example.i.imagecache.bean.RandomEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/***
 * Created by I on 2017/9/26.
 */


public interface WallpaperService {

    @Headers("Cache-Control: public, max-age=3600")
    @GET(Constants.URL_HistoryDate)
    Call<HttpResult<List<String>>> getGankHistoryDate();

    //http://gank.io/api/data/Android/10/1
    @Headers("Cache-Control: public, max-age=120")
    @GET("data/{type}/{count}/{pageIndex}")
    Call<HttpResult<List<GankEntity>>> getCommonDateNew(@Path("type") String type,
                                                        @Path("count") int count,
                                                        @Path("pageIndex") int pageIndex
    );

    //http://gank.io/api/day/2015/08/06 --- 每日数据
    @Headers("Cache-Control: public, max-age=300")
    @GET("day/{year}/{month}/{day}")
    Call<DayEntity> getOneDayData(@Path("year") String year,
                                  @Path("month") String month,
                                  @Path("day") String day
    );

    //http://gank.io/api/random/data/Android/5 --- 随机数据
    @Headers("Cache-Control: public, max-age=300")
    @GET("random/data/{type}/{count}")
    Call<RandomEntity> getRandomDatas(@Path("type") String type,
                                      @Path("count") int count
    );


}
