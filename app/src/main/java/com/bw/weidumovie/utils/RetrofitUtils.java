package com.bw.weidumovie.utils;



import com.bw.weidumovie.api.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {


    private final Retrofit build;

    private static final class SINGLE_INSTANCE{
        public static final RetrofitUtils _INSTANCE = new RetrofitUtils();

    }

    public static RetrofitUtils getInstance(){

        return SINGLE_INSTANCE._INSTANCE;
    }

    private RetrofitUtils(){
        build = new Retrofit.Builder()
                .baseUrl(Api.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(buildOkHttpClient())
                .build();

    }

    private OkHttpClient buildOkHttpClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .writeTimeout(3000,TimeUnit.SECONDS)
                .readTimeout(3000,TimeUnit.SECONDS)
                .build();
    }

    public Retrofit getRetrofit(){

        return build;
    }

    public <T> T create(Class<T> clazz){
        return build.create(clazz);
    }


}
