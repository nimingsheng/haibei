package com.nms.mydemo.seashell.httputils;

/**
 * Created by my on 2016/3/4.
 */
public interface RequestCallBack {
    public void onSuccess(String result, int requestCode);
    public void onFailed();
}
