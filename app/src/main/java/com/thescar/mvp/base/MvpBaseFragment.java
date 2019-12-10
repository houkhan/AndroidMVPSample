package com.thescar.mvp.base;

import android.os.Bundle;
import android.view.View;

import com.thescar.mvp.ui.base.BaseFragment;

/**
 * @Author :TheScar
 * @Date :2019/12/10 13:17
 * @Email :han_shuaishuai@126.com
 * @Description : MvpBaseFragment
 */
public abstract class MvpBaseFragment<P extends BasePresenter> extends BaseFragment {
    protected P mvpPresenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter = createPresenter();
    }

    protected abstract P createPresenter();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }
}
