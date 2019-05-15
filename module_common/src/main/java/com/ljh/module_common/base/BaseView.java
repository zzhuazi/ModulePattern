package com.ljh.module_common.base;

import androidx.annotation.Keep;

/**
 * View接口的基类
 *
 * @author Ljh 2019/5/14 23:20
 */
@Keep
public interface BaseView<T> {
    void setPresenter(T presenter);
}
