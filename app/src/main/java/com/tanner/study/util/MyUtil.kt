package com.tanner.study.util

import android.widget.Toast
import com.tanner.study.base.MyApplication

/**
 * Created by Tanner on 2017/9/4.
 */
class MyUtil{

    public fun showMsg(msg:String){
        Toast.makeText(MyApplication.instance,msg,Toast.LENGTH_SHORT).show()
    }
}