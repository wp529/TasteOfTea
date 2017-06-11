package edu.pzhu.system.presenter;

import java.util.Map;

import edu.pzhu.system.base.BasePresenter;
import edu.pzhu.system.base.IBaseView;
import edu.pzhu.system.model.selectresult.SelectResultBean;
import edu.pzhu.system.model.selectresult.SelectResultModel;

public class SelectResultPresenter extends BasePresenter<SelectResultBean> {

    private final SelectResultModel selectResultModel;

    /**
     * 构造方法
     *
     * @param view 具体业务的接口对象
     */
    public SelectResultPresenter(IBaseView view) {
        super(view);
        selectResultModel = new SelectResultModel();
    }

    public void getSelectResult(Map<String, String> params) {
        selectResultModel.requestData(this, 1, params);
    }
}
