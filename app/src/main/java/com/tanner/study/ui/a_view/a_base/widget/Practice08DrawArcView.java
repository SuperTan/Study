package com.tanner.study.ui.a_view.a_base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Tanner on 2017/8/19.
 */

public class Practice08DrawArcView extends View {
    public Practice08DrawArcView(Context context) {
        super(context);
    }

    public Practice08DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        Paint paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLUE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(100,100,500,300,10,100,true,paint);
        }else{
            String txt = "版本过低，不支持drawArc方法";
            canvas.drawText(txt, 100, 100, paint);
        }
    }
}
