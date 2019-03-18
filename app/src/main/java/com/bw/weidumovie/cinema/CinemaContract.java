package com.bw.weidumovie.cinema;

import android.content.Context;

import com.bw.weidumovie.mvp.BasePresenter;
import com.bw.weidumovie.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class CinemaContract {
    interface View extends BaseView {
        
    }

    interface  Presenter extends BasePresenter<View> {
        
    }
}
