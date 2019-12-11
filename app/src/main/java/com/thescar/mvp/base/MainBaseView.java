package com.thescar.mvp.base;

import com.thescar.mvp.model.JokeModel;

/**
 * @Author :TheScar
 * @Date :2019/12/10 13:16
 * @Email :han_shuaishuai@126.com
 * @Description :mainView的接口
 */
public interface MainBaseView<M> extends BaseView {

    void getDataSuccess(M model);

    void getDataFail(String msg);

}
