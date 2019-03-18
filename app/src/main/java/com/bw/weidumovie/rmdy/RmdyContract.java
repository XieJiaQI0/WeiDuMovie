package com.bw.weidumovie.rmdy;

import android.content.Context;

import com.bw.weidumovie.mvp.BasePresenter;
import com.bw.weidumovie.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class RmdyContract {
    interface View extends BaseView {
        void onShouYeReMenSuccess(Object o);
        void onShouYeReMenFailed();
    }

    interface  Presenter extends BasePresenter<View> {
        void getShouYeReMenMethede(int page,int count);
    }
}
