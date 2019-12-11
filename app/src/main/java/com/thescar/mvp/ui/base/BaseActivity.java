package com.thescar.mvp.ui.base;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.blankj.utilcode.util.SPUtils;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.thescar.mvp.App.OverallConstants;
import com.thescar.mvp.R;

import androidx.appcompat.widget.Toolbar;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 * @Author :TheScar
 * @Date :2019/12/10 13:21
 * @Email :han_shuaishuai@126.com
 * @Description : BaseActivity
 */
public abstract class BaseActivity extends AppCompatActivity implements OverallConstants {
    private Unbinder mUnbinder;
    private QMUITipDialog progressDialog;
    private Toast mToast;
    public SPUtils sp;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStatus();
    }

    private void initStatus() {
        setStatusBar(true, true);
        sp = SPUtils.getInstance(TAG, MODE_PRIVATE);
        intent = new Intent();
        setContentView(intiLayout());
        mUnbinder = ButterKnife.bind(this);
        initView();
        initData();
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
     * 设置布局
     *
     * @return
     */
    public abstract int intiLayout();

    /**
     * 初始化组件
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();

    /**
     * 显示短吐司
     *
     * @param str
     */
    protected void ShowToastShort(String str) {
        if (null == mToast) {
            mToast = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT);
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
            mToast = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG);
        } else {
            mToast.setText(str);
        }
        mToast.show();
    }


    /**
     * 设置沉浸式及字体颜色
     *
     * @param isSetStatusBar 是否沉浸式
     * @param isLightColor   沉浸式字体颜色  true 黑色  false 白色
     */
    public void setStatusBar(boolean isSetStatusBar, boolean isLightColor) {
        if (isSetStatusBar) {
            if (isLightColor) {
                QMUIStatusBarHelper.translucent(this);
                QMUIStatusBarHelper.setStatusBarLightMode(this);
            } else {
                QMUIStatusBarHelper.translucent(this);
                QMUIStatusBarHelper.setStatusBarDarkMode(this);
            }
        } else {
            if (isLightColor) {
                QMUIStatusBarHelper.setStatusBarLightMode(this);
            } else {
                QMUIStatusBarHelper.setStatusBarDarkMode(this);
            }
        }
    }

    /**
     * 显示默认加载框
     */
    public void showProgressDialog() {
        if (null == progressDialog) {
            progressDialog = new QMUITipDialog.Builder(this).setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
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
            progressDialog = new QMUITipDialog.Builder(this).setIconType(iconType)
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
    protected void onDestroy() {
        super.onDestroy();
        dismissProgressDialog();
        mUnbinder.unbind();
    }
}
