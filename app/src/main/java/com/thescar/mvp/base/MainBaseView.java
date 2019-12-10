package com.thescar.mvp.base;

import com.thescar.mvp.model.MainModel;

/**
 * @Author :TheScar
 * @Date :2019/12/10 13:16
 * @Email :han_shuaishuai@126.com
 * @Description :mainView的接口
 */
public interface MainBaseView extends BaseView {

    void getDataSuccess(MainModel model);

    void getDataFail(String msg);

}
