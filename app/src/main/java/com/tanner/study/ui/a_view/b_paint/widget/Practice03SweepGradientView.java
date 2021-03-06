package com.tanner.study.ui.a_view.b_paint.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Tanner on 2017/8/19.
 */

public class Practice03SweepGradientView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice03SweepGradientView(Context context) {
        super(context);
    }

    public Practice03SweepGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03SweepGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    {
        // 用 Paint.setShader(shader) 设置一个 SweepGradient
        // SweepGradient 的参数：圆心坐标：(300, 300)；颜色：#E91E63 到 #2196F3
        Shader shader = new SweepGradient(300, 300, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"));
        mPaint.setShader(shader);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(300, 300, 100, mPaint);
    }
}
