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

public class Practice02DrawCircleView extends View {
    public Practice02DrawCircleView(Context context) {
        super(context);
    }

    public Practice02DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        Paint paint = new Paint();

        //圆1的 中心坐标 和半径
        float x1=100;
        float y1=100;
        float r1=80;
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x1,y1,r1,paint);
        //圆2的 中心坐标 和半径
        float x2=x1+200;
        float y2=100;
        float r2=80;
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x2,y2,r2,paint);

        //圆3的 中心坐标 和半径
        float x3=100;
        float y3=y1+200;
        float r3=80;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(x3,y3,r3,paint);

        //圆4的 中心坐标 和半径
        float x4=x1+200;
        float y4=y1+200;
        float r4=80;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(x4,y4,r4,paint);
    }
}
