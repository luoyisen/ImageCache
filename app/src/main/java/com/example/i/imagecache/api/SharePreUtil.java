package com.example.i.imagecache.api;

import android.content.Context;
import android.content.SharedPreferences;

/***
 * Created by I on 2017/9/26.
 */

public class SharePreUtil {

    private static String CONFIG = "config";
    private static SharedPreferences sp;

    /**
     * 保存boolean类配置信息
     * @param context	上下文
     * @param key		键
     * @param value		值
     */
    public static void saveBooleanData(Context context, String key, boolean value){
        if(sp == null){
            sp = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).apply();
    }

    /**
     * 获取boolean类配置信息
     * @param context	上下文
     * @param key		键
     * @param defValue		值
     */
    public static boolean getBooleanData(Context context,String key,boolean defValue){
        if(sp == null){
            sp = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }

    /**
     * 保存String类型配置信息
     * @param context	上下文
     * @param key		键
     * @param value		值
     */
    public static void saveStringData(Context context,String key,String value){
        if(sp == null){
            sp = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).commit();
    }

    /**
     * 获取String类型配置信息
     * @param context	上下文
     * @param key		键
     * @param defValue		值
     */
    public static String getStringData(Context context,String key,String defValue){
        if(sp == null){
            sp = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        return sp.getString(key, defValue);
    }

    /**
     * 保存int类型配置信息
     * @param context	上下文
     * @param key		键
     * @param value		值
     */
    public static void saveIntData(Context context,String key,int value){
        if(sp == null){
            sp = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key, value).commit();
    }

    /**
     * 获取int类型配置信息
     * @param context	上下文
     * @param key		键
     * @param defValue		值
     */
    public static int getIntData(Context context,String key,int defValue){
        if(sp == null){
            sp = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        return sp.getInt(key, defValue);
    }

}
