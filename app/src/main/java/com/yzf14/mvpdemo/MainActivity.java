package com.yzf14.mvpdemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.yzf14.mvpdemo.base.BaseActivity;
import com.yzf14.mvpdemo.base.BaseView;

public class MainActivity extends BaseActivity implements MvpView {

    ProgressDialog progressBarDialog;
    TextView textView;

    MvpPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);

        progressBarDialog = new ProgressDialog(this);
        progressBarDialog.setCancelable(false);
        progressBarDialog.setMessage("正在加载数据");

        presenter = new MvpPresenter();

        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    public void getData(View view) {
        presenter.getData("normal");
    }

    public void getDataForFailure(View view) {
        presenter.getData("failure");
    }

    public void getDataForError(View view) {
        presenter.getData("error");
    }
    @Override
    public void showLoading() {
        if (!progressBarDialog.isShowing()) {
            progressBarDialog.show();
        }
    }
    @Override
    public void hideLoading() {
        if (progressBarDialog.isShowing()) {
            progressBarDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showErr() {

    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void showData(String data) {
        textView.setText(data);
    }
}
