package com.tanner.study.base

import android.support.v4.app.Fragment

/**
 * Created by Tanner on 2017/9/12.
 */
open abstract class BaseFragment : Fragment() {
    abstract val title: String?

}