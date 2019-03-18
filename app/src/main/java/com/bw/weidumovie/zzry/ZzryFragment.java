package com.bw.weidumovie.zzry;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.weidumovie.R;
import com.bw.weidumovie.adapter.ZzryFragmentAdapter;
import com.bw.weidumovie.adapter.ZzsyAdapter;
import com.bw.weidumovie.bean.ZzsyBean;
import com.bw.weidumovie.mvp.MVPBaseFragment;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ZzryFragment extends MVPBaseFragment<ZzryContract.View, ZzryPresenter> implements ZzryContract.View {
    @BindView(R.id.xrecy_zzry)
    XRecyclerView xrecyZzry;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.zzry_fragment, container, false);
        bind = ButterKnife.bind(this, inflate);
        mPresenter.getShouYeZZRYMethede(1, 10);
        LinearLayoutManager zzrylinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        xrecyZzry.setLayoutManager(zzrylinearLayoutManager);
        return inflate;
    }

    @Override
    public void onShouYeZZRYSuccess(Object o) {
        if (o instanceof ZzsyBean){
            ZzsyBean zzsyBean = (ZzsyBean)o;
            final List<ZzsyBean.ResultBean> result1 = zzsyBean.getResult();
            if(zzsyBean!=null){
                ZzryFragmentAdapter zzryFragmentAdapter = new ZzryFragmentAdapter(getContext(),result1);
                xrecyZzry.setAdapter(zzryFragmentAdapter);

            }
        }
    }

    @Override
    public void onShouYeZZRYFailed() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
