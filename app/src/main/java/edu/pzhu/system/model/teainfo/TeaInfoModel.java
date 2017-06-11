package edu.pzhu.system.model.teainfo;

import java.util.Map;

import edu.pzhu.system.base.BaseModel;
import edu.pzhu.system.base.BaseSubscriber;
import edu.pzhu.system.base.IBasePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/5/13.
 */
public class TeaInfoModel extends BaseModel<TeaInfoBean> {
    @Override
    public void requestData(IBasePresenter<TeaInfoBean> callBack, int requestCode, Map<String, String> params) {
        service.getTeaInfoList(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<>(callBack, requestCode));
    }
}
