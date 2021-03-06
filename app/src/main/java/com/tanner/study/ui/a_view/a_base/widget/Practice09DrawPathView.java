package com.tanner.study.ui.a_view.a_base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Tanner on 2017/8/19.
 */

public class Practice09DrawPathView extends View {
    int offsetX ;
    int offsetY;

    public Practice09DrawPathView(Context context) {
        super(context);
    }

    public Practice09DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice09DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        offsetX = getWidth() / 2;
        offsetY = getHeight() / 2 - 55;

        //练习内容：使用 canvas.drawPath() 方法画心形
        Paint paint = new Paint();
        Path path = new Path();

//        paint.setStyle(Paint.Style.STROKE);
        //画弧形
//        path.lineTo(400,543);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            path.addArc(200,200,400,400,-225,225);
        }else{
            String txt = "版本过低，不支持addArc方法";
            canvas.drawText(txt, 100, 100, paint);
        }
        //移动到弧形起点（有痕迹）

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            path.arcTo(400,200,600,400,-180,225,false);
        }else{
            String txt = "版本过低，不支持arcTo方法";
            canvas.drawText(txt, 100, 200, paint);
        }
        //移动到
        path.lineTo(400,543);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawPath(path,paint);
        }else{
            String txt = "版本过低，不支持drawPath方法";
            canvas.drawText(txt, 100, 300, paint);
        }

        float angle = 10;
        while (angle < 180) {
            Point p = getHeartPoint(angle);
            canvas.drawPoint(p.x, p.y, paint);
            angle = angle + 0.02f;
        }
    }

    public Point getHeartPoint(float angle) {
        float t = (float) (angle / Math.PI);
        float x = (float) (19.5 * (16 * Math.pow(Math.sin(t), 3)));
        float y = (float) (-20 * (13 * Math.cos(t) - 5 * Math.cos(2 * t) - 2 * Math.cos(3 * t) - Math.cos(4 * t)));
        return new Point(offsetX + (int) x, offsetY + (int) y);
    }
}
