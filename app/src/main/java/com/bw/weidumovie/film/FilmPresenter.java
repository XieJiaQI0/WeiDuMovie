package com.bw.weidumovie.film;

import android.content.Context;

import com.bw.weidumovie.api.ApiService;
import com.bw.weidumovie.bean.JjsyBean;
import com.bw.weidumovie.bean.LoginBean;
import com.bw.weidumovie.bean.RmdyBean;
import com.bw.weidumovie.bean.ZzsyBean;
import com.bw.weidumovie.mvp.BasePresenterImpl;
import com.bw.weidumovie.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class FilmPresenter extends BasePresenterImpl<FilmContract.View> implements FilmContract.Presenter{

    @Override
    public void getShouYeReMenMethede(int page, int count) {
        final ApiService apiService = RetrofitUtils.getInstance().create(ApiService.class);
        apiService.showShouYeReMen(page,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver<RmdyBean>() {
                    @Override
                    public void onNext(RmdyBean value) {

                        mView.onShouYeReMenSuccess(value);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getShouYeZZRYMethede(int page, int count) {
        final ApiService apiService1 = RetrofitUtils.getInstance().create(ApiService.class);
        apiService1.showShouYeZZRY(page,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver<ZzsyBean>() {
                    @Override
                    public void onNext(ZzsyBean value) {

                        mView.onShouYeZZRYSuccess(value);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

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
