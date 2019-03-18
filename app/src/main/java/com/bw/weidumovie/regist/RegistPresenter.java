package com.bw.weidumovie.regist;

import android.content.Context;

import com.bw.weidumovie.api.ApiService;
import com.bw.weidumovie.bean.LoginBean;
import com.bw.weidumovie.bean.RegistBean;
import com.bw.weidumovie.mvp.BasePresenterImpl;
import com.bw.weidumovie.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class RegistPresenter extends BasePresenterImpl<RegistContract.View> implements RegistContract.Presenter{

    @Override
    public void getRegistMethed(String nickName, String phone, String pwd, String pwd2, int sex, String birthday, String imei, String ua, String screenSize, String os, String email) {
        final ApiService apiService = RetrofitUtils.getInstance().create(ApiService.class);
        apiService.showRegist(nickName,phone,pwd,pwd2,sex,birthday,imei,ua,screenSize,os,email)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver<RegistBean>() {
                    @Override
                    public void onNext(RegistBean value) {

                        mView.onRegistSuccess(value);

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
