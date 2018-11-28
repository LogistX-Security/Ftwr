package com.example.hackintosh.ftwr.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.hackintosh.ftwr.fragmnets.InviteFragment
import com.example.hackintosh.ftwr.fragmnets.QuizFragment
import java.util.*

class QuestionsViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    var pagerFragments: List<Fragment> = Arrays.asList(QuizFragment(), InviteFragment())

    override fun getCount(): Int {
        return pagerFragments.size
    }


    override fun getItem(p0: Int): Fragment {
        return pagerFragments[p0]
    }

}