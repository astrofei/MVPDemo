package com.yzf14.mvpdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MvpView{

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

        presenter = new MvpPresenter(this);
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
    public void showData(String data) {
        textView.setText(data);
    }
    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        textView.setText(msg);
    }
    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "网络请求数据出现异常", Toast.LENGTH_SHORT).show();
        textView.setText("网络请求数据出现异常");
    }
}
