package edu.pzhu.system.model.login;

import java.util.Map;

import edu.pzhu.system.base.BaseModel;
import edu.pzhu.system.base.BaseSubscriber;
import edu.pzhu.system.base.IBasePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class LoginModel extends BaseModel<LoginBean> {
    @Override
    public void requestData(IBasePresenter<LoginBean> callBack, int requestCode, Map<String, String> params) {
        service.getLoginStatus(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<>(callBack, requestCode));
    }
}
