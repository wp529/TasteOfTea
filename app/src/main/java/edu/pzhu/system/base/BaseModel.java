package edu.pzhu.system.base;

import java.util.Map;

import edu.pzhu.system.api.ApiManager;
import edu.pzhu.system.api.Service;

public abstract class BaseModel<T> {
    protected Service service;

    public BaseModel() {
        service = ApiManager.builder().getService();
    }
    public abstract void requestData(IBasePresenter<T> callBack, int requestCode, Map<String,String> params);
}
