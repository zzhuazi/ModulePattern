package com.ljh.module_app;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ljh.module_common.base.BaseApplication;
import com.ljh.module_common.util.Utils;

/**
 * @author Ljh 2019/5/15 14:03
 */
public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (Utils.isAppDebug()) {
            //开启InstantRun之后，一定要在Arouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
