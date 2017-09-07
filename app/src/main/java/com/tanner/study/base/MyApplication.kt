package com.tanner.study.base

import android.app.Application

/**
 * Created by Tanner on 2017/9/4.
 */
class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: MyApplication? = null
    }
}