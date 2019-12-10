package com.thescar.mvp.base;

import android.os.Bundle;

import com.thescar.mvp.ui.base.BaseActivity;
/**
 * @Author :TheScar
 * @Date :2019/12/10 13:17
 * @Email :han_shuaishuai@126.com
 * @Description : MvpBaseActivity
 */
public abstract class MvpBaseActivity<P extends BasePresenter> extends BaseActivity {
    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }

    public void showLoading() {
        showProgressDialog();
    }

    public void hideLoading() {
        dismissProgressDialog();
    }
}
