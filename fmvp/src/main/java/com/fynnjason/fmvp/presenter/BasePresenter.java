package com.fynnjason.fmvp.presenter;

import com.fynnjason.fmvp.view.IBaseView;

public  class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {
    protected T view;

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }

    protected boolean isViewAttached() {
        return view != null;
    }
}
