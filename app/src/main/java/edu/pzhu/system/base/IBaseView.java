package edu.pzhu.system.base;

/**
 * MVP中的View接口
 * 每个activity或者fragment基本的请求数据与View相关操作都有
 * 泛型T代表加载的数据Model
 */
public interface IBaseView<T> {
    /**
     * 显示Dialog
     */
    void displayDialog();

    /**
     * 加载数据
     * @param data 请求回来的数据
     * @param requestCode 请求的标识
     */
    void loadDataSuccess(T data, int requestCode);

    /**
     * 隐藏Dialog
     */
    void hideDialog();

    /**
     * 加载失败
     * @param errorMsg 加载失败的原因
     * @param requestCode 请求的标识
     */
    void loadDataError(String errorMsg, int requestCode);

    /**
     * 给用户的提示
     * @param toastMsg 提示信息
     */
    void toast(String toastMsg);
}
