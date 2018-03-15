package com.yzf14.mvpdemo;

import com.yzf14.mvpdemo.base.BaseView;

/**
 * Created by yzf14 on 2018/3/15.
 */

public interface MvpView extends BaseView{

    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(String data);
}
