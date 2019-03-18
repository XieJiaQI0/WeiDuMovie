package com.bw.weidumovie.regist;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.weidumovie.R;
import com.bw.weidumovie.login.LoginActivity;
import com.bw.weidumovie.mvp.MVPBaseActivity;
import com.bw.weidumovie.utils.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class RegistActivity extends MVPBaseActivity<RegistContract.View, RegistPresenter> implements RegistContract.View {


    @BindView(R.id.regist_nike)
    EditText registNike;
    @BindView(R.id.regist_sex)
    EditText registSex;
    @BindView(R.id.regist_date)
    EditText registDate;
    @BindView(R.id.regist_phone)
    EditText registPhone;
    @BindView(R.id.regist_email)
    EditText registEmail;
    @BindView(R.id.regist_pwd)
    EditText registPwd;
    @BindView(R.id.regist_pwd2)
    EditText registPwd2;
    @BindView(R.id.btn_regist)
    Button btnRegist;
    private Unbinder unbinder;
    private int sexNum;
    private final String TAG="RegistActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_regist);
        unbinder = ButterKnife.bind(this);


    }

    @Override
    public void onRegistSuccess(Object o) {
        Toast.makeText(RegistActivity.this,"注册成功！",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(RegistActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onRegistFailed() {
        Toast.makeText(RegistActivity.this,"注册失败！",Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btn_regist)
    public void onViewClicked() {

        final String nikename = registNike.getText().toString().trim();
        final String sex = registSex.getText().toString().trim();
        if (sex.equals("男")){
            sexNum=1;
        }else if (sex.equals("女")){
            sexNum=2;
        }
        final String birthday = registDate.getText().toString().trim();
        final String phone = registPhone.getText().toString();
        Log.i(TAG, "initView: "+phone);
        Log.i(TAG, "initView1: "+sex);
        final String email = registEmail.getText().toString().trim();
        String pwd = registPwd.getText().toString().trim();
        final String encrypt = EncryptUtil.encrypt(pwd);
        String pwd2 = registPwd2.getText().toString().trim();
        final String encrypt2 = EncryptUtil.encrypt(pwd2);

        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(encrypt)|| TextUtils.isEmpty(encrypt2)|| TextUtils.isEmpty(sex)|| TextUtils.isEmpty(birthday)|| TextUtils.isEmpty(email)|| TextUtils.isEmpty(nikename)) {
            Toast.makeText(RegistActivity.this, "请完善您的信息！", Toast.LENGTH_LONG).show();

        }else {
            if (encrypt.equals(encrypt2)){
                mPresenter.getRegistMethed(nikename,phone,encrypt,encrypt2,sexNum,birthday,"123456","小米","5.0","android",email);
            }else {
                Toast.makeText(RegistActivity.this,"请确认你的密码是否正确！",Toast.LENGTH_LONG).show();
            }
        }

    }
}
