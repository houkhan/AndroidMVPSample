package com.thescar.mvp.ui.fragment;

import com.blankj.utilcode.util.LogUtils;
import com.thescar.mvp.R;
import com.thescar.mvp.base.BasePresenter;
import com.thescar.mvp.base.MvpBaseFragment;
/**
 * @Author :TheScar
 * @Date :2019/12/10 13:22
 * @Email :han_shuaishuai@126.com
 * @Description : MessageFragment
 */
public class MessageFragment extends MvpBaseFragment {
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void onFragmentFirstVisible() {
        LogUtils.d("Fragment","MessageFragment---onFragmentFirstVisible");
    }

    @Override
    protected void onFragmentResume() {
        LogUtils.d("Fragment","MessageFragment---onFragmentResume");
    }

    @Override
    protected void onFragmentPause() {
        LogUtils.d("Fragment","MessageFragment---onFragmentPause");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_message;
    }

}
