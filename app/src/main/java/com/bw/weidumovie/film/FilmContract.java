package com.bw.weidumovie.film;

import android.content.Context;

import com.bw.weidumovie.mvp.BasePresenter;
import com.bw.weidumovie.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class FilmContract {
    interface View extends BaseView {

        void onShouYeReMenSuccess(Object o);
        void onShouYeReMenFailed();
        void onShouYeZZRYSuccess(Object o);
        void onShouYeZZRYFailed();
        void onShouYeJJSYSuccess(Object o);
        void onShouYeJJSYFailed();
    }

    interface  Presenter extends BasePresenter<View> {
        void getShouYeReMenMethede(int page,int count);
        void getShouYeZZRYMethede(int page,int count);
        void getShouYeJJSYMethede(int page,int count);
    }
}
