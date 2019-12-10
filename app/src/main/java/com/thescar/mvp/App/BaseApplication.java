package com.thescar.mvp.App;

import android.app.Application;
import android.content.Context;


import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.thescar.mvp.R;
/**
 * @Author :TheScar
 * @Date :2019/12/10 13:13
 * @Email :han_shuaishuai@126.com
 * @Description : APP入口
 */
public class BaseApplication extends Application implements OverallConstants {

    /**
     * SmartRefreshLayout设置全局的刷新加载样式
     */
    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.white, R.color.black);
                return new ClassicsHeader(context);
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initStatus();
    }

    /**
     * 初始化
     */
    private void initStatus() {
        /*Utils*/
        Utils.init(getApplicationContext());
        /*LogUtils*/
        LogUtils.getConfig().setLogSwitch(AppUtils.isAppDebug()).setGlobalTag(TAG);
    }
}
