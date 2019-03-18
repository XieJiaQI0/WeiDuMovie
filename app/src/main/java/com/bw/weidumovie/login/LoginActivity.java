package com.bw.weidumovie.login;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.weidumovie.MainActivity;
import com.bw.weidumovie.R;
import com.bw.weidumovie.activity.HomeActivity;
import com.bw.weidumovie.bean.LoginBean;
import com.bw.weidumovie.mvp.MVPBaseActivity;
import com.bw.weidumovie.regist.RegistActivity;
import com.bw.weidumovie.utils.EncryptUtil;
import com.bw.weidumovie.utils.PhoneNumber;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LoginActivity extends MVPBaseActivity<LoginContract.View, LoginPresenter> implements LoginContract.View {


    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.cb_eye)
    CheckBox cbEye;
    @BindView(R.id.checkbox_remember)
    CheckBox checkboxRemember;
    @BindView(R.id.checkbox_go)
    CheckBox checkboxGo;
    @BindView(R.id.text_regist)
    TextView textRegist;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private Unbinder unbinder;
    private SharedPreferences sharedPreferences;
    private boolean isChecked = true;
    private SharedPreferences.Editor edit;

    //手动
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //引用登录的布局
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);
        sharedPreferences = getSharedPreferences("UserS", MODE_PRIVATE);
        boolean flag = sharedPreferences.getBoolean("flag", false);
        checkboxRemember.setChecked(flag);
        if (flag) {

            String phone1 = sharedPreferences.getString("phone", "");
            String pwd1 = sharedPreferences.getString("pwd", "");

            loginPhone.setText(phone1);
            loginPwd.setText(pwd1);
        }

        cbEye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isChecked = !isChecked;
                if (isChecked) {
                    //设置为明文显示
                    loginPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //设置为密文显示
                    loginPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                //光标在最后显示
                loginPwd.setSelection(loginPwd.length());
            }
        });



    }

    @Override
    public void onLoginSuccess(Object o) {
        if (o instanceof LoginBean){
            LoginBean loginBean = (LoginBean)o;
            final String status = loginBean.getStatus();
            String sessionId = loginBean.getResult().getSessionId();
            String userId = loginBean.getResult().getUserId();
            edit.putString("sessionId",sessionId);
            edit.putString("userId",userId);
            edit.commit();
            if (status.equals("0000")){
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    public void onLoginFailed() {

    }

    @OnClick({R.id.text_regist, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_regist:

                Intent intent = new Intent(LoginActivity.this,RegistActivity.class);
                startActivity(intent);
                finish();

                break;
            case R.id.btn_login:
                String phone = loginPhone.getText().toString().trim();
                String pwd = loginPwd.getText().toString().trim();
                String encrypt = EncryptUtil.encrypt(pwd);
                if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(encrypt)) {
                    Toast.makeText(LoginActivity.this, "用户名或密码不能为空！", Toast.LENGTH_LONG).show();
                } else {
                    final boolean mobileNO = PhoneNumber.isMobileNO(phone);
                    if (mobileNO){
                        mPresenter.getLoginMethede(phone,encrypt);
                        sharedPreferences = getSharedPreferences("UserS", MODE_PRIVATE);
                        edit = sharedPreferences.edit();
                        if (checkboxRemember.isChecked()) {
                            edit.putBoolean("flag", true);
                            edit.putString("phone", phone);
                            edit.putString("pwd", pwd);
                        } else {
                            edit.putBoolean("flag", false);
                        }
                        edit.commit();
                    }
                }

                break;
        }
    }
}
