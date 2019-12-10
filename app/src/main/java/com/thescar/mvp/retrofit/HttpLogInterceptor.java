package com.thescar.mvp.retrofit;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.LogUtils;
import com.thescar.mvp.App.OverallConstants;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * @Author :TheScar
 * @Date :2019/12/10 13:19
 * @Email :han_shuaishuai@126.com
 * @Description : okhttp 拦截器
 */
public class HttpLogInterceptor implements Interceptor, OverallConstants {
    private final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        RequestBody requestBody = request.body();
        String body = null;
        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            Charset charset = UTF8;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }
            body = buffer.readString(charset);
        }
        if (AppUtils.isAppDebug()) {
            LogUtils.d(
                    "\n发送请求: method：" + request.method()
                            + "\nurl：" + request.url()
                            + "\n请求参数: " + EncodeUtils.urlDecode(body));
        }
        Response response = chain.proceed(request);

        ResponseBody responseBody = response.body();
        String rBody;

        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE);
        Buffer buffer = source.buffer();

        Charset charset = UTF8;
        MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            try {
                charset = contentType.charset(UTF8);
            } catch (UnsupportedCharsetException e) {
                e.printStackTrace();
            }
        }
        rBody = buffer.clone().readString(charset);
        if (AppUtils.isAppDebug()) {
            LogUtils.d(
                    "\n收到响应: code:" + response.code()
                            + "\n请求url：" + response.request().url()
                            + "\n请求body：" + EncodeUtils.urlDecode(rBody));
        }
        return response;
    }
}