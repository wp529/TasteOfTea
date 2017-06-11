package com.pzhu.tabbarview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TabBarView extends RelativeLayout {
    private static String PAGE_NAME = "com.pzhu.tabbarview.Page";
    private Context ctx;
    private int windowWidth;
    private int windowHeight;
    private int statusHeight;
    private RadioGroup tabBarContainer;
    private FrameLayout pages;
    private ArrayList<String> tabText = new ArrayList<>();
    private ArrayList<Integer> tabTextNormal = new ArrayList<>();
    private ArrayList<Integer> tabTextSelect = new ArrayList<>();
    private ArrayList<Boolean> tabCheck = new ArrayList<>();
    private ArrayList<String> pageFragment = new ArrayList<>();
    private ArrayList<Integer> selectIcon = new ArrayList<>();
    private ArrayList<Integer> normalIcon = new ArrayList<>();
    private Map<String,Fragment> fragments = new HashMap<>();

    public TabBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;
        getWindowWidthAndHeight();
        getStatusBarHeight();
        initLayout();
    }

    private void initLayout() {
        tabBarContainer = new RadioGroup(ctx);
        LayoutParams tabBarContainerParams = new LayoutParams(windowWidth, (int) (windowHeight() * 0.1));
        tabBarContainerParams.addRule(ALIGN_PARENT_BOTTOM);
        tabBarContainer.setOrientation(LinearLayout.HORIZONTAL);
        tabBarContainer.setLayoutParams(tabBarContainerParams);
        pages = new FrameLayout(ctx);
        LayoutParams pagesParams = new LayoutParams(windowWidth, (int) (windowHeight() * 0.9));
        pages.setLayoutParams(pagesParams);
        pages.setId(R.id.frameid);
        this.addView(tabBarContainer);
        this.addView(pages);
    }

    @Override
    protected void onAttachedToWindow() {
        initPageData();
        initTabBarUI();
        initPage();
        initListener();
    }

    private void initPage() {
        FragmentActivity activity = (FragmentActivity) ctx;
        android.support.v4.app.FragmentManager manager = activity.getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        for (int i = 0; i < tabCheck.size(); i++) {
            if (tabCheck.get(i)) {
                Fragment fragment = fragments.get(pageFragment.get(i));
                if(fragment == null){
                    try {
                        fragment = (Fragment) Class.forName(pageFragment.get(i)).newInstance();
                        fragments.put(pageFragment.get(i),fragment);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                transaction.replace(pages.getId(), fragment);
                transaction.commit();
            }
        }
    }

    private void initListener() {
        tabBarContainer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                int count = radioGroup.getChildCount();
                for (int i = 0; i < count; i++) {
                    RadioButton rb = (RadioButton) radioGroup.getChildAt(i);
                    if (id == rb.getId()) {
                        Drawable d = getResources().getDrawable(selectIcon.get(i));
                        rb.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
                        rb.setTextColor(tabTextNormal.get(i));
                        FragmentActivity activity = (FragmentActivity) ctx;
                        android.support.v4.app.FragmentManager manager = activity.getSupportFragmentManager();
                        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
                        Fragment fragment = fragments.get(pageFragment.get(i));
                        if(fragment == null){
                            try {
                                fragment = (Fragment) Class.forName(pageFragment.get(i)).newInstance();
                                fragments.put(pageFragment.get(i),fragment);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        transaction.replace(pages.getId(), fragment);
                        transaction.commit();
                    } else {
                        rb.setTextColor(tabTextSelect.get(i));
                        Drawable d = getResources().getDrawable(normalIcon.get(i));
                        rb.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
                    }
                }
            }
        });
    }

    private void initTabBarUI() {
        int radioCount = pageFragment.size();
        int radioWidth = windowWidth / radioCount;
        for (int i = 0; i < radioCount; i++) {
            RadioButton radio = new RadioButton(ctx);
            LayoutParams param = new LayoutParams(radioWidth, (int) (windowHeight() * 0.1));
            radio.setLayoutParams(param);
            radio.setText(tabText.get(i));
            Bitmap a = null;
            radio.setButtonDrawable(new BitmapDrawable(a));

            if (tabCheck.get(i)) {
                Drawable d = getResources().getDrawable(selectIcon.get(i));
                radio.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
                radio.setTextColor(tabTextNormal.get(i));
            } else {
                Drawable d = getResources().getDrawable(normalIcon.get(i));
                radio.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
                radio.setTextColor(tabTextSelect.get(i));
            }
            radio.setGravity(Gravity.CENTER);
            tabBarContainer.addView(radio);
        }
    }

    private void getWindowWidthAndHeight() {
        WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        windowWidth = wm.getDefaultDisplay().getWidth();
        windowHeight = wm.getDefaultDisplay().getHeight();
    }

    private void getStatusBarHeight() {
        Class<?> c;
        Object obj;
        Field field;
        int x;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusHeight = getContext().getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }


    private void initPageData() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (PAGE_NAME.equals(getChildAt(i).getClass().getName())) {
                Page page = (Page) getChildAt(i);
                tabText.add(page.getText());
                tabTextNormal.add(page.getNormal());
                tabTextSelect.add(page.getSelect());
                pageFragment.add(page.getFragment());
                tabCheck.add(page.isCheck());
                selectIcon.add(page.getDrawableSelect());
                normalIcon.add(page.getDrawableNormal());
            }
        }
    }

    private int windowHeight() {
        return windowHeight - statusHeight;
    }
}
