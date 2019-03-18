package com.bw.weidumovie.zzry;

import android.content.Context;

import com.bw.weidumovie.api.ApiService;
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

public class ZzryPresenter extends BasePresenterImpl<ZzryContract.View> implements ZzryContract.Presenter{

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
}
