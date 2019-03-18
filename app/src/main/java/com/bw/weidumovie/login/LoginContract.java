package com.bw.weidumovie.login;

import android.content.Context;

import com.bw.weidumovie.mvp.BasePresenter;
import com.bw.weidumovie.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class LoginContract {
    interface View extends BaseView {
        void onLoginSuccess(Object o);
        void onLoginFailed();
    }

    interface  Presenter extends BasePresenter<View> {
        //获取登录数据方法
        void getLoginMethede(String phone,String pwd);
    }
}
