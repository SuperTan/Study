package com.tanner.study.ui.a_view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by Tanner on 2017/8/19.
 */

public class Practice04DrawPointView extends View {
    public Practice04DrawPointView(Context context) {
        super(context);
    }

    public Practice04DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //        练习内容：使用 canvas.drawPoint() 方法画点
        //        一个圆点，一个方点
        //        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        Paint paint = new Paint();
        float x1=100;
        float y1=100;
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(20);
        canvas.drawPoint(x1,y1,paint);

        float x2=x1+100;
        float y2=100;
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(x2,y2,paint);

        float x3=x2+100;
        float y3=100;
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setColor(Color.GREEN);
        canvas.drawPoint(x3,y3,paint);


    }
}
