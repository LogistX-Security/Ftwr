package com.example.hackintosh.ftwr.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.ViewGroup
import com.example.hackintosh.ftwr.fragmnets.InviteFragment
import com.example.hackintosh.ftwr.fragmnets.QuizFragment
import com.example.hackintosh.ftwr.utils.Constants
import com.example.hackintosh.ftwr.utils.SharedPrefUtil
import kotlin.collections.ArrayList

class QuestionsViewPagerAdapter(fm: FragmentManager, isResponseProvided: Boolean): FragmentStatePagerAdapter(fm) {

    var pagerFragments: ArrayList<Fragment> = ArrayList()

    init {
        if (!isResponseProvided) {
            pagerFragments.add(QuizFragment())
        }
        pagerFragments.add(InviteFragment())
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position) as Fragment
        pagerFragments[position] = fragment
        return fragment
    }

    override fun getCount(): Int {
        return pagerFragments.size
    }

    override fun getItem(p0: Int): Fragment {
        return pagerFragments[p0]
    }

    override fun getItemPosition(`object`: Any): Int {
        return if(pagerFragments.contains(`object`)) {
            pagerFragments.indexOf(`object`)
        } else {
            POSITION_NONE
        }
    }

}