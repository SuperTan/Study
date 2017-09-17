package com.tanner.study.ui.a_view.d_canvas.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tanner.study.R
import com.tanner.study.base.BaseFragment


/**
 * Created by Tanner on 2017/9/13.
 */
class Practice14Fragment : BaseFragment() {
    override val title: String?
        get() = "FlipboardView"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.aview_dcanvas_practice14, container, false)

    }
}