package com.jike.propertyanimation;

import android.view.View;

/**
 * Created by Administrator on 2016/2/3.
 * 对于没有get和set的属性, 可以对这个类进行包装然后再添加相关方法
 */
public class WrapperView {

    private View mTarget;

    public WrapperView(View target){
        mTarget = target;
    }

    public int getWidth(){
        return mTarget.getLayoutParams().width;
    }

    public void setWidth(int width){
        mTarget.getLayoutParams().width = width;
        mTarget.requestLayout();
    }

}
