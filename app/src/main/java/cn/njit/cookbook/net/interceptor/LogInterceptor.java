package cn.njit.cookbook.net.interceptor;


import cn.njit.cookbook.utils.LogUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 作者：赵若位
 * 时间：2018/12/6 10:06
 * 邮箱：1070138445@qq.com
 * 功能：
 */
public class LogInterceptor implements Interceptor
{
    public LogInterceptor()
    {
    }

    @Override
    public Response intercept(Chain chain) throws IOException
    {
        Request request = chain.request();
        Response response = chain.proceed(request);
        String content = response.body().string();
        LogUtils.e(content);
        return response.newBuilder()
                .body(ResponseBody.create(response.body().contentType(), content))
                .build();
    }
}
