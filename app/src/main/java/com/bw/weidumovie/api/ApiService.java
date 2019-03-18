package com.bw.weidumovie.api;

import com.bw.weidumovie.bean.JjsyBean;
import com.bw.weidumovie.bean.LoginBean;
import com.bw.weidumovie.bean.RegistBean;
import com.bw.weidumovie.bean.RmdyBean;
import com.bw.weidumovie.bean.ZzsyBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    //登录
    @POST(Api.LOGIN_API)
    @FormUrlEncoded
    Observable<LoginBean> showLogin(@Field("phone") String phone, @Field("pwd") String pwd);

    //注册
    @POST(Api.REGIST_API)
    @FormUrlEncoded
    Observable<RegistBean> showRegist(@Field("nickName") String nickName, @Field("phone") String phone, @Field("pwd") String pwd, @Field("pwd2") String pwd2, @Field("sex") int sex, @Field("birthday") String birthday, @Field("imei") String imei, @Field("ua") String ua, @Field("screenSize") String screenSize, @Field("os") String os, @Field("email") String email);

    //影片首页——热门电影
    @GET(Api.SHOUYE_RMDY_API)
    Observable<RmdyBean> showShouYeReMen(@Query("page") int page,
                                           @Query("count") int count);

    //影片首页——正在上映
    @GET(Api.SHOUYE_ZZSY_API)
    Observable <ZzsyBean> showShouYeZZRY(@Query("page") int page,
                                                   @Query("count") int count);
    //影片首页——即将上映
    @GET(Api.SHOUYE_JJSY_API)
    Observable <JjsyBean> showShouYeJJSY(@Query("page") int page,
                                                   @Query("count") int count);



}
