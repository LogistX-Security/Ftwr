package com.example.hackintosh.ftwr.fragmnets

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

open class BaseFragment: Fragment() {

    private var viewId: Int = 0
    protected var activity: Activity? = null
    protected var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = getActivity()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            rootView = inflater.inflate(viewId, null)
        }
        return rootView
    }

    fun setContentLayout(contentLayoutId: Int) {
        viewId = contentLayoutId
    }
}