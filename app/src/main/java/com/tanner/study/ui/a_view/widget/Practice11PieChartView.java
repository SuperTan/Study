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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        Paint paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(Color.GRAY);

        canvas.drawLine(100,100,500,300,paint);
    }
}
