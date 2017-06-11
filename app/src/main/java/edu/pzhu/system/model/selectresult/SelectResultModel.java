package edu.pzhu.system.model.selectresult;

import java.util.Map;

import edu.pzhu.system.base.BaseModel;
import edu.pzhu.system.base.BaseSubscriber;
import edu.pzhu.system.base.IBasePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/5/13.
 */
public class SelectResultModel extends BaseModel<SelectResultBean> {
    @Override
    public void requestData(IBasePresenter<SelectResultBean> callBack, int requestCode, Map<String, String> params) {
        service.getSelectResult(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<>(callBack, requestCode));
    }
}
