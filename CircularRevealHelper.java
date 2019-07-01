package com.shinhoandroid.constraintlayout;

import android.content.Context;
import android.os.Build;
import android.support.constraint.ConstraintHelper;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;

/**
 * @author Liupengfei
 * @describe TODO
 * @date on 2019/7/1 9:34
 */
public class CircularRevealHelper extends ConstraintHelper {
    public CircularRevealHelper(Context context) {
        super(context);
    }
    public CircularRevealHelper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public void updatePostLayout(ConstraintLayout container) {
        super.updatePostLayout(container);
        //版本判断
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){ return;}
        //获取所有的View
        for (int i= 0;i<mCount;i++) {
            View view = container.getViewById(mIds[i]);
            Double radius = Math.hypot(view.getWidth(), view.getHeight());
            Float f = Float.parseFloat(String.valueOf(radius));
            //实现动画
            ViewAnimationUtils.createCircularReveal(view, 0, 0, 0f, f)
                    .setDuration(2000L)
                    .start();
        }
    }
}
