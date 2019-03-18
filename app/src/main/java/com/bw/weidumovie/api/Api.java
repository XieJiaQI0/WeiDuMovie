package com.bw.weidumovie.api;

public class Api {

    //外网
    //public static final String BASE_API="http://mobile.bwstudent.com/movieApi/";
    //内网
    public static final String BASE_API="http://172.17.8.100/movieApi/";
    //注册
    public static final String REGIST_API="user/v1/registerUser";
    //登录
    public static final String LOGIN_API="user/v1/login";
    //影片首页——热门电影
    public static final String SHOUYE_RMDY_API="movie/v1/findHotMovieList";
    //影片首页——正在上映
    public static final String SHOUYE_ZZSY_API="movie/v1/findReleaseMovieList";
    //影片首页——即将上映
    public static final String SHOUYE_JJSY_API="movie/v1/findComingSoonMovieList";

}
