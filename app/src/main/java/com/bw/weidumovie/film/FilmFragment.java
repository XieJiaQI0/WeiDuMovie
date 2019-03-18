package com.bw.weidumovie.film;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.weidumovie.R;
import com.bw.weidumovie.activity.DetailsActivity;
import com.bw.weidumovie.activity.HomeActivity;
import com.bw.weidumovie.adapter.JjsyAdapter;
import com.bw.weidumovie.adapter.MuMaAdapter;
import com.bw.weidumovie.adapter.RmdyAdapter;
import com.bw.weidumovie.adapter.ZzsyAdapter;
import com.bw.weidumovie.bean.JjsyBean;
import com.bw.weidumovie.bean.LoginBean;
import com.bw.weidumovie.bean.RmdyBean;
import com.bw.weidumovie.bean.ZzsyBean;
import com.bw.weidumovie.login.LoginActivity;
import com.bw.weidumovie.mvp.MVPBaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import recycler.coverflow.RecyclerCoverFlow;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class FilmFragment extends MVPBaseFragment<FilmContract.View, FilmPresenter> implements FilmContract.View {
    @BindView(R.id.film_location)
    ImageView filmLocation;
    @BindView(R.id.textview_location)
    TextView textviewLocation;
    @BindView(R.id.film_search)
    RelativeLayout filmSearch;
    @BindView(R.id.film_rcf)
    RecyclerCoverFlow filmRcf;
    @BindView(R.id.top)
    RelativeLayout top;
    @BindView(R.id.movie_text_xian)
    TextView movieTextXian;
    @BindView(R.id.movie_text_dong)
    TextView movieTextDong;
    @BindView(R.id.textview_rmdy)
    TextView textviewRmdy;
    @BindView(R.id.txt_view)
    View txtView;
    @BindView(R.id.film_rmdy_next)
    ImageView filmRmdyNext;
    @BindView(R.id.recy_rmdy)
    RecyclerView recyRmdy;
    @BindView(R.id.rl_rmdy)
    RelativeLayout rlRmdy;
    @BindView(R.id.textview_zzsy)
    TextView textviewZzsy;
    @BindView(R.id.txt_view1)
    View txtView1;
    @BindView(R.id.film_zzsy_next)
    ImageView filmZzsyNext;
    @BindView(R.id.recy_zzry)
    RecyclerView recyZzry;
    @BindView(R.id.zzsy_rl)
    RelativeLayout zzsyRl;
    @BindView(R.id.txt_zzsy)
    TextView txtZzsy;
    @BindView(R.id.txt_view2)
    View txtView2;
    @BindView(R.id.film_jjsy_next)
    ImageView filmJjsyNext;
    @BindView(R.id.recy_jjsy)
    RecyclerView recyJjsy;
    Unbinder unbinder;
    private MuMaAdapter muMaAdapter;
    private RmdyAdapter rmdyAdapter;
    private ZzsyAdapter zzsyAdapter;
    private JjsyAdapter jjsyAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.film_layout, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        mPresenter.getShouYeReMenMethede(1,10);
        mPresenter.getShouYeZZRYMethede(1,10);
        mPresenter.getShouYeJJSYMethede(1,10);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyRmdy.setLayoutManager(linearLayoutManager);
        LinearLayoutManager zzrylinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyZzry.setLayoutManager(zzrylinearLayoutManager);
        LinearLayoutManager jjlinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyJjsy.setLayoutManager(jjlinearLayoutManager);

        rlRmdy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                startActivity(intent);

                Toast.makeText(getActivity(),"点击啦",Toast.LENGTH_LONG).show();
            }
        });
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onShouYeReMenSuccess(Object o) {
        if (o instanceof RmdyBean){
            RmdyBean rmdyBean = (RmdyBean)o;
            final List<RmdyBean.ResultBean> result = rmdyBean.getResult();
            if(rmdyBean!=null){
                muMaAdapter = new MuMaAdapter(getActivity(),result);
                filmRcf.setAdapter(muMaAdapter);
                rmdyAdapter = new RmdyAdapter(getActivity(),result);
                recyRmdy.setAdapter(rmdyAdapter);

            }
        }
    }

    @Override
    public void onShouYeReMenFailed() {

    }

    @Override
    public void onShouYeZZRYSuccess(Object o) {

        if (o instanceof ZzsyBean){
            ZzsyBean zzsyBean = (ZzsyBean)o;
            final List<ZzsyBean.ResultBean> result1 = zzsyBean.getResult();
            if(zzsyBean!=null){
                zzsyAdapter = new ZzsyAdapter(getActivity(),result1);
                recyZzry.setAdapter(zzsyAdapter);

            }
        }



    }

    @Override
    public void onShouYeZZRYFailed() {

    }

    @Override
    public void onShouYeJJSYSuccess(Object o) {

        if (o instanceof JjsyBean){
            JjsyBean jjsyBean = (JjsyBean)o;
            final List<JjsyBean.ResultBean> result2 = jjsyBean.getResult();
            if(jjsyBean!=null){
                jjsyAdapter = new JjsyAdapter(getActivity(),result2);
                recyJjsy.setAdapter(jjsyAdapter);

            }
        }
    }

    @Override
    public void onShouYeJJSYFailed() {

    }
}
