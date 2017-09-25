package com.tanner.study.ui.a_view.f_anim.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tanner.study.R
import com.tanner.study.base.BaseFragment



/**
 * Created by Tanner on 2017/9/13.
 */
class Practice05Fragment : BaseFragment(){
    override val title: String?
        get() = "MultiProperties"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.aview_fanim_practice05, container, false)

    }
}