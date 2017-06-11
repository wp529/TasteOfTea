package edu.pzhu.system.presenter;

import java.util.Map;

import edu.pzhu.system.base.BasePresenter;
import edu.pzhu.system.base.IBaseView;
import edu.pzhu.system.model.manager.ManagerBean;
import edu.pzhu.system.model.manager.ManagerModel;

public class ManagerPresenter extends BasePresenter<ManagerBean> {

    private final ManagerModel managerModel;

    /**
     * 构造方法
     *
     * @param view 具体业务的接口对象
     */
    public ManagerPresenter(IBaseView view) {
        super(view);
        managerModel = new ManagerModel();
    }

    public void getManageListData(Map<String, String> params) {
        managerModel.requestData(this, 1, params);
    }
}
