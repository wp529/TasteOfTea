package edu.pzhu.system.model.manager;

import java.util.Map;

import edu.pzhu.system.base.BaseModel;
import edu.pzhu.system.base.BaseSubscriber;
import edu.pzhu.system.base.IBasePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ManagerModel extends BaseModel<ManagerBean> {
    @Override
    public void requestData(IBasePresenter<ManagerBean> callBack, int requestCode, Map<String, String> params) {
        service.getManagerList(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<>(callBack, requestCode));
    }
}
