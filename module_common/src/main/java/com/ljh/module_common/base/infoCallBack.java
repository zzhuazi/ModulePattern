package com.ljh.module_common.base;

/**
 * 数据回调接口
 *
 * @author Ljh 2019/5/14 23:22
 */
public interface infoCallBack<T> {
    void onSuccess(T info);

    void onError(int code, String message);
}
