package com.thescar.mvp.retrofit;

import com.thescar.mvp.App.OverallConstants;
import com.thescar.mvp.model.JokeModel;

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
    String KEY = "9653a90da9c61b2462d3497d7e423b59";


    /*BaseUrl*/
    String Host = ISONLINE ? "http://v.juhe.cn/" : "http://www.weather.com.cn/TEST";

    /**
     * 获取随机笑话
     *
     * @return
     */
    @GET("joke/randJoke.php?key=" + KEY)
    Observable<JokeModel> getJoker();
}
