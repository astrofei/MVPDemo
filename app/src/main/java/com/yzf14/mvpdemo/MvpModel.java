package com.yzf14.mvpdemo;

import android.os.Handler;

/**
 * Created by yzf14 on 2018/3/15.
 */

public class MvpModel {

    public static void  getNetData(final String params, final MvpCallBack mvpCallBack) {
        // 利用postDelayed方法模拟网络请求数据的耗时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (params){
                    case "normal":
                        mvpCallBack.onSuccess("根据参数"+params+"的请求网络数据成功");
                        break;
                    case "failure":
                        mvpCallBack.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        mvpCallBack.onError();
                        break;
                }
                mvpCallBack.onComplete();
            }
        },2000);

    }
}
