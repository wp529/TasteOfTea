package edu.pzhu.system.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.zxing.activity.CaptureActivity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.Random;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.pzhu.system.R;
import edu.pzhu.system.api.ApiManager;
import edu.pzhu.system.model.CodeBean;
import okhttp3.Call;
import okhttp3.Response;

public class UserMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_scan_qrcode)
    public void scanQRCode(View v) {
        Intent intent = new Intent(UserMainActivity.this, CaptureActivity.class);
        startActivityForResult(intent, 123);
        //startActivity(new Intent(this,SelectResultActivity.class));
    }

    @OnClick(R.id.btn_tea_info)
    public void teaInfo(View v) {
        startActivity(new Intent(this,TeaInfoActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("qr_scan_result");//扫描获取id
            //Toast.makeText(this, "扫描结果:" + scanResult, Toast.LENGTH_SHORT).show();
            //获取id
            //System.out.println("+++++++++" + scanResult);
            getCodeFromServer(scanResult);
            //startActivity(new Intent(this,SelectResultActivity.class));
        }else{
            Toast.makeText(UserMainActivity.this,"你没有扫描",Toast.LENGTH_SHORT).show();
        }
        //Toast.makeText(UserMainActivity.this,"你没有扫描",Toast.LENGTH_SHORT).show();
        /*Random random = new Random();
        getCodeFromServer("" + (random.nextInt(5) + 1));*/
    }

    private void getCodeFromServer(String scanResult) {
        OkGo.post(ApiManager.BASE_URL+"AppApi/Tea/getCodeDetails")
               .params("id",scanResult)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        String result = s.toString().trim();
                        if(!TextUtils.isEmpty(result)){
                            Gson gson = new Gson();
                            CodeBean codeBean = gson.fromJson(result, CodeBean.class);
                            String number_sn = codeBean.getDatas().getNumber_sn();
                            Intent intent = new Intent(UserMainActivity.this,SelectResultActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("number_sn",number_sn);//将编码传递过去
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    }
                });
    }
}
