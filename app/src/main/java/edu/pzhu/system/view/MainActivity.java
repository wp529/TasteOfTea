package edu.pzhu.system.view;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import edu.pzhu.system.R;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bundle bundle = getIntent().getExtras();
        //String mid = bundle.getString("mid");
    }
}
