package com.thescar.mvp.ui.base;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.SPUtils;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.thescar.mvp.App.OverallConstants;
import com.thescar.mvp.R;

import java.util.List;

import androidx.fragment.app.FragmentManager;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

/**
 * @Author :TheScar
 * @Date :2019/12/10 13:21
 * @Email :han_shuaishuai@126.com
 * @Description : BaseFragment
 */
public abstract class BaseFragment extends Fragment implements OverallConstants {

    public Activity mActivity;
    private View mView;
    public SPUtils sp;
    public Intent intent;
    protected Toast mToast;
    private QMUITipDialog progressDialog;
    private Unbinder mUnbinder;
    /*当前Fragment是否是首次可见*/
    private boolean isFirstVisible = true;
    /*当前真正的可见状态*/
    private boolean currentVisibleState = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, mView);
        sp = SPUtils.getInstance(TAG, MODE_PRIVATE);
        mActivity = getActivity();
        intent = new Intent();
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isHidden() && !currentVisibleState && isResumed()) {
            dispatchVisibleState(true);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (currentVisibleState && !isResumed()) {
            dispatchVisibleState(false);
        }
    }

    /**
     * 控制父Fragment的可见状态
     *
     * @param isVisible
     */
    private void dispatchVisibleState(boolean isVisible) {
        /*为了兼容内嵌ViewPager的情况,分发时，还要判断父Fragment是不是可见*/
        if (isVisible && isParentInvisible()) {
            /*如果当前可见，但是父容器不可见，那么也不必分发*/
            return;
        }
        if (isVisible == currentVisibleState) {
            /*如果目标值，和当前值相同，那就别费劲了*/
            return;
        }
        /*更新状态值*/
        currentVisibleState = isVisible;
        /*如果可见*/
        if (isVisible) {
            /*那就区分是第一次可见，还是非第一次可见*/
            if (isFirstVisible) {
                isFirstVisible = false;
                onFragmentFirstVisible();
            }
            onFragmentResume();
            dispatchChildVisibilityState(true);
        } else {
            onFragmentPause();
            dispatchChildVisibilityState(false);
        }
    }

    /**
     * 控制内嵌的Fragment的可见状态
     *
     * @param isVisible
     */
    private void dispatchChildVisibilityState(boolean isVisible) {
        FragmentManager fragmentManager = getChildFragmentManager();
        List<Fragment> list = fragmentManager.getFragments();
        if (list != null) {
            /*遍历子fragment*/
            for (Fragment fg : list) {
                if (fg instanceof BaseFragment
                        && !fg.isHidden() && fg.getUserVisibleHint()) {
                    ((BaseFragment) fg).dispatchVisibleState(isVisible);
                }
            }
        }
    }


    private boolean isParentInvisible() {
        Fragment parent = getParentFragment();
        if (parent instanceof BaseFragment) {
            BaseFragment lz = (BaseFragment) parent;
            return !lz.currentVisibleState;
        }
        /*默认可见*/
        return false;
    }


    /**
     * 设置ToolBar
     *
     * @param view
     * @param title
     * @return
     */
    public Toolbar initToolBar(View view, String title) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        TextView toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText(title);
        return toolbar;
    }

    /**
     * 当第一次可见的时候(此方法，在View的一次生命周期中只执行一次)
     * 如果Fragment经历了onDestroyView，那么整个方法会再次执行
     * 重写此方法时，对Fragment全局变量进行 初始化
     * 第一次可见,进行当前Fragment初始化操作
     */
    protected abstract void onFragmentFirstVisible();

    /**
     * 当fragment变成可见的时候(可能会多次)
     */
    protected abstract void onFragmentResume();

    /**
     * 当fragment变成不可见的时候(可能会多次)
     */
    protected abstract void onFragmentPause();

    /**
     * layout xml文件ID
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 显示短吐司
     *
     * @param str
     */
    protected void ShowToastShort(String str) {
        if (null == mToast) {
            mToast = Toast.makeText(mActivity, str, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(str);
        }
        mToast.show();
    }


    /**
     * 显示长吐司
     *
     * @param str
     */
    protected void ShowToastLong(String str) {
        if (null == mToast) {
            mToast = Toast.makeText(mActivity, str, Toast.LENGTH_LONG);
        } else {
            mToast.setText(str);
        }
        mToast.show();
    }

    /**
     * 显示默认加载框
     */
    public void showProgressDialog() {
        if (null == progressDialog) {
            progressDialog = new QMUITipDialog.Builder(mActivity).setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                    .setTipWord("加载中")
                    .create(false);
        }
        progressDialog.show();
    }

    /**
     * 显示指定加载框
     */
    public void showProgressDialog(@QMUITipDialog.Builder.IconType int iconType,String msg) {
        if (null == progressDialog) {
            progressDialog = new QMUITipDialog.Builder(mActivity).setIconType(iconType)
                    .setTipWord(msg)
                    .create(false);
        }
        progressDialog.show();
    }


    /**
     * 隐藏加载框
     */
    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    /**
     * 销毁回收
     */
    @Override
    public void onDestroyView() {
        mUnbinder.unbind();
        dismissProgressDialog();
        super.onDestroyView();
    }
}
