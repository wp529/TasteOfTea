package edu.pzhu.system.base;

import rx.Subscriber;

public class BaseSubscriber<T> extends Subscriber<T> {
    private IBasePresenter callBack;
    private int requestCode;

    public BaseSubscriber(IBasePresenter<T> callBack, int requestCode) {
        this.callBack = callBack;
        this.requestCode = requestCode;
    }

    @Override
    public void onStart() {
        super.onStart();
        callBack.beforeRequest();
    }

    @Override
    public void onCompleted() {
        callBack.requestComplete();
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("+++" + e);
        callBack.requestError("网络异常,请重试", requestCode);
    }

    @Override
    public void onNext(T t) {
        if (t != null) {
            callBack.requestSuccess(t, requestCode);
        } else{
            callBack.requestError("网络异常,请重试", requestCode);
            System.out.println("----");
        }
    }
}
