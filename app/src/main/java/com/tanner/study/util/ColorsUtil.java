package com.tanner.study.util;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import java.util.Random;

/**
 * Created by Tanner on 2017/7/24.
 * 随机返回一种颜色
 */

public class ColorsUtil {

    static String[] colors={"#33B5E5","#AA66CC","#99CC00","#FFBB33","#FF4444","#e91e63","#3f51b5","#03a9f4",
            "#259b24","#cddc39","#ffeb3b","#ff9800","#795548","#9e9e9e","#607d8b",};

    public static int getColor(){
        int i = new Random().nextInt(colors.length);
        String color = colors[i];
        return Color.parseColor(color);

    }

    public static Drawable getColor2(){
        return new ColorDrawable(Color.parseColor("#ffffff"));

    }
}
