package com.tanner.study.ui.a_view.b_paint.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Tanner on 2017/8/19.
 */

public class Practice11PieChartView extends View {
    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        float centerX=getWidth()/2;
        float centerY=getHeight()/2;
        float r=200;//半径
        float d=20;

        Paint paint = new Paint();

        //画扇形
        //扇形1
        float startAngle1=-180;
        float sweepAngle1=120;
        paint.setColor(Color.RED);
        canvas.drawArc(centerX-r-d,centerY-r-d,centerX+r-d,centerY+r-d,startAngle1,sweepAngle1,true,paint);

        //扇形2
        float startAngle2=startAngle1+sweepAngle1;
        float sweepAngle2=30;
        paint.setColor(Color.BLUE);
        canvas.drawArc(centerX-r,centerY-r,centerX+r,centerY+r,startAngle2,sweepAngle2,true,paint);

        //扇形3
        float startAngle3=startAngle2+sweepAngle2;
        float sweepAngle3=45;
        paint.setColor(Color.YELLOW);
        canvas.drawArc(centerX-r,centerY-r,centerX+r,centerY+r,startAngle3,sweepAngle3,true,paint);

        //扇形4
        float startAngle4=startAngle3+sweepAngle3;
        float sweepAngle4=60;
        paint.setColor(Color.GREEN);
        canvas.drawArc(centerX-r,centerY-r,centerX+r,centerY+r,startAngle4,sweepAngle4,true,paint);

        //扇形5
        float startAngle5=startAngle4+sweepAngle4;
        float sweepAngle5=60;
        paint.setColor(Color.GRAY);
        canvas.drawArc(centerX-r,centerY-r,centerX+r,centerY+r,startAngle5,sweepAngle5,true,paint);

        //扇形5
        float startAngle6=startAngle5+sweepAngle5;
        float sweepAngle6=45;
        paint.setColor(Color.BLACK);
        canvas.drawArc( centerX - r, centerY - r, centerX + r, centerY + r, startAngle6, sweepAngle6, true, paint);

    }
}
