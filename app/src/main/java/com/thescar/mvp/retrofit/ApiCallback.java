package com.thescar.mvp.retrofit;


import com.blankj.utilcode.util.LogUtils;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;
/**
 * @Author :TheScar
 * @Date :2019/12/10 13:18
 * @Email :han_shuaishuai@126.com
 * @Description : ApiCallback
 */
public abstract class ApiCallback<M> extends DisposableObserver<M> {

    public abstract void onSuccess(M model);

    public abstract void onFailure(String msg);

    public abstract void onFinish();


    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            String msg = httpException.getMessage();
            LogUtils.d("code=" + code);
            if (code == 504) {
                msg = "网络不给力";
            }
            if (code == 502 || code == 404) {
                msg = "服务器异常，请稍后再试";
            }
            onFailure(msg);
        } else {
            onFailure(e.getMessage());
        }
        onFinish();
    }

    @Override
    public void onNext(M model) {
        onSuccess(model);

    }

    @Override
    public void onComplete() {
        onFinish();
    }
}