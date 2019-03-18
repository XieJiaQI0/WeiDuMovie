package com.bw.weidumovie.login;

import android.content.Context;

import com.bw.weidumovie.api.ApiService;
import com.bw.weidumovie.bean.LoginBean;
import com.bw.weidumovie.mvp.BasePresenterImpl;
import com.bw.weidumovie.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter{

    @Override
    public void getLoginMethede(String phone, String pwd) {
        final ApiService apiService = RetrofitUtils.getInstance().create(ApiService.class);
        apiService.showLogin(phone, pwd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean value) {

                        mView.onLoginSuccess(value);

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
