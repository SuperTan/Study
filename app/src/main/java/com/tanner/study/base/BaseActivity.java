package com.tanner.study.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.tanner.study.util.StateBarTranslucentUtils;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;

/**
 * Created by Tanner on 2016/5/19.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected String TAG = this.getClass().getSimpleName();
    protected Context mContext;
    private int mRequestCode;
    //右滑返回
//    private SwipeBackLayout mSwipeBackLayout;


    protected MyHandler mHandler = new MyHandler(this);

    protected static class MyHandler extends Handler {
        protected WeakReference<BaseActivity> mReference;

        public MyHandler(BaseActivity activity) {
            mReference = new WeakReference<BaseActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mReference != null) {
                BaseActivity activity = mReference.get();
                switch (msg.what) {
//                    case DeviceUtil.RAIL_WARN:
//                        Vibrator vibrator0d = (Vibrator) MyApplication.getInstance().getSystemService(context.VIBRATOR_SERVICE);
//                        vibrator0d.vibrate(500);
//                        MyUtils.showToast(MyApplication.getInstance().getResources().getString(R.string.hint_pet_warn));
//                        break;
//                    case NOUSER:
//                        //没有用户数据
//                        MyUtils.showToast(MyApplication.getInstance().getResources().getString(R.string.hint_no_user_data));
//                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
        Bmob.initialize(this, "bf4a8d25685142563728be6059caf0c0");

//        mSwipeBackLayout = getSwipeBackLayout();
//        // 设置滑动方向，可设置EDGE_LEFT, EDGE_RIGHT, EDGE_ALL, EDGE_BOTTOM
//        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);


        mContext = getActivityContext();
        loadViewLayout();
        ButterKnife.bind(this);

        // 给状态栏着色 android 版本大于19 才能给通知栏修改颜色
        //状态栏透明化
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }

    /**
     * Activity.this
     */
    protected abstract Context getActivityContext();

    /**
     * 加载页面layout
     */
    protected abstract void loadViewLayout();


    protected void initStateBar(int colorInt) {

        //设置状态栏透明
        StateBarTranslucentUtils.setStateBarTranslucent(this);
        //状态栏着色
        StateBarTranslucentUtils.setStateBarColor(this,colorInt);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
