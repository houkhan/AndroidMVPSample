package com.thescar.mvp.ui.fragment;

import com.blankj.utilcode.util.LogUtils;
import com.thescar.mvp.R;
import com.thescar.mvp.base.BasePresenter;
import com.thescar.mvp.base.MvpBaseFragment;
/**
 * @Author :TheScar
 * @Date :2019/12/10 13:22
 * @Email :han_shuaishuai@126.com
 * @Description : FriendsFragment
 */
public class FriendsFragment extends MvpBaseFragment {
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void onFragmentFirstVisible() {
        LogUtils.d("Fragment","FriendsFragment---onFragmentFirstVisible");
    }

    @Override
    protected void onFragmentResume() {
        LogUtils.d("Fragment","FriendsFragment---onFragmentResume");
    }

    @Override
    protected void onFragmentPause() {
        LogUtils.d("Fragment","FriendsFragment---onFragmentPause");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_friends;
    }
}
