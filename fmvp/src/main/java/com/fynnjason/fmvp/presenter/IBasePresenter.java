package com.fynnjason.fmvp.presenter;

import com.fynnjason.fmvp.view.IBaseView;

public interface IBasePresenter<T extends IBaseView> {
    void attachView(T view);

    void detachView();
}
