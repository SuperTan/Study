package com.tanner.study.ui.a_view.a_base.widget;

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

public class Practice06DrawLineView extends View {
    public Practice06DrawLineView(Context context) {
        super(context);
    }

    public Practice06DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //        练习内容：使用 canvas.drawLine() 方法画直线
        Paint paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(Color.GRAY);

        canvas.drawLine(100,100,500,300,paint);
    }
}
