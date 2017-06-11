package edu.pzhu.system.view;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.pzhu.system.R;
import edu.pzhu.system.base.BaseActivity;
import edu.pzhu.system.model.teainfo.TeaInfoBean;
import edu.pzhu.system.model.teainfodetail.TeaInfoDetailBean;
import edu.pzhu.system.presenter.TeaInfoDetailPresenter;

public class TeaInfoDetailActivity extends BaseActivity<TeaInfoDetailBean> {

    @Bind(R.id.iv)
    ImageView iv;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.wb)
    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_info_detail);
        ButterKnife.bind(this);
        TeaInfoDetailPresenter presenter = new TeaInfoDetailPresenter(this);
        Bundle bundle = getIntent().getExtras();
        String discribe = bundle.getString("discribe");
        String cover = bundle.getString("cover");
        final String webUrl = bundle.getString("webUrl");
        String time = bundle.getString("time");
        Picasso.with(this).load(cover)
                .fit()
                .placeholder(R.drawable.login_bg)
                .error(R.drawable.login_bg)
                .into(iv);
        tvTitle.setText(discribe);
        tvTime.setText(time);
        wb.loadUrl(webUrl);
        WebSettings webSettings =   wb .getSettings();
        webSettings.setUseWideViewPort(true);//设置此属性，可任意比例缩放
        webSettings.setLoadWithOverviewMode(true);
        wb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(webUrl);
                return true;
            }
        });
    }

    @Override
    public void loadDataSuccess(TeaInfoDetailBean data, int requestCode) {

    }
}
