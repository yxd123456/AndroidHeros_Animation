package com.jike.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 类动画初体验
     * @param v
     */
    public void click1(View v){
        ObjectAnimator oa = ObjectAnimator.ofFloat(v, "alpha", 0);
        //注意:操纵的属性必须有get和set方法!
        oa.setDuration(2000);
        oa.start();

    }

    /**
     * 属性值持有者
     */
    public void click2(View v){
        PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("translationX", 300f);
        PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
        PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
        ObjectAnimator.ofPropertyValuesHolder(v, pvh1, pvh2, pvh3).setDuration(1000).start();
    }

    /**
     * 值动画器以及动画事件的监听
     */
    public void click3(View v){
        ValueAnimator va = ValueAnimator.ofFloat(0, 100);
        va.setTarget(v);
        va.setRepeatCount(1);
        va.setRepeatMode(ValueAnimator.REVERSE);
        va.setDuration(1000).start();
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float value = (Float) animation.getAnimatedValue();
                Log.d("MainActivity", "value:" + value);
            }
        });
      /*  va.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });*/
        va.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });


    }

    /**
     * 动画集合
     * playTogether()
     * playSeq...
     * animSet.play() with() before() after()
     */
    public void click4(View v){
        ObjectAnimator oa1 = ObjectAnimator.ofFloat(v, "translationX", 300f);
        ObjectAnimator oa2 = ObjectAnimator.ofFloat(v, "scaleX", 1f, 0f, 1f);
        ObjectAnimator oa3 = ObjectAnimator.ofFloat(v, "scaleY", 1f, 0f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(2000);
        set.playTogether(oa1, oa2, oa3);
        set.start();
    }

    /**
     * 在xml中使用属性动画, 需要创建一个animator文件夹
     * @param v
     */
    public void click5(View v){
        Animator anim = AnimatorInflater.loadAnimator(this, R.animator.anim_ye);
        anim.setTarget(v);
        anim.start();
    }

    /**
     * 属性动画的简写形式:View的animate方法
     */
    public void click6(View v){
        v.animate().alpha(0).y(300).setDuration(300)
                .withStartAction(new Runnable() {
                    @Override
                    public void run() {

                    }
                }).withEndAction(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

}
