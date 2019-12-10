package com.thescar.mvp.presenter;

import com.thescar.mvp.base.BasePresenter;
import com.thescar.mvp.base.MainBaseView;
import com.thescar.mvp.model.MainModel;
import com.thescar.mvp.retrofit.ApiCallback;
/**
 * @Author :TheScar
 * @Date :2019/12/10 13:15
 * @Email :han_shuaishuai@126.com
 * @Description :presenter  用于交互view和model层
 */
public class MainPresenter extends BasePresenter<MainBaseView> {

    public MainPresenter(MainBaseView view) {
        attachView(view);
    }

    public void loadDataByRetrofitRxjava(String cityId) {
        mvpView.showLoading();
        addSubscription(apiStores.loadDataByRetrofitRxJava(cityId),
                new ApiCallback<MainModel>() {
                    @Override
                    public void onSuccess(MainModel model) {
                        mvpView.getDataSuccess(model);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.getDataFail(msg);
                    }

                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }

}
