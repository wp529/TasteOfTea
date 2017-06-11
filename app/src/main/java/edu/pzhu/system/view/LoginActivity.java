package edu.pzhu.system.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.pzhu.system.MyApplication;
import edu.pzhu.system.R;
import edu.pzhu.system.base.BaseActivity;
import edu.pzhu.system.model.login.LoginBean;
import edu.pzhu.system.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginBean> {

    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.btn_user)
    Button btnUser;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);

    }

    @OnClick(R.id.btn_login)
    public void click(View v) {
        String loginUsername = etUsername.getText().toString().trim();
        String loginPassword = etPassword.getText().toString().trim();
        if (isUserNameAndPasswordCorrect(loginUsername, loginPassword)) {
            toast("用户名和密码不能为空");
        } else {
            Map<String, String> params = new HashMap<>();
            params.put("username", loginUsername);
            params.put("password", loginPassword);
            loginPresenter.getLoginData(params);
            //startActivity(new Intent(this,MainActivity.class));
        }
    }

    @OnClick(R.id.btn_user)
    public void userIn(View v) {
        startActivity(new Intent(this, UserMainActivity.class));
    }


    @Override
    public void loadDataSuccess(LoginBean data, int requestCode) {
        //System.out.println("+++" + data.getCode());
        if(data.getCode()==200){
            Intent intent = new Intent(this,MainActivity.class);
            //Bundle bundle = new Bundle();
            MyApplication.loginData = data;
            MyApplication.MID = data.getDatas().getMid();
            //bundle.putString("mid",data.getDatas().getMid());
            //intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }else{
            //15680351591  123456
            toast("用户名或密码错误");
        }
    }

    private boolean isUserNameAndPasswordCorrect(String userName, String password) {
        return TextUtils.isEmpty(userName) || TextUtils.isEmpty(password);
    }
}
