package edu.pzhu.system.presenter;

import java.util.Map;

import edu.pzhu.system.base.BasePresenter;
import edu.pzhu.system.base.IBaseView;
import edu.pzhu.system.model.handleresult.ApplyModel;
import edu.pzhu.system.model.handleresult.CutModel;
import edu.pzhu.system.model.handleresult.FertilizeModel;
import edu.pzhu.system.model.handleresult.HandleResultBean;
import edu.pzhu.system.model.handleresult.MakeModel;
import edu.pzhu.system.model.handleresult.PickModel;
import edu.pzhu.system.model.handleresult.WaterModel;

public class ManageTeaPresenter extends BasePresenter<HandleResultBean> {

    private final ApplyModel applyModel;
    private final CutModel cutModel;
    private final FertilizeModel fertilizeModel;
    private final MakeModel makeModel;
    private final PickModel pickModel;
    private final WaterModel waterModel;

    /**
     * 构造方法
     *
     * @param view 具体业务的接口对象
     */
    public ManageTeaPresenter(IBaseView view) {
        super(view);
        applyModel = new ApplyModel();
        cutModel = new CutModel();
        fertilizeModel = new FertilizeModel();
        makeModel = new MakeModel();
        pickModel = new PickModel();
        waterModel = new WaterModel();
    }

    public void applyTea(Map<String, String> params) {
        applyModel.requestData(this,1,params);
    }

    public void cutTea(Map<String, String> params) {
        cutModel.requestData(this,1,params);
    }

    public void fertilizeTea(Map<String, String> params) {
        fertilizeModel.requestData(this,1,params);
    }

    public void makeTea(Map<String, String> params) {
        makeModel.requestData(this,1,params);
    }

    public void pickTea(Map<String, String> params) {
        pickModel.requestData(this,1,params);
    }

    public void waterTea(Map<String, String> params) {
        waterModel.requestData(this,1,params);
    }

}
