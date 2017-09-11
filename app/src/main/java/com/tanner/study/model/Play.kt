package com.tanner.study.model

import cn.bmob.v3.BmobObject
import cn.bmob.v3.datatype.BmobDate
import com.tanner.study.base.MyApplication

/**
 * Created by Tanner on 2017/9/7.
 */
class Play: BmobObject(){
    var content: String? = null
    var desc: String? = null
    var date: BmobDate? = null
    var time: BmobDate? = null
    var remind: Boolean? = null
    var type: String? = null
    var complete: Boolean? = null
    var group: String? = null



}