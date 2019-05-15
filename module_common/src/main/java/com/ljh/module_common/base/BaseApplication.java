package com.ljh.module_common.base;

import android.app.Application;

import com.ljh.module_common.util.Utils;

/**
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 *
 * @author Administrator
 * @date 2019/5/14
 */
public class BaseApplication extends Application {

    private static BaseApplication Instance;

    public static BaseApplication getInstance() {
        return Instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Instance = this;
        //通过utils来获取全局context
        Utils.init(this);
    }
}
