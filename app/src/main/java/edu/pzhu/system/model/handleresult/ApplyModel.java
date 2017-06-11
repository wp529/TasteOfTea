package edu.pzhu.system.model.handleresult;

import java.util.Map;

import edu.pzhu.system.base.BaseModel;
import edu.pzhu.system.base.BaseSubscriber;
import edu.pzhu.system.base.IBasePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApplyModel extends BaseModel<HandleResultBean>{
    @Override
    public void requestData(IBasePresenter<HandleResultBean> callBack, int requestCode, Map<String, String> params) {
        service.applyTea(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<>(callBack, requestCode));
    }
}
