package edu.pzhu.system.base;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.Toast;

public abstract class BaseFragment<T> extends Fragment implements IBaseView<T>{
    private ProgressDialog progressDialog;
    @Override
    public void displayDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("加载中……");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public abstract void loadDataSuccess(T data, int requestCode);

    @Override
    public void hideDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void loadDataError(String errorMsg, int requestCode) {
        toast(errorMsg);
    }

    @Override
    public void toast(String toastMsg) {
        if(!TextUtils.isEmpty(toastMsg))
            Toast.makeText(getActivity(),toastMsg,Toast.LENGTH_SHORT).show();
    }
}
