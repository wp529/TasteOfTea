package com.pzhu.tabbarview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

public class Page extends View {
    private String fragment;
    private int normal;
    private int select;
    private String text;
    private boolean check;
    private int drawableSelect;
    private int drawableNormal;


    public Page(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.pages);
        int attrCount = a.getIndexCount();
        for (int i = 0; i < attrCount; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.pages_text_color_select) {
                setNormal(a.getColor(attr, Color.BLACK));

            } else if (attr == R.styleable.pages_text_color_normal) {
                setSelect(a.getColor(attr, Color.GRAY));

            } else if (attr == R.styleable.pages_text) {
                setText(a.getString(attr));

            } else if (attr == R.styleable.pages_checked) {
                setCheck(a.getBoolean(attr, false));

            } else if (attr == R.styleable.pages_icon_normal) {
                setDrawableNormal(a.getResourceId(attr, -1));

            } else if (attr == R.styleable.pages_icon_select) {
                setDrawableSelect(a.getResourceId(attr, -1));

            } else if (attr == R.styleable.pages_page) {
                String className = a.getString(attr);
                setFragment(className);

            }
        }
        a.recycle();
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getFragment() {
        return fragment;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public int getSelect() {
        return select;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDrawableSelect() {
        return drawableSelect;
    }

    public void setDrawableSelect(int drawableSelect) {
        this.drawableSelect = drawableSelect;
    }

    public int getDrawableNormal() {
        return drawableNormal;
    }

    public void setDrawableNormal(int drawableNormal) {
        this.drawableNormal = drawableNormal;
    }

}
