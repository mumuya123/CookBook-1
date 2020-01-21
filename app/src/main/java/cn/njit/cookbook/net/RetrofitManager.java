package cn.njit.cookbook.net;


import android.text.TextUtils;

import cn.njit.cookbook.net.interceptor.LogInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：赵若位
 * 时间：2018/4/30 18:27
 * 邮箱：1070138445@qq.com
 * 功能：RetrofitManager管理器的创建，保证Retrofit在类中只有一个实例，避免请求体的多次创建。
 */

public class RetrofitManager
{
    private static final long DEFAULT_TIMEOUT = 10L;//超时时间
    private static RetrofitManager mManager;
    public static final String BASE_URL = "http://apis.juhe.cn/";//网络请求基地址
    private OkHttpClient mClient;
    private ApiService mService;


    private RetrofitManager()
    {
        this(null);
    }


    private RetrofitManager(String url)
    {
        if (TextUtils.isEmpty(url))
        {
            url = BASE_URL;
        }
        this.mClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addNetworkInterceptor(new LogInterceptor())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(mClient)
                .baseUrl(url)
                .build();
        mService = retrofit.create(ApiService.class);
    }


    //单利模式
    public static RetrofitManager getManager()
    {
        return SingletonHolder.INSTANCE;
    }

    public static RetrofitManager getManager(String url)
    {
        return mManager = new RetrofitManager(url);
    }


    public static class SingletonHolder
    {
        private static final RetrofitManager INSTANCE = new RetrofitManager();
    }


    public ApiService getService()
    {
        return mService;
    }


    /*文件上传*/
    public RequestBody getUploadFileRequestBody(String mImagePath)
    {
        File file = new File(mImagePath);
        //构建body
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file))
                .build();
        return body;
    }


}


