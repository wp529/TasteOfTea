package edu.pzhu.system.base;

/**
 * 请求数据的回调
 * Presenter用于接受model获取（加载）数据后的回调
 */
public interface IBasePresenter<T> {
    /**
     * 开始请求之前
     */
    void beforeRequest();

    /**
     * 请求失败
     * @param errorMsg 失败的原因
     * @param requestCode 请求的标识
     */
    void requestError(String errorMsg, int requestCode);

    /**
     * 请求结束
     */
    void requestComplete();

    /**
     * 请求成功
     *
     * @param data 根据业务返回相应的数据
     */
    void requestSuccess(T data, int requestCode);
}
