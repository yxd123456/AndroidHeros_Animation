package com.jike.androidheros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     * 透明度动画
     * @param v
     */
    public void click1(View v){
        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setRepeatCount(3);
        aa.setRepeatMode(Animation.REVERSE);
        aa.setDuration(5000);

        aa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(MainActivity.this, "动画开始了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(MainActivity.this, "动画结束了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Toast.makeText(MainActivity.this, "动画重复了", Toast.LENGTH_SHORT).show();
            }
        });
        v.startAnimation(aa);

    }

    /**
     * 旋转动画
     * @param v
     */
    public void click2(View v){
        RotateAnimation ra = new RotateAnimation(0, 360);
        ra.setDuration(1500);
        v.startAnimation(ra);
    }

    /**
     * 位移动画
     * @param v
     */
    public void click3(View v){
        TranslateAnimation ta = new TranslateAnimation(0, 300, 0, 400);
        ta.setDuration(1000);
        v.startAnimation(ta);
    }

    /**
     * 缩放动画
     * @param v
     */
    public void click4(View v){
        ScaleAnimation sa = new ScaleAnimation(0, 2, 0, 2, v.getWidth()/2, v.getHeight()/2);
        sa.setDuration(2000);
        v.startAnimation(sa);
    }

    public void click5(View v){

        AnimationSet as = new AnimationSet(true);
        as.setDuration(1500);

        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setDuration(1500);
        as.addAnimation(aa);

        RotateAnimation ra = new RotateAnimation(0, 360);
        ra.setDuration(1500);
        as.addAnimation(ra);

        TranslateAnimation ta = new TranslateAnimation(0, 300, 0, 400);
        ta.setDuration(1500);
        as.addAnimation(ta);

        ScaleAnimation sa = new ScaleAnimation(0, 2, 0, 2, v.getWidth()/2, v.getHeight()/2);
        sa.setDuration(1500);
        as.addAnimation(sa);

        v.startAnimation(as);

    }




}
