package com.bw.weidumovie.zzry;

import android.content.Context;

import com.bw.weidumovie.mvp.BasePresenter;
import com.bw.weidumovie.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class ZzryContract {
    interface View extends BaseView {
        void onShouYeZZRYSuccess(Object o);
        void onShouYeZZRYFailed();
    }

    interface  Presenter extends BasePresenter<View> {
        void getShouYeZZRYMethede(int page,int count);
    }
}
