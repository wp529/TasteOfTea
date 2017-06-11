package edu.pzhu.system.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.pzhu.system.MyApplication;
import edu.pzhu.system.R;
import edu.pzhu.system.api.ApiManager;
import edu.pzhu.system.base.BaseActivity;
import edu.pzhu.system.model.FertilizationAndApplication;
import edu.pzhu.system.model.handleresult.HandleResultBean;
import edu.pzhu.system.presenter.ManageTeaPresenter;
import okhttp3.Call;
import okhttp3.Response;

public class ManageActivity extends BaseActivity<HandleResultBean> {
    private static final int WATER = 1;
    private static final int FERTILIZATION = 2;
    private static final int CUT = 3;
    private static final int PICK = 4;
    private static final int APPLY = 5;
    private static final int MAKE = 6;
    private ManageTeaPresenter presenter;
    private String teaNumber;
    private ImageView back;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        back = (ImageView) findViewById(R.id.manage_top_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        teaNumber = getIntent().getStringExtra("tea_number");
        presenter = new ManageTeaPresenter(this);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ll_apply_tea, R.id.ll_cut_tea, R.id.tv_done_tea, R.id.ll_fertilization_tea, R.id.ll_water_tea, R.id.ll_pick_tea, R.id.ll_make_tea})
    public void doRightThing(View view) {
        switch (view.getId()) {
            case R.id.ll_apply_tea:
                getFertilizationAndApplication(2);
                //showSinChooseDialog(new String[]{"药1", "药2", "药3"}, "选择药品品种", APPLY);
                break;
            case R.id.ll_cut_tea:
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = format.format(date);
                showNormalDialog("修剪", "现在时间\n" + time +"\n确认已经进行了修剪操作？", CUT, null, null);
                break;
            case R.id.tv_done_tea:
                break;
            case R.id.ll_fertilization_tea:
                getFertilizationAndApplication(1);
                //showSinChooseDialog(new String[]{"化肥1", "化肥2", "化肥3"}, "选择化肥品种", FERTILIZATION);
                break;
            case R.id.ll_water_tea:
                //showNormalDialog("给茶浇水", "你确定给茶浇水吗？", WATER);
                showTeaDialog();
                break;
            case R.id.ll_pick_tea:
                showNormalDialog("采摘茶叶", "你确定采摘茶叶吗？", PICK, null, null);
                break;
            case R.id.ll_make_tea:
                showNormalDialog("制作茶叶", "你确定要制作茶叶吗？", MAKE, null, null);
                //showSinChooseDialog(new String[]{"茶叶1", "茶叶2", "茶叶3"}, "选择茶叶品种", MAKE);
                break;
        }
    }

    /**
     * 施肥施药
     *
     * @param type
     */
    private void getFertilizationAndApplication(final int type) {
        OkGo.post(ApiManager.BASE_URL + "AppApi/ManurePesticide/getList")
                .params("type", type)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        String result = s.toString().trim();
                        if (!TextUtils.isEmpty(result)) {
                            Gson gson = new Gson();
                            FertilizationAndApplication json = gson.fromJson(result, FertilizationAndApplication.class);
                            if (json.getCode() == 200) {
                                List<FertilizationAndApplication.DatasEntity> datas = json.getDatas();
                                items = new String[datas.size()];
                                for (int i = 0; i < datas.size(); i++) {
                                    FertilizationAndApplication.DatasEntity datasEntity = datas.get(i);
                                    items[i] = datasEntity.getName();
                                }
                                if (type == 1) {//肥料
                                    showSinChooseDialog(items, "选择肥料品种", FERTILIZATION);
                                }
                                if (type == 2) {//农药
                                    showSinChooseDialog(items, "请选择肥料品种", APPLY);
                                }
                            }
                        }
                    }
                });
    }

    private void showTeaDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ManageActivity.this);
        builder.setTitle("请输入");    //设置对话框标题
        builder.setIcon(android.R.drawable.btn_star);   //设置对话框标题前的图标
        /*final EditText edit = new EditText(ManageActivity.this);
        edit.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(edit);*/
        View view = View.inflate(this,R.layout.layout_water,null);
        final EditText edit = (EditText) view.findViewById(R.id.et_input);
        TextView date = (TextView) view.findViewById(R.id.tv_date);
        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date1);
        date.setText(time);
        builder.setView(view);
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(ManageActivity.this, "你输入的是: " + edit.getText().toString(), Toast.LENGTH_SHORT).show();
                if (TextUtils.isEmpty(edit.getText().toString().trim())){
                    toast("浇水数量不能为空");
                    return;
                }
                showNormalDialog("给茶浇水", "你确定给茶浇水吗？", WATER, edit.getText().toString().trim(), null);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(ManageActivity.this, "你点了取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(true);    //设置按钮是否可以按返回键取消,false则不可以取消
        AlertDialog dialog = builder.create();  //创建对话框
        dialog.setCanceledOnTouchOutside(true); //设置弹出框失去焦点是否隐藏,即点击屏蔽其它地方是否隐藏
        dialog.show();
    }

    public void getDataFromServer(HttpParams params, final int type) {
        OkGo.post(ApiManager.BASE_URL + "AppApi/Tea/addTask")
                .params(params)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        String result = s.toString().trim();
                        if (!TextUtils.isEmpty(result)) {
                            Gson gson = new Gson();
                            HandleResultBean resultBean = gson.fromJson(result, HandleResultBean.class);
                            if (resultBean.code == 200) {
                                if (type == WATER) {
                                    toast("浇水成功");
                                } else if (type == CUT) {
                                    toast("修剪成功");
                                } else if (type == PICK) {
                                    toast("摘茶成功");
                                } else if (type == MAKE) {
                                    toast("制茶成功");
                                } else if (type == APPLY) {
                                    toast("施药成功");
                                } else if (type == FERTILIZATION) {
                                    toast("施肥成功");
                                }
                            }
                        }
                    }
                });
    }

    @Override
    public void loadDataSuccess(HandleResultBean data, int requestCode) {

    }

    int yourChose = -1;

    private void showSinChooseDialog(final String[] items, String title, final int handle) {
        yourChose = -1;
        final AlertDialog.Builder sinChosDia = new AlertDialog.Builder(this);
        sinChosDia.setTitle(title);
        sinChosDia.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                yourChose = which;
            }
        });
        sinChosDia.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (yourChose != -1) {
                    switch (handle) {
                        case APPLY:
                            showNormalDialog("给茶施药", "你确定给茶施" + items[yourChose] + "吗？", APPLY, null, items[yourChose]);
                            break;
                        case FERTILIZATION:
                            showNormalDialog("给茶施肥", "你确定给茶施" + items[yourChose] + "吗？", FERTILIZATION, null, items[yourChose]);
                            break;
                        /*case MAKE:
                            showNormalDialog("制作茶叶", "你确定给茶进行" + items[yourChose] + "吗？", MAKE,null);
                            break;*/
                    }
                    yourChose = -1;
                }
            }
        });
        sinChosDia.create().show();
    }

    /*普通的对话框*/
    private void showNormalDialog(String title, String content, final int item, final String value, final String name) {
        AlertDialog.Builder normalDia = new AlertDialog.Builder(this);
        normalDia.setIcon(android.R.drawable.ic_dialog_alert);
        normalDia.setTitle(title);
        normalDia.setMessage(content);

        normalDia.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (item) {
                    case WATER:
                        HttpParams waterParams = new HttpParams();
                        waterParams.put("mid", MyApplication.MID);
                        waterParams.put("use_name", "");
                        waterParams.put("use_number", value);
                        waterParams.put("number_sn", teaNumber);
                        waterParams.put("type", "1");
                        getDataFromServer(waterParams, WATER);
                        //toast("浇水"+value);
                        break;
                    case CUT:
                        HttpParams cutParams = new HttpParams();
                        cutParams.put("mid", MyApplication.MID);
                        cutParams.put("use_name", "");
                        cutParams.put("use_number", "");
                        cutParams.put("number_sn", teaNumber);
                        cutParams.put("type", "3");
                        getDataFromServer(cutParams, CUT);
                        //toast("修剪成功");
                        break;
                    case PICK:
                        HttpParams pickParams = new HttpParams();
                        pickParams.put("mid", MyApplication.MID);
                        pickParams.put("use_name", "");
                        pickParams.put("use_number", "");
                        pickParams.put("number_sn", teaNumber);
                        pickParams.put("type", "4");
                        getDataFromServer(pickParams, PICK);
                        //toast("摘茶成功");
                        break;
                    case APPLY:
                        HttpParams applyParams = new HttpParams();
                        applyParams.put("mid", MyApplication.MID);
                        applyParams.put("use_name", name);
                        applyParams.put("use_number", "");
                        applyParams.put("number_sn", teaNumber);
                        applyParams.put("type", "5");
                        getDataFromServer(applyParams, APPLY);
                        //toast("施药成功");
                        break;
                    case FERTILIZATION:
                        HttpParams fertilizationParams = new HttpParams();
                        fertilizationParams.put("mid", MyApplication.MID);
                        fertilizationParams.put("use_name", name);
                        fertilizationParams.put("use_number", "");
                        fertilizationParams.put("number_sn", teaNumber);
                        fertilizationParams.put("type", "2");
                        getDataFromServer(fertilizationParams, FERTILIZATION);
                        //toast("施肥成功");
                        break;
                    case MAKE:
                        HttpParams makeParams = new HttpParams();
                        makeParams.put("mid", MyApplication.MID);
                        makeParams.put("use_name", "");
                        makeParams.put("use_number", "");
                        makeParams.put("number_sn", teaNumber);
                        makeParams.put("type", "6");
                        getDataFromServer(makeParams, MAKE);
                        //toast("制作成功");
                        break;
                }
            }
        });
        normalDia.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        normalDia.create().show();
    }
}
