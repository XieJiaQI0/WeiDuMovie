package com.bw.weidumovie.jjsy;

import android.content.Context;

import com.bw.weidumovie.api.ApiService;
import com.bw.weidumovie.bean.JjsyBean;
import com.bw.weidumovie.mvp.BasePresenterImpl;
import com.bw.weidumovie.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class JjsyPresenter extends BasePresenterImpl<JjsyContract.View> implements JjsyContract.Presenter{

    @Override
    public void getShouYeJJSYMethede(int page, int count) {
        final ApiService apiService2 = RetrofitUtils.getInstance().create(ApiService.class);
        apiService2.showShouYeJJSY(page,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver<JjsyBean>() {
                    @Override
                    public void onNext(JjsyBean value) {

                        mView.onShouYeJJSYSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
