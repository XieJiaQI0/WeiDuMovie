package com.bw.weidumovie.jjsy;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.weidumovie.R;
import com.bw.weidumovie.adapter.JjsyFragmentAdapter;
import com.bw.weidumovie.bean.JjsyBean;
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

public class JjsyFragment extends MVPBaseFragment<JjsyContract.View, JjsyPresenter> implements JjsyContract.View {
    @BindView(R.id.xrecy_jjsy)
    XRecyclerView xrecyJjsy;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.jjsy_fragment, container, false);
        bind = ButterKnife.bind(this, inflate);
        mPresenter.getShouYeJJSYMethede(1,10);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        xrecyJjsy.setLayoutManager(linearLayoutManager);
        return inflate;
    }

    @Override
    public void onShouYeJJSYSuccess(Object o) {
        if (o instanceof JjsyBean) {
            JjsyBean jjsyBean = (JjsyBean) o;
            final List<JjsyBean.ResultBean> result2 = jjsyBean.getResult();
            if (jjsyBean != null) {
                JjsyFragmentAdapter jjsyFragmentAdapter = new JjsyFragmentAdapter(getContext(),result2);
                xrecyJjsy.setAdapter(jjsyFragmentAdapter);

            }
        }
    }

    @Override
    public void onShouYeJJSYFailed() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
