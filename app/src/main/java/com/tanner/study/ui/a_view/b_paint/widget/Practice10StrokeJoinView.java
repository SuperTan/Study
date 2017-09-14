package com.tanner.study.ui.a_view.b_paint.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Tanner on 2017/8/19.
 */

public class Practice10StrokeJoinView extends View {

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path mPath = new Path();

    public Practice10StrokeJoinView(Context context) {
        super(context);
    }

    public Practice10StrokeJoinView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10StrokeJoinView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    {
        mPaint.setStrokeWidth(40);
        mPaint.setStyle(Paint.Style.STROKE);

        mPath.rLineTo(200, 0);
        mPath.rLineTo(-160, 120);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        // 使用 Paint.setStrokeJoin() 来设置不同的拐角形状
        //TRANSLATE：位移
        //ROTATE：旋转
        //MORPH：变体

        canvas.translate(100, 100); //相对平移
        //第一种形状 MITER
        mPaint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawPath(mPath, mPaint);

        canvas.translate(300, 0);
        // 第二种形状：BEVEL
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(mPath, mPaint);

        canvas.translate(300, 0);
        // 第三种形状：ROUND
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(mPath, mPaint);

        canvas.restore();


    }
}
