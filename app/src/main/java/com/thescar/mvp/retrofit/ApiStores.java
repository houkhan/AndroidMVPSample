package com.thescar.mvp.retrofit;

import com.thescar.mvp.model.MainModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
/**
 * @Author :TheScar
 * @Date :2019/12/10 13:19
 * @Email :han_shuaishuai@126.com
 * @Description : ApiStores
 */
public interface ApiStores {

    /*是否正式接口*/
    boolean ISONLINE = true;

    /*BaseUrl*/
    String Host = ISONLINE ? "http://www.weather.com.cn/"
            : "http://www.weather.com.cn/TEST";

    /*加载天气*/
    @GET("adat/sk/{cityId}.html")
    Call<MainModel> loadDataByRetrofit(@Path("cityId") String cityId);

    /*加载天气*/
    @GET("adat/sk/{cityId}.html")
    Observable<MainModel> loadDataByRetrofitRxJava(@Path("cityId") String cityId);
}
