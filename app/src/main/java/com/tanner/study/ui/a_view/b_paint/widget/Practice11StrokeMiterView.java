package com.tanner.study.ui.a_view.b_paint.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Tanner on 2017/8/19.
 */

public class Practice11StrokeMiterView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path mPath = new Path();


    public Practice11StrokeMiterView(Context context) {
        super(context);
    }

    public Practice11StrokeMiterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11StrokeMiterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    {
        mPaint.setStrokeWidth(40);
        mPaint.setStyle(Paint.Style.STROKE);

        mPath.rLineTo(200, 0);
        mPath.rLineTo(-160, 120);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();

        //设置 MITER 型拐角的延长线的最大值
        canvas.translate(100, 100);
        // MITER 值：1
        mPaint.setStrokeMiter(1);
        canvas.drawPath(mPath, mPaint);

        canvas.translate(300, 0);
        // MITER 值：2
        mPaint.setStrokeMiter(2);
        canvas.drawPath(mPath, mPaint);

        canvas.translate(300, 0);
        // MITER 值：5
        mPaint.setStrokeMiter(5);
        canvas.drawPath(mPath, mPaint);

        canvas.restore();

    }
}
