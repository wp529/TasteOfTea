package edu.pzhu.system.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.pzhu.system.MyApplication;
import edu.pzhu.system.R;
import edu.pzhu.system.api.ApiManager;
import edu.pzhu.system.base.BaseActivity;
import edu.pzhu.system.model.ConfirmBean;
import edu.pzhu.system.model.teabatch.TeaBatchBean;
import edu.pzhu.system.presenter.TeaBacthPresenter;
import okhttp3.Call;
import okhttp3.Response;

public class AddTeaBatchActivity extends BaseActivity<TeaBatchBean>{
    @Bind(R.id.add_top_back)
    ImageView addTopBack;
    @Bind(R.id.tv_batch_number)
    TextView tvBatchNumber;
    @Bind(R.id.tv_add_time)
    TextView tvAddTime;
    @Bind(R.id.et_tea_house_name)
    EditText etTeaHouseName;
    @Bind(R.id.btn_add)
    Button btnAdd;
    private TeaBacthPresenter presenter;
    private String time;
    private String number_sn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tea_batch);
        getBatchNumber();
        ButterKnife.bind(this);
        presenter = new TeaBacthPresenter(this);
        setListener();
    }

    private void setListener() {
        addTopBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teaHouseName = etTeaHouseName.getText().toString().trim();
                if(!TextUtils.isEmpty(MyApplication.MID)
                        &&!TextUtils.isEmpty(number_sn)
                        &&!TextUtils.isEmpty(time)
                        &&!TextUtils.isEmpty(teaHouseName)){
                    Map<String,String> map = new HashMap<String, String>();
                    map.put("mid", MyApplication.MID);
                    map.put("number_sn",number_sn);
                    map.put("create_time",time);
                    map.put("tea_park",teaHouseName);
                    presenter.getTeaBatch(map);
                }else {
                    toast("茶园信息不能为空");
                }
            }
        });
    }

    private void getBatchNumber() {
        OkGo.post(ApiManager.BASE_URL+"AppApi/Tea/getNextNumber")
                .execute(new StringCallback() {

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        String result = s.toString().trim();
                        if(!TextUtils.isEmpty(result)){
                            Gson gson = new Gson();
                            ConfirmBean confirmBean = gson.fromJson(result, ConfirmBean.class);
                            number_sn = confirmBean.getDatas().getNumber_sn();
                            //Log.e("==========",number_sn);
                            tvBatchNumber.setText(number_sn);
                            time = getTime();
                            tvAddTime.setText(time);
                        }
                    }
                });
    }

    private String getTime(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);
        return time;
    }

    @Override
    public void loadDataSuccess(TeaBatchBean data, int requestCode) {
        Log.e("===========",data.code+"");
        if(data.code==200){
            toast("添加批次成功");
            finish();
        }else{
            toast("添加批次失败");
        }
    }


}
