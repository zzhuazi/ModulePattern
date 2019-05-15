package com.ljh.module_common.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Utils工具类
 *
 * @author Ljh 2019/5/14 22:38
 */
public class Utils {

    private static Context context;

    private Utils(){
        throw new UnsupportedOperationException("u can't instantiate me ...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context){
        Utils.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return applicationContext
     */
    public static Context getContext() {
        if(context != null) {
            return context;
        }
        throw new NullPointerException("u should init Utils first");
    }

    /**
     * 全局获取String的方法
     *
     * @param id 资源id
     * @return String
     */
    public static String getString(@StringRes int id){
        return context.getResources().getString(id);
    }

    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, int frameId){
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    public static <T> T checkNotNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

}
