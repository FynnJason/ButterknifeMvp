package com.fynnjason.butterknifemvp;

import com.fynnjason.fmvp.presenter.BasePresenter;

public class MainPresenter extends BasePresenter<MainView> {
    public void setText() {
        if (isViewAttached()) {
            view.upText("it`s mvp");
        }
    }
}
