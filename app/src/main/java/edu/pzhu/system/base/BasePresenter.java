package edu.pzhu.system.base;

/**
 * Presenter的基类，对相同的操作进行统一的封装
 */
public class BasePresenter<V> implements IBasePresenter<V> {
    public IBaseView iView;

    /**
     * 构造方法
     *
     * @param view 具体业务的接口对象
     */
    public BasePresenter(IBaseView view) {
        this.iView = view;
    }

    @Override
    public void beforeRequest() {
        iView.displayDialog();
    }

    @Override
    public void requestError(String errorMsg, int requestCode) {
        iView.loadDataError(errorMsg, requestCode);
        iView.hideDialog();
    }

    @Override
    public void requestComplete() {
        iView.hideDialog();
    }

    @Override
    public void requestSuccess(V data, int requestCode) {
        iView.hideDialog();
        iView.loadDataSuccess(data, requestCode);
    }
}
