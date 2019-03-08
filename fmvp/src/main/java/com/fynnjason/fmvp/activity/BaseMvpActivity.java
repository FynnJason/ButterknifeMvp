package com.fynnjason.fmvp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.fynnjason.fmvp.presenter.IBasePresenter;
import com.fynnjason.fmvp.view.IBaseView;

import butterknife.ButterKnife;

public abstract class BaseMvpActivity<T extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(getActivity());
        presenter = getPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        initView();
        loadData();
    }

    public abstract T getPresenter();

    public abstract int getLayoutId();

    public void initView() {

    }

    public void loadData() {

    }

    public Activity getActivity() {
        return this;
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.detachView();
        }
        super.onDestroy();
    }
}
