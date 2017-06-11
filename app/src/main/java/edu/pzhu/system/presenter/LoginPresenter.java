package edu.pzhu.system.presenter;

import java.util.Map;

import edu.pzhu.system.base.BasePresenter;
import edu.pzhu.system.base.IBaseView;
import edu.pzhu.system.model.login.LoginBean;
import edu.pzhu.system.model.login.LoginModel;
import edu.pzhu.system.model.news.News;
import edu.pzhu.system.model.news.NewsModel;

public class LoginPresenter extends BasePresenter<LoginBean> {
    private LoginModel loginModel;

    public LoginPresenter(IBaseView view) {
        super(view);
        loginModel = new LoginModel();
    }

    public void getLoginData(Map<String, String> params) {
        loginModel.requestData(this, 1, params);
    }
}
