package com.bw.weidumovie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bw.weidumovie.R;
import com.bw.weidumovie.adapter.GuideViewPagerAdapter;
import com.bw.weidumovie.app.AppConstants;
import com.bw.weidumovie.login.LoginActivity;
import com.bw.weidumovie.utils.SpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.vp_guide)
    ViewPager vp;
    @BindView(R.id.btn_enter)
    Button btnEnter;
    @BindView(R.id.ll)
    LinearLayout ll;
    private GuideViewPagerAdapter adapter;
    private static final String TAG="GuideActivity";
    int[] pics = {R.layout.guid_view1,
            R.layout.guid_view2, R.layout.guid_view3, R.layout.guid_view4};

    // 底部小点图片
    private ImageView[] dots;
    // 记录当前选中位置
    private int currentIndex;
    private List<View> views;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

// 引导页图片资源
        Log.i(TAG, "initView: "+pics.length);
        views = new ArrayList<>();
        // 初始化引导页视图列表
        for (int i = 0; i < pics.length; i++) {
            View view = LayoutInflater.from(this).inflate(pics[i], null);
//            if (i==pics.length-1) {
//                btnEnter.setVisibility(View.VISIBLE);
//                btnEnter.setTag("enter");
//                btnEnter.setOnClickListener(this);
//            }
            views.add(view);
        }
        Log.i(TAG, "onCreate: "+views.size());
        // 初始化adapter
         GuideViewPagerAdapter adapter = new GuideViewPagerAdapter(views);
        Log.i(TAG, "onCreate: "+adapter.toString());
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(new PageChangeListener());
        //小圆点移动
        initDots();
    }
    private void initDots() {
        dots = new ImageView[pics.length];
        // 循环取得小点图片
        for (int i = 0; i < pics.length; i++) {
            // 得到一个LinearLayout下面的每一个子元素
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(false);// 都设为灰色
            //dots[i].setOnClickListener(this);
            dots[i].setTag(i);// 设置位置tag，方便取出与当前位置对应
        }
        btnEnter.setOnClickListener(this);
        currentIndex = 0;
        dots[currentIndex].setEnabled(true); // 设置为白色，即选中状态

    }
    private void enterMainActivity() {
        Intent intent = new Intent(GuideActivity.this,
                LoginActivity.class);
        startActivity(intent);
        SpUtils.putBoolean(GuideActivity.this, AppConstants.FIRST_OPEN, true);
        finish();
    }
    @Override
    public void onClick(View v) {
        if (v.getTag().equals("enter")) {
            enterMainActivity();
            return;
        }

        int position = (Integer) v.getTag();
        setCurView(position);
        setCurDot(position);
    }
    /**
     * 设置当前view
     *
     * @param position
     */
    private void setCurView(int position) {
        if (position < 0 || position >= pics.length) {
            return;
        }
        vp.setCurrentItem(position);
    }

    /**
     * 设置当前指示点
     *
     * @param position
     */
    private void setCurDot(int position) {
        if (position < 0 || position > pics.length || currentIndex == position) {
            return;
        }
        dots[position].setEnabled(true);
        dots[currentIndex].setEnabled(false);
        currentIndex = position;
    }


    private class PageChangeListener implements ViewPager.OnPageChangeListener, View.OnClickListener {
        // 当滑动状态改变时调用
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            setCurDot(i);
            if (i==3){
                btnEnter.setText("点击进入");
                btnEnter.setVisibility(View.VISIBLE);
                btnEnter.setTag("enter");

            }else {
                btnEnter.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }

        @Override
        public void onClick(View v) {
            if (v.getTag().equals("enter")) {
                enterMainActivity();
                return;
            }

            int position = (Integer) v.getTag();
            setCurView(position);
            setCurDot(position);
        }
    }

}
