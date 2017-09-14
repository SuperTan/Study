package com.tanner.study.ui.a_view.b_paint.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        CornerPathEffect cornerPathEffect = new CornerPathEffect(20);
        paint.setPathEffect(cornerPathEffect);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(500, 0);
        // 第二处：DiscretePathEffect 线条进行随机的偏离
        //iscretePathEffect(float segmentLength, float deviation) 的两个参数中，  segmentLength 是用来拼接的每个线段的长度， deviation 是偏离量
        paint.setPathEffect(new DiscretePathEffect(20, 5));
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第三处：DashPathEffect 使用虚线来绘制线条
        /**
         * 它的构造方法 DashPathEffect(float[] intervals, float phase) 中， 第一个参数 intervals 是一个数组，
         * 它指定了虚线的格式：数组中元素必须为偶数（最少是 2 个），按照「画线长度、空白长度、画线长度、空白长度」
         * ……的顺序排列，例如上面代码中的 20, 5, 10, 5 就表示虚线是按照「画 20 像素、空 5 像素、画 10 像素
         * 、空 5 像素」的模式来绘制；第二个参数 phase 是虚线的偏移量。
         * */
        paint.setPathEffect(new DashPathEffect(new float[]{10, 5, 20, 10}, 0));
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // 第四处：PathDashPathEffect
        Path dashPath = new Path();
        dashPath.moveTo(10, 10);
        dashPath.lineTo(15, 20);
        dashPath.lineTo(5, 20);
        dashPath.close();
        PathDashPathEffect pathDashPathEffect = new PathDashPathEffect(dashPath, 40, 0, PathDashPathEffect.Style.TRANSLATE);

        paint.setPathEffect(pathDashPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect
        PathEffect dashEffect = new DashPathEffect(new float[]{20, 10}, 0);
        PathEffect discretePathEffect = new DiscretePathEffect(20, 5);
        PathEffect sumPathEffect = new SumPathEffect(dashEffect, discretePathEffect);
        paint.setPathEffect(sumPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第六处：ComposePathEffect
        PathEffect dashEffect1 = new DashPathEffect(new float[]{20, 10}, 0);
        PathEffect discretePathEffect1 = new DiscretePathEffect(20, 5);
        PathEffect composePathEffect = new ComposePathEffect(dashEffect1, discretePathEffect1);
        paint.setPathEffect(composePathEffect);

        canvas.drawPath(path, paint);
        canvas.restore();
    }
}