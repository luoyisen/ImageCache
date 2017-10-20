package com.example.i.imagecache.api;

import com.example.i.imagecache.MyApplication;
import com.example.i.imagecache.R;
import com.example.i.imagecache.bean.GankEntity;
import com.example.i.imagecache.bean.HttpResult;
import com.example.i.imagecache.bean.RandomEntity;
import com.example.i.imagecache.net.BuildApi;
import com.example.i.imagecache.presenter.MyCallBack;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/***
 * Created by I on 2017/9/26.
 */

public class GankApi {

    private final static String GET_DATA_FAIL = MyApplication.getIntstance().getString(R.string.gank_get_data_fail);
    private final static String NET_FAIL = MyApplication.getIntstance().getString(R.string.gank_net_fail);

    public static Call<HttpResult<List<GankEntity>>> getCommonDataNew(String type, int count, int pageIndex, final int what, final MyCallBack myCallBack) {
        Call<HttpResult<List<GankEntity>>> commonDateNew = BuildApi.getAPIService().getCommonDateNew(type, count, pageIndex);

        commonDateNew.enqueue(new Callback<HttpResult<List<GankEntity>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<GankEntity>>> call, Response<HttpResult<List<GankEntity>>> response) {
                if (response.isSuccessful()) {
                    HttpResult<List<GankEntity>> httpResult = response.body();
                    if (httpResult != null) {
                        if (!httpResult.isError()) {
                            List<GankEntity> gankEntityList = httpResult.getResults();
                            myCallBack.onSuccessList(what, gankEntityList);
                        } else {
                            myCallBack.onFail(what, GET_DATA_FAIL);
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<HttpResult<List<GankEntity>>> call, Throwable t) {
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });
        return commonDateNew;
    }

    public static Call<RandomEntity> getRandomDatas(String type, int count, final int what, final MyCallBack myCallBack) {

        Call<RandomEntity> randomDatasCall = BuildApi.getAPIService().getRandomDatas(type, count);

        randomDatasCall.enqueue(new Callback<RandomEntity>() {
            @Override
            public void onResponse(Call<RandomEntity> call, Response<RandomEntity> response) {
                if (response.isSuccessful()) {
                    RandomEntity body = response.body();
                    if (body != null) {
                        if (!body.isError()) {
                            myCallBack.onSuccessList(what, body.getResults());
                        } else {
                            myCallBack.onFail(what, GET_DATA_FAIL);
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<RandomEntity> call, Throwable t) {
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return randomDatasCall;
    }

//    public static Call<HttpResult<List<String>>> getHistoryData(final int what, final MyCallBack myCallBack) {
//
//        Call<HttpResult<List<String>>> gankHistoryDate = BuildApi.getAPIService().getGankHistoryDate();
//
//        gankHistoryDate.enqueue(new Callback<HttpResult<List<String>>>() {
//            @Override
//            public void onResponse(Call<HttpResult<List<String>>> call, Response<HttpResult<List<String>>> response) {
//                if (response.isSuccessful()) {
//                    HttpResult<List<String>> httpResult = response.body();
//                    if (httpResult != null) {
//                        if (!httpResult.isError()) {
//                            List<String> gankEntityList = httpResult.getResults();
//                            myCallBack.onSuccessList(what, gankEntityList);
//                        } else {
//                            myCallBack.onFail(what, GET_DATA_FAIL);
//                        }
//                    } else {
//                        myCallBack.onFail(what, GET_DATA_FAIL);
//                    }
//                } else {
//                    myCallBack.onFail(what, GET_DATA_FAIL);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<HttpResult<List<String>>> call, Throwable t) {
//                //数据错误
//                myCallBack.onFail(what, NET_FAIL);
//            }
//        });
//
//        return gankHistoryDate;
//
//    }
//
//    /**
//     * 获取一天的数据
//     *
//     * @param year
//     * @param month
//     * @param day
//     * @param what
//     * @param myCallBack
//     * @return
//     */
//    public static Call<DayEntity> getOneDayData(String year, String month, String day, final int what, final MyCallBack myCallBack) {
//
//        Call<DayEntity> oneDayData = BuildApi.getAPIService().getOneDayData(year, month, day);
//
//        oneDayData.enqueue(new Callback<DayEntity>() {
//            @Override
//            public void onResponse(Call<DayEntity> call, Response<DayEntity> response) {
//                if (response.isSuccessful()) {
//                    DayEntity body = response.body();
//                    if (body != null) {
//                        if (!body.isError()) {
//                            myCallBack.onSuccess(what, body);
//                        } else {
//                            myCallBack.onFail(what, GET_DATA_FAIL);
//                        }
//                    } else {
//                        myCallBack.onFail(what, GET_DATA_FAIL);
//                    }
//                } else {
//                    myCallBack.onFail(what, GET_DATA_FAIL);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<DayEntity> call, Throwable t) {
//                //数据错误
//                myCallBack.onFail(what, NET_FAIL);
//            }
//        });
//
//        return oneDayData;
//    }


//    public static Call<AppUpdateInfo> getAppUpdateInfo(final int what, final MyCallBack myCallBack) {
//
//        Call<AppUpdateInfo> theLastAppInfoCall = BuildApi.getAPIService().getTheLastAppInfo();
//
//        theLastAppInfoCall.enqueue(new Callback<AppUpdateInfo>() {
//            @Override
//            public void onResponse(Call<AppUpdateInfo> call, Response<AppUpdateInfo> response) {
//                if (response.isSuccessful()) {
//                    AppUpdateInfo body = response.body();
//                    if (body != null) {
//                        if (body.getName().equals("干货营")) {
//                            myCallBack.onSuccess(what, body);
//                        } else {
//                            myCallBack.onFail(what, GET_DATA_FAIL);
//                        }
//                    } else {
//                        myCallBack.onFail(what, GET_DATA_FAIL);
//                    }
//                } else {
//                    myCallBack.onFail(what, GET_DATA_FAIL);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<AppUpdateInfo> call, Throwable t) {
//                KLog.e("getRandomDatas-----onFailure：" + t.toString());
//                //数据错误
//                myCallBack.onFail(what, NET_FAIL);
//            }
//        });
//
//        return theLastAppInfoCall;
//    }
//
//
//    /**
//     * 获取搜索结果
//     *
//     * @param keyWord    关键字
//     * @param type       类型  category 后面可接受参数 all | Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
//     * @param count      搜索长度
//     * @param indexPage  页码
//     * @param what
//     * @param myCallBack
//     * @return
//     */
//    public static Call<HttpResult<List<SearchBean>>> getSearchData(String keyWord, String type, int count, int indexPage, final int what, final MyCallBack myCallBack) {
//
//        Call<HttpResult<List<SearchBean>>> ganSearchData = BuildApi.getAPIService().getSearchData(keyWord, type, count, indexPage);
//
//        ganSearchData.enqueue(new Callback<HttpResult<List<SearchBean>>>() {
//            @Override
//            public void onResponse(Call<HttpResult<List<SearchBean>>> call, Response<HttpResult<List<SearchBean>>> response) {
//                if (response.isSuccessful()) {
//                    HttpResult<List<SearchBean>> httpResult = response.body();
//                    if (httpResult != null) {
//                        if (!httpResult.isError()) {
//                            List<SearchBean> gankEntityList = httpResult.getResults();
//                            KLog.i("getHistoryData---success：" + gankEntityList.toString());
//                            myCallBack.onSuccessList(what, gankEntityList);
//                        } else {
//                            myCallBack.onFail(what, GET_DATA_FAIL);
//                        }
//                    } else {
//                        myCallBack.onFail(what, GET_DATA_FAIL);
//                    }
//                } else {
//                    myCallBack.onFail(what, GET_DATA_FAIL);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<HttpResult<List<SearchBean>>> call, Throwable t) {
//                KLog.e("getHistoryData-----onFailure：" + t.toString());
//                //数据错误
//                myCallBack.onFail(what, NET_FAIL);
//            }
//        });
//
//
//        return ganSearchData;
//
//    }
//
//    /***
//     * 获取城市列表
//     *
//     * @param what
//     * @param myCallBack
//     * @return
//     */
//    public static Call<CitysEntity> getCitys(final int what, final MyCallBack myCallBack) {
//
//        Call<CitysEntity> entityCall = BuildApi.getAPIService().getCitys(Constants.URL_APP_Key);
//
//        entityCall.enqueue(new Callback<CitysEntity>() {
//            @Override
//            public void onResponse(Call<CitysEntity> call, Response<CitysEntity> response) {
//                if (response.isSuccessful()) {
//                    CitysEntity citysEntity = response.body();
//                    if (citysEntity != null) {
//                        //保存
//                        UserUtils.saveCitysCache(citysEntity);
//                        if (citysEntity.getMsg().equals("success")) {
//                            KLog.i("getCitys---success：" + citysEntity.toString());
//                            myCallBack.onSuccessList(what, citysEntity.getResult());
//                        } else {
//                            myCallBack.onFail(what, GET_DATA_FAIL);
//                        }
//                    } else {
//                        myCallBack.onFail(what, GET_DATA_FAIL);
//                    }
//                } else {
//                    myCallBack.onFail(what, GET_DATA_FAIL);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CitysEntity> call, Throwable t) {
//                KLog.e("getCitys-----onFailure：" + t.toString());
//                //数据错误
//                myCallBack.onFail(what, NET_FAIL);
//            }
//        });
//
//        return entityCall;
//    }
//
//
//    /***
//     * 获取城市天气信息
//     *
//     * @param city
//     * @param province
//     * @param what
//     * @param myCallBack
//     * @return
//     */
//    public static Call<WeatherBeseEntity> getCityWeather(String city, String province, final int what, final MyCallBack myCallBack) {
//
//        Call<WeatherBeseEntity> weatherEntityCall = BuildApi.getAPIService().getCityWeather(Constants.URL_APP_Key, city, province);
//
//        weatherEntityCall.enqueue(new Callback<WeatherBeseEntity>() {
//            @Override
//            public void onResponse(Call<WeatherBeseEntity> call, Response<WeatherBeseEntity> response) {
//                if (response.isSuccessful()) {
//                    WeatherBeseEntity weatherBeseEntity = response.body();
//                    if (weatherBeseEntity != null) {
//                        if (weatherBeseEntity.getMsg().equals("success")) {
//                            KLog.i("getCityWeather---success：" + weatherBeseEntity.toString());
//                            myCallBack.onSuccessList(what, weatherBeseEntity.getResult());
//                        } else {
//                            myCallBack.onFail(what, GET_DATA_FAIL);
//                        }
//                    } else {
//                        myCallBack.onFail(what, GET_DATA_FAIL);
//                    }
//                } else {
//                    myCallBack.onFail(what, GET_DATA_FAIL);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<WeatherBeseEntity> call, Throwable t) {
//                KLog.e("getCityWeather-----onFailure：" + t.toString());
//                //数据错误
//                myCallBack.onFail(what, NET_FAIL);
//            }
//        });
//
//        return weatherEntityCall;
//    }
//
//    /***
//     * 获取万年历信息
//     *
//     * @param date
//     * @param what
//     * @param myCallBack
//     * @return
//     */
//    public static Call<MobBaseEntity<CalendarInfoEntity>> getCalendarInfo(String date, final int what, final MyCallBack myCallBack) {
//        Call<MobBaseEntity<CalendarInfoEntity>> calendarInfoCall = BuildApi.getAPIService().getCalendarInfo(Constants.URL_APP_Key, date);
//        calendarInfoCall.enqueue(new Callback<MobBaseEntity<CalendarInfoEntity>>() {
//            @Override
//            public void onResponse(Call<MobBaseEntity<CalendarInfoEntity>> call, Response<MobBaseEntity<CalendarInfoEntity>> response) {
//                if (response.isSuccessful()) {
//                    MobBaseEntity<CalendarInfoEntity> body = response.body();
//                    if (body != null) {
//                        if (body.getMsg().equals("success")) {
//                            KLog.i("getCalendarInfo---success：" + body.toString());
//                            myCallBack.onSuccess(what, body.getResult());
//                        } else {
//                            myCallBack.onFail(what, GET_DATA_FAIL);
//                        }
//                    } else {
//                        myCallBack.onFail(what, GET_DATA_FAIL);
//                    }
//                } else {
//                    myCallBack.onFail(what, GET_DATA_FAIL);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MobBaseEntity<CalendarInfoEntity>> call, Throwable t) {
//                KLog.e("getCalendarInfo-----onFailure：" + t.toString());
//                //数据错误
//                myCallBack.onFail(what, NET_FAIL);
//            }
//        });
//
//        return calendarInfoCall;
//    }

}
