package com.example.hackintosh.ftwr.fragmnets

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.hackintosh.ftwr.R
import com.example.hackintosh.ftwr.activities.QuestionActivity


class QuizFragment: BaseFragment() {

    lateinit var followButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentLayout(R.layout.fragment_quiz)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        followButton = view.findViewById(R.id.followButton)
        followButton.setOnClickListener {moveToInvitePage()}
    }

    private fun moveToInvitePage() {
        (activity as QuestionActivity).viewPager.currentItem = 1
    }

}