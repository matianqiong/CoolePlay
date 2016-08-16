package com.example.mtq.cooleplaydemo.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

import com.example.mtq.cooleplaydemo.global.GooglePlayApplication;

/**
 * Created by mtq on 2016/7/4.
 */
public class UIUtils {

    public static Context getContext(){
        return GooglePlayApplication.getContext();
    }
    public static Handler getHandler(){
        return GooglePlayApplication.getHandler();
    }
    public static int getMainThreadId(){
     return GooglePlayApplication.getMainThreadId();
    }
    //获取资源文件字符串
    public static String getString(int id){
        return getContext().getResources().getString(id);
    }
    //获取资源文件字符串数组
    public static String[] getStringArrary(int id){
        return getContext().getResources().getStringArray(id);
    }
    //获取图片
    public static Drawable getDrawable(int id){
        return getContext().getResources().getDrawable(id);
    }
    //获取颜色
    public static int getColor(int id){
        return getContext().getResources().getColor(id);
    }

    //获取尺寸

    public static int getDemin(int id){
        return getContext().getResources().getDimensionPixelSize(id);
    }
    //dip转化成px
    public static int dip2px(int mIndicatorHeight) {
        float density=getContext().getResources().getDisplayMetrics().density;
        return (int) (mIndicatorHeight*density+0.5f);
    }
    //px转化成ｄｉｐ
    public static float px2dip(int px){
        float density=getContext().getResources().getDisplayMetrics().density;
        return px/density;
    }

    public static ColorStateList getColorStateList(int mTabTextColorResId) {

        return getContext().getResources().getColorStateList(mTabTextColorResId);

    }

    //加载布局文件
    public static View inflate(int resId){
        return View.inflate(getContext(),resId,null);
    }
    //判断是否在主线程
    public static boolean isRunOnUiThread(){
        int Tid= android.os.Process.myTid();
        if (Tid==getMainThreadId()){
            return true;
        }
        return false;
    }
    public static void runOnMainThread(Runnable r){
        if (isRunOnUiThread()){
            r.run();
        }else{
            getHandler().post(r);
        }
    }
}
