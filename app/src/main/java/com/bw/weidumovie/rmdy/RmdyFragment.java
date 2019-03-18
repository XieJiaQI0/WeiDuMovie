package com.bw.weidumovie.rmdy;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.weidumovie.R;
import com.bw.weidumovie.adapter.MuMaAdapter;
import com.bw.weidumovie.adapter.RmdyAdapter;
import com.bw.weidumovie.adapter.RmdyFragmentAdapter;
import com.bw.weidumovie.bean.RmdyBean;
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

public class RmdyFragment extends MVPBaseFragment<RmdyContract.View, RmdyPresenter> implements RmdyContract.View {


    @BindView(R.id.xrecy_rmdy)
    XRecyclerView xrecyRmdy;
    private Unbinder unbinder;
    private RmdyFragmentAdapter rmdyFragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.rmdy_fragment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        mPresenter.getShouYeReMenMethede(1, 10);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        xrecyRmdy.setLayoutManager(linearLayoutManager);


        return inflate;
    }

    @Override
    public void onShouYeReMenSuccess(Object o) {

        if (o instanceof RmdyBean){
            RmdyBean rmdyBean = (RmdyBean)o;
            final List<RmdyBean.ResultBean> result = rmdyBean.getResult();
            if(rmdyBean!=null){
                rmdyFragmentAdapter = new RmdyFragmentAdapter(getContext(),result);
                xrecyRmdy.setAdapter(rmdyFragmentAdapter);

            }
        }



    }

    @Override
    public void onShouYeReMenFailed() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
