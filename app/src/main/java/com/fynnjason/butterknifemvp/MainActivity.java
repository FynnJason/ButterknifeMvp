package com.fynnjason.butterknifemvp;


import android.widget.TextView;

import com.fynnjason.fmvp.activity.BaseMvpActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainView {

    @BindView(R.id.tv_text)
    TextView tvText;

    @Override
    public MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void upText(String s) {
        tvText.setText(s);
        showToast(s);
    }


    @OnClick(R.id.btn_click)
    public void onViewClicked() {
        presenter.setText();
    }
}
