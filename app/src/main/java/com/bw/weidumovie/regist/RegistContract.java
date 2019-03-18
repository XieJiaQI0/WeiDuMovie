package com.bw.weidumovie.regist;

import android.content.Context;

import com.bw.weidumovie.mvp.BasePresenter;
import com.bw.weidumovie.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class RegistContract {



    interface View extends BaseView {
        void onRegistSuccess(Object o);
        void onRegistFailed();
    }

    interface  Presenter extends BasePresenter<View> {

        void getRegistMethed(String nickName,String phone,String pwd,String pwd2,int sex,String birthday,String imei,String ua,String screenSize,String os,String email);

    }
}
