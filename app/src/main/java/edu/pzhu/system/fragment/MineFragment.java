package edu.pzhu.system.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import edu.pzhu.system.MyApplication;
import edu.pzhu.system.R;
import edu.pzhu.system.model.login.LoginBean;

public class MineFragment extends Fragment{
    private View rootView;
    private TextView tvName;
    private TextView tvStatus;
    private TextView tvRegisterDate;
    private TextView tvAddress;
    private TextView tvPhone;
    private Button loginOut;
    private RelativeLayout call;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            View view = inflater.inflate(R.layout.fragment_mine,null);
            tvName = (TextView) view.findViewById(R.id.tv_user_name);
            tvStatus = (TextView) view.findViewById(R.id.tv_user_status);
            tvRegisterDate = (TextView) view.findViewById(R.id.tv_user_register_date);
            tvAddress = (TextView) view.findViewById(R.id.tv_user_address);
            call = (RelativeLayout) view.findViewById(R.id.el_call);
            tvPhone = (TextView) view.findViewById(R.id.tv_user_phone);
            loginOut = (Button) view.findViewById(R.id.btn_user_loginout);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mIntent = new Intent(Intent.ACTION_CALL);
                    mIntent.setData(Uri.parse("tel:" + tvPhone.getText().toString().trim()));
                    startActivity(mIntent);
                }
            });
            loginOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.exit(0);
                }
            });

            LoginBean.DatasEntity datas = MyApplication.loginData.getDatas();
            tvName.setText(datas.getNickname());
            if("0".equals(datas.getStatus())){
                tvStatus.setText("账号状态:被冻结");
            }else{
                tvStatus.setText("账号状态:已解冻");
            }
            tvRegisterDate.setText("注册时间:" + datas.getCreate_time());
            tvAddress.setText("家庭住址:" + datas.getAddress());
            rootView = view;
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }
}
