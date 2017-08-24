package com.tanner.study.ui.a_view.b_paint.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.tanner.study.R;

/**
 * Created by Tanner on 2017/8/19.
 */

public class Practice06LightingColorFilterView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    public Practice06LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter
        ColorFilter lightFilter = new LightingColorFilter(0xffffff, 0x000000);
        mPaint.setColorFilter(lightFilter);


        // 第一个 LightingColorFilter：去掉红色部分
        ColorFilter lightFilter1 = new LightingColorFilter(0x00ffff, 0x000000);
        mPaint.setColorFilter(lightFilter1);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);

        // 第二个 LightingColorFilter：增强绿色部分
        ColorFilter lightFilter2 = new LightingColorFilter(0xffffff, 0x00ff00);
        mPaint.setColorFilter(lightFilter2);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, mPaint);
    }
}
