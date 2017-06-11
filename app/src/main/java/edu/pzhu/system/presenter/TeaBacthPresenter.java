package edu.pzhu.system.presenter;

import java.util.Map;

import edu.pzhu.system.base.BasePresenter;
import edu.pzhu.system.base.IBaseView;
import edu.pzhu.system.model.teabatch.TeaBatchBean;
import edu.pzhu.system.model.teabatch.TeaBatchModel;

public class TeaBacthPresenter extends BasePresenter<TeaBatchBean> {

    private final TeaBatchModel teaBatchModel;

    /**
     * 构造方法
     *
     * @param view 具体业务的接口对象
     */
    public TeaBacthPresenter(IBaseView view) {
        super(view);
        teaBatchModel = new TeaBatchModel();
    }

    public void getTeaBatch(Map<String, String> params){
        teaBatchModel.requestData(this,1,params);
    }
}
