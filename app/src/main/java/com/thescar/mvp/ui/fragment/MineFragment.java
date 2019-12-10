package com.thescar.mvp.ui.fragment;

import com.blankj.utilcode.util.LogUtils;
import com.thescar.mvp.R;
import com.thescar.mvp.base.BasePresenter;
import com.thescar.mvp.base.MvpBaseFragment;
/**
 * @Author :TheScar
 * @Date :2019/12/10 13:22
 * @Email :han_shuaishuai@126.com
 * @Description : MineFragment
 */
public class MineFragment extends MvpBaseFragment {
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void onFragmentFirstVisible() {
        LogUtils.d("Fragment","MineFragment---onFragmentFirstVisible");
    }

    @Override
    protected void onFragmentResume() {
        LogUtils.d("Fragment","MineFragment---onFragmentResume");
    }

    @Override
    protected void onFragmentPause() {
        LogUtils.d("Fragment","MineFragment---onFragmentPause");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

}
