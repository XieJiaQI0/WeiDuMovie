package com.bw.weidumovie.jjsy;

import android.content.Context;

import com.bw.weidumovie.mvp.BasePresenter;
import com.bw.weidumovie.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class JjsyContract {
    interface View extends BaseView {
        void onShouYeJJSYSuccess(Object o);
        void onShouYeJJSYFailed();
    }

    interface  Presenter extends BasePresenter<View> {
        void getShouYeJJSYMethede(int page,int count);
    }
}
