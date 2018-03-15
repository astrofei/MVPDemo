package com.yzf14.mvpdemo;

/**
 * Created by yzf14 on 2018/3/15.
 */

public class MvpPresenter {

    MvpView mMvpView;

    MvpPresenter(MvpView mvpView) {
        this.mMvpView = mvpView;
    }
    /**
     * 获取网络数据
     * @param params
     */
    public void getData(String params) {
        // 显示正在加载进度条
        mMvpView.showLoading();
        MvpModel.getNetData(params, new MvpCallBack() {
            @Override
            public void onSuccess(String data) {
                //调用view接口显示数据
                mMvpView.showData(data);
            }

            @Override
            public void onFailure(String msg) {
                //调用view接口提示失败信息
                mMvpView.showFailureMessage(msg);
            }

            @Override
            public void onError() {
                //调用view接口提示请求异常
                mMvpView.showErrorMessage();
            }

            @Override
            public void onComplete() {
                // 隐藏正在加载进度条
                mMvpView.hideLoading();
            }
        });
    }
}
