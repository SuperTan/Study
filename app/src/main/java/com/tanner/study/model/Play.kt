package com.tanner.study.model

import cn.bmob.v3.BmobObject

/**
 * Created by Tanner on 2017/9/7.
 */
class Play: BmobObject(){
    var content: String? = null
    var desc: String? = null
    var date: String? = null
    var time: String? = null
    var remind: Boolean? = null
    var type: String? = null
    var complete: Boolean? = null

}