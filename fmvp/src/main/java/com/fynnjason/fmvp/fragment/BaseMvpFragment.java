package com.fynnjason.fmvp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fynnjason.fmvp.presenter.IBasePresenter;
import com.fynnjason.fmvp.view.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseMvpFragment<T extends IBasePresenter> extends Fragment implements IBaseView {

    public T presenter;
    public View mView;
    public Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null)
            mView = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(getFragment(), mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        loadData();
    }

    public abstract T getPresenter();

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        if (presenter != null) {
            presenter.detachView();
        }
        super.onDestroy();
    }

    public abstract int getLayoutId();

    public void initView() {

    }

    public void loadData() {

    }

    private Fragment getFragment() {
        return this;
    }
}
