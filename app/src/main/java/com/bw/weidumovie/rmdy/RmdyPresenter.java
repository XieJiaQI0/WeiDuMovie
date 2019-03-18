package com.bw.weidumovie.rmdy;

import android.content.Context;

import com.bw.weidumovie.api.ApiService;
import com.bw.weidumovie.bean.RmdyBean;
import com.bw.weidumovie.mvp.BasePresenterImpl;
import com.bw.weidumovie.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class RmdyPresenter extends BasePresenterImpl<RmdyContract.View> implements RmdyContract.Presenter{

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
}
