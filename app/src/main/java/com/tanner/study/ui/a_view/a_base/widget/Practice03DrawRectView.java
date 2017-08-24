package com.tanner.study.ui.a_view.a_base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Tanner on 2017/8/19.
 */

public class Practice03DrawRectView extends View {
    public Practice03DrawRectView(Context context) {
        super(context);
    }

    public Practice03DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //        练习内容：使用 canvas.drawRect() 方法画矩形
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        float left = 10;
        float top = 10;
        float right = left + 100;
        float bottom = top + 100;
        canvas.drawRect(left, top, right, bottom, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        Rect rect = new Rect((int) left, (int) bottom + 10, (int) right, (int) bottom * 2);
        canvas.drawRect(rect, paint);
    }
}
