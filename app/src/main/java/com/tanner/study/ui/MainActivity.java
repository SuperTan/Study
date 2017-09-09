package com.tanner.study.ui;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.tanner.study.R;
import com.tanner.study.ui.fragment.AboutFragment;
import com.tanner.study.ui.fragment.CatalogFragment;
import com.tanner.study.ui.fragment.HomeFragment;
import com.tanner.study.ui.fragment.MyFragment;
import com.tanner.study.ui.fragment.PlayFragment;
import com.tanner.study.util.ColorsUtil;
import com.tanner.study.util.StateBarTranslucentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.id_tb)
    Toolbar mToolbar;
    @BindView(R.id.id_drawerlayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.id_main_ll)
    FrameLayout mMainLl;

    ActionBarDrawerToggle mDrawerToggle;
    AnimationDrawable mAnimationDrawable;

    MyFragment mMyFragment;
    HomeFragment mHomeFragment;
    CatalogFragment mCatalogFragment;
    AboutFragment mAboutFragment;
    PlayFragment mPlayFragment;
    @BindView(R.id.id_left_icon_home)
    TextView mIconHome;
    @BindView(R.id.id_left_icon_catalog)
    TextView mIconCatalog;
    @BindView(R.id.id_left_icon_about)
    TextView mIconAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //设置状态栏透明
        StateBarTranslucentUtils.setStateBarTranslucent(this);
        //状态栏着色
        int color = ColorsUtil.getColor();
        StateBarTranslucentUtils.setStateBarColor(this);

//        mToolbar.setTitle("Study");
//        mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.setTitleTextColor(Color.parseColor("#ffffff"));//设置标题颜色
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);//设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                mAnimationDrawable.stop();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                mAnimationDrawable.start();
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        //设置图标颜色
        mIconCatalog.setTextColor(ColorsUtil.getColor());
        mIconAbout.setTextColor(ColorsUtil.getColor());
        mIconHome.setTextColor(ColorsUtil.getColor());
        //设置主页默认的布局

    }


    @OnClick(R.id.id_left_my)
    public void toMy() {
        if (mMyFragment == null) {
            mMyFragment = new MyFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.id_main_ll, mMyFragment).commit();
        }
        showFragment(mMyFragment);

    }


    @OnClick(R.id.id_left_home)
    public void toHome() {
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.id_main_ll, mHomeFragment).commit();
        }
        showFragment(mHomeFragment);
    }

    @OnClick(R.id.id_left_catalog)
    public void toCatalog() {
        if (mCatalogFragment == null) {
            mCatalogFragment = new CatalogFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.id_main_ll, mCatalogFragment).commit();
        }
        showFragment(mCatalogFragment);
    }


    @OnClick(R.id.id_left_about)
    public void toAbout() {
        if (mAboutFragment == null) {
            mAboutFragment = new AboutFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.id_main_ll, mAboutFragment).commit();
        }
        showFragment(mAboutFragment);
    }

    @OnClick(R.id.id_left_play_ll)
    public void toPlay() {
        if (mPlayFragment == null) {
            mPlayFragment = new PlayFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.id_main_ll, mPlayFragment).commit();
        }
        showFragment(mPlayFragment);
    }

    /**
     * 显示指定页面
     *
     * @param fragment
     */
    private void showFragment(Fragment fragment) {
        //先隐藏所有页面
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mMyFragment != null) {
            transaction.hide(mMyFragment);
        }
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mCatalogFragment != null) {
            transaction.hide(mCatalogFragment);
        }
        if (mAboutFragment != null) {
            transaction.hide(mAboutFragment);
        }
        if (mPlayFragment != null) {
            transaction.hide(mPlayFragment);
        }
        transaction.show(fragment).commit();
        //清除图片颜色
        mIconHome.setBackgroundColor(Color.parseColor("#ffffff"));
        mIconCatalog.setBackgroundColor(Color.parseColor("#ffffff"));
        mIconAbout.setBackgroundColor(Color.parseColor("#ffffff"));

        String title = "";
        if (fragment instanceof AboutFragment) {
            title = "关于我们";

        } else if (fragment instanceof CatalogFragment) {
            title = "目录";
        } else if (fragment instanceof HomeFragment) {
            title = "主页";
        } else if (fragment instanceof MyFragment) {
            title = "个人信息";
        } else if (fragment instanceof PlayFragment) {
            title = "计划";
        }
        mToolbar.setTitle(title);

        mDrawerLayout.closeDrawer(Gravity.LEFT);
    }

}
